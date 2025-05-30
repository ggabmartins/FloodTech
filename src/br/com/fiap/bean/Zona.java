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
    public void setBairrosPerigosos(String bairrosPerigosos){
    }

    //metodos particulares
    public static String getZonas() {
        // Retorna as zonas separadas por vírgula ou número para o menu
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
}