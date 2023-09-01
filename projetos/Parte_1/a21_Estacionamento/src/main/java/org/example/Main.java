package org.example;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;


//Classe para interagir com o usuário e executar as funcionalidades da aplicação.

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        GestaoPark gestao = new GestaoPark();

        int opcao;
        do {
            System.out.println("  _____                   _        ______  _    _   _____  \n" +
                    " |  __ \\                 | |      |___  / | |  | | |  __ \\ \n" +
                    " | |__) |   __ _   _ __  | | __      / /  | |  | | | |__) |\n" +
                    " |  ___/   / _` | | '__| | |/ /     / /   | |  | | |  ___/ \n" +
                    " | |      | (_| | | |    |   <     / /__  | |__| | | |     \n" +
                    " |_|       \\__,_| |_|    |_|\\_\\   /_____|  \\____/  |_|     \n" +
                    "                                                           ");
            System.out.println(">>> Bem-vindo ao Sistema de Estacionamento! <<<");
            System.out.println("1 - Adicionar carro no estacionamento");
            System.out.println("2 - Registrar saída e Calcular Valor do estacionamento");
            System.out.println("3 - Listar todos os carros em estacionamento");
            System.out.println("4 - Listagem Geral dos carros");
            System.out.println("0 - Sair");
            System.out.println("Digite a opção desejada: ");
            System.out.println();
            opcao = scan.nextInt();


            switch (opcao) {
                case 1:
                    System.out.println("Digite a placa do carro: ");
                    String placa = scan.next();
                    System.out.println("Digite a marca do carro: ");
                    String marca = scan.next();
                    System.out.println("Digite o modelo do carro: ");
                    String modelo = scan.next();
                    System.out.println("Digite o proprietário do carro: ");
                    String proprietario = scan.next();
//                    System.out.println("Digite a data de entrada do carro: ");
//                    String dataEntrada = scan.next();

                    Carros carros = new Carros(placa, marca, modelo, null, null, 0, proprietario);
                    carros.setPlaca(placa);
                    carros.setModelo(modelo);
                    carros.setMarca(marca);
                    carros.setDataEntrada(LocalDateTime.now());
                    carros.setProprietario(proprietario);


                    gestao.addCarro(carros);
                    System.out.println("Carro adicionado!");
                    break;

                case 2:
                    List<Carros> carrosPark = gestao.listarCarrosPark();

                    System.out.println("Carros estacionados: ");
                    for (Carros carro : carrosPark) {
                        System.out.println("Placa:" + carro.getPlaca());
                        System.out.println("Marca:" + carro.getMarca());
                        System.out.println("Modelo:" + carro.getModelo());
                        System.out.println("Data de entrada:" + carro.getDataEntrada());
                        System.out.println("Proprietário:" + carro.getProprietario());
                        System.out.println();
                    }
                    System.out.println("Digite a PLACA do carro que está saindo: ");
                    String placaCarroSaida = scan.next();

                    Carros carroSaida = null;
                    for (Carros carro : carrosPark) {
//                        if (carro.getId() == idCarroSaida) {
                        if (carro.getPlaca().equals(placaCarroSaida)) {

                            carroSaida = carro;
                            break;
                        }
                    }

                    if (carroSaida != null) {
                        carroSaida.setDataSaida(LocalDateTime.now());
                        gestao.calcularTotal(carroSaida);
                        System.out.println("Saída registrada. Valor pago: " + carroSaida.getPrecoTotal());

                    } else {
                        System.out.println("Carro não encontrado!");

                    }
                    break;

                case 3:
                    carrosPark = gestao.listarCarrosPark();

                    System.out.println("Carros estacionados: ");
                    for (Carros carro : carrosPark) {
                        System.out.println("Placa:" + carro.getPlaca());
                        System.out.println("Marca:" + carro.getMarca());
                        System.out.println("Modelo:" + carro.getModelo());
                        System.out.println("Data de entrada:" + carro.getDataEntrada());
                        System.out.println("Proprietário:" + carro.getProprietario());
                        System.out.println("_______________________________________");
                    }
                    break;

                case 4:
                    List<Carros> carrosGeral = gestao.listagemGeral();
                    System.out.println("Registro de todos os carros.");
                    for (Carros carro : carrosGeral) {
                        System.out.println("Placa:" + carro.getPlaca());
                        System.out.println("Marca:" + carro.getMarca());
                        System.out.println("Modelo:" + carro.getModelo());
                        System.out.println("Data de entrada:" + carro.getDataEntrada());
                        System.out.println("Data de saída:" + carro.getDataSaida() != null ? carro.getDataSaida() : "Carro ESTACIONADO.");
                        System.out.println("Valor total:" + carro.getPrecoTotal());
                        System.out.println("Proprietário:" + carro.getProprietario());
                        System.out.println("_______________________________________");
                    }
                    break;
                case 0:
                    System.out.println("Fechando...");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }


        } while (opcao != 0);
    }
}

