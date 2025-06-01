package br.com.pensaosalvatore.sistema_hotelaria.modelo.dto;

import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.enumeradores.Genero;
import java.util.Date;

/**
 *
 * @author Érica_Almeida
 */
public class PessoaDTO {

    private Integer id;
    private String nome;
    private Genero genero;
    private Date dataNascimento;
    private String cpf;
    private String email;
    private String fixo;
    private String celular;
    private Boolean whatsapp;
    private String observacoes;
    private EnderecoDTO endereco;

    public PessoaDTO() {
    }

    public PessoaDTO(Integer id) {
        this.id = id;
    }

    
    
    public PessoaDTO(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    
    

    public PessoaDTO(Integer id, String nome, Genero genero, Date dataNascimento, String cpf, String email, String fixo, String celular, Boolean whatsapp, String observacoes, EnderecoDTO endereco) {
        this.id = id;
        this.nome = nome;
        this.genero = genero;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.email = email;
        this.fixo = fixo;
        this.celular = celular;
        this.whatsapp = whatsapp;
        this.observacoes = observacoes;
        this.endereco = endereco;
    }

    public PessoaDTO(Integer id, String nome, Genero genero, String cpf, String email, String celular, Boolean whatsapp, EnderecoDTO endereco) {
        this.id = id;
        this.nome = nome;
        this.genero = genero;
        this.cpf = cpf;
        this.email = email;
        this.celular = celular;
        this.whatsapp = whatsapp;
        this.endereco = endereco;
    }

    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFixo() {
        return fixo;
    }

    public void setFixo(String fixo) {
        this.fixo = fixo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Boolean getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(Boolean whatsapp) {
        this.whatsapp = whatsapp;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public EnderecoDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDTO endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "PessoaDTO{"
                + "id=" + id
                + ", nome='" + nome + '\''
                + ", genero=" + genero
                + ", dataNascimento=" + dataNascimento
                + ", cpf='" + cpf + '\''
                + ", email='" + email + '\''
                + ", fixo='" + fixo + '\''
                + ", celular='" + celular + '\''
                + ", whatsapp=" + whatsapp
                + ", observacoes='" + observacoes + '\''
                + ", endereco=" + endereco
                + '}';
    }

}
