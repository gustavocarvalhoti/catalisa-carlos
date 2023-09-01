package system;

import connection.RebeldeController;
import utilidades.ItemUtilidades;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private RebeldeController rebeldeController;

    public Menu() {
        scanner = new Scanner(System.in);
        rebeldeController = new RebeldeController();

    }

    public void executarMenu() {
        int opcao = 0;


        do {
            System.out.println("========== MENU DO JOGO ==========");
            System.out.println("1. Criar Rebelde");
            System.out.println("2. Atualizar localização do Rebelde");
            System.out.println("3. Reportar rebelde como traidor");
            System.out.println("4. Comprar item");
            System.out.println("5. Gerar relatórios");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    criarRebelde();
                    break;
                case 2:
                    atualizarLocalizacaoRebelde();
                    break;
                case 3:
                    reportarTraidor();
                    break;
                case 4:
                    comprarItem();
                    break;
//                case 5:
//                    gerarRelatorios();
//                    break;
                case 6:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Favor escolha outra opção.");
                    System.out.println();

            }

        } while (opcao != 6);

        rebeldeController.closeConnection();
    }

    private void criarRebelde() {
        System.out.println("Informe o nome do Rebelde: ");
        var nome = scanner.next();
        System.out.println("Informe a idade do Rebelde: ");
        var idade = scanner.nextInt();
        System.out.println("Informe o genero do Rebelde: ");
        var genero = scanner.next();
        System.out.println("Informe a localização do Rebelde: ");
        var localizacao = scanner.next();


        rebeldeController.adicionarRebelde(nome, idade, genero, localizacao);
        System.out.println("Rebelde criado com sucesso");
    }

    private void atualizarLocalizacaoRebelde() {
        System.out.println("Informe o id do Rebelde: ");
        var rebeldeId = scanner.nextInt();
        System.out.println("Informe a nova localização do Rebelde: ");
        var novaLocalizacao = scanner.next();


        rebeldeController.atualizarLocalizacao(rebeldeId, novaLocalizacao);
        System.out.println("Rebelde localizado com sucesso");
    }

    public void reportarTraidor() {
        System.out.println("Informe o id do Rebelde para reportar Traição: ");
        var rebeldeId = scanner.nextInt();

        rebeldeController.reportarTraidor(rebeldeId);
        System.out.println("Rebelde reportado com sucesso");
    }

    public void comprarItem(){
        System.out.println("Informe o id do Rebelde: ");
        var rebeldeId = scanner.nextInt();
        System.out.println("Informe o item: ");
        var item = scanner.next();
        System.out.println("Informe a quantidade: ");
        var quantidade = scanner.nextInt();

//        itemUtilidades.comprarItem(rebeldeId, item, quantidade);
    }

//    public void gerarRelatorios(){
//        double porcentagemTraidores = rebeldeUtilidades.calcularPorcentagemTraidores();
//        double porcentagemRebeldes = rebeldeUtilidades.calcularPorcentagemRebeldes();
//
//        System.out.println("Porcentagem de traidores: " + porcentagemTraidores);
//        System.out.println("Porcentagem de traídos: " + porcentagemRebeldes);
//    }
}
