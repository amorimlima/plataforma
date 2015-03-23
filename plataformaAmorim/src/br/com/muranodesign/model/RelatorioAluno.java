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
@Table(name = "relatorio_aluno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RelatorioAluno.findAll", query = "SELECT r FROM RelatorioAluno r"),
    @NamedQuery(name = "RelatorioAluno.findByIdrelatorioAluno", query = "SELECT r FROM RelatorioAluno r WHERE r.idrelatorioAluno = :idrelatorioAluno"),
    @NamedQuery(name = "RelatorioAluno.findByData", query = "SELECT r FROM RelatorioAluno r WHERE r.data = :data")})
public class RelatorioAluno implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idrelatorio_aluno")
    private Integer idrelatorioAluno;
    @Lob
    @Column(name = "relatorio")
    private String relatorio;
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @JoinColumn(name = "aluno", referencedColumnName = "ID_ALUNO")
    @ManyToOne
    private Aluno aluno;
    @JoinColumn(name = "ano_letivo", referencedColumnName = "idano_letivo")
    @ManyToOne
    private AnoLetivo anoLetivo;
    @JoinColumn(name = "professor", referencedColumnName = "idprofessor_funcionario")
    @ManyToOne
    private ProfessorFuncionario professor;

    public RelatorioAluno() {
    }

    public RelatorioAluno(Integer idrelatorioAluno) {
        this.idrelatorioAluno = idrelatorioAluno;
    }

    public Integer getIdrelatorioAluno() {
        return idrelatorioAluno;
    }

    public void setIdrelatorioAluno(Integer idrelatorioAluno) {
        this.idrelatorioAluno = idrelatorioAluno;
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

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public AnoLetivo getAnoLetivo() {
        return anoLetivo;
    }

    public void setAnoLetivo(AnoLetivo anoLetivo) {
        this.anoLetivo = anoLetivo;
    }

    public ProfessorFuncionario getProfessor() {
        return professor;
    }

    public void setProfessor(ProfessorFuncionario professor) {
        this.professor = professor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrelatorioAluno != null ? idrelatorioAluno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RelatorioAluno)) {
            return false;
        }
        RelatorioAluno other = (RelatorioAluno) object;
        if ((this.idrelatorioAluno == null && other.idrelatorioAluno != null) || (this.idrelatorioAluno != null && !this.idrelatorioAluno.equals(other.idrelatorioAluno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.muranodesign.model.RelatorioAluno[ idrelatorioAluno=" + idrelatorioAluno + " ]";
    }
    
}
