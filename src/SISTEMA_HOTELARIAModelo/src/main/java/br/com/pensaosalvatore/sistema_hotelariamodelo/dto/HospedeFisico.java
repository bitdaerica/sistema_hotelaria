package br.com.pensaosalvatore.sistema_hotelariamodelo.dto;

import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.enumeradores.Andar;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.enumeradores.Cama;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.enumeradores.Estado;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.enumeradores.EstadoCivil;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.enumeradores.Genero;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.enumeradores.StatusHospede;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.enumeradores.TipoDocumento;
import java.util.Date;

/**
 *
 * @author 202412170006
 */
public class HospedeFisico {
    private Integer id;
    
    private String nome;
    
    private String sobrenome;
    
    private Genero genero;
    
    private String cpf;
    
    private Date datadenascimento;
    
    private EstadoCivil estadocivil;
    
    private String naturalidade;
    
    private String profissao;
    
    private Integer rg;
    
    private StatusHospede status;
    
    private String cep;
    
    private String rua;
    
    private Integer numero;
    
    private String complemento;
    
    private String bairro;
    
    private Estado estado;
    
    private String email;
    
    private String celular;
    
    //private ? whatsapp;
    
    private String fixo;
    
    private Integer numerodocumento;
    
    private TipoDocumento tipodocumento;
    
    private String orgaoemissor;
    
    private Date datadeemissao;
    
    private Date datadecadastro;
    
    private String preferenciadecontato;
    
    //private ? preferenciadequarto;
    
    private Andar preferenciadeandar;
      
    private Date datadedaultimavisita;
    
    private Cama preferedecama;
    
    private String itensespeciais;
    
    private String interesses;
    
    private String notasinternas;
    
    private String observacoes;
    
    //private ? empresavinculada;
    
    private String cnpj;
    
    private String cargo;
    
    private String responsavelpelofaturamento;
    
    public Integer getId(){
        return id;
    }
    public void setId(Integer id){
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDatadenascimento() {
        return datadenascimento;
    }

    public void setDatadenascimento(Date datadenascimento) {
        this.datadenascimento = datadenascimento;
    }

    public EstadoCivil getEstadocivil() {
        return estadocivil;
    }

    public void setEstadocivil(EstadoCivil estadocivil) {
        this.estadocivil = estadocivil;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public Integer getRg() {
        return rg;
    }

    public void setRg(Integer rg) {
        this.rg = rg;
    }

    public StatusHospede getStatus() {
        return status;
    }

    public void setStatus(StatusHospede status) {
        this.status = status;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getFixo() {
        return fixo;
    }

    public void setFixo(String fixo) {
        this.fixo = fixo;
    }

    public Integer getNumerodocumento() {
        return numerodocumento;
    }

    public void setNumerodocumento(Integer numerodocumento) {
        this.numerodocumento = numerodocumento;
    }

    public TipoDocumento getTipodocumento() {
        return tipodocumento;
    }

    public void setTipodocumento(TipoDocumento tipodocumento) {
        this.tipodocumento = tipodocumento;
    }

    public String getOrgaoemissor() {
        return orgaoemissor;
    }

    public void setOrgaoemissor(String orgaoemissor) {
        this.orgaoemissor = orgaoemissor;
    }

    public Date getDatadeemissao() {
        return datadeemissao;
    }

    public void setDatadeemissao(Date datadeemissao) {
        this.datadeemissao = datadeemissao;
    }

    public Date getDatadecadastro() {
        return datadecadastro;
    }

    public void setDatadecadastro(Date datadecadastro) {
        this.datadecadastro = datadecadastro;
    }

    public String getPreferenciadecontato() {
        return preferenciadecontato;
    }

    public void setPreferenciadecontato(String preferenciadecontato) {
        this.preferenciadecontato = preferenciadecontato;
    }

    public Andar getPreferenciadeandar() {
        return preferenciadeandar;
    }

    public void setPreferenciadeandar(Andar preferenciadeandar) {
        this.preferenciadeandar = preferenciadeandar;
    }

    public Date getDatadedaultimavisita() {
        return datadedaultimavisita;
    }

    public void setDatadedaultimavisita(Date datadedaultimavisita) {
        this.datadedaultimavisita = datadedaultimavisita;
    }

    public Cama getPreferedecama() {
        return preferedecama;
    }

    public void setPreferedecama(Cama preferedecama) {
        this.preferedecama = preferedecama;
    }

    public String getItensespeciais() {
        return itensespeciais;
    }

    public void setItensespeciais(String itensespeciais) {
        this.itensespeciais = itensespeciais;
    }

    public String getInteresses() {
        return interesses;
    }

    public void setInteresses(String interesses) {
        this.interesses = interesses;
    }

    public String getNotasinternas() {
        return notasinternas;
    }

    public void setNotasinternas(String notasinternas) {
        this.notasinternas = notasinternas;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getResponsavelpelofaturamento() {
        return responsavelpelofaturamento;
    }

    public void setResponsavelpelofaturamento(String responsavelpelofaturamento) {
        this.responsavelpelofaturamento = responsavelpelofaturamento;
    }
    
        
    
}
