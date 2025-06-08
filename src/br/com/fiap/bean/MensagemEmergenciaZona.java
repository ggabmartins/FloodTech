package br.com.fiap.bean;

public class MensagemEmergenciaZona extends MensagemEmergencia {
    private String previsao;


        public MensagemEmergenciaZona(String previsao) {
            super();
            this.previsao = previsao;
        }


        @Override
        public String getTexto() {
            return super.getTexto() + "\nATENÇÃO: " + previsao;
        }
    }


