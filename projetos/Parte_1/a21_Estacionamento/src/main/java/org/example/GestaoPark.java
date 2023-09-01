package org.example;

//Classe que será responsável por gerenciar o estacionamento e seus métodos de gestão.

import org.example.conexaoBD.ConexaoBD;

import java.sql.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GestaoPark {

    private List<Carros> carrosPark;

    private Connection conexao;

    public GestaoPark() {
        carrosPark = new ArrayList<>();
        try {
            conexao = ConexaoBD.getConnection();
            System.out.println("BANCO DE DADOS - Conectado com sucesso!");
            System.out.println();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("BANCO DE DADOS - Erro ao conectar!");
            System.out.println();
        }

    }

    //Método para adicionar um carro no estacionamento.
    public void addCarro(Carros carros) {
        carrosPark.add(carros);

        var sql = "INSERT INTO controle_carros (placa, marca, modelo, data_entrada, proprietario) " +
                "VALUES (?, ?, ?, ?, ?)";


        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, carros.getPlaca());
            stmt.setString(2, carros.getMarca());
            stmt.setString(3, carros.getModelo());
            stmt.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));
            stmt.setString(5, carros.getProprietario());
//            stmt.setTimestamp(6, Timestamp.valueOf(carros.getDataSaida()));
//            stmt.setDouble(7, carros.getPrecoTotal());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //Método para calcular o total de precos dos carros.
    public void calcularTotal(Carros carros) {
        LocalDateTime dataSaida = carros.getDataSaida();
        Duration duracao = Duration.between(carros.getDataEntrada(), dataSaida);

        double precoTotal = 0;
        long minutos = duracao.toMinutes();

        if (minutos <= 60) {
            precoTotal = 10;
        } else {
            precoTotal = 10;
            minutos -= 60;
            precoTotal += (minutos / 30) * 2;
            precoTotal = Math.min(precoTotal, 90);
        }

        carros.setPrecoTotal(precoTotal);

        //Atualizar o valor pago no banco de dados.
        var sql = "UPDATE controle_carros SET data_saida = ?, valor_pago = ? WHERE placa = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setTimestamp(1, Timestamp.valueOf(dataSaida));
            stmt.setDouble(2, precoTotal);
            stmt.setString(3, carros.getPlaca());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //aqui funçao para listar os carros em estacionamento
    public List<Carros> listarCarrosPark() {

        var sql = "SELECT * FROM controle_carros WHERE data_saida IS NULL";

        List<Carros> carros = new ArrayList<>();

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Carros carro = new Carros("", "", "", LocalDateTime.now(), null, 0.0, "");
                carro.setPlaca(rs.getString("placa"));
                carro.setMarca(rs.getString("marca"));
                carro.setModelo(rs.getString("modelo"));
                carro.setDataEntrada(rs.getTimestamp("data_entrada").toLocalDateTime());
                carro.setDataSaida(rs.getTimestamp("data_saida") != null ?
                        rs.getTimestamp("data_saida").toLocalDateTime() : null);
                carro.setPrecoTotal(rs.getDouble("valor_pago"));
                carro.setProprietario(rs.getString("proprietario"));

                carros.add(carro);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carros;
    }

    //aqui funçao para listar todos os carros que ja foram estacionados ou não.

    public List<Carros> listagemGeral() {
        var sql = "SELECT * FROM controle_carros";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Carros carro = new Carros("", "", "", LocalDateTime.now(), null, 0.0, "");
                carro.setPlaca(rs.getString("placa"));
                carro.setMarca(rs.getString("marca"));
                carro.setModelo(rs.getString("modelo"));
                carro.setDataEntrada(rs.getTimestamp("data_entrada").toLocalDateTime());
                carro.setDataSaida(rs.getTimestamp("data_saida") != null ?
                        rs.getTimestamp("data_saida").toLocalDateTime() : null);
                carro.setPrecoTotal(rs.getDouble("valor_pago"));
                carro.setProprietario(rs.getString("proprietario"));
                carrosPark.add(carro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carrosPark;
    }
}