package br.com.fiap.bean;

public class Zona {
    private String nome;
    private String bairrosPerigosos;

    //contrutores
    public Zona(String nome, String bairrosPerigosos) {
        this.nome = nome;
        this.bairrosPerigosos = bairrosPerigosos;
    }

    //getters e setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getBairrosPerigosos() {
        return bairrosPerigosos;
    }
    public void setBairrosPerigosos(String bairrosPerigosos) {

    }
}