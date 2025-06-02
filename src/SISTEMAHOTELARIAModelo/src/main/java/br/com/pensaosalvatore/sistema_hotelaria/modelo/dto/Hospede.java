package br.com.pensaosalvatore.sistema_hotelaria.modelo.dto;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;


/**
 *
 * @author 202412170006
 */
public class Hospede extends Pessoa {

    private String nacionalidade;
    private String profissao;
    private LocalDate dataCadastro;

    public Hospede() {
        super();
    }

    public Hospede(Integer id) {
        super(id);
    }

    public Hospede(Integer id, String nome, String nacionalidade, String profissao, String dataCadastro,
            String genero, String cpf, String dataNascimento, String fixo, String observacoes,
            String email, String celular, Boolean whatsapp, Endereco endereco) {
        super(id, nome, genero, cpf, email, celular, whatsapp, endereco);
        this.nacionalidade = nacionalidade;
        this.profissao = profissao;
        this.dataCadastro = LocalDate.parse(dataCadastro, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
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

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    // 🔸 toString() opcional, para debug
    @Override
    public String toString() {
        return "Hospede{"
                + "id=" + getId()
                + ", nome='" + getNome() + '\''
                + ", genero='" + getGenero() + '\''
                + ", dataNascimento=" + getDataNascimento()
                + ", cpf='" + getCpf() + '\''
                + ", email='" + getEmail() + '\''
                + ", fixo='" + getFixo() + '\''
                + ", celular='" + getCelular() + '\''
                + ", whatsapp=" + getWhatsapp()
                + ", observacoes='" + getObservacoes() + '\''
                + ", nacionalidade='" + nacionalidade + '\''
                + ", profissao='" + profissao + '\''
                + ", dataCadastro=" + dataCadastro
                + '}';
    }
}
