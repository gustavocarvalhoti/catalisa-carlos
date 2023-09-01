package system;

import java.util.Map;

//Temos a entidade "Rebelde" com os atributos nome, idade, gênero, localização e inventário.
public class Rebelde {

    private String nome;
    private int idade;
    private String genero;
    private String localizacao;
    private Map<String, Integer> inventario;


    public Rebelde(String nome, int idade, String genero, String localizacao, Map<String, Integer> inventario) {
        this.nome = nome;
        this.idade = idade;
        this.genero = genero;
        this.localizacao = localizacao;
        this.inventario = inventario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public Map<String, Integer> getInventario() {
        return inventario;
    }

    public void setInventario(Map<String, Integer> inventario) {
        this.inventario = inventario;
    }
}
