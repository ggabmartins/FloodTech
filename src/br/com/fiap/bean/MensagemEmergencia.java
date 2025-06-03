package br.com.fiap.bean;

public class MensagemEmergencia extends Informacao {
    public MensagemEmergencia() {
        super("\nEm caso de enchente urgente:\n"
                + "- Procure abrigo em local seguro.\n"
                + "- Evite contato com a água.\n"
                + "- Siga as orientações da Defesa Civil.\n"
                + "- Tenha os contatos de emergência à mão.\n");
    }

    @Override
    public String getTexto() {
        // Exemplo: adiciona um prefixo de urgência antes do texto original
        return "[CUIDADO] " + super.getTexto();
    }
}

