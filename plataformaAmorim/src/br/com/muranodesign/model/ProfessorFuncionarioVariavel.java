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
import javax.persistence.Lob;
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
@Table(name = "professor_funcionario_variavel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProfessorFuncionarioVariavel.findAll", query = "SELECT p FROM ProfessorFuncionarioVariavel p"),
    @NamedQuery(name = "ProfessorFuncionarioVariavel.findByIdprofessorFuncionarioVariavel", query = "SELECT p FROM ProfessorFuncionarioVariavel p WHERE p.idprofessorFuncionarioVariavel = :idprofessorFuncionarioVariavel"),
    @NamedQuery(name = "ProfessorFuncionarioVariavel.findByFormacao", query = "SELECT p FROM ProfessorFuncionarioVariavel p WHERE p.formacao = :formacao"),
    @NamedQuery(name = "ProfessorFuncionarioVariavel.findByQuinquenio", query = "SELECT p FROM ProfessorFuncionarioVariavel p WHERE p.quinquenio = :quinquenio"),
    @NamedQuery(name = "ProfessorFuncionarioVariavel.findByLetra", query = "SELECT p FROM ProfessorFuncionarioVariavel p WHERE p.letra = :letra"),
    @NamedQuery(name = "ProfessorFuncionarioVariavel.findByDescontoQuinquenio", query = "SELECT p FROM ProfessorFuncionarioVariavel p WHERE p.descontoQuinquenio = :descontoQuinquenio"),
    @NamedQuery(name = "ProfessorFuncionarioVariavel.findByCargo", query = "SELECT p FROM ProfessorFuncionarioVariavel p WHERE p.cargo = :cargo")})
public class ProfessorFuncionarioVariavel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idprofessor_funcionario_variavel")
    private Integer idprofessorFuncionarioVariavel;
    @Basic(optional = false)
    @Column(name = "formacao")
    private String formacao;
    @Basic(optional = false)
    @Column(name = "quinquenio")
    private short quinquenio;
    @Basic(optional = false)
    @Column(name = "letra")
    private String letra;
    @Column(name = "desconto_quinquenio")
    private Short descontoQuinquenio;
    @Lob
    @Column(name = "foto_professor_funcionario")
    private String fotoProfessorFuncionario;
    @Lob
    @Column(name = "observacao")
    private String observacao;
    @Column(name = "cargo")
    private String cargo;
    
    
    @Column(name = "ativo")
    private int ativo;
    
    
    @Column(name = "qpe")
    private String qpe;
    
    @JoinColumn(name = "professor_funcionario", referencedColumnName = "idprofessor_funcionario")
    @ManyToOne
    private ProfessorFuncionario professorFuncionario;
    @JoinColumn(name = "periodo", referencedColumnName = "idperiodo")
    @ManyToOne
    private Periodo periodo;
    @JoinColumn(name = "ano_letivo", referencedColumnName = "idano_letivo")
    @ManyToOne
    private AnoLetivo anoLetivo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "professor")
    private Collection<PresencaProfessor> presencaProfessorCollection;

    public ProfessorFuncionarioVariavel() {
    }

    public ProfessorFuncionarioVariavel(Integer idprofessorFuncionarioVariavel) {
        this.idprofessorFuncionarioVariavel = idprofessorFuncionarioVariavel;
    }

    public ProfessorFuncionarioVariavel(Integer idprofessorFuncionarioVariavel, String formacao, short quinquenio, String letra) {
        this.idprofessorFuncionarioVariavel = idprofessorFuncionarioVariavel;
        this.formacao = formacao;
        this.quinquenio = quinquenio;
        this.letra = letra;
    }

    public Integer getIdprofessorFuncionarioVariavel() {
        return idprofessorFuncionarioVariavel;
    }

    public void setIdprofessorFuncionarioVariavel(Integer idprofessorFuncionarioVariavel) {
        this.idprofessorFuncionarioVariavel = idprofessorFuncionarioVariavel;
    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    public short getQuinquenio() {
        return quinquenio;
    }

    public void setQuinquenio(short quinquenio) {
        this.quinquenio = quinquenio;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public Short getDescontoQuinquenio() {
        return descontoQuinquenio;
    }

    public void setDescontoQuinquenio(Short descontoQuinquenio) {
        this.descontoQuinquenio = descontoQuinquenio;
    }

    

    public String getFotoProfessorFuncionario() {
		return fotoProfessorFuncionario;
	}

	public void setFotoProfessorFuncionario(String fotoProfessorFuncionario) {
		this.fotoProfessorFuncionario = fotoProfessorFuncionario;
	}

	public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public ProfessorFuncionario getProfessorFuncionario() {
        return professorFuncionario;
    }

    public void setProfessorFuncionario(ProfessorFuncionario professorFuncionario) {
        this.professorFuncionario = professorFuncionario;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public AnoLetivo getAnoLetivo() {
        return anoLetivo;
    }

    public void setAnoLetivo(AnoLetivo anoLetivo) {
        this.anoLetivo = anoLetivo;
    }

    @XmlTransient
    public Collection<PresencaProfessor> getPresencaProfessorCollection() {
        return presencaProfessorCollection;
    }

    public void setPresencaProfessorCollection(Collection<PresencaProfessor> presencaProfessorCollection) {
        this.presencaProfessorCollection = presencaProfessorCollection;
    }

    
    
    public int getAtivo() {
		return ativo;
	}

	public void setAtivo(int ativo) {
		this.ativo = ativo;
	}

	
	
	public String getQpe() {
		return qpe;
	}

	public void setQpe(String qpe) {
		this.qpe = qpe;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idprofessorFuncionarioVariavel != null ? idprofessorFuncionarioVariavel.hashCode() : 0);
        return hash;
    }

	
	
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProfessorFuncionarioVariavel)) {
            return false;
        }
        ProfessorFuncionarioVariavel other = (ProfessorFuncionarioVariavel) object;
        if ((this.idprofessorFuncionarioVariavel == null && other.idprofessorFuncionarioVariavel != null) || (this.idprofessorFuncionarioVariavel != null && !this.idprofessorFuncionarioVariavel.equals(other.idprofessorFuncionarioVariavel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.muranodesign.model.ProfessorFuncionarioVariavel[ idprofessorFuncionarioVariavel=" + idprofessorFuncionarioVariavel + " ]";
    }
    
}
