package br.com.pensaosalvatore.sistema_hotelaria.desktop.controller.usuario;

import br.com.pensaosalvatore.sistema_hotelaria.desktop.view.usuario.CadUsuarioView;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.util.Conexao;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dao.UsuarioDAO;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.Usuario;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Érica_Almeida
 */
public class CadUsuarioController {

    private CadUsuarioView view;
    
    public CadUsuarioController(CadUsuarioView view) {
        this.view = view;

    }

    public void salvaUsuario() {
        String nome = view.getTxtNome().getText();
        String usuarioStr = view.getTxtUsuario().getText();
        String senha = new String(view.getSenha().getPassword());
        String email = view.getTxtEmail2().getText();
        String cpf = view.getFmtCpf().getText();
        String celular = view.getFmtCelular().getText();
        String fixo = view.getFmtFixo().getText();
        String dataNascimento = view.getFmtDatanascimento().getText();
        String genero = view.getTxtGenero().getText();

        boolean whatsapp = view.getBtnWhatsapp().isSelected();
        String observacoes = view.getTxtObservacoes().getText();

        String cep = view.getFmtCep().getText();
        String rua = view.getTxtRua().getText();
        String numero = view.getTxtNumero().getText();
        String bairro = view.getTxtBairro().getText();
        String cidade = view.getTxtCidade().getText();

        String estado = view.getTxtEstado().getText();

        String complemento = view.getTxtComplemento().getText();

        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setUsuario(usuarioStr);
        usuario.setSenha(senha);
        usuario.setEmail(email);
        usuario.setCpf(cpf);
        usuario.setCelular(celular);
        usuario.setFixo(fixo);
        usuario.setWhatsapp(whatsapp);
        usuario.setObservacoes(observacoes);

        try (Connection conexao = Conexao.getConnection()) {  // try-with-resources para fechar conexão automaticamente
            UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
            usuarioDao.inserirUsuario(usuario);
            JOptionPane.showMessageDialog(null, "Usuário salvo com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(CadUsuarioView.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao salvar usuário: " + ex.getMessage());
        }
    }

    public void limparCampos() {
        view.getTxtNome().setText("");
        view.getTxtUsuario().setText("");
        view.getSenha().setText("");
        view.getTxtEmail2().setText("");
        view.getFmtCpf().setText("");
        view.getFmtCelular().setText("");
        view.getFmtFixo().setText("");
        view.getFmtDatanascimento().setText("");
        view.getTxtGenero().setText("");
        view.getBtnWhatsapp().setSelected(false);
        view.getTxtObservacoes().setText("");

        view.getFmtCep().setText("");
        view.getTxtRua().setText("");
        view.getTxtBairro().setText("");
        view.getTxtCidade().setText("");
        view.getTxtNumero().setText("");
        view.getTxtEstado().setText("");
        view.getTxtComplemento().setText("");
    }

    public void cancelar() {
        limparCampos();
        JOptionPane.showMessageDialog(null, "Operação cancelada.");
    }

    public void mostrarTela() {
        CadUsuarioView mostrar = new CadUsuarioView();
        mostrar.setVisible(true);
    }

    

    

}
