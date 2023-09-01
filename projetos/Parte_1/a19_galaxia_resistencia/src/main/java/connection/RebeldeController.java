package connection;

import system.Rebelde;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

//Receber as entradas do usuário, executar as operações correspondentes e interagir com o banco de dados.
public class RebeldeController {

    private Connection connection;

    public RebeldeController() {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/galaxia",
                    "postgres", "Postgres@1982");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //adicionar rebelde
    public void adicionarRebelde(String nome, int idade, String genero, String localizacao){

        Rebelde rebelde = new Rebelde(nome, idade, genero, localizacao, null );

        var sql = "INSERT INTO rebelde (nome, idade, genero, localizacao) VALUES ('%s', %d, '%s', '%s')";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, rebelde.getNome());
            statement.setInt(2, rebelde.getIdade());
            statement.setString(3, rebelde.getGenero());
            statement.setString(4, rebelde.getLocalizacao());
            statement.setObject(5, rebelde.getInventario());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //atualizar rebelde localização
    public void atualizarLocalizacao(int rebeldeId, String novaLocalizacao) {
        var sql = "UPDATE rebelde SET localizacao = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, novaLocalizacao);
            statement.setInt(2, rebeldeId);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //reportar traidores e marcar rebelde como traidor
    //Insere um registro na tabela traidores indicando a traição do rebelde.
    public void reportarTraidor(int rebeldeId) {
        if (isRebeldeTraidor(rebeldeId)) {
            System.out.println("O Rebelde já está marcado como traidor");
            return;
        }
        //adiciona registro de traicao na tabela
        var sql = "INSERT INTO traidores (rebelde_id) VALUES (?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, rebeldeId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (isRebeldeLimiteTraicoes(rebeldeId)) {
            desativarRebelde(rebeldeId);
            System.out.println("O Rebelde já está com limite de traídos");

        } else {
            System.out.println("O rebelde está marcado como traidor");
        }
    }

    private boolean isRebeldeTraidor(int rebeldeId) {
        var sql = "SELECT COUNT(*) FROM traidores WHERE rebelde_id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, rebeldeId);
            var rs = statement.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    //Verifica se o rebelde atingiu o limite de traições (3 traições).
    // Caso sim, desativa o rebelde e exibe uma mensagem informando que o
    // rebelde foi marcado como traidor e desativado.
    private boolean isRebeldeLimiteTraicoes(int rebeldeId) {
        var sql = "SELECT COUNT(*) FROM traidores WHERE rebelde_id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, rebeldeId);
            var rs = statement.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                return count >= 3;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private void desativarRebelde(int rebeldeId) {
        var sql = "UPDATE rebelde SET ativo = false WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, rebeldeId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

