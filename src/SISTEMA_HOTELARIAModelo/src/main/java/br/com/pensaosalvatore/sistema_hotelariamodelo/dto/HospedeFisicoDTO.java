package br.com.pensaosalvatore.sistema_hotelariamodelo.dto;

import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.enumeradores.Andar;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.enumeradores.Estado;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.enumeradores.TipoCama;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.enumeradores.EstadoCivil;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.enumeradores.Genero;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.enumeradores.PreferenciaQuarto;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.enumeradores.StatusHospede;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.enumeradores.TipoDocumento;
import java.util.Date;

/**
 *
 * @author 202412170006
 */
public class HospedeFisicoDTO extends PessoaDTO {

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

    private Integer numerodocumento;

    private TipoDocumento tipodocumento;

    private String orgaoemissor;

    private Date datadeemissao;

    private Date datadecadastro;

    private String preferenciadecontato;

    private PreferenciaQuarto preferenciadequarto;
    
    private Andar preferenciadeandar;

    private Date datadedaultimavisita;

    private TipoCama preferenciadecama;

    private String itensespeciais;

    private String interesses;

    private String notasinternas;

    private String empresavinculada;

    private String cnpj;

    private String cargo;

    private String responsavelpelofaturamento;

    public HospedeFisicoDTO() {

    }

    public HospedeFisicoDTO(Integer id, String nome, String sobrenome, Genero genero, String cpf, Date datadenascimento, EstadoCivil estadocivil,
            String naturalidade, String profissao, Integer rg, StatusHospede status, Integer numerodocumento, TipoDocumento tipodocumento, String orgaoemissor,
            Date datadeemissao, Date datadecadastro, String preferenciadecontato, PreferenciaQuarto preferenciadequarto, Andar preferenciadeandar,
            Date datadedaultimavisita, TipoCama preferenciadecama, String itensespeciais, String interesses, String notasinternas, String empresavinculada, String cnpj, String cargo, String responsavelpelofaturamento, Integer idPessoa, String email, String fixo, String celular, 
            Boolean whatsapp, String observacoes,Integer idEndereco, String rua, String numero, String complemento, String bairro, String cidade, Estado estado, String cep) {
        super(idPessoa, email, fixo, celular, whatsapp, observacoes, idEndereco, rua, numero, complemento, bairro, cidade, estado, cep);
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.genero = genero;
        this.cpf = cpf;
        this.datadenascimento = datadenascimento;
        this.estadocivil = estadocivil;
        this.naturalidade = naturalidade;
        this.profissao = profissao;
        this.rg = rg;
        this.status = status;
        this.numerodocumento = numerodocumento;
        this.tipodocumento = tipodocumento;
        this.orgaoemissor = orgaoemissor;
        this.datadeemissao = datadeemissao;
        this.datadecadastro = datadecadastro;
        this.preferenciadecontato = preferenciadecontato;
        this.preferenciadequarto = preferenciadequarto;
        this.preferenciadeandar = preferenciadeandar;
        this.datadedaultimavisita = datadedaultimavisita;
        this.preferenciadecama = preferenciadecama;
        this.itensespeciais = itensespeciais;
        this.interesses = interesses;
        this.notasinternas = notasinternas;
        this.empresavinculada = empresavinculada;
        this.cnpj = cnpj;
        this.cargo = cargo;
        this.responsavelpelofaturamento = responsavelpelofaturamento;
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

    public PreferenciaQuarto getPreferenciadequarto() {
        return preferenciadequarto;
    }

    public void setPreferenciadequarto(PreferenciaQuarto preferenciadequarto) {
        this.preferenciadequarto = preferenciadequarto;
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

    public TipoCama getPreferenciadecama() {
        return preferenciadecama;
    }

    public void setPreferenciadecama(TipoCama preferenciadecama) {
        this.preferenciadecama = preferenciadecama;
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

    public String getEmpresavinculada() {
        return empresavinculada;
    }

    public void setEmpresavinculada(String empresavinculada) {
        this.empresavinculada = empresavinculada;
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

    @Override
    public Integer getIdPessoa() {
        return idPessoa;
    }

    @Override
    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getFixo() {
        return fixo;
    }

    @Override
    public void setFixo(String fixo) {
        this.fixo = fixo;
    }

    @Override
    public String getCelular() {
        return celular;
    }

    @Override
    public void setCelular(String celular) {
        this.celular = celular;
    }

    @Override
    public Boolean getWhatsapp() {
        return whatsapp;
    }

    @Override
    public void setWhatsapp(Boolean whatsapp) {
        this.whatsapp = whatsapp;
    }

    @Override
    public String getObservacoes() {
        return observacoes;
    }

    @Override
    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    @Override
    public Integer getIdEndereco() {
        return idEndereco;
    }

    @Override
    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    @Override
    public String getRua() {
        return rua;
    }

    @Override
    public void setRua(String rua) {
        this.rua = rua;
    }

    @Override
    public String getNumero() {
        return numero;
    }

    @Override
    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String getComplemento() {
        return complemento;
    }

    @Override
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    @Override
    public String getBairro() {
        return bairro;
    }

    @Override
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    @Override
    public String getCidade() {
        return cidade;
    }

    @Override
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public Estado getEstado() {
        return estado;
    }

    @Override
    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public String getCep() {
        return cep;
    }

    @Override
    public void setCep(String cep) {
        this.cep = cep;
    }
    
    
}