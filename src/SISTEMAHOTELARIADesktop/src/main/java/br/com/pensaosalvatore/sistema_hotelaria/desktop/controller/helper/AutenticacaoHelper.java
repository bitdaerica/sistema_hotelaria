
package br.com.pensaosalvatore.sistema_hotelaria.desktop.controller.helper;

import br.com.pensaosalvatore.sistema_hotelaria.desktop.view.autenticacao.AutenticacaoView;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.UsuarioDTO;



/**
 *
 * @author Érica_Almeida
 * */
 
public class AutenticacaoHelper {
    private final AutenticacaoView view;

    public AutenticacaoHelper(AutenticacaoView view) {
        this.view = view;
    }
    
    public UsuarioDTO obterModelo(){
        String nome = view.getTxtUsuario().getText();
        String senha = view.getTxtSenha().getText();
        
        UsuarioDTO modelo = new UsuarioDTO(0, nome, senha);
        return modelo;
    }
    
    public void setarModelo(UsuarioDTO modelo){
        String nome = modelo.getNome();
        String senha = modelo.getSenha();
        
        view.getTxtUsuario().setText(nome);
        view.getTxtSenha().setText(nome);
    }
    
    public void limparTela(){
        view.getTxtUsuario().setText("");
        view.getTxtSenha().setText("");
    }
   
}
