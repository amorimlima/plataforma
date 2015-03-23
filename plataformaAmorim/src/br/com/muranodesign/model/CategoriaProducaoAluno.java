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
@Table(name = "categoria_producao_aluno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CategoriaProducaoAluno.findAll", query = "SELECT c FROM CategoriaProducaoAluno c"),
    @NamedQuery(name = "CategoriaProducaoAluno.findByIdcategoriaProducaoAluno", query = "SELECT c FROM CategoriaProducaoAluno c WHERE c.idcategoriaProducaoAluno = :idcategoriaProducaoAluno"),
    @NamedQuery(name = "CategoriaProducaoAluno.findByCategoria", query = "SELECT c FROM CategoriaProducaoAluno c WHERE c.categoria = :categoria")})
public class CategoriaProducaoAluno implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcategoria_producao_aluno")
    private Integer idcategoriaProducaoAluno;
    @Basic(optional = false)
    @Column(name = "categoria")
    private String categoria;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoria")
    private Collection<ProducaoAluno> producaoAlunoCollection;

    public CategoriaProducaoAluno() {
    }

    public CategoriaProducaoAluno(Integer idcategoriaProducaoAluno) {
        this.idcategoriaProducaoAluno = idcategoriaProducaoAluno;
    }

    public CategoriaProducaoAluno(Integer idcategoriaProducaoAluno, String categoria) {
        this.idcategoriaProducaoAluno = idcategoriaProducaoAluno;
        this.categoria = categoria;
    }

    public Integer getIdcategoriaProducaoAluno() {
        return idcategoriaProducaoAluno;
    }

    public void setIdcategoriaProducaoAluno(Integer idcategoriaProducaoAluno) {
        this.idcategoriaProducaoAluno = idcategoriaProducaoAluno;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
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
        hash += (idcategoriaProducaoAluno != null ? idcategoriaProducaoAluno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategoriaProducaoAluno)) {
            return false;
        }
        CategoriaProducaoAluno other = (CategoriaProducaoAluno) object;
        if ((this.idcategoriaProducaoAluno == null && other.idcategoriaProducaoAluno != null) || (this.idcategoriaProducaoAluno != null && !this.idcategoriaProducaoAluno.equals(other.idcategoriaProducaoAluno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.muranodesign.model.CategoriaProducaoAluno[ idcategoriaProducaoAluno=" + idcategoriaProducaoAluno + " ]";
    }
    
}
