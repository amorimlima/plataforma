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
@Table(name = "relatorio_tutoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RelatorioTutoria.findAll", query = "SELECT r FROM RelatorioTutoria r"),
    @NamedQuery(name = "RelatorioTutoria.findByIdrelatorioTutoria", query = "SELECT r FROM RelatorioTutoria r WHERE r.idrelatorioTutoria = :idrelatorioTutoria"),
    @NamedQuery(name = "RelatorioTutoria.findByData", query = "SELECT r FROM RelatorioTutoria r WHERE r.data = :data")})
public class RelatorioTutoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idrelatorio_tutoria")
    private Integer idrelatorioTutoria;
    @Basic(optional = false)
    @Lob
    @Column(name = "relatorio")
    private String relatorio;
    @Basic(optional = false)
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @JoinColumn(name = "tutoria", referencedColumnName = "idtutoria")
    @ManyToOne(optional = false)
    private Tutoria tutoria;
    @JoinColumn(name = "aluno", referencedColumnName = "ID_ALUNO")
    @ManyToOne(optional = false)
    private Aluno aluno;

    public RelatorioTutoria() {
    }

    public RelatorioTutoria(Integer idrelatorioTutoria) {
        this.idrelatorioTutoria = idrelatorioTutoria;
    }

    public RelatorioTutoria(Integer idrelatorioTutoria, String relatorio, Date data) {
        this.idrelatorioTutoria = idrelatorioTutoria;
        this.relatorio = relatorio;
        this.data = data;
    }

    public Integer getIdrelatorioTutoria() {
        return idrelatorioTutoria;
    }

    public void setIdrelatorioTutoria(Integer idrelatorioTutoria) {
        this.idrelatorioTutoria = idrelatorioTutoria;
    }

    public String getRelatorio() {
        return relatorio;
    }

    public void setRelatorio(String relatorio) {
        this.relatorio = relatorio;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Tutoria getTutoria() {
        return tutoria;
    }

    public void setTutoria(Tutoria tutoria) {
        this.tutoria = tutoria;
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
        hash += (idrelatorioTutoria != null ? idrelatorioTutoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RelatorioTutoria)) {
            return false;
        }
        RelatorioTutoria other = (RelatorioTutoria) object;
        if ((this.idrelatorioTutoria == null && other.idrelatorioTutoria != null) || (this.idrelatorioTutoria != null && !this.idrelatorioTutoria.equals(other.idrelatorioTutoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.muranodesign.model.RelatorioTutoria[ idrelatorioTutoria=" + idrelatorioTutoria + " ]";
    }
    
}
