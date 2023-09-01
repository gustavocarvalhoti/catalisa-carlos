package spring.service;

import spring.model.CarrinhoModel;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoService {
    private List<CarrinhoModel> carrinho = new ArrayList<>();

    public void addCarrinho(CarrinhoModel itemCarrinho) {
        carrinho.add(itemCarrinho);

    }

    public List<CarrinhoModel> exibirListaCarrinho() {
        return carrinho;
    }

    public double totalCarrinho() {
        return carrinho.stream()
                .mapToDouble(item -> item.getQuantidade() * item.getValorUnitario())
                .sum();
    }


    public void editarItemCarrinho(String codigo, int quantidade) {
                carrinho.stream()
                .filter(item -> item.getCodigo().equals(codigo))
                .forEach(item -> item.setQuantidade(quantidade));

    }

    public void removerItemCarrinho(String codigo) {
                carrinho.stream()
                .filter(item -> item.getCodigo().equals(codigo))
                .forEach(item -> carrinho.remove(item));
    }


}
