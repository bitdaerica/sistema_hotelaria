package br.com.pensaosalvatore.sistema_hotelaria.modelo.dto;

import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.enumeradores.Genero;

/**
 *
 * @author 202412170006
 */
public class UsuarioDTO extends PessoaDTO {

    private String usuario;
    private String senha;

    public UsuarioDTO() {

    }

    public UsuarioDTO(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

    
    public UsuarioDTO(String usuario, String senha, Integer id, String nome, Genero genero, String cpf, String email, String celular, Boolean whatsapp, EnderecoDTO endereco) {
        super(id, nome, genero, cpf, email, celular, whatsapp, endereco);
        this.usuario = usuario;
        this.senha = senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
