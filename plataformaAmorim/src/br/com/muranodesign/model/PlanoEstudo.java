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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author rogerio
 */
@Entity
@Table(name = "plano_estudo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlanoEstudo.findAll", query = "SELECT p FROM PlanoEstudo p"),
    @NamedQuery(name = "PlanoEstudo.findByIdplanoEstudo", query = "SELECT p FROM PlanoEstudo p WHERE p.idplanoEstudo = :idplanoEstudo"),
    @NamedQuery(name = "PlanoEstudo.findByDataInicio", query = "SELECT p FROM PlanoEstudo p WHERE p.dataInicio = :dataInicio"),
    @NamedQuery(name = "PlanoEstudo.findByObjetivoTutoria", query = "SELECT p FROM PlanoEstudo p WHERE p.objetivoTutoria = :objetivoTutoria"),
    @NamedQuery(name = "PlanoEstudo.findByObjetivoPessoal", query = "SELECT p FROM PlanoEstudo p WHERE p.objetivoPessoal = :objetivoPessoal"),
    @NamedQuery(name = "PlanoEstudo.findByTarefaDeCasa", query = "SELECT p FROM PlanoEstudo p WHERE p.tarefaDeCasa = :tarefaDeCasa"),
    @NamedQuery(name = "PlanoEstudo.findByAutoAvaliacao", query = "SELECT p FROM PlanoEstudo p WHERE p.autoAvaliacao = :autoAvaliacao"),
    @NamedQuery(name = "PlanoEstudo.findByStatus", query = "SELECT p FROM PlanoEstudo p WHERE p.status = :status"),
    @NamedQuery(name = "PlanoEstudo.findByDataFim", query = "SELECT p FROM PlanoEstudo p WHERE p.dataFim = :dataFim")})
public class PlanoEstudo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idplano_estudo")
    private Integer idplanoEstudo;
    @Basic(optional = false)
    @Column(name = "data_inicio")
    @Temporal(TemporalType.DATE)
    private Date dataInicio;
    @Basic(optional = false)
    @Column(name = "objetivo_tutoria")
    private String objetivoTutoria;
    @Basic(optional = false)
    @Column(name = "objetivo_pessoal")
    private String objetivoPessoal;
    @Column(name = "tarefa_de_casa")
    private String tarefaDeCasa;
    @Column(name = "auto_avaliacao")
    private String autoAvaliacao;
    @Lob
    @Column(name = "observacoes_tutor")
    private String observacoesTutor;
    @Lob
    @Column(name = "observacoes_pais")
    private String observacoesPais;
    @Basic(optional = false)
    @Column(name = "status")
    private short status;
    @Basic(optional = false)
    @Column(name = "data_fim")
    @Temporal(TemporalType.DATE)
    private Date dataFim;
    @JoinColumn(name = "aluno", referencedColumnName = "ID_ALUNO")
    @ManyToOne(optional = false)
    private Aluno aluno;
    @OneToMany(mappedBy = "planoEstudo")
    private Collection<PlanejamentoRoteiro> planejamentoRoteiroCollection;
    @OneToMany(mappedBy = "planoEstudo")
    private Collection<RegistroDiario> registroDiarioCollection;

    public PlanoEstudo() {
    }

    public PlanoEstudo(Integer idplanoEstudo) {
        this.idplanoEstudo = idplanoEstudo;
    }

    public PlanoEstudo(Integer idplanoEstudo, Date dataInicio, String objetivoTutoria, String objetivoPessoal, short status, Date dataFim) {
        this.idplanoEstudo = idplanoEstudo;
        this.dataInicio = dataInicio;
        this.objetivoTutoria = objetivoTutoria;
        this.objetivoPessoal = objetivoPessoal;
        this.status = status;
        this.dataFim = dataFim;
    }

    public Integer getIdplanoEstudo() {
        return idplanoEstudo;
    }

    public void setIdplanoEstudo(Integer idplanoEstudo) {
        this.idplanoEstudo = idplanoEstudo;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getObjetivoTutoria() {
        return objetivoTutoria;
    }

    public void setObjetivoTutoria(String objetivoTutoria) {
        this.objetivoTutoria = objetivoTutoria;
    }

    public String getObjetivoPessoal() {
        return objetivoPessoal;
    }

    public void setObjetivoPessoal(String objetivoPessoal) {
        this.objetivoPessoal = objetivoPessoal;
    }

    public String getTarefaDeCasa() {
        return tarefaDeCasa;
    }

    public void setTarefaDeCasa(String tarefaDeCasa) {
        this.tarefaDeCasa = tarefaDeCasa;
    }

    public String getAutoAvaliacao() {
        return autoAvaliacao;
    }

    public void setAutoAvaliacao(String autoAvaliacao) {
        this.autoAvaliacao = autoAvaliacao;
    }

    public String getObservacoesTutor() {
        return observacoesTutor;
    }

    public void setObservacoesTutor(String observacoesTutor) {
        this.observacoesTutor = observacoesTutor;
    }

    public String getObservacoesPais() {
        return observacoesPais;
    }

    public void setObservacoesPais(String observacoesPais) {
        this.observacoesPais = observacoesPais;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    @XmlTransient
    public Collection<PlanejamentoRoteiro> getPlanejamentoRoteiroCollection() {
        return planejamentoRoteiroCollection;
    }

    public void setPlanejamentoRoteiroCollection(Collection<PlanejamentoRoteiro> planejamentoRoteiroCollection) {
        this.planejamentoRoteiroCollection = planejamentoRoteiroCollection;
    }

    @XmlTransient
    public Collection<RegistroDiario> getRegistroDiarioCollection() {
        return registroDiarioCollection;
    }

    public void setRegistroDiarioCollection(Collection<RegistroDiario> registroDiarioCollection) {
        this.registroDiarioCollection = registroDiarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idplanoEstudo != null ? idplanoEstudo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlanoEstudo)) {
            return false;
        }
        PlanoEstudo other = (PlanoEstudo) object;
        if ((this.idplanoEstudo == null && other.idplanoEstudo != null) || (this.idplanoEstudo != null && !this.idplanoEstudo.equals(other.idplanoEstudo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.muranodesign.model.PlanoEstudo[ idplanoEstudo=" + idplanoEstudo + " ]";
    }
    
}
