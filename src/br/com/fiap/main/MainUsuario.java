package br.com.fiap.main;

import br.com.fiap.bean.*;

import javax.swing.JOptionPane;
import java.time.LocalDate;

public class MainUsuario {
    public static void main(String[] args) {

        // Boas vindas
        JOptionPane.showMessageDialog(null,
                "Olá seja bem-vindo (a) ao FloodTech!\nPara iniciarmos clique em OK",
                "Boas-vindas",
                JOptionPane.INFORMATION_MESSAGE);

        // Cadastro do usuário
        String nome = JOptionPane.showInputDialog(null, "Digite seu nome:", "Nome", JOptionPane.QUESTION_MESSAGE);
        String telefone = JOptionPane.showInputDialog(null, "Digite seu telefone:", "Telefone", JOptionPane.QUESTION_MESSAGE);

        Usuario usuario = new Usuario(nome, telefone);

        boolean sair = false;

        while (!sair) {
            String menu = "Escolha uma opção:\n"
                    + "1 - Zonas\n"
                    + "2 - Contato\n"
                    + "3 - Boas Práticas\n"
                    + "4 - Sair";

            String escolhaStr = JOptionPane.showInputDialog(null, menu, "Menu", JOptionPane.QUESTION_MESSAGE);
            if (escolhaStr == null) {
                break;
            }

            int escolha;
            try {
                escolha = Integer.parseInt(escolhaStr);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, digite um número válido.", "Erro", JOptionPane.ERROR_MESSAGE);
                continue;
            }

            switch (escolha) {
                case 1:
                    String opcoesZonas = Zona.getZonas();
                    String zonaEscolhidaStr = JOptionPane.showInputDialog(null, "Escolha sua zona:\n" + opcoesZonas, "Zonas", JOptionPane.QUESTION_MESSAGE);
                    if (zonaEscolhidaStr == null) break;

                    int zonaEscolhida;
                    try {
                        zonaEscolhida = Integer.parseInt(zonaEscolhidaStr);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Opção inválida. Por favor, digite um número válido.", "Erro", JOptionPane.ERROR_MESSAGE);
                        break;
                    }

                    String bairros = Zona.getBairrosPorZona(zonaEscolhida);
                    if (bairros.equals("Zona inválida")) {
                        JOptionPane.showMessageDialog(null, "Zona inválida. \nPor favor, selecione uma opção válida.", "Erro", JOptionPane.ERROR_MESSAGE);
                        break;
                    }

                    String nomeZona = "";
                    switch (zonaEscolhida) {
                        case 1: nomeZona = "Zona Norte"; break;
                        case 2: nomeZona = "Zona Sul"; break;
                        case 3: nomeZona = "Zona Leste"; break;
                        case 4: nomeZona = "Zona Oeste"; break;
                        case 5: nomeZona = "Centro"; break;
                    }

                    Zona zona = new Zona(nomeZona, bairros);

                    JOptionPane.showMessageDialog(null, "Bairros perigosos na zona selecionada:\n" + bairros, "Bairros", JOptionPane.INFORMATION_MESSAGE);

                    // Exibir previsão do tempo (usando sobrecarga)
                    String previsao = zona.simularPrevisao(LocalDate.now());
                    JOptionPane.showMessageDialog(null, previsao, "Previsão do tempo", JOptionPane.INFORMATION_MESSAGE);

                    int moraNaZona = JOptionPane.showConfirmDialog(null, "Você mora em algum desses bairros?", "Confirmação", JOptionPane.YES_NO_OPTION);

                    if (moraNaZona == JOptionPane.YES_OPTION) {
                        MensagemEmergenciaZona mensagemEmergenciaZona = new MensagemEmergenciaZona(previsao);
                        JOptionPane.showMessageDialog(null, mensagemEmergenciaZona.getTexto() + "\nVerifique os contatos no menu.", "Mensagem de emergência.", JOptionPane.INFORMATION_MESSAGE);
                    } else if (moraNaZona == JOptionPane.NO_OPTION) {
                        BoasPraticas boasPraticas = new BoasPraticas();
                        JOptionPane.showMessageDialog(null, "Recomendamos que você leia as boas práticas:\n\n" + boasPraticas.getTexto(), "Recomendação", JOptionPane.INFORMATION_MESSAGE);
                    }
                    break;

                case 2:
                    Contato contato = new Contato();
                    JOptionPane.showMessageDialog(null, contato.getTexto(), "Contatos", JOptionPane.INFORMATION_MESSAGE);
                    break;

                case 3:
                    BoasPraticas boasPraticas = new BoasPraticas();
                    JOptionPane.showMessageDialog(null, boasPraticas.getTexto(), "Boas Práticas", JOptionPane.INFORMATION_MESSAGE);
                    break;

                case 4:
                    sair = true;
                    JOptionPane.showMessageDialog(null, "Programa encerrado. Obrigado!", "Fim", JOptionPane.INFORMATION_MESSAGE);
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
