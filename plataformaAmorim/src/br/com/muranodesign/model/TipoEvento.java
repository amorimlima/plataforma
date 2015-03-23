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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rogerio
 */
@Entity
@Table(name = "tipo_evento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoEvento.findAll", query = "SELECT t FROM TipoEvento t"),
    @NamedQuery(name = "TipoEvento.findByIdtipoEvento", query = "SELECT t FROM TipoEvento t WHERE t.idtipoEvento = :idtipoEvento"),
    @NamedQuery(name = "TipoEvento.findByTipoEvento", query = "SELECT t FROM TipoEvento t WHERE t.tipoEvento = :tipoEvento")})
public class TipoEvento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipo_evento")
    private Integer idtipoEvento;
    @Basic(optional = false)
    @Column(name = "tipo_evento")
    private String tipoEvento;
    
    //@OneToMany(mappedBy = "tipoEventoData")
   // private Collection<Calendario> calendarioCollection;
    //@OneToMany(mappedBy = "tipoEvento")
    //private Collection<CalendarioEventos> calendarioEventosCollection;

    public TipoEvento() {
    }

    public TipoEvento(Integer idtipoEvento) {
        this.idtipoEvento = idtipoEvento;
    }

    public TipoEvento(Integer idtipoEvento, String tipoEvento) {
        this.idtipoEvento = idtipoEvento;
        this.tipoEvento = tipoEvento;
    }

    public Integer getIdtipoEvento() {
        return idtipoEvento;
    }

    public void setIdtipoEvento(Integer idtipoEvento) {
        this.idtipoEvento = idtipoEvento;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipoEvento != null ? idtipoEvento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoEvento)) {
            return false;
        }
        TipoEvento other = (TipoEvento) object;
        if ((this.idtipoEvento == null && other.idtipoEvento != null) || (this.idtipoEvento != null && !this.idtipoEvento.equals(other.idtipoEvento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.muranodesign.model.TipoEvento[ idtipoEvento=" + idtipoEvento + " ]";
    }
    
}
