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
@Table(name = "ano_estudo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AnoEstudo.findAll", query = "SELECT a FROM AnoEstudo a"),
    @NamedQuery(name = "AnoEstudo.findByIdanoEstudo", query = "SELECT a FROM AnoEstudo a WHERE a.idanoEstudo = :idanoEstudo"),
    @NamedQuery(name = "AnoEstudo.findByAno", query = "SELECT a FROM AnoEstudo a WHERE a.ano = :ano")})
public class AnoEstudo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idano_estudo")
    private Integer idanoEstudo;
    @Basic(optional = false)
    @Column(name = "ano")
    private String ano;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "anoEstudo")
    private Collection<AlunoVariavel> alunoVariavelCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "anoEstudo")
    private Collection<Roteiro> roteiroCollection;

    public AnoEstudo() {
    }

    public AnoEstudo(Integer idanoEstudo) {
        this.idanoEstudo = idanoEstudo;
    }

    public AnoEstudo(Integer idanoEstudo, String ano) {
        this.idanoEstudo = idanoEstudo;
        this.ano = ano;
    }

    public Integer getIdanoEstudo() {
        return idanoEstudo;
    }

    public void setIdanoEstudo(Integer idanoEstudo) {
        this.idanoEstudo = idanoEstudo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    @XmlTransient
    public Collection<AlunoVariavel> getAlunoVariavelCollection() {
        return alunoVariavelCollection;
    }

    public void setAlunoVariavelCollection(Collection<AlunoVariavel> alunoVariavelCollection) {
        this.alunoVariavelCollection = alunoVariavelCollection;
    }

    @XmlTransient
    public Collection<Roteiro> getRoteiroCollection() {
        return roteiroCollection;
    }

    public void setRoteiroCollection(Collection<Roteiro> roteiroCollection) {
        this.roteiroCollection = roteiroCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idanoEstudo != null ? idanoEstudo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AnoEstudo)) {
            return false;
        }
        AnoEstudo other = (AnoEstudo) object;
        if ((this.idanoEstudo == null && other.idanoEstudo != null) || (this.idanoEstudo != null && !this.idanoEstudo.equals(other.idanoEstudo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.muranodesign.model.AnoEstudo[ idanoEstudo=" + idanoEstudo + " ]";
    }
    
}
