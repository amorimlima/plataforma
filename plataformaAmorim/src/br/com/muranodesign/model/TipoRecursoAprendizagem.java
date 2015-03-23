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
@Table(name = "tipo_recurso_aprendizagem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoRecursoAprendizagem.findAll", query = "SELECT t FROM TipoRecursoAprendizagem t"),
    @NamedQuery(name = "TipoRecursoAprendizagem.findByIdtipoRecursoAprendizagem", query = "SELECT t FROM TipoRecursoAprendizagem t WHERE t.idtipoRecursoAprendizagem = :idtipoRecursoAprendizagem"),
    @NamedQuery(name = "TipoRecursoAprendizagem.findByNome", query = "SELECT t FROM TipoRecursoAprendizagem t WHERE t.nome = :nome")})
public class TipoRecursoAprendizagem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipo_recurso_aprendizagem")
    private Integer idtipoRecursoAprendizagem;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @OneToMany(mappedBy = "tipoRecursoAprendizagem")
    private Collection<RecursoAprendizagem> recursoAprendizagemCollection;

    public TipoRecursoAprendizagem() {
    }

    public TipoRecursoAprendizagem(Integer idtipoRecursoAprendizagem) {
        this.idtipoRecursoAprendizagem = idtipoRecursoAprendizagem;
    }

    public TipoRecursoAprendizagem(Integer idtipoRecursoAprendizagem, String nome) {
        this.idtipoRecursoAprendizagem = idtipoRecursoAprendizagem;
        this.nome = nome;
    }

    public Integer getIdtipoRecursoAprendizagem() {
        return idtipoRecursoAprendizagem;
    }

    public void setIdtipoRecursoAprendizagem(Integer idtipoRecursoAprendizagem) {
        this.idtipoRecursoAprendizagem = idtipoRecursoAprendizagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public Collection<RecursoAprendizagem> getRecursoAprendizagemCollection() {
        return recursoAprendizagemCollection;
    }

    public void setRecursoAprendizagemCollection(Collection<RecursoAprendizagem> recursoAprendizagemCollection) {
        this.recursoAprendizagemCollection = recursoAprendizagemCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipoRecursoAprendizagem != null ? idtipoRecursoAprendizagem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoRecursoAprendizagem)) {
            return false;
        }
        TipoRecursoAprendizagem other = (TipoRecursoAprendizagem) object;
        if ((this.idtipoRecursoAprendizagem == null && other.idtipoRecursoAprendizagem != null) || (this.idtipoRecursoAprendizagem != null && !this.idtipoRecursoAprendizagem.equals(other.idtipoRecursoAprendizagem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.muranodesign.model.TipoRecursoAprendizagem[ idtipoRecursoAprendizagem=" + idtipoRecursoAprendizagem + " ]";
    }
    
}
