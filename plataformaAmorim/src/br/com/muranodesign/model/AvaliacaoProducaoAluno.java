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
@Table(name = "avaliacao_producao_aluno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AvaliacaoProducaoAluno.findAll", query = "SELECT a FROM AvaliacaoProducaoAluno a"),
    @NamedQuery(name = "AvaliacaoProducaoAluno.findByIdavaliacaoProducaoAluno", query = "SELECT a FROM AvaliacaoProducaoAluno a WHERE a.idavaliacaoProducaoAluno = :idavaliacaoProducaoAluno")})
public class AvaliacaoProducaoAluno implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idavaliacao_producao_aluno")
    private Integer idavaliacaoProducaoAluno;
    @Lob
    @Column(name = "avaliacao")
    private String avaliacao;
    @JoinColumn(name = "producao_aluno", referencedColumnName = "idproducao_aluno")
    @ManyToOne(optional = false)
    private ProducaoAluno producaoAluno;
    @JoinColumn(name = "aluno", referencedColumnName = "ID_ALUNO")
    @ManyToOne
    private Aluno aluno;

    public AvaliacaoProducaoAluno() {
    }

    public AvaliacaoProducaoAluno(Integer idavaliacaoProducaoAluno) {
        this.idavaliacaoProducaoAluno = idavaliacaoProducaoAluno;
    }

    public Integer getIdavaliacaoProducaoAluno() {
        return idavaliacaoProducaoAluno;
    }

    public void setIdavaliacaoProducaoAluno(Integer idavaliacaoProducaoAluno) {
        this.idavaliacaoProducaoAluno = idavaliacaoProducaoAluno;
    }

    public String getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(String avaliacao) {
        this.avaliacao = avaliacao;
    }

    public ProducaoAluno getProducaoAluno() {
        return producaoAluno;
    }

    public void setProducaoAluno(ProducaoAluno producaoAluno) {
        this.producaoAluno = producaoAluno;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idavaliacaoProducaoAluno != null ? idavaliacaoProducaoAluno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AvaliacaoProducaoAluno)) {
            return false;
        }
        AvaliacaoProducaoAluno other = (AvaliacaoProducaoAluno) object;
        if ((this.idavaliacaoProducaoAluno == null && other.idavaliacaoProducaoAluno != null) || (this.idavaliacaoProducaoAluno != null && !this.idavaliacaoProducaoAluno.equals(other.idavaliacaoProducaoAluno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.muranodesign.model.AvaliacaoProducaoAluno[ idavaliacaoProducaoAluno=" + idavaliacaoProducaoAluno + " ]";
    }
    
}
