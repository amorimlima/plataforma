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
@Table(name = "periodo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Periodo.findAll", query = "SELECT p FROM Periodo p"),
    @NamedQuery(name = "Periodo.findByIdperiodo", query = "SELECT p FROM Periodo p WHERE p.idperiodo = :idperiodo"),
    @NamedQuery(name = "Periodo.findByPeriodo", query = "SELECT p FROM Periodo p WHERE p.periodo = :periodo")})
public class Periodo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idperiodo")
    private Integer idperiodo;
    @Column(name = "periodo")
    private String periodo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "periodo")
    private Collection<AlunoVariavel> alunoVariavelCollection;
    @OneToMany(mappedBy = "periodo")
    private Collection<Tutoria> tutoriaCollection;
    @OneToMany(mappedBy = "periodo")
    private Collection<ProfessorFuncionarioVariavel> professorFuncionarioVariavelCollection;

    public Periodo() {
    }

    public Periodo(Integer idperiodo) {
        this.idperiodo = idperiodo;
    }

    public Integer getIdperiodo() {
        return idperiodo;
    }

    public void setIdperiodo(Integer idperiodo) {
        this.idperiodo = idperiodo;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    @XmlTransient
    public Collection<AlunoVariavel> getAlunoVariavelCollection() {
        return alunoVariavelCollection;
    }

    public void setAlunoVariavelCollection(Collection<AlunoVariavel> alunoVariavelCollection) {
        this.alunoVariavelCollection = alunoVariavelCollection;
    }

    @XmlTransient
    public Collection<Tutoria> getTutoriaCollection() {
        return tutoriaCollection;
    }

    public void setTutoriaCollection(Collection<Tutoria> tutoriaCollection) {
        this.tutoriaCollection = tutoriaCollection;
    }

    @XmlTransient
    public Collection<ProfessorFuncionarioVariavel> getProfessorFuncionarioVariavelCollection() {
        return professorFuncionarioVariavelCollection;
    }

    public void setProfessorFuncionarioVariavelCollection(Collection<ProfessorFuncionarioVariavel> professorFuncionarioVariavelCollection) {
        this.professorFuncionarioVariavelCollection = professorFuncionarioVariavelCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idperiodo != null ? idperiodo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Periodo)) {
            return false;
        }
        Periodo other = (Periodo) object;
        if ((this.idperiodo == null && other.idperiodo != null) || (this.idperiodo != null && !this.idperiodo.equals(other.idperiodo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.muranodesign.model.Periodo[ idperiodo=" + idperiodo + " ]";
    }
    
}
