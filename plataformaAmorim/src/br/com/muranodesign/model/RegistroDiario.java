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
import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rogerio
 */
@Entity
@Table(name = "registro_diario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RegistroDiario.findAll", query = "SELECT r FROM RegistroDiario r"),
    @NamedQuery(name = "RegistroDiario.findByIdregistroDiario", query = "SELECT r FROM RegistroDiario r WHERE r.idregistroDiario = :idregistroDiario"),
    @NamedQuery(name = "RegistroDiario.findByData", query = "SELECT r FROM RegistroDiario r WHERE r.data = :data")})
public class RegistroDiario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idregistro_diario")
    private Integer idregistroDiario;
    @Basic(optional = false)
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Basic(optional = false)
    @Lob
    @Column(name = "registro")
    private String registro;
    @JoinColumn(name = "plano_estudo", referencedColumnName = "idplano_estudo")
    @ManyToOne
    private PlanoEstudo planoEstudo;

    public RegistroDiario() {
    }

    public RegistroDiario(Integer idregistroDiario) {
        this.idregistroDiario = idregistroDiario;
    }

    public RegistroDiario(Integer idregistroDiario, Date data, String registro) {
        this.idregistroDiario = idregistroDiario;
        this.data = data;
        this.registro = registro;
    }

    public Integer getIdregistroDiario() {
        return idregistroDiario;
    }

    public void setIdregistroDiario(Integer idregistroDiario) {
        this.idregistroDiario = idregistroDiario;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public PlanoEstudo getPlanoEstudo() {
        return planoEstudo;
    }

    public void setPlanoEstudo(PlanoEstudo planoEstudo) {
        this.planoEstudo = planoEstudo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idregistroDiario != null ? idregistroDiario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegistroDiario)) {
            return false;
        }
        RegistroDiario other = (RegistroDiario) object;
        if ((this.idregistroDiario == null && other.idregistroDiario != null) || (this.idregistroDiario != null && !this.idregistroDiario.equals(other.idregistroDiario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.muranodesign.model.RegistroDiario[ idregistroDiario=" + idregistroDiario + " ]";
    }
    
}
