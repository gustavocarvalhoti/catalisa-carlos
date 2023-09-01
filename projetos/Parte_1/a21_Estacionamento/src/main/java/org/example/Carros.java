package org.example;


import java.time.LocalDateTime;

//Classe Carros para a criação de um objeto para controle de estacionamento
public class Carros {
    private String placa;
    private String modelo;
    private String marca;
    private String proprietario;
    private LocalDateTime dataEntrada;
    private LocalDateTime dataSaida;
    private double precoTotal;

    public Carros(String placa, String marca, String modelo, LocalDateTime dataEntrada,
                  LocalDateTime dataSaida, double precoTotal, String proprietario) {
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.proprietario = proprietario;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.precoTotal = precoTotal;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public LocalDateTime getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDateTime dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public LocalDateTime getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDateTime dataSaida) {
        this.dataSaida = dataSaida;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }
}
