package com.factory.contabancaria.testDTO;


import com.factory.contabancaria.dto.ContaGetDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
// É usada para indicar que você está executando testes de integração de Spring Boot.
// Essa anotação carrega o contexto completo da aplicação Spring durante a execução dos testes,
// o que permite que você teste várias partes da sua aplicação em conjunto, incluindo componentes,
// serviços, controladores, etc.
public class ContaGetDTOTests {

    @Test
    public void testContaGetDTO() {
        String numeroConta = "125";
        String agencia = "1234";
        String nomeCliente = "Carlos";
        BigDecimal valorAtualConta = BigDecimal.valueOf(1500.99);

        ContaGetDTO dtoGet = new ContaGetDTO(numeroConta, agencia, nomeCliente, valorAtualConta);

        assertEquals(numeroConta, dtoGet.getNumero_conta());
        assertEquals(agencia, dtoGet.getAgencia());
        assertEquals(nomeCliente, dtoGet.getNomeCliente());
        assertEquals(valorAtualConta, dtoGet.getValor_atual_conta());

        System.out.println();
        System.out.println("RESULTADOS DE GET");
        System.out.println("Número da conta: " + dtoGet.getNumero_conta());
        System.out.println("Agência: " + dtoGet.getAgencia());
        System.out.println("Nome do cliente: " + dtoGet.getNomeCliente());
        System.out.println("Valor atual da conta: " + dtoGet.getValor_atual_conta());
        System.out.println();

        //Os métodos assertEquals verificam se os valores esperados coincidem com os valores obtidos
        // dos métodos getters. O uso do System.out.println para imprimir os resultados no console é
        // uma boa prática para visualizar os detalhes do teste durante a execução,
        // o que pode ser útil para depuração.

    }


}
