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
@Table(name = "aluno_variavel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AlunoVariavel.findAll", query = "SELECT a FROM AlunoVariavel a"),
    @NamedQuery(name = "AlunoVariavel.findByIdalunoVariavel", query = "SELECT a FROM AlunoVariavel a WHERE a.idalunoVariavel = :idalunoVariavel"),
    @NamedQuery(name = "AlunoVariavel.findByInicio", query = "SELECT a FROM AlunoVariavel a WHERE a.inicio = :inicio"),
    @NamedQuery(name = "AlunoVariavel.findByProgramaSocial", query = "SELECT a FROM AlunoVariavel a WHERE a.programaSocial = :programaSocial")})
public class AlunoVariavel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idaluno_variavel")
    private Integer idalunoVariavel;
    @Basic(optional = false)
    @Column(name = "inicio")
    @Temporal(TemporalType.DATE)
    private Date inicio;
    @Column(name = "programa_social")
    private String programaSocial;
    @JoinColumn(name = "ano_estudo", referencedColumnName = "idano_estudo")
    @ManyToOne(optional = false)
    private AnoEstudo anoEstudo;
    @JoinColumn(name = "ano_letivo", referencedColumnName = "idano_letivo")
    @ManyToOne(optional = false)
    private AnoLetivo anoLetivo;
    
    @Column(name = "ativo")
    private int ativo;
    
    
    @JoinColumn(name = "aluno", referencedColumnName = "ID_ALUNO")
    @ManyToOne(optional = false)
    private Aluno aluno;
    @JoinColumn(name = "periodo", referencedColumnName = "idperiodo")
    @ManyToOne(optional = false)
    private Periodo periodo;
    @JoinColumn(name = "grupo", referencedColumnName = "idgrupo")
    @ManyToOne
    private Grupo grupo;

    public AlunoVariavel() {
    }

    public AlunoVariavel(Integer idalunoVariavel) {
        this.idalunoVariavel = idalunoVariavel;
    }

    public AlunoVariavel(Integer idalunoVariavel, Date inicio) {
        this.idalunoVariavel = idalunoVariavel;
        this.inicio = inicio;
    }

    public Integer getIdalunoVariavel() {
        return idalunoVariavel;
    }

    public void setIdalunoVariavel(Integer idalunoVariavel) {
        this.idalunoVariavel = idalunoVariavel;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public String getProgramaSocial() {
        return programaSocial;
    }

    public void setProgramaSocial(String programaSocial) {
        this.programaSocial = programaSocial;
    }

    public AnoEstudo getAnoEstudo() {
        return anoEstudo;
    }

    public void setAnoEstudo(AnoEstudo anoEstudo) {
        this.anoEstudo = anoEstudo;
    }

    public AnoLetivo getAnoLetivo() {
        return anoLetivo;
    }

    public void setAnoLetivo(AnoLetivo anoLetivo) {
        this.anoLetivo = anoLetivo;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    
    
    public int getAtivo() {
		return ativo;
	}

	public void setAtivo(int ativo) {
		this.ativo = ativo;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idalunoVariavel != null ? idalunoVariavel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlunoVariavel)) {
            return false;
        }
        AlunoVariavel other = (AlunoVariavel) object;
        if ((this.idalunoVariavel == null && other.idalunoVariavel != null) || (this.idalunoVariavel != null && !this.idalunoVariavel.equals(other.idalunoVariavel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.muranodesign.model.AlunoVariavel[ idalunoVariavel=" + idalunoVariavel + " ]";
    }
    
}
