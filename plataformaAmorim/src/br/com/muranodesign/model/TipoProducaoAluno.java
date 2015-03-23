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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "tipo_producao_aluno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoProducaoAluno.findAll", query = "SELECT t FROM TipoProducaoAluno t"),
    @NamedQuery(name = "TipoProducaoAluno.findByIdtipoProducaoAluno", query = "SELECT t FROM TipoProducaoAluno t WHERE t.idtipoProducaoAluno = :idtipoProducaoAluno"),
    @NamedQuery(name = "TipoProducaoAluno.findByTipo", query = "SELECT t FROM TipoProducaoAluno t WHERE t.tipo = :tipo")})
public class TipoProducaoAluno implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipo_producao_aluno")
    private Integer idtipoProducaoAluno;
    @Basic(optional = false)
    @Column(name = "tipo")
    private String tipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipo")
    private Collection<ProducaoAluno> producaoAlunoCollection;

    public TipoProducaoAluno() {
    }

    public TipoProducaoAluno(Integer idtipoProducaoAluno) {
        this.idtipoProducaoAluno = idtipoProducaoAluno;
    }

    public TipoProducaoAluno(Integer idtipoProducaoAluno, String tipo) {
        this.idtipoProducaoAluno = idtipoProducaoAluno;
        this.tipo = tipo;
    }

    public Integer getIdtipoProducaoAluno() {
        return idtipoProducaoAluno;
    }

    public void setIdtipoProducaoAluno(Integer idtipoProducaoAluno) {
        this.idtipoProducaoAluno = idtipoProducaoAluno;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public Collection<ProducaoAluno> getProducaoAlunoCollection() {
        return producaoAlunoCollection;
    }

    public void setProducaoAlunoCollection(Collection<ProducaoAluno> producaoAlunoCollection) {
        this.producaoAlunoCollection = producaoAlunoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipoProducaoAluno != null ? idtipoProducaoAluno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoProducaoAluno)) {
            return false;
        }
        TipoProducaoAluno other = (TipoProducaoAluno) object;
        if ((this.idtipoProducaoAluno == null && other.idtipoProducaoAluno != null) || (this.idtipoProducaoAluno != null && !this.idtipoProducaoAluno.equals(other.idtipoProducaoAluno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.muranodesign.model.TipoProducaoAluno[ idtipoProducaoAluno=" + idtipoProducaoAluno + " ]";
    }
    
}
