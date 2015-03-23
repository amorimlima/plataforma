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
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
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
@Table(name = "perfil")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Perfil.findAll", query = "SELECT p FROM Perfil p"),
    @NamedQuery(name = "Perfil.findByIdperfil", query = "SELECT p FROM Perfil p WHERE p.idperfil = :idperfil"),
    @NamedQuery(name = "Perfil.findByPerfil", query = "SELECT p FROM Perfil p WHERE p.perfil = :perfil")})
public class Perfil implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idperfil")
    private Integer idperfil;
    @Column(name = "perfil")
    private String perfil;
    @Lob
    @Column(name = "descricao")
    private String descricao;
    @ManyToMany(mappedBy = "perfilCollection")
    private Collection<Acoes> acoesCollection;
 
    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "perfil")
    private Collection<ProfessorFuncionario> professorFuncionarioCollection;*/
   
    @OneToMany(mappedBy = "perfil")
    private Collection<Usuario> usuarioCollection;

    public Perfil() {
    }

    public Perfil(Integer idperfil) {
        this.idperfil = idperfil;
    }

    public Integer getIdperfil() {
        return idperfil;
    }

    public void setIdperfil(Integer idperfil) {
        this.idperfil = idperfil;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public Collection<Acoes> getAcoesCollection() {
        return acoesCollection;
    }

    public void setAcoesCollection(Collection<Acoes> acoesCollection) {
        this.acoesCollection = acoesCollection;
    }

    /*@XmlTransient
    public Collection<ProfessorFuncionario> getProfessorFuncionarioCollection() {
        return professorFuncionarioCollection;
    }

    public void setProfessorFuncionarioCollection(Collection<ProfessorFuncionario> professorFuncionarioCollection) {
        this.professorFuncionarioCollection = professorFuncionarioCollection;
    }*/

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idperfil != null ? idperfil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Perfil)) {
            return false;
        }
        Perfil other = (Perfil) object;
        if ((this.idperfil == null && other.idperfil != null) || (this.idperfil != null && !this.idperfil.equals(other.idperfil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.muranodesign.model.Perfil[ idperfil=" + idperfil + " ]";
    }
    
}
