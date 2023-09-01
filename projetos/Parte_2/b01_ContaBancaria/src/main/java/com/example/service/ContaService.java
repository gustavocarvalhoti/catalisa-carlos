package com.example.service;

import com.example.model.ContaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.repository.ContaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ContaService {

    @Autowired
    ContaRepository contaRepository;

    //Método que busca todas as contas bancárias no banco de dados
    public List<ContaModel> exibirContas() {
        try {
            return contaRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao exibir contas: " + e.getMessage(), e);
        }

    }

    //Método para exibir uma conta específica por id
    public ContaModel exibirContaPorId(Long id) {
        return contaRepository.findById(id).orElseThrow(()
                -> new RuntimeException("Conta por ID não encontrada! "));
    }

    //    //Método para exibir uma conta específica por numero de conta
    public ContaModel exibirContaPorNumeroConta(String numero_conta) {
        return (ContaModel) contaRepository.exibirContaPorNumeroConta(numero_conta).orElseThrow(()
                -> new RuntimeException("Número da Conta não encontrada! "));
    }

    //Método para cadastrar uma conta bancária no banco de dados
    public ContaModel cadastrarConta(ContaModel contaModel) {
        return contaRepository.save(contaModel);
    }

    //Método para excluir uma conta bancária do banco de dados
    public void excluirConta(Long id) {
        contaRepository.deleteById(id);
    }

    //Método para atualizar uma conta bancária no banco de dados
    public ContaModel atualizarConta(ContaModel contaModel) {
        return contaRepository.save(contaModel);
    }
}
