package br.com.pensaosalvatore.sistema_hotelaria.desktop.controller.autenticacao;

import br.com.pensaosalvatore.sistema_hotelaria.desktop.view.autenticacao.AutenticacaoView;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dao.UsuarioDAO;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.util.Conexao;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Érica_Almeida
 */
public class AutenticacaoController {

    private final AutenticacaoView view;

    public AutenticacaoController(AutenticacaoView view) {
        this.view = view;
    }

    public void entarnoSistema() throws SQLException {

        Connection connection = Conexao.getConnection();
        UsuarioDAO usuarioDAO = new UsuarioDAO(connection);

    }

    public void fizTarefa() {
        System.out.println("Busquei algo do banco de dados");

        this.view.exibeMensagem("Seja Bem-vindo!");
    }

    //  public void buscarUsuario(){
    //  }
}
