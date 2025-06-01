package br.com.pensaosalvatore.sistema_hotelaria.modelo.dto;

import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.enumeradores.Genero;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 202412170006
 */
public class HospedeDTO extends PessoaDTO {

    private String nacionalidade;
    private String profissao;
    private Date dataCadastro;

    public HospedeDTO() {

    }

    public HospedeDTO(String nacionalidade, String profissao, Date dataCadastro, Integer id, String nome, Genero genero, Date dataNascimento, String cpf, String email, String fixo, String celular, Boolean whatsapp, String observacoes, EnderecoDTO endereco) {
        super(id, nome, genero, dataNascimento, cpf, email, fixo, celular, whatsapp, observacoes, endereco);
        this.nacionalidade = nacionalidade;
        this.profissao = profissao;
        this.dataCadastro = dataCadastro;
    }

    public HospedeDTO(Integer id, String nome, String nacionalidade, String profissao, String dataCadastro, Genero genero, String cpf, String dataNascimento, String fixo, String observacoes, String email, String celular, Boolean whatsapp, EnderecoDTO endereco) {
        super(id, nome, genero, cpf, email, celular, whatsapp, endereco);
        this.nacionalidade = nacionalidade;
        this.profissao = profissao;
        try {
            this.dataCadastro = new SimpleDateFormat("dd/MM/yyyy").parse(dataCadastro);
        } catch (ParseException ex) {
            Logger.getLogger(ReservaDTO.class.getName()).log(Level.SEVERE, null, ex);
        }

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

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
