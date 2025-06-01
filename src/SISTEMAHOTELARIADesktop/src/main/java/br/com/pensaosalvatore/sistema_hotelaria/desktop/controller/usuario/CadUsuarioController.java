package br.com.pensaosalvatore.sistema_hotelaria.desktop.controller.usuario;

import br.com.pensaosalvatore.sistema_hotelaria.desktop.view.usuario.CadUsuarioView;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dao.Conexao;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dao.UsuarioDAO;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.UsuarioDTO;
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
            // Pegando os dados da view
    String nome = view.getTxtNome().getText();
    String usuarioStr = view.getTxtUsuario().getText();
    String senha = new String(view.getSenha().getPassword());
    String email = view.getTxtEmail2().getText();
    String cpf = view.getFmtCpf().getText();
    String celular = view.getFmtCelular().getText();
    String fixo = view.getFmtFixo().getText();
    String dataNascimento = view.getFmtDatanascimento().getText();
    String genero = view.getCmbGenero1().getSelectedItem().toString();
    boolean whatsapp = view.getBtnWhatsapp().isSelected();
    String observacoes = view.getTxtObservacoes().getText();

    String cep = view.getFmtCep().getText();
    String rua = view.getTxtRua().getText();
    String bairro = view.getTxtBairro().getText();
    String cidade = view.getTxtCidade().getText();
    String estado = view.getCmbEstado().getSelectedItem().toString();
    String complemento = view.getTxtComplemento().getText();

    // Criando o objeto DTO
    UsuarioDTO usuarioDTO = new UsuarioDTO();
    usuarioDTO.setNome(nome);
    usuarioDTO.setUsuario(usuarioStr);
    usuarioDTO.setSenha(senha);
    usuarioDTO.setEmail(email);
    usuarioDTO.setCpf(cpf);
    usuarioDTO.setCelular(celular);
    usuarioDTO.setFixo(fixo);
    usuarioDTO.setWhatsapp(whatsapp);
    usuarioDTO.setObservacoes(observacoes);
    

    // Salvando no banco
    try {
        Connection conn = new Conexao().conectaBD();
        UsuarioDAO usuarioDao = new UsuarioDAO((Conexao) conn);
        usuarioDao.inserirUsuario(usuarioDTO);

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
        view.getCmbGenero1().setSelectedIndex(0);
        view.getBtnWhatsapp().setSelected(false);
        view.getTxtObservacoes().setText("");

       view.getFmtCep().setText("");
        view.getTxtRua().setText("");
        view.getTxtBairro().setText("");
        view.getTxtCidade().setText("");
        view.getCmbEstado().setSelectedIndex(0);
        view.getTxtComplemento().setText("");
    }

    public void cancelar() {
        limparCampos();
        JOptionPane.showMessageDialog(null, "Operação cancelada.");
    }

}
