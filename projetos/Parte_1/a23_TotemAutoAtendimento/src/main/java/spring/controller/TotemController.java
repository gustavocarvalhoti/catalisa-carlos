package spring.controller;
//Controllers responsáveis pelo Endpoints para as operações do Totem de auto-atendimento para os clientes


import dto.BebidaDTO;
import dto.LancheDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.model.CarrinhoModel;
import spring.service.BebidaService;
import spring.service.CarrinhoService;
import spring.service.LancheService;

import java.util.List;

@RestController
public class TotemController {

    @Autowired
    private LancheService lancheService;
    @Autowired
    private BebidaService bebidaService;

    //parte da segunda versão
    @Autowired
    private CarrinhoService carrinhoService;

    //primeira versão

//    @GetMapping("/lanches")
//    public List<LancheDTO> exibirLanches() {
//        return lancheService.exibirLanches();
//    }
//
//    @GetMapping("/bebidas")
//    public List<BebidaDTO> exibirBebidas() {
//        return bebidaService.exibirBebidas();
//    }

    //segunda versão
    @GetMapping(path = "/menuInicial")
    public ResponseEntity<String> exibirMenuInicial() {
        String menuInicial = "Menu inicial:\n1 - Lanches\n2 - Bebidas";

        return ResponseEntity.ok("Menu inicial");
    }

    @PostMapping("/escolha-opcao")
    public ResponseEntity<String> escolhaOpcao(@RequestParam String opcao) {
        if (!opcao.matches("[1-2]")) {
            return ResponseEntity.badRequest().body("Opção inválida. Tente novamente.");
        }

        if (opcao.equals("1")) {

            return ResponseEntity.ok("Voce escolheu os Lanches. Digite a opção desejada: \n1 - X-burguer \n2 - X-salada");

        } else {
            return ResponseEntity.ok("Voce escolheu Bebidas. Digite a opção desejada: \n1 - Refrigerante \n2 - Suco");
        }
    }

    @PostMapping("/escolha-lanche")
    public ResponseEntity<String> escolhaLanche(@RequestParam String lanche) {
        if (!lanche.matches("[1-2]")) {
            return ResponseEntity.badRequest().body("Opção inválida. Tente novamente.");
        }

        int lancheSelecionado = Integer.parseInt(lanche);
        if (lancheSelecionado == 1) {
            //aqui o usuario escolheu o X-burguer
            return ResponseEntity.ok("Voce escolheu o X-burguer. Digite a quantidade desejada: ");
        } else {
            //aqui o usuario escolheu o X-salada
            return ResponseEntity.ok("Voce escolheu o X-salada. Digite a quantidade desejada: ");
        }

    }

    // Implementar outros métodos para as funcionalidades de escolher bebida,
    // adicionar ao carrinho e calcular o valor total.

    @PostMapping("/add-carrinho")
    public ResponseEntity<String> addCarrinho(@RequestParam String codigo, @RequestParam int quantidade) {
        //lógica para validar o código do item e a quantidade

        CarrinhoModel itemCarrinho = new CarrinhoModel();
        itemCarrinho.setCodigo(codigo);
        itemCarrinho.setNome("X-burguer");
        itemCarrinho.setQuantidade(quantidade);
        itemCarrinho.setValorUnitario(10.00);

        carrinhoService.addCarrinho(itemCarrinho);
        double valorTotal = carrinhoService.totalCarrinho();

        return ResponseEntity.ok("Item adicionado ao carrinho. Valor total do carrinho até o momento: R$ " + valorTotal);
    }

    //métodos para implementar a escolha de bebidas
    @PostMapping("/escolha-bebida")
    public ResponseEntity<String> escolhaBebida(@RequestParam String bebida) {

        if (!bebida.matches("[1-2]")) {
            return ResponseEntity.badRequest().body("Opção inválida de bebida. Tente novamente.");
        }

        int bebidaSelecionada = Integer.parseInt(bebida);
        if (bebidaSelecionada == 1) {
            //aqui o usuario escolheu o refrigerante
            return ResponseEntity.ok("Voce escolheu o refrigerante. Digite a quantidade desejada: ");
        } else { //aqui o usuario escolheu o suco
            return ResponseEntity.ok("Voce escolheu o suco. Digite a quantidade desejada: ");
        }

    }

    //Método para o encerramento do pedido
    @PostMapping("/finalizar-pedido")
    public ResponseEntity<String> finalizarPedido() {

        double valorTotal = carrinhoService.totalCarrinho();
        String carrinhoString = gerarCarrinhoString();

        return ResponseEntity.ok("Valor total do pedido: R$ " + valorTotal + "\nItens selecionados:\n" +
                carrinhoString + "\n\nEscolha a forma de pagamento:\n1. Cartão de crédito\n2. Cartão de débito" +
                "\n3. Vale refeição\n4. Dinheiro");

    }

    private String gerarCarrinhoString() {
        List<CarrinhoModel> carrinho = carrinhoService.exibirListaCarrinho();
        StringBuilder sb = new StringBuilder();
        for (CarrinhoModel item : carrinho) {
            sb.append(item.getNome()).append(" - ").append("Quantidade: ")
                    .append(item.getQuantidade()).append(" - Valor unidade: ").append(item.getValorUnitario())
                    .append("\n");
        }
        return sb.toString();
    }

    //Método para a forma de pagamento escolhida na finalizaçao do pedido
    @PostMapping("/pagamento")
    public ResponseEntity<String> realizarPagamento(@RequestParam String formaPagamento,
                                                    @RequestParam(required = false) Double valorTotal) {
        if (!formaPagamento.matches("[1-4]")) {
            return ResponseEntity.badRequest().body("Opção inválida de forma de pagamento. Tente novamente.");
        }

        switch (formaPagamento) {
            case "1":
                //cartão de crédito
//                if (valorTotal == null) {
                return ResponseEntity.badRequest().body("Valor total inválido. Tente novamente.");
//                }
//            break;
            case "2":
                //cartão de debito
//                if (valorTotal == null) {
                return ResponseEntity.badRequest().body("Valor total inválido. Tente novamente.");
//                }
//            break;
            case "3":
                //vale refeição
//                if (valorTotal == null) {
                return ResponseEntity.badRequest().body("Valor total inválido. Tente novamente.");
//                }
//            break;
            case "4":
                //dinheiro
                if (valorTotal == null || valorTotal < carrinhoService.totalCarrinho()) {
                    return ResponseEntity.badRequest().body("Valor em dinheiro abaixo do valor total. " +
                            "Tente novamente. O valor total da compra é: R$ " + carrinhoService.totalCarrinho());
                }
                double trocoDinheiro = valorTotal - carrinhoService.totalCarrinho();
                return ResponseEntity.ok("Compra finalizada!" +
                        "O troco em dinheiro é: R$ " + trocoDinheiro + "Tenha uma ótima refeição! Volte sempre!");

            default:
                return ResponseEntity.badRequest().body("Opção inválida de forma de pagamento. " +
                        "Tente novamente a opção correta de forma de pagamento.");
        }
    }


    //Método para implementar a edição dos itens do carrinho
    @PutMapping("/editar-item")
    public ResponseEntity<String> editarItemCarrinho(@RequestParam String codigo, @RequestParam int quantidade) {

        carrinhoService.editarItemCarrinho(codigo, quantidade);
        double valorTotal = carrinhoService.totalCarrinho();
        String carrinhoString = gerarCarrinhoString();

        return ResponseEntity.ok("Carrinho atualizado! Valor total do pedido: R$ " + valorTotal +
                "\nItens selecionados:\n" + carrinhoString);
    }

    //Método para implementar a remoção dos itens do carrinho
    @DeleteMapping("/remover-item")
    public ResponseEntity<String> removerItemCarrinho(@RequestParam String codigo) {

        carrinhoService.removerItemCarrinho(codigo);
        double valorTotal = carrinhoService.totalCarrinho();
        String carrinhoString = gerarCarrinhoString();

        return ResponseEntity.ok("Item removido do Carrinho! Atualizado! " +
                "Valor total do pedido: R$ " + valorTotal +
                "\nItens selecionados:\n" + carrinhoString);

    }

}

