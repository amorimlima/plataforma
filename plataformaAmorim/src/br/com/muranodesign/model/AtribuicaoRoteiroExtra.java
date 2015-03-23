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
@Table(name = "atribuicao_roteiro_extra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AtribuicaoRoteiroExtra.findAll", query = "SELECT a FROM AtribuicaoRoteiroExtra a"),
    @NamedQuery(name = "AtribuicaoRoteiroExtra.findByIdatribuicaoRoteiroExtra", query = "SELECT a FROM AtribuicaoRoteiroExtra a WHERE a.idatribuicaoRoteiroExtra = :idatribuicaoRoteiroExtra"),
    @NamedQuery(name = "AtribuicaoRoteiroExtra.findByMotivo", query = "SELECT a FROM AtribuicaoRoteiroExtra a WHERE a.motivo = :motivo")})
public class AtribuicaoRoteiroExtra implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idatribuicao_roteiro_extra")
    private Integer idatribuicaoRoteiroExtra;
    @Column(name = "motivo")
    private String motivo;
    @JoinColumn(name = "ano_letivo", referencedColumnName = "idano_letivo")
    @ManyToOne
    private AnoLetivo anoLetivo;
    @JoinColumn(name = "aluno", referencedColumnName = "ID_ALUNO")
    @ManyToOne
    private Aluno aluno;
    @JoinColumn(name = "roteiro", referencedColumnName = "idroteiro")
    @ManyToOne
    private Roteiro roteiro;

    public AtribuicaoRoteiroExtra() {
    }

    public AtribuicaoRoteiroExtra(Integer idatribuicaoRoteiroExtra) {
        this.idatribuicaoRoteiroExtra = idatribuicaoRoteiroExtra;
    }

    public Integer getIdatribuicaoRoteiroExtra() {
        return idatribuicaoRoteiroExtra;
    }

    public void setIdatribuicaoRoteiroExtra(Integer idatribuicaoRoteiroExtra) {
        this.idatribuicaoRoteiroExtra = idatribuicaoRoteiroExtra;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public AnoLetivo getAnoLetivo() {
        return anoLetivo;
    }

    public void setAnoLetivo(AnoLetivo anoLetivo) {
        this.anoLetivo = anoLetivo;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Roteiro getRoteiro() {
        return roteiro;
    }

    public void setRoteiro(Roteiro roteiro) {
        this.roteiro = roteiro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idatribuicaoRoteiroExtra != null ? idatribuicaoRoteiroExtra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AtribuicaoRoteiroExtra)) {
            return false;
        }
        AtribuicaoRoteiroExtra other = (AtribuicaoRoteiroExtra) object;
        if ((this.idatribuicaoRoteiroExtra == null && other.idatribuicaoRoteiroExtra != null) || (this.idatribuicaoRoteiroExtra != null && !this.idatribuicaoRoteiroExtra.equals(other.idatribuicaoRoteiroExtra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.muranodesign.model.AtribuicaoRoteiroExtra[ idatribuicaoRoteiroExtra=" + idatribuicaoRoteiroExtra + " ]";
    }
    
}
