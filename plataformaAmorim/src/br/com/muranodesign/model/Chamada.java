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
@Table(name = "chamada")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Chamada.findAll", query = "SELECT c FROM Chamada c"),
    @NamedQuery(name = "Chamada.findByIdchamada", query = "SELECT c FROM Chamada c WHERE c.idchamada = :idchamada"),
    @NamedQuery(name = "Chamada.findByData", query = "SELECT c FROM Chamada c WHERE c.data = :data"),
    @NamedQuery(name = "Chamada.findByPresenca", query = "SELECT c FROM Chamada c WHERE c.presenca = :presenca")})
public class Chamada implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idchamada")
    private Integer idchamada;
    @Basic(optional = false)
    @Column(name = "data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @Basic(optional = false)
    @Column(name = "presenca")
    private short presenca;
    @JoinColumn(name = "aluno", referencedColumnName = "ID_ALUNO")
    @ManyToOne(optional = false)
    private Aluno aluno;

    public Chamada() {
    }

    public Chamada(Integer idchamada) {
        this.idchamada = idchamada;
    }

    public Chamada(Integer idchamada, Date data, short presenca) {
        this.idchamada = idchamada;
        this.data = data;
        this.presenca = presenca;
    }

    public Integer getIdchamada() {
        return idchamada;
    }

    public void setIdchamada(Integer idchamada) {
        this.idchamada = idchamada;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public short getPresenca() {
        return presenca;
    }

    public void setPresenca(short presenca) {
        this.presenca = presenca;
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
        hash += (idchamada != null ? idchamada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chamada)) {
            return false;
        }
        Chamada other = (Chamada) object;
        if ((this.idchamada == null && other.idchamada != null) || (this.idchamada != null && !this.idchamada.equals(other.idchamada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.muranodesign.model.Chamada[ idchamada=" + idchamada + " ]";
    }
    
}
