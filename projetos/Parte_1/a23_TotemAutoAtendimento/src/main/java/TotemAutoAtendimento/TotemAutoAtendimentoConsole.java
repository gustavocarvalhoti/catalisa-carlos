package TotemAutoAtendimento;


import dto.LancheDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spring.model.LancheModel;
import spring.service.BebidaService;
import spring.service.CarrinhoService;
import spring.service.LancheService;

import java.util.List;
import java.util.Scanner;

//Aqui vou TENTAR implementar um classe para a Interação do Usuário no CONSOLE
public class TotemAutoAtendimentoConsole {

    @Autowired
    LancheService lancheService;
    BebidaService bebidaService;
    CarrinhoService carrinhoService;
    Scanner input = new Scanner(System.in);


    public void iniciarConsole() {
        System.out.println();
        System.out.println("Bem vindo ao Totem Auto Atendimento");
        System.out.println("  ___               _       ___                  _ \n" +
                " | __|  __ _   ___ | |_    | __|  ___   ___   __| |\n" +
                " | _|  / _` | (_-< |  _|   | _|  / _ \\ / _ \\ / _` |\n" +
                " |_|   \\__,_| /__/  \\__|   |_|   \\___/ \\___/ \\__,_|\n" +
                "                                                   \n");
        while (true) {
            System.out.println("Selecione a opção desejada:");
            System.out.println("1 - Lanches");
            System.out.println("2 - Bebidas");
            System.out.println("3 - Finalizar pedido");
            System.out.println("0 - Sair");

            int opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    List<LancheModel> lanches = lancheService.exibirLanches();
                    for (LancheModel lanche : lanches) {
                        System.out.println(lanche.getId());
                        System.out.println(lanche.getNome());
                        System.out.println(lanche.getPreco());
                    }
                    break;
                case 2:
                    bebidaService.exibirBebidas();
                    break;
                case 3:
                    carrinhoService.totalCarrinho();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }


        }


    }


}
