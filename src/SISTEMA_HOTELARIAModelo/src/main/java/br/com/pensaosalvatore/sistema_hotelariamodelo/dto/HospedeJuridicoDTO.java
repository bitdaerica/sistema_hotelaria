/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.pensaosalvatore.sistema_hotelariamodelo.dto;

import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.enumeradores.Estado;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.enumeradores.StatusHospede;
import br.com.pensaosalvatore.sistema_hotelaria.modelo.dto.enumeradores.TipodeContrato;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Érica_Almeida
 */
public class HospedeJuridicoDTO {
    private Integer id;
    
    private String razaosocial;
    
    private String cnpj;
    
    private String inscricaoestadual;
    
    private StatusHospede status;
    
    private TipodeContrato tipodecontrato; 
    
    private Date datadecadastro;
       
    private String preferenciadecontato;
    
    private String responsavelpeloofaturamento;
        
    private String notasinternas;
    
    //private ? formadepagamento;
    
    private PrazodeFaturamento prazodefaturamento;
    
    private BigDecimal limetedecredito;
    
    private String interesses;

    public HospedeJuridicoDTO() {
    }
