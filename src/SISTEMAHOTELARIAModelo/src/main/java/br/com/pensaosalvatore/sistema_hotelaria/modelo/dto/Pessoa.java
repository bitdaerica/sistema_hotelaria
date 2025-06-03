package br.com.pensaosalvatore.sistema_hotelaria.modelo.dto;

import java.time.LocalDate;

/**
 *
 * @author Érica_Almeida
 */
public class Pessoa {

    private Integer id;
    private String nome;
    private String genero;
    private LocalDate data_nascimento;
    private String cpf;
    private String email;
    private String fixo;
    private String celular;
    private Boolean whatsapp;
    private String observacoes;
    private Endereco endereco;

    public Pessoa() {
    }

    public Pessoa(Integer id) {
        this.id = id;
    }

    public Pessoa(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Pessoa(Integer id, String nome, String genero, LocalDate data_nascimento, String cpf, String email, String fixo, String celular, boolean whatsapp, String observacoes, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.genero = genero;
        this.data_nascimento = data_nascimento;
        this.cpf = cpf;
        this.email = email;
        this.fixo = fixo;
        this.celular = celular;
        this.whatsapp = whatsapp;
        this.observacoes = observacoes;
        this.endereco = endereco;
    }

    public Pessoa(Integer id, String nome, String genero, String cpf, String email, String celular, Boolean whatsapp, Endereco endereco) {
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public LocalDate getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(LocalDate data_nascimento) {
        this.data_nascimento = data_nascimento;
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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "PessoaDTO{"
                + "id=" + id
                + ", nome='" + nome + '\''
                + ", genero=" + genero
                + ", data_nascimento=" + data_nascimento
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
