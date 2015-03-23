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
@Table(name = "ano_letivo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AnoLetivo.findAll", query = "SELECT a FROM AnoLetivo a"),
    @NamedQuery(name = "AnoLetivo.findByIdanoLetivo", query = "SELECT a FROM AnoLetivo a WHERE a.idanoLetivo = :idanoLetivo"),
    @NamedQuery(name = "AnoLetivo.findByAno", query = "SELECT a FROM AnoLetivo a WHERE a.ano = :ano")})
public class AnoLetivo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idano_letivo")
    private Integer idanoLetivo;
    @Basic(optional = false)
    @Column(name = "ano")
    private String ano;
    @OneToMany(mappedBy = "anoLetivo")
    private Collection<RelatorioAluno> relatorioAlunoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "anoLetivo")
    private Collection<AlunoVariavel> alunoVariavelCollection;
    @OneToMany(mappedBy = "anoLetivo")
    private Collection<Tutoria> tutoriaCollection;
    @OneToMany(mappedBy = "anoLetivo")
    private Collection<ProfessorFuncionarioVariavel> professorFuncionarioVariavelCollection;
    @OneToMany(mappedBy = "anoLetivo")
  //  private Collection<CalendarioEventos> calendarioEventosCollection;
    //@OneToMany(mappedBy = "anoLetivo")
    private Collection<FichaFinalizacaoQuestao> fichaFinalizacaoQuestaoCollection;
    @OneToMany(mappedBy = "anoLetivo")
    private Collection<AtribuicaoRoteiroExtra> atribuicaoRoteiroExtraCollection;

    public AnoLetivo() {
    }

    public AnoLetivo(Integer idanoLetivo) {
        this.idanoLetivo = idanoLetivo;
    }

    public AnoLetivo(Integer idanoLetivo, String ano) {
        this.idanoLetivo = idanoLetivo;
        this.ano = ano;
    }

    public Integer getIdanoLetivo() {
        return idanoLetivo;
    }

    public void setIdanoLetivo(Integer idanoLetivo) {
        this.idanoLetivo = idanoLetivo;
    }

   

    public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	@XmlTransient
    public Collection<RelatorioAluno> getRelatorioAlunoCollection() {
        return relatorioAlunoCollection;
    }

    public void setRelatorioAlunoCollection(Collection<RelatorioAluno> relatorioAlunoCollection) {
        this.relatorioAlunoCollection = relatorioAlunoCollection;
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

   

    @XmlTransient
    public Collection<FichaFinalizacaoQuestao> getFichaFinalizacaoQuestaoCollection() {
        return fichaFinalizacaoQuestaoCollection;
    }

    public void setFichaFinalizacaoQuestaoCollection(Collection<FichaFinalizacaoQuestao> fichaFinalizacaoQuestaoCollection) {
        this.fichaFinalizacaoQuestaoCollection = fichaFinalizacaoQuestaoCollection;
    }

    @XmlTransient
    public Collection<AtribuicaoRoteiroExtra> getAtribuicaoRoteiroExtraCollection() {
        return atribuicaoRoteiroExtraCollection;
    }

    public void setAtribuicaoRoteiroExtraCollection(Collection<AtribuicaoRoteiroExtra> atribuicaoRoteiroExtraCollection) {
        this.atribuicaoRoteiroExtraCollection = atribuicaoRoteiroExtraCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idanoLetivo != null ? idanoLetivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AnoLetivo)) {
            return false;
        }
        AnoLetivo other = (AnoLetivo) object;
        if ((this.idanoLetivo == null && other.idanoLetivo != null) || (this.idanoLetivo != null && !this.idanoLetivo.equals(other.idanoLetivo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.muranodesign.model.AnoLetivo[ idanoLetivo=" + idanoLetivo + " ]";
    }
    
}
