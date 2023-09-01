package com.example.model;

//Especificações da Conta Bancária
//1- Uma conta deve possuir:
//  •  id;
//  • numero de conta;
//  • agencia;
//  • nome do Cliente;
//  • valor atual da conta;
//  • valor final;
//  • valor fornecido para saque ou deposito (valor a ser acrescido ou subtraído no valor final);
//  • tipo de serviço (saque ou depósito);


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "contas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ContaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 15, nullable = false)
    private String numero_conta;
    @Column(length = 8, nullable = false)
    private String agencia;
    @Column(length = 30, nullable = false)
    private String nome_cliente;
    @Column(length = 15, nullable = false)
    private double valor_atual;
    @Column(length = 15, nullable = false)
    private double valor_final;
    @Column(length = 15, nullable = false)
    private double valor_saque;
    @Column(length = 15, nullable = false)
    private double valor_deposito;
    @Column(length = 15, nullable = false)
    private String tipo_servico;
}
