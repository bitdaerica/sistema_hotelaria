package br.com.pensaosalvatore.sistema_hotelaria.modelo.dto;

import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.enumeradores.Genero;
import java.util.Date;

/**
 *
 * @author 202412170006
 */
public class Usuario extends Pessoa {

    private String usuario;
    private String senha;

    public Usuario() {

    }

    public Usuario(Integer id) {
        super(id);
    }
    

    public Usuario(int id, String usuario, String senha) {
        super(id);
        this.usuario = usuario;
        this.senha = senha;
    }

    public Usuario(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

    public Usuario(Integer id, String nome, String usuario, String senha, Genero genero, Date dataNascimento, String cpf, String email, String fixo, String celular, Boolean whatsapp, String observacoes, Endereco endereco) {
        super(id, nome, genero, dataNascimento, cpf, email, fixo, celular, whatsapp, observacoes, endereco);
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

    public Pessoa getPessoa() {
        return null;
    }

    
}
