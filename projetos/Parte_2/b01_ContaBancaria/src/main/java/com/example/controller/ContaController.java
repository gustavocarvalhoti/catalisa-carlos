package com.example.controller;

import com.example.model.ContaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.service.ContaService;

import java.util.List;

@RestController
public class ContaController {
    @Autowired
    ContaService contaService;

    //Endpoint de consultar todas as contas
    //Requisitando todas as contas
    @GetMapping(path = "/contas")
    public List<ContaModel> exibirContas() {
        return contaService.exibirContas();
    }

    //Consultar conta bancária por ID
    @GetMapping(path = "/contas/id/{id}")
    public ResponseEntity<ContaModel> exibirContaPorId(@PathVariable Long id) {
        ContaModel contaModel = contaService.exibirContaPorId(id);

        if (contaModel != null) {
            return ResponseEntity.ok(contaModel);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Endpoint consultar conta por número de conta
    @GetMapping(path = "/contas/numero/{numero_conta}")
    public ResponseEntity<ContaModel> exibirContaPorNumeroConta(@PathVariable String numero_conta) {
        ContaModel contaModel = contaService.exibirContaPorNumeroConta(numero_conta);

        if (contaModel != null) {
            return ResponseEntity.ok(contaModel);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Endpoint de cadastrar uma conta
    @PostMapping(path = "/contas")
    public ResponseEntity<ContaModel> cadastrarConta(@RequestBody ContaModel contaModel) {
        ContaModel novaConta = contaService.cadastrarConta(contaModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaConta);
    }

    //Endpoint de atualizar uma conta por ID
    @PutMapping(path = "/contas/id/{id}")
    public ResponseEntity<ContaModel> atualizarConta(@PathVariable Long id, @RequestBody ContaModel contaModel) {
        ContaModel contaExistente = contaService.exibirContaPorId(id);

        if (contaExistente != null) {
            contaExistente.setAgencia(contaModel.getAgencia());
            contaExistente.setNumero_conta(contaModel.getNumero_conta());
            contaExistente.setNome_cliente(contaModel.getNome_cliente());
            contaExistente.setValor_atual(contaModel.getValor_atual());
            contaExistente.setValor_final(contaModel.getValor_final());
            contaExistente.setValor_saque(contaModel.getValor_saque());
            contaExistente.setValor_deposito(contaModel.getValor_deposito());
            contaExistente.setTipo_servico(contaModel.getTipo_servico());

            ContaModel contaAtualizada = contaService.atualizarConta(contaExistente);
            return ResponseEntity.ok(contaAtualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Endpoint de excluir uma conta
    @DeleteMapping(path = "/contas/id/{id}")
    public ResponseEntity<Void> excluirConta(@PathVariable Long id) {
        contaService.excluirConta(id);
        return ResponseEntity.noContent().build();
    }
}
