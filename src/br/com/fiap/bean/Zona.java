package br.com.fiap.bean;

import java.time.LocalDate;

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

    // Método estático que retorna as opções de zonas
    public static String getZonas() {
        return "1 - Zona Norte\n"
                + "2 - Zona Sul\n"
                + "3 - Zona Leste\n"
                + "4 - Zona Oeste\n"
                + "5 - Centro\n";
    }

    // Método estático que retorna os bairros perigosos conforme a zona escolhida
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

    // Simulação da previsão do tempo para uma data específica (sobrecarga)
    public String simularPrevisao(LocalDate data) {
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
        return "Previsão para " + data + " na zona " + nome + ": " + chuva + "mm de chuva. Risco de enchente: " + risco + ".";
    }

    // Simulação da previsão do tempo para a data atual (sobrecarga)
    public String simularPrevisao() {
        return simularPrevisao(LocalDate.now());
    }
}
