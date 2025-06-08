package br.com.fiap.bean;

public class MensagemEmergenciaZona extends MensagemEmergencia {
    private String previsao;

        // Construtor recebe a previsão para incluir na mensagem
        public MensagemEmergenciaZona(String previsao) {
            super();
            this.previsao = previsao;
        }

        // Sobrescrita do método getTexto para incluir a previsão na mensagem
        @Override
        public String getTexto() {
            return super.getTexto() + "\nATENÇÃO: " + previsao;
        }
    }


