package br.com.pensaosalvatore.sistema_hotelaria.modelo.dto;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


/**
 *
 * @author 202412170006
 */
public class Hospede extends Pessoa {

    private String nacionalidade;
    private String profissao;
    private LocalDate datacadastro;

    public Hospede() {
        super();
    }

    public Hospede(Integer id) {
        super(id);
    }

    public Hospede(Integer id, String nome, String nacionalidade, String profissao, String data_cadastro,
            String genero, String cpf, String data_nascimento, String fixo, String observacoes,
            String email, String celular, Boolean whatsapp, Endereco endereco) {
        super(id, nome, genero, cpf, email, celular, whatsapp, endereco);
        this.nacionalidade = nacionalidade;
        this.profissao = profissao;
        this.datacadastro = LocalDate.parse(data_cadastro, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

   

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public LocalDate getDatacadastro() {
        return datacadastro;
    }

    public void setDatacadastro(LocalDate datacadastro) {
        this.datacadastro = datacadastro;
    }

    // toString()  para debug
    @Override
    public String toString() {
        return this.getNome(); 
    }
}
