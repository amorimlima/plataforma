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
import java.util.Collection;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author rogerio
 */
@Entity
@Table(name = "ficha_finalizacao_questao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FichaFinalizacaoQuestao.findAll", query = "SELECT f FROM FichaFinalizacaoQuestao f"),
    @NamedQuery(name = "FichaFinalizacaoQuestao.findByIdfichaFinalizacaoQuestao", query = "SELECT f FROM FichaFinalizacaoQuestao f WHERE f.idfichaFinalizacaoQuestao = :idfichaFinalizacaoQuestao"),
    @NamedQuery(name = "FichaFinalizacaoQuestao.findByRoteiro", query = "SELECT f FROM FichaFinalizacaoQuestao f WHERE f.roteiro = :roteiro"),
    @NamedQuery(name = "FichaFinalizacaoQuestao.findByNumero", query = "SELECT f FROM FichaFinalizacaoQuestao f WHERE f.numero = :numero"),
    @NamedQuery(name = "FichaFinalizacaoQuestao.findByFichaFinalizacaoQuestaocol", query = "SELECT f FROM FichaFinalizacaoQuestao f WHERE f.fichaFinalizacaoQuestaocol = :fichaFinalizacaoQuestaocol")})
public class FichaFinalizacaoQuestao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idficha_finalizacao_questao")
    private Integer idfichaFinalizacaoQuestao;
    @Lob
    @Column(name = "questao")
    private String questao;
    @Column(name = "roteiro")
    private Integer roteiro;
    @Column(name = "numero")
    private Integer numero;
    @Column(name = "ficha_finalizacao_questaocol")
    private String fichaFinalizacaoQuestaocol;
    @OneToMany(mappedBy = "fichaFinalizacaoQuestao")
    private Collection<FichaFinalizacaoResposta> fichaFinalizacaoRespostaCollection;
    @JoinColumn(name = "aluno", referencedColumnName = "ID_ALUNO")
    @ManyToOne
    private Aluno aluno;
    @JoinColumn(name = "ano_letivo", referencedColumnName = "idano_letivo")
    @ManyToOne
    private AnoLetivo anoLetivo;

    public FichaFinalizacaoQuestao() {
    }

    public FichaFinalizacaoQuestao(Integer idfichaFinalizacaoQuestao) {
        this.idfichaFinalizacaoQuestao = idfichaFinalizacaoQuestao;
    }

    public Integer getIdfichaFinalizacaoQuestao() {
        return idfichaFinalizacaoQuestao;
    }

    public void setIdfichaFinalizacaoQuestao(Integer idfichaFinalizacaoQuestao) {
        this.idfichaFinalizacaoQuestao = idfichaFinalizacaoQuestao;
    }

    public String getQuestao() {
        return questao;
    }

    public void setQuestao(String questao) {
        this.questao = questao;
    }

    public Integer getRoteiro() {
        return roteiro;
    }

    public void setRoteiro(Integer roteiro) {
        this.roteiro = roteiro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getFichaFinalizacaoQuestaocol() {
        return fichaFinalizacaoQuestaocol;
    }

    public void setFichaFinalizacaoQuestaocol(String fichaFinalizacaoQuestaocol) {
        this.fichaFinalizacaoQuestaocol = fichaFinalizacaoQuestaocol;
    }

    @XmlTransient
    public Collection<FichaFinalizacaoResposta> getFichaFinalizacaoRespostaCollection() {
        return fichaFinalizacaoRespostaCollection;
    }

    public void setFichaFinalizacaoRespostaCollection(Collection<FichaFinalizacaoResposta> fichaFinalizacaoRespostaCollection) {
        this.fichaFinalizacaoRespostaCollection = fichaFinalizacaoRespostaCollection;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public AnoLetivo getAnoLetivo() {
        return anoLetivo;
    }

    public void setAnoLetivo(AnoLetivo anoLetivo) {
        this.anoLetivo = anoLetivo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfichaFinalizacaoQuestao != null ? idfichaFinalizacaoQuestao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FichaFinalizacaoQuestao)) {
            return false;
        }
        FichaFinalizacaoQuestao other = (FichaFinalizacaoQuestao) object;
        if ((this.idfichaFinalizacaoQuestao == null && other.idfichaFinalizacaoQuestao != null) || (this.idfichaFinalizacaoQuestao != null && !this.idfichaFinalizacaoQuestao.equals(other.idfichaFinalizacaoQuestao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.muranodesign.model.FichaFinalizacaoQuestao[ idfichaFinalizacaoQuestao=" + idfichaFinalizacaoQuestao + " ]";
    }
    
}
