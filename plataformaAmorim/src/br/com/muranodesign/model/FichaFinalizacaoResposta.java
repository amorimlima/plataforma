/**
 *   Este codigo é software livre você e pode resdistribuir e/ou modificar ele seguindo os termos da
 *   Creative Commons Attribution 4.0 International Pare visualizar uma copia desta 
 *   licensa em ingles visite http://creativecommons.org/licenses/by/4.0/.
 *   
 *   This code is free software; you can redistribute it and/or modify it
 *   under the terms of Creative Commons Attribution 4.0 International License. 
 *   To view a copy of this license, visit http://creativecommons.org/licenses/by/4.0/.
 */
package br.com.muranodesign.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rogerio
 */
@Entity
@Table(name = "ficha_finalizacao_resposta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FichaFinalizacaoResposta.findAll", query = "SELECT f FROM FichaFinalizacaoResposta f"),
    @NamedQuery(name = "FichaFinalizacaoResposta.findByIdfichaFinalizacaoResposta", query = "SELECT f FROM FichaFinalizacaoResposta f WHERE f.idfichaFinalizacaoResposta = :idfichaFinalizacaoResposta")})
public class FichaFinalizacaoResposta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idficha_finalizacao_resposta")
    private Integer idfichaFinalizacaoResposta;
    @Lob
    @Column(name = "resposta")
    private String resposta;
    @JoinColumn(name = "ficha_finalizacao_questao", referencedColumnName = "idficha_finalizacao_questao")
    @ManyToOne
    private FichaFinalizacaoQuestao fichaFinalizacaoQuestao;

    public FichaFinalizacaoResposta() {
    }

    public FichaFinalizacaoResposta(Integer idfichaFinalizacaoResposta) {
        this.idfichaFinalizacaoResposta = idfichaFinalizacaoResposta;
    }

    public Integer getIdfichaFinalizacaoResposta() {
        return idfichaFinalizacaoResposta;
    }

    public void setIdfichaFinalizacaoResposta(Integer idfichaFinalizacaoResposta) {
        this.idfichaFinalizacaoResposta = idfichaFinalizacaoResposta;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public FichaFinalizacaoQuestao getFichaFinalizacaoQuestao() {
        return fichaFinalizacaoQuestao;
    }

    public void setFichaFinalizacaoQuestao(FichaFinalizacaoQuestao fichaFinalizacaoQuestao) {
        this.fichaFinalizacaoQuestao = fichaFinalizacaoQuestao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfichaFinalizacaoResposta != null ? idfichaFinalizacaoResposta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FichaFinalizacaoResposta)) {
            return false;
        }
        FichaFinalizacaoResposta other = (FichaFinalizacaoResposta) object;
        if ((this.idfichaFinalizacaoResposta == null && other.idfichaFinalizacaoResposta != null) || (this.idfichaFinalizacaoResposta != null && !this.idfichaFinalizacaoResposta.equals(other.idfichaFinalizacaoResposta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.muranodesign.model.FichaFinalizacaoResposta[ idfichaFinalizacaoResposta=" + idfichaFinalizacaoResposta + " ]";
    }
    
}
