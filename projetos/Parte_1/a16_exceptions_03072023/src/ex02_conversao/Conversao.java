package a16_exceptions_03072023.src.ex02_conversao;

import java.math.BigDecimal;
import java.util.HashMap;


public class Conversao {
    HashMap<String, BigDecimal> moedas = new HashMap<>();
    private String tipoDaMoeda;
    private boolean valor;


    public Conversao() {
        moedas.put("Dolar Americano", new BigDecimal(5));
        moedas.put("Dolar Canadense", new BigDecimal(1));
        moedas.put("Euro", new BigDecimal(6));
        moedas.put("Libra Esterlina", new BigDecimal(1));


    }

    //metodo que verifica o tipo de moeda e se é válida.
    public void verificaTipoDeMoeda(String tipoDaMoeda) {
        if (!moedas.containsKey(tipoDaMoeda)) {
            throw new IllegalArgumentException("Tipo" + tipoDaMoeda + " de moeda inválido.");
            this.tipoDaMoeda = tipoDaMoeda;
        }

        //metodo verificar se o valor é nulo, menor que zero.

        public void verificaValorInserido (BigDecimal valor) {
            if (valor == null) {
                throw new NumberFormatException("Paramoeda o valor monetário deve ser um número decimal.");

                if (valor.compareTo(BigDecimal.ZERO) == 0 || valor.compareTo(BigDecimal.ZERO) < 0) {
                    throw new NumberFormatException("Paramoeda o valor monetário deve ser um número positivo.");
                }
            }

        }

    }
}

