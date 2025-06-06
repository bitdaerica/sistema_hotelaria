package br.com.pensaosalvatore.sistema_hotelaria.desktop.controller.autenticacao;

import br.com.pensaosalvatore.sistema_hotelaria.desktop.controller.principal.PrincipalController;
import br.com.pensaosalvatore.sistema_hotelaria.desktop.view.autenticacao.AutenticacaoView;
import br.com.pensaosalvatore.sistema_hotelaria.desktop.view.principal.PrincipalView;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dao.UsuarioDAO;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.Usuario;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.util.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Controller responsável pela autenticação do usuário no sistema. Realiza
 * validações, conexão com o banco e redireciona para a tela principal.
 *
 * @author Érica
 */
public class AutenticacaoController {

    private final AutenticacaoView view; // Referência para a tela de login
    private UsuarioDAO usuarioDAO;       // DAO para acesso ao banco de usuários

    /**
     * Construtor: inicializa a view e a conexão com o banco de dados.
     *
     * @param view Tela de autenticação associada ao controller.
     */
    public AutenticacaoController(AutenticacaoView view) {
        this.view = view;

        try {
            Connection connection = Conexao.getConnection(); // Estabelece conexão com o banco
            this.usuarioDAO = new UsuarioDAO(connection);    // Instancia o DAO com a conexão
        } catch (SQLException e) {
            // Exibe erro de conexão ao usuário
            JOptionPane.showMessageDialog(view, "Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }

    /**
     * Método principal de entrada no sistema. Valida campos, consulta o banco e
     * realiza o login.
     */
    public void entrarNoSistema() {
        // Recupera os dados da interface
        String usuario = view.getTxtUsuario().getText().trim();
        String senha = new String(view.getTxtSenha().getPassword()).trim();

        // Validação de campos obrigatórios
        if (usuario.isEmpty() || senha.isEmpty()) {
            mostrarErro("Preencha todos os campos!");
            return;
        }

        try {
            // Verifica se usuário e senha existem e estão corretos
            if (usuarioDAO.existeNoBancoPorUsuarioESenha(usuario, senha)) {
                Usuario usuarios = usuarioDAO.listarPorUsuario(usuario);
                mostrarTelaPrincipal(usuarios);
            } else {
                mostrarErro("Usuário ou senha incorretos!");
                limparSenha();
            }
        } catch (SQLException ex) {
            Logger.getLogger(AutenticacaoController.class.getName()).log(Level.SEVERE, null, ex);
            mostrarErro("Erro ao acessar o sistema. Tente novamente.");
        }
    }

    /**
     * Exibe a tela principal após autenticação bem-sucedida.
     *
     * @param usuario Usuário autenticado
     */
    private void mostrarTelaPrincipal(Usuario usuario) {
        view.dispose(); // Fecha a tela de login
        PrincipalView principalView = new PrincipalView(usuario); // Cria tela principal com usuário
        new PrincipalController(principalView, usuario).iniciar(); // Inicia o controller da tela principal
    }

    /**
     * Exibe uma mensagem de erro para o usuário.
     *
     * @param mensagem Texto da mensagem
     */
    private void mostrarErro(String mensagem) {
        JOptionPane.showMessageDialog(view, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Limpa o campo de senha e reposiciona o foco no campo de usuário.
     */
    private void limparSenha() {
        view.getTxtUsuario().setText("");
        view.getTxtSenha().setText("");
        view.getTxtUsuario().requestFocus();
    }

    /**
     * Realiza a confirmação de saída do sistema.
     */
    public void sair() {
        int resposta = JOptionPane.showConfirmDialog(
                view,
                "Deseja realmente sair?",
                "Confirmar Sair",
                JOptionPane.YES_NO_OPTION
        );

        if (resposta == JOptionPane.YES_OPTION) {
            view.dispose();  // Fecha a tela
            System.exit(0);  // Finaliza o programa
        }
    }
}
