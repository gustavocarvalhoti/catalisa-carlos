package com.factory.contabancaria.testController;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


import com.factory.contabancaria.controller.ContasController;
import com.factory.contabancaria.model.ContasModel;
import com.factory.contabancaria.service.ContasService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;


@WebMvcTest(ContasController.class)
//é usado para testar os controladores e suas interações com as camadas relacionadas à web,
// como a camada de segurança, a camada de serviço e a camada de persistência.
public class ContaControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ContasService contasService;

    private List<ContasModel> contas;

    @BeforeEach
    @Test
    void startList() {
        //Preparando o cenário de dados para criar uma lista.
        contas = new ArrayList<>();
        contas.add(new ContasModel(1L, "123", "1234", "Carlos",
                BigDecimal.valueOf(100.00), BigDecimal.valueOf(1000.00), "Deposito"));

        System.out.println();
        System.out.println(contas);

    }

    //Teste para listar todas as contas cadastradas no sistema Bancário
    @Test
    public void testListarContas() throws Exception {
        when(contasService.listarContas()).thenReturn(contas);


        mockMvc.perform(MockMvcRequestBuilders.get("/api/contas"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].numero_conta").value("123"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].agencia").value("1234"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].nomeCliente").value("Carlos"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].valor_atual_conta").value(100.00))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].valor_fornecido").value(1000.00))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].tipo_servico").value("Deposito"))

                //Printar os dados no console para facilitar a depuração
                .andDo(print());
    }

    //Teste para Listar conta pela Classe ContaGetDTO
    @Test

    public void testListarContasDTO() throws Exception {
        when(contasService.listarContas()).thenReturn(contas);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/contas/dto"))
                .andExpectAll(MockMvcResultMatchers.status().isOk(),
                        MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON),
                        MockMvcResultMatchers.jsonPath("$.length()").value(1),
                        MockMvcResultMatchers.jsonPath("$[0].numero_conta").value("123"),
                        MockMvcResultMatchers.jsonPath("$[0].agencia").value("1234"),
                        MockMvcResultMatchers.jsonPath("$[0].nomeCliente").value("Carlos"),
                        MockMvcResultMatchers.jsonPath("$[0].valor_atual_conta").value(100.00))


                .andDo(print());
    }


}
