package br.com.pensaosalvatore.sistema_hotelaria.desktop.controller.principal;

import br.com.pensaosalvatore.sistema_hotelaria.desktop.controller.autenticacao.AutenticacaoController;
import br.com.pensaosalvatore.sistema_hotelaria.desktop.view.autenticacao.AutenticacaoView;
import br.com.pensaosalvatore.sistema_hotelaria.desktop.view.hospede.CadHospedeView;
import br.com.pensaosalvatore.sistema_hotelaria.desktop.view.principal.PrincipalView;
import br.com.pensaosalvatore.sistema_hotelaria.desktop.view.quarto.CadQuartoView;
import br.com.pensaosalvatore.sistema_hotelaria.desktop.view.reserva.CadReservaView;
import br.com.pensaosalvatore.sistema_hotelaria.desktop.view.usuario.CadUsuarioView;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.Usuario;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Érica_Almeida
 */
public class PrincipalController {

    private final PrincipalView view;
    private String usuarioLogado;

    public PrincipalController(PrincipalView view, Usuario usuario) {
        this.view = view;
        this.usuarioLogado = usuario.getUsuario();
        configurarAcoes();
        configurarUsuario();
    }

    private void configurarUsuario() {
        view.getLblNomedousuario().setText("Usuário: " + usuarioLogado);

    }

    private void configurarAcoes() {
        // Configura ações dos botões
        view.getMiHospede().addActionListener(e -> entrarCadastroHospede());
        view.getMiQuarto().addActionListener(e -> entrarCadastroQuarto());
        view.getMiUsuario().addActionListener(e -> entrarCadastroUsuario());
        view.getMiRealizarreserva().addActionListener(e -> realizarReserva());
        view.getMnSair().addActionListener(e -> sairSistema());
        view.getBtnLogoff().addActionListener(e -> logoff());
    }

    public void entrarCadastroHospede() {
        abrirJanela(new CadHospedeView(), "Cadastro de Hóspedes");
    }

    public void entrarCadastroQuarto() {
        abrirJanela(new CadQuartoView(), "Cadastro de Quartos");
    }

    public void entrarCadastroUsuario() {
        abrirJanela(new CadUsuarioView(), "Cadastro de Usuários");
    }

    public void realizarReserva() {
        abrirJanela(new CadReservaView(), "Realizar Reserva");
    }

    private void abrirJanela(JFrame janela, String titulo) {
        janela.setTitle(titulo);
        janela.setLocationRelativeTo(view);
        janela.setVisible(true);
    }

    private void logoff() {
        int resposta = JOptionPane.showConfirmDialog(
                view,
                "Deseja realmente fazer LogOff?",
                "Confirmar LogOff",
                JOptionPane.YES_NO_OPTION
        );

        if (resposta == JOptionPane.YES_OPTION) {
            view.dispose(); // Fechar a janela
            AutenticacaoView loginView = new AutenticacaoView();
            AutenticacaoController controller = new AutenticacaoController(loginView);
            loginView.setVisible(true);
        }

    }

    private void sairSistema() {
        int resposta = JOptionPane.showConfirmDialog(
                view,
                "Deseja realmente sair?",
                "Confirmar Sair",
                JOptionPane.YES_NO_OPTION
        );

        if (resposta == JOptionPane.YES_OPTION) {
            view.dispose(); // Fechar a janela
            System.exit(0);
        }

    }

    public void iniciar() {
        view.setLocationRelativeTo(null); // Centraliza a janela
        view.setVisible(true);
    }
}
