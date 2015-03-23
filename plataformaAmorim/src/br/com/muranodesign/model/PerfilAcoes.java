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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "perfil_acoes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PerfilAcoes.findAll", query = "SELECT p FROM PerfilAcoes p"),
    @NamedQuery(name = "PerfilAcoes.findByIdperfilAcoes", query = "SELECT p FROM PerfilAcoes p WHERE p.idperfilAcoes = :idperfilAcoes")})
public class PerfilAcoes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idperfil_acoes")
    private Integer idperfilAcoes;
    @JoinColumn(name = "perfil", referencedColumnName = "idperfil")
    @ManyToOne
    private Perfil perfil;
    @JoinColumn(name = "acoes", referencedColumnName = "idacoes")
    @ManyToOne
    private Acoes acoes;
    @OneToMany(mappedBy = "perfilAcoes")
    private Collection<Perfil> perfilCollection;
    @OneToMany(mappedBy = "perfilAcoes")
    private Collection<Acoes> acoesCollection;

    public PerfilAcoes() {
    }

    public PerfilAcoes(Integer idperfilAcoes) {
        this.idperfilAcoes = idperfilAcoes;
    }

    public Integer getIdperfilAcoes() {
        return idperfilAcoes;
    }

    public void setIdperfilAcoes(Integer idperfilAcoes) {
        this.idperfilAcoes = idperfilAcoes;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public Acoes getAcoes() {
        return acoes;
    }

    public void setAcoes(Acoes acoes) {
        this.acoes = acoes;
    }

    @XmlTransient
    public Collection<Perfil> getPerfilCollection() {
        return perfilCollection;
    }

    public void setPerfilCollection(Collection<Perfil> perfilCollection) {
        this.perfilCollection = perfilCollection;
    }

    @XmlTransient
    public Collection<Acoes> getAcoesCollection() {
        return acoesCollection;
    }

    public void setAcoesCollection(Collection<Acoes> acoesCollection) {
        this.acoesCollection = acoesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idperfilAcoes != null ? idperfilAcoes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PerfilAcoes)) {
            return false;
        }
        PerfilAcoes other = (PerfilAcoes) object;
        if ((this.idperfilAcoes == null && other.idperfilAcoes != null) || (this.idperfilAcoes != null && !this.idperfilAcoes.equals(other.idperfilAcoes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.muranodesign.model.PerfilAcoes[ idperfilAcoes=" + idperfilAcoes + " ]";
    }
    
}
