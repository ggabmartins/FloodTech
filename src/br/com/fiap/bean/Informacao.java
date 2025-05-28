package br.com.fiap.bean;

public class Informacao {
    private String Texto;

    //Construtor
    public Informacao(String Texto) {
        this.Texto = Texto;
    }

    //Getters e setters

    public String getTexto() {
        return Texto;
    }

    public void setTexto(String texto) {
        Texto = texto;
    }
}
