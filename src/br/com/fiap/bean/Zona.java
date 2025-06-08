package br.com.fiap.bean;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Zona {
    private String nome;
    private String bairrosPerigosos;

    // Construtor
    public Zona(String nome, String bairrosPerigosos) {
        this.nome = nome;
        this.bairrosPerigosos = bairrosPerigosos;
    }

    // Getters e setters
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
        this.bairrosPerigosos = bairrosPerigosos;
    }

    // Métodos
    public static String getZonas() {
        return "1 - Zona Norte\n"
                + "2 - Zona Sul\n"
                + "3 - Zona Leste\n"
                + "4 - Zona Oeste\n"
                + "5 - Centro\n";
    }


    public static String getBairrosPorZona(int opcaoZona) {
        switch(opcaoZona) {
            case 1:
                return "Jaçanã, Tremembé, Vila Maria";
            case 2:
                return "Capão Redondo, Grajaú, Jardim Ângela";
            case 3:
                return "São Mateus, Itaquera, Guaianases";
            case 4:
                return "Butantã, Pinheiros, Lapa";
            case 5:
                return "Sé, República, Bela Vista";
            default:
                return "Zona inválida";
        }
    }

    public String simularPrevisao(LocalDate data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormatada = data.format(formatter);

        int dia = data.getDayOfMonth();
        int chuva = 10 + (dia % 3) * 10; // Pode ser 10, 20 ou 30 mm
        String risco;
        if (chuva >= 30) {
            risco = "ALTO";
        } else if (chuva >= 20) {
            risco = "MÉDIO";
        } else {
            risco = "BAIXO";
        }
        return "Previsão para " + dataFormatada + " na zona " + nome + ": " + chuva + "mm de chuva. " +
                "\nRisco de enchente: " + risco + ".";
    }
}
