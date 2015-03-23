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
@Table(name = "tutoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tutoria.findAll", query = "SELECT t FROM Tutoria t"),
    @NamedQuery(name = "Tutoria.findByIdtutoria", query = "SELECT t FROM Tutoria t WHERE t.idtutoria = :idtutoria"),
    @NamedQuery(name = "Tutoria.findByTutoria", query = "SELECT t FROM Tutoria t WHERE t.tutoria = :tutoria")})
public class Tutoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtutoria")
    private Integer idtutoria;
    @Column(name = "tutoria")
    private String tutoria;
    @OneToMany(mappedBy = "tutoria")
    private Collection<Grupo> grupoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tutoria")
    private Collection<RelatorioTutoria> relatorioTutoriaCollection;
    @JoinColumn(name = "tutor", referencedColumnName = "idprofessor_funcionario")
    @ManyToOne
    private ProfessorFuncionario tutor;
    @JoinColumn(name = "ano_letivo", referencedColumnName = "idano_letivo")
    @ManyToOne
    private AnoLetivo anoLetivo;
    @JoinColumn(name = "periodo", referencedColumnName = "idperiodo")
    @ManyToOne
    private Periodo periodo;

    public Tutoria() {
    }

    public Tutoria(Integer idtutoria) {
        this.idtutoria = idtutoria;
    }

    public Integer getIdtutoria() {
        return idtutoria;
    }

    public void setIdtutoria(Integer idtutoria) {
        this.idtutoria = idtutoria;
    }

    public String getTutoria() {
        return tutoria;
    }

    public void setTutoria(String tutoria) {
        this.tutoria = tutoria;
    }

    @XmlTransient
    public Collection<Grupo> getGrupoCollection() {
        return grupoCollection;
    }

    public void setGrupoCollection(Collection<Grupo> grupoCollection) {
        this.grupoCollection = grupoCollection;
    }

    @XmlTransient
    public Collection<RelatorioTutoria> getRelatorioTutoriaCollection() {
        return relatorioTutoriaCollection;
    }

    public void setRelatorioTutoriaCollection(Collection<RelatorioTutoria> relatorioTutoriaCollection) {
        this.relatorioTutoriaCollection = relatorioTutoriaCollection;
    }

    public ProfessorFuncionario getTutor() {
        return tutor;
    }

    public void setTutor(ProfessorFuncionario tutor) {
        this.tutor = tutor;
    }

    public AnoLetivo getAnoLetivo() {
        return anoLetivo;
    }

    public void setAnoLetivo(AnoLetivo anoLetivo) {
        this.anoLetivo = anoLetivo;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtutoria != null ? idtutoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tutoria)) {
            return false;
        }
        Tutoria other = (Tutoria) object;
        if ((this.idtutoria == null && other.idtutoria != null) || (this.idtutoria != null && !this.idtutoria.equals(other.idtutoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.muranodesign.model.Tutoria[ idtutoria=" + idtutoria + " ]";
    }
    
}
