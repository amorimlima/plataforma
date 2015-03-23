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
@Table(name = "presenca_professor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PresencaProfessor.findAll", query = "SELECT p FROM PresencaProfessor p"),
    @NamedQuery(name = "PresencaProfessor.findByIdpresencaProfessor", query = "SELECT p FROM PresencaProfessor p WHERE p.idpresencaProfessor = :idpresencaProfessor"),
    @NamedQuery(name = "PresencaProfessor.findByData", query = "SELECT p FROM PresencaProfessor p WHERE p.data = :data"),
    @NamedQuery(name = "PresencaProfessor.findByPresenca", query = "SELECT p FROM PresencaProfessor p WHERE p.presenca = :presenca")})
public class PresencaProfessor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpresenca_professor")
    private Integer idpresencaProfessor;
    @Basic(optional = false)
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Basic(optional = false)
    @Column(name = "presenca")
    private int presenca;
    @JoinColumn(name = "professor", referencedColumnName = "idprofessor_funcionario_variavel")
    @ManyToOne(optional = false)
    private ProfessorFuncionarioVariavel professor;
    @JoinColumn(name = "calendario", referencedColumnName = "idcalendario")
    @ManyToOne
    private Calendario calendario;

    public PresencaProfessor() {
    }

    public PresencaProfessor(Integer idpresencaProfessor) {
        this.idpresencaProfessor = idpresencaProfessor;
    }

    public PresencaProfessor(Integer idpresencaProfessor, Date data, int presenca) {
        this.idpresencaProfessor = idpresencaProfessor;
        this.data = data;
        this.presenca = presenca;
    }

    public Integer getIdpresencaProfessor() {
        return idpresencaProfessor;
    }

    public void setIdpresencaProfessor(Integer idpresencaProfessor) {
        this.idpresencaProfessor = idpresencaProfessor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getPresenca() {
        return presenca;
    }

    public void setPresenca(int presenca) {
        this.presenca = presenca;
    }

    public ProfessorFuncionarioVariavel getProfessor() {
        return professor;
    }

    public void setProfessor(ProfessorFuncionarioVariavel professor) {
        this.professor = professor;
    }

    public Calendario getCalendario() {
        return calendario;
    }

    public void setCalendario(Calendario calendario) {
        this.calendario = calendario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpresencaProfessor != null ? idpresencaProfessor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PresencaProfessor)) {
            return false;
        }
        PresencaProfessor other = (PresencaProfessor) object;
        if ((this.idpresencaProfessor == null && other.idpresencaProfessor != null) || (this.idpresencaProfessor != null && !this.idpresencaProfessor.equals(other.idpresencaProfessor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.muranodesign.model.PresencaProfessor[ idpresencaProfessor=" + idpresencaProfessor + " ]";
    }
    
}
