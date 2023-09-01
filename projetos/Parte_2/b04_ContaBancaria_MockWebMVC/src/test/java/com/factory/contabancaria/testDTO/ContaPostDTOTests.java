package com.factory.contabancaria.testDTO;

import com.factory.contabancaria.dto.ContaPostDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
// É usada para indicar que você está executando testes de integração de Spring Boot.
// Essa anotação carrega o contexto completo da aplicação Spring durante a execução dos testes,
// o que permite que você teste várias partes da sua aplicação em conjunto, incluindo componentes,
// serviços, controladores, etc.
public class ContaPostDTOTests {

    @Test
    public void testContaPostDTO() {
        String nomeCliente = "Carolina";
        BigDecimal valor_atual_conta = BigDecimal.valueOf(1500.22);
        BigDecimal valor_fornecido = BigDecimal.valueOf(500.00);
        String tipo_servico = "deposito";

        ContaPostDTO dtoPost = new ContaPostDTO();
        dtoPost.setNomeCliente(nomeCliente);
        dtoPost.setValor_atual_conta(valor_atual_conta);
        dtoPost.setValor_fornecido(valor_fornecido);
        dtoPost.setTipo_servico(tipo_servico);

        assertEquals(nomeCliente, dtoPost.getNomeCliente());
        assertEquals(valor_atual_conta, dtoPost.getValor_atual_conta());
        assertEquals(valor_fornecido, dtoPost.getValor_fornecido());
        assertEquals(tipo_servico, dtoPost.getTipo_servico());

        System.out.println();
        System.out.println("RESULTADOS DE POST");
        System.out.println("Nome do cliente: " + dtoPost.getNomeCliente());
        System.out.println("Valor atual da conta: " + dtoPost.getValor_atual_conta());
        System.out.println("Valor fornecido: " + dtoPost.getValor_fornecido());
        System.out.println("Tipo de serviço: " + dtoPost.getTipo_servico());
        System.out.println();

        //Os métodos assertEquals verificam se os valores esperados coincidem com os valores obtidos
        // dos métodos getters. O uso do System.out.println para imprimir os resultados no console é
        // uma boa prática para visualizar os detalhes do teste durante a execução,
        // o que pode ser útil para depuração.

    }
}
