package br.com.pensaosalvatore.sistema_hotelaria.modelo.dto;

import java.time.LocalDate;

/**
 *
 * @author 202412170006
 */
public class Usuario extends Pessoa {

    private String usuario;
    private String senha;

    // Construtores
    public Usuario() {
        super();
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

    public Usuario(Integer id, String nome, String usuario, String senha, String genero, LocalDate dataNascimento,
            String cpf, String email, String fixo, String celular, Boolean whatsapp, String observacoes, Endereco endereco) {
        super(id, nome, genero, dataNascimento, cpf, email, fixo, celular, whatsapp, observacoes, endereco);
        this.usuario = usuario;
        this.senha = senha;
    }

    // Getters e Setters
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

    @Override
    public String toString() {
        return id + " - " + usuario;
    }

}
