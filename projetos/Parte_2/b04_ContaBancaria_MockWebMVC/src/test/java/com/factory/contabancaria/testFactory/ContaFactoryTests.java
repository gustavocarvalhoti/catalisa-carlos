package com.factory.contabancaria.testFactory;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.factory.contabancaria.model.factory.ContaFactory;
import com.factory.contabancaria.model.factory.CalculoConta;
import com.factory.contabancaria.model.factory.CalculoDeposito;
import com.factory.contabancaria.model.factory.CalculoSaque;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
// Inicia o contexto da aplicação Spring, o que permitirá que você use os beans reais em seu teste,
// incluindo o bean ContaFactory.
public class ContaFactoryTests {

    @MockBean
    private CalculoDeposito calculoDeposito;

    @MockBean
    private CalculoSaque calculoSaque;

    private ContaFactory contaFactory;

    private CalculoConta calculoConta;

    @BeforeEach
    @Test
    void setupDados() {
        contaFactory = new ContaFactory();
        calculoSaque = new CalculoSaque();
        calculoDeposito = new CalculoDeposito();

    }
    //Método para teste de calculo por serviço de depósito
    @Test
    public void testTipoServicoContaDeposito() {
        //Simular o tipo de conta deposito
        CalculoConta calculoDeposito = Mockito.mock(CalculoConta.class);
        BigDecimal resultadoEsperado = BigDecimal.valueOf(1500.00);
        when(calculoDeposito.calcular(BigDecimal.valueOf(1000.00), BigDecimal.valueOf(500.00)))
                .thenReturn(resultadoEsperado);

        CalculoConta calculoconta = contaFactory.tipoServicoConta("deposito");
        BigDecimal resultado = calculoconta.calcular(BigDecimal.valueOf(1000.00),
                BigDecimal.valueOf(500.00));

        assertEquals(resultadoEsperado, resultado);
        System.out.println();
        System.out.println("RESULTADOS DE CÁLCULO DEPÓSITO");
        System.out.println("O resultado inicial é: " + resultado);
        System.out.println("O resultado esperado após o depósito é: " + resultadoEsperado);
        System.out.println();

    }

    //Método para teste de calculo por serviço de saque
    @Test
    public void testTipoServicoContaSaque() {
        //Simular o tipo de conta saque
        CalculoConta calculoSaque = Mockito.mock(CalculoConta.class);
        BigDecimal resultadoEsperado = BigDecimal.valueOf(1500.00);
        when(calculoSaque.calcular(BigDecimal.valueOf(2000.00), BigDecimal.valueOf(500.00)))
                .thenReturn(resultadoEsperado);

        CalculoConta calculoconta = contaFactory.tipoServicoConta("saque");
        BigDecimal resultado = calculoconta.calcular(BigDecimal.valueOf(2000.00),
                BigDecimal.valueOf(500.00));

        assertEquals(resultadoEsperado, resultado);
        System.out.println();
        System.out.println("RESULTADOS DE CÁLCULO DE SAQUE");
        System.out.println("O resultado inicial é: " + resultado);
        System.out.println("O resultado esperado após o saque é: " + resultadoEsperado);
        System.out.println();
    }

}


