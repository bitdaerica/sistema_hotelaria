package br.com.pensaosalvatore.sistema_hotelariamodelo.dto;

import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.enumeradores.CategoriaServico;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.enumeradores.Status;
import java.math.BigDecimal;

/**
 *
 * @author Érica_Almeida
 */
public class ServicoDTO {

    private Integer id;
    private Integer codigoservico;
    private String nome;
    private CategoriaServico categoria;
    private String descricao;
    private String localprestacao;
    private String tempomedioexecucao;
    private Status statusservico;
    private BigDecimal precobase;
    private BigDecimal taxasadicionais;
    private String formapagamento;
    private BigDecimal custooperacional;
    private BigDecimal desconto;
    private String horariosdisponiveis;
    private String diassemana;
    private Integer capacidademaxima;
    private Integer antecedenciaminima;
    private String funcionarioresponsavel;
    private String recursosnecessarios;
    private Integer idademinima;
    private String acessibilidade;
    private String restricoessaude;
    private String observacoes;

    public ServicoDTO() {
    }

    public ServicoDTO(Integer id, Integer codigoservico, String nome, CategoriaServico categoria, String descricao, String localprestacao, String tempomedioexecucao, Status statusservico, BigDecimal precobase, BigDecimal taxasadicionais, String formapagamento, BigDecimal custooperacional, BigDecimal desconto, String horariosdisponiveis, String diassemana, Integer capacidademaxima, Integer antecedenciaminima, String funcionarioresponsavel, String recursosnecessarios, Integer idademinima, String acessibilidade, String restricoessaude, String observacoes) {
        this.id = id;
        this.codigoservico = codigoservico;
        this.nome = nome;
        this.categoria = categoria;
        this.descricao = descricao;
        this.localprestacao = localprestacao;
        this.tempomedioexecucao = tempomedioexecucao;
        this.statusservico = statusservico;
        this.precobase = precobase;
        this.taxasadicionais = taxasadicionais;
        this.formapagamento = formapagamento;
        this.custooperacional = custooperacional;
        this.desconto = desconto;
        this.horariosdisponiveis = horariosdisponiveis;
        this.diassemana = diassemana;
        this.capacidademaxima = capacidademaxima;
        this.antecedenciaminima = antecedenciaminima;
        this.funcionarioresponsavel = funcionarioresponsavel;
        this.recursosnecessarios = recursosnecessarios;
        this.idademinima = idademinima;
        this.acessibilidade = acessibilidade;
        this.restricoessaude = restricoessaude;
        this.observacoes = observacoes;
    }

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCodigoservico() {
        return codigoservico;
    }

    public void setCodigoservico(Integer codigoservico) {
        this.codigoservico = codigoservico;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public CategoriaServico getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaServico categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLocalprestacao() {
        return localprestacao;
    }

    public void setLocalprestacao(String localprestacao) {
        this.localprestacao = localprestacao;
    }

    public String getTempomedioexecucao() {
        return tempomedioexecucao;
    }

    public void setTempomedioexecucao(String tempomedioexecucao) {
        this.tempomedioexecucao = tempomedioexecucao;
    }

    public Status getStatusservico() {
        return statusservico;
    }

    public void setStatusservico(Status statusservico) {
        this.statusservico = statusservico;
    }

    public BigDecimal getPrecobase() {
        return precobase;
    }

    public void setPrecobase(BigDecimal precobase) {
        this.precobase = precobase;
    }

    public BigDecimal getTaxasadicionais() {
        return taxasadicionais;
    }

    public void setTaxasadicionais(BigDecimal taxasadicionais) {
        this.taxasadicionais = taxasadicionais;
    }

    public String getFormapagamento() {
        return formapagamento;
    }

    public void setFormapagamento(String formapagamento) {
        this.formapagamento = formapagamento;
    }

    public BigDecimal getCustooperacional() {
        return custooperacional;
    }

    public void setCustooperacional(BigDecimal custooperacional) {
        this.custooperacional = custooperacional;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public String getHorariosdisponiveis() {
        return horariosdisponiveis;
    }

    public void setHorariosdisponiveis(String horariosdisponiveis) {
        this.horariosdisponiveis = horariosdisponiveis;
    }

    public String getDiassemana() {
        return diassemana;
    }

    public void setDiassemana(String diassemana) {
        this.diassemana = diassemana;
    }

    public Integer getCapacidademaxima() {
        return capacidademaxima;
    }

    public void setCapacidademaxima(Integer capacidademaxima) {
        this.capacidademaxima = capacidademaxima;
    }

    public Integer getAntecedenciaminima() {
        return antecedenciaminima;
    }

    public void setAntecedenciaminima(Integer antecedenciaminima) {
        this.antecedenciaminima = antecedenciaminima;
    }

    public String getFuncionarioresponsavel() {
        return funcionarioresponsavel;
    }

    public void setFuncionarioresponsavel(String funcionarioresponsavel) {
        this.funcionarioresponsavel = funcionarioresponsavel;
    }

    public String getRecursosnecessarios() {
        return recursosnecessarios;
    }

    public void setRecursosnecessarios(String recursosnecessarios) {
        this.recursosnecessarios = recursosnecessarios;
    }

    public Integer getIdademinima() {
        return idademinima;
    }

    public void setIdademinima(Integer idademinima) {
        this.idademinima = idademinima;
    }

    public String getAcessibilidade() {
        return acessibilidade;
    }

    public void setAcessibilidade(String acessibilidade) {
        this.acessibilidade = acessibilidade;
    }

    public String getRestricoessaude() {
        return restricoessaude;
    }

    public void setRestricoessaude(String restricoessaude) {
        this.restricoessaude = restricoessaude;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
       

}
