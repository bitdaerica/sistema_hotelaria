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

    public Usuario(Integer id, String nome, String usuario, String senha, Genero genero, Date dataNascimento,
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

    /**
     * Retorna uma instância de Pessoa com os dados herdados do usuário.Útil
     * para operações que precisam da entidade Pessoa (como o DAO).
     *
     * @return
     */
    public Pessoa getPessoa() {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(this.getId());
        pessoa.setNome(this.getNome());
        pessoa.setGenero(this.getGenero());
        pessoa.setDataNascimento(this.getDataNascimento());
        pessoa.setCpf(this.getCpf());
        pessoa.setEmail(this.getEmail());
        pessoa.setFixo(this.getFixo());
        pessoa.setCelular(this.getCelular());
        pessoa.setWhatsapp(this.getWhatsapp());
        pessoa.setObservacoes(this.getObservacoes());
        pessoa.setEndereco(this.getEndereco());
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        if (pessoa != null) {
            this.setId(pessoa.getId());
            this.setNome(pessoa.getNome());
            this.setGenero(pessoa.getGenero());
            this.setDataNascimento(pessoa.getDataNascimento());
            this.setCpf(pessoa.getCpf());
            this.setEmail(pessoa.getEmail());
            this.setFixo(pessoa.getFixo());
            this.setCelular(pessoa.getCelular());
            this.setWhatsapp(pessoa.getWhatsapp());
            this.setObservacoes(pessoa.getObservacoes());
            this.setEndereco(pessoa.getEndereco());
        }

    }
}
