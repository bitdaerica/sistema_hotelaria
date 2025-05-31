/**
package br.com.pensaosalvatore.sistema_hotelaria.desktop.controller.helper;

import br.com.pensaosalvatore.sistema_hotelaria.desktop.view.autenticacao.AutenticacaoView;






 *
 * @author Érica_Almeida
 
public class AutenticacaoHelper {
    private final AutenticacaoView view;

    public AutenticacaoHelper(AutenticacaoView view) {
        this.view = view;
    }
    
    public UsuarioDTO obterModelo(){
        String nome = view.getTxtUsuario().getText();
        String senha = view.getPfSenha().getText();
        UsuarioDTO modelo = new UsuarioDTO(0, nome, senha);
        return modelo;
    }
    
   
}
*/