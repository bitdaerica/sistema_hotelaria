package br.com.pensaosalvatore.sistema_hotelaria.desktop.controller.principal;

import br.com.pensaosalvatore.sistema_hotelaria.desktop.view.hospede.CadHospedeView;
import br.com.pensaosalvatore.sistema_hotelaria.desktop.view.principal.PrincipalView;
import br.com.pensaosalvatore.sistema_hotelaria.desktop.view.quarto.CadQuartoView;
import br.com.pensaosalvatore.sistema_hotelaria.desktop.view.reserva.ReservaView;
import br.com.pensaosalvatore.sistema_hotelaria.desktop.view.usuario.CadUsuarioView;
import java.sql.SQLException;

/**
 *
 * @author Érica_Almeida
 */
public class PrincipalController {

    private final PrincipalView view;


    public PrincipalController(PrincipalView view) {
        this.view = view;
    }

    public void entrarCadastroHospede() {
        CadHospedeView tela = new CadHospedeView();
        tela.setVisible(true);

    }

    public void entrarCadastroQuarto() {
        CadQuartoView tela = new CadQuartoView();
        tela.setVisible(true);

    }

    public void entrarCadastroUsuario() throws SQLException {
        CadUsuarioView tela = new CadUsuarioView(null);
        tela.setVisible(true);

    }

    public void realizarReserva() {
        ReservaView tela = new ReservaView();
        tela.setVisible(true);

    }

    

}
