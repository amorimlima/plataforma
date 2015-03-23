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
import javax.persistence.Lob;
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
@Table(name = "professor_funcionario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProfessorFuncionario.findAll", query = "SELECT p FROM ProfessorFuncionario p"),
    @NamedQuery(name = "ProfessorFuncionario.findByIdprofessorFuncionario", query = "SELECT p FROM ProfessorFuncionario p WHERE p.idprofessorFuncionario = :idprofessorFuncionario"),
    @NamedQuery(name = "ProfessorFuncionario.findByNome", query = "SELECT p FROM ProfessorFuncionario p WHERE p.nome = :nome"),
    @NamedQuery(name = "ProfessorFuncionario.findByRua", query = "SELECT p FROM ProfessorFuncionario p WHERE p.rua = :rua"),
    @NamedQuery(name = "ProfessorFuncionario.findByNumero", query = "SELECT p FROM ProfessorFuncionario p WHERE p.numero = :numero"),
    @NamedQuery(name = "ProfessorFuncionario.findByComplemento", query = "SELECT p FROM ProfessorFuncionario p WHERE p.complemento = :complemento"),
    @NamedQuery(name = "ProfessorFuncionario.findByCep", query = "SELECT p FROM ProfessorFuncionario p WHERE p.cep = :cep"),
    @NamedQuery(name = "ProfessorFuncionario.findByBairro", query = "SELECT p FROM ProfessorFuncionario p WHERE p.bairro = :bairro"),
    @NamedQuery(name = "ProfessorFuncionario.findByCidade", query = "SELECT p FROM ProfessorFuncionario p WHERE p.cidade = :cidade"),
    @NamedQuery(name = "ProfessorFuncionario.findByEstado", query = "SELECT p FROM ProfessorFuncionario p WHERE p.estado = :estado"),
    @NamedQuery(name = "ProfessorFuncionario.findByNaturalidadeEstado", query = "SELECT p FROM ProfessorFuncionario p WHERE p.naturalidadeEstado = :naturalidadeEstado"),
    @NamedQuery(name = "ProfessorFuncionario.findByNaturalidadePais", query = "SELECT p FROM ProfessorFuncionario p WHERE p.naturalidadePais = :naturalidadePais"),
    //@NamedQuery(name = "ProfessorFuncionario.findByQpe", query = "SELECT p FROM ProfessorFuncionario p WHERE p.qpe = :qpe"),
    @NamedQuery(name = "ProfessorFuncionario.findByDataEntradaPrefeitura", query = "SELECT p FROM ProfessorFuncionario p WHERE p.dataEntradaPrefeitura = :dataEntradaPrefeitura"),
    @NamedQuery(name = "ProfessorFuncionario.findByAtivo", query = "SELECT p FROM ProfessorFuncionario p WHERE p.ativo = :ativo"),
    @NamedQuery(name = "ProfessorFuncionario.findByDataEntradaEscola", query = "SELECT p FROM ProfessorFuncionario p WHERE p.dataEntradaEscola = :dataEntradaEscola"),
    @NamedQuery(name = "ProfessorFuncionario.findByFotoProfessorFuncionario", query = "SELECT p FROM ProfessorFuncionario p WHERE p.fotoProfessorFuncionario = :fotoProfessorFuncionario")})
public class ProfessorFuncionario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idprofessor_funcionario")
    private Integer idprofessorFuncionario;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "rua")
    private String rua;
    @Basic(optional = false)
    @Column(name = "numero")
    private String numero;
   
    @Column(name = "complemento")
    private String complemento;
    @Basic(optional = false)
    @Column(name = "cep")
    private String cep;
    @Basic(optional = false)
    @Column(name = "bairro")
    private String bairro;
    @Basic(optional = false)
    @Column(name = "cidade")
    private String cidade;
    @Basic(optional = false)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @Column(name = "naturalidade_estado")
    private String naturalidadeEstado;
    @Basic(optional = false)
    @Column(name = "naturalidade_pais")
    private String naturalidadePais;
    
    @Basic(optional = false)
    @Column(name = "data_entrada_prefeitura")
    @Temporal(TemporalType.DATE)
    private Date dataEntradaPrefeitura;
    @Basic(optional = false)
    @Column(name = "ativo")
    private String ativo;
    @Column(name = "data_entrada_escola")
    @Temporal(TemporalType.DATE)
    private Date dataEntradaEscola;
    @Lob
    @Column(name = "observacao")
    private String observacao;
    @Column(name = "foto_professor_funcionario")
    private String fotoProfessorFuncionario;
    
    //@JoinColumn(name = "perfil", referencedColumnName = "idperfil")
    //@ManyToOne(optional = false)
    //private Perfil perfil;
    @OneToMany(mappedBy = "professor")
    private Collection<RelatorioAluno> relatorioAlunoCollection;
    @OneToMany(mappedBy = "tutor")
    private Collection<Tutoria> tutoriaCollection;
    @OneToMany(mappedBy = "professorFuncionario")
    private Collection<ProfessorFuncionarioVariavel> professorFuncionarioVariavelCollection;
    @OneToMany(mappedBy = "professor")
    private Collection<Usuario> usuarioCollection;

    public ProfessorFuncionario() {
    }

    public ProfessorFuncionario(Integer idprofessorFuncionario) {
        this.idprofessorFuncionario = idprofessorFuncionario;
    }

    public ProfessorFuncionario(Integer idprofessorFuncionario, String nome, String rua, String numero, String complemento, String cep, String bairro, String cidade, String estado, String naturalidadeEstado, String naturalidadePais, String qpe, Date dataEntradaPrefeitura, String ativo) {
        this.idprofessorFuncionario = idprofessorFuncionario;
        this.nome = nome;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.naturalidadeEstado = naturalidadeEstado;
        this.naturalidadePais = naturalidadePais;
        //this.qpe = qpe;
        this.dataEntradaPrefeitura = dataEntradaPrefeitura;
        this.ativo = ativo;
    }

    public Integer getIdprofessorFuncionario() {
        return idprofessorFuncionario;
    }

    public void setIdprofessorFuncionario(Integer idprofessorFuncionario) {
        this.idprofessorFuncionario = idprofessorFuncionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNaturalidadeEstado() {
        return naturalidadeEstado;
    }

    public void setNaturalidadeEstado(String naturalidadeEstado) {
        this.naturalidadeEstado = naturalidadeEstado;
    }

    public String getNaturalidadePais() {
        return naturalidadePais;
    }

    public void setNaturalidadePais(String naturalidadePais) {
        this.naturalidadePais = naturalidadePais;
    }

  /*  public String getQpe() {
        return qpe;
    }

    public void setQpe(String qpe) {
        this.qpe = qpe;
    }
    */

    public Date getDataEntradaPrefeitura() {
        return dataEntradaPrefeitura;
    }

    public void setDataEntradaPrefeitura(Date dataEntradaPrefeitura) {
        this.dataEntradaPrefeitura = dataEntradaPrefeitura;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    public Date getDataEntradaEscola() {
        return dataEntradaEscola;
    }

    public void setDataEntradaEscola(Date dataEntradaEscola) {
        this.dataEntradaEscola = dataEntradaEscola;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getFotoProfessorFuncionario() {
        return fotoProfessorFuncionario;
    }

    public void setFotoProfessorFuncionario(String fotoProfessorFuncionario) {
        this.fotoProfessorFuncionario = fotoProfessorFuncionario;
    }

    /*
    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
    */

    @XmlTransient
    public Collection<RelatorioAluno> getRelatorioAlunoCollection() {
        return relatorioAlunoCollection;
    }

    public void setRelatorioAlunoCollection(Collection<RelatorioAluno> relatorioAlunoCollection) {
        this.relatorioAlunoCollection = relatorioAlunoCollection;
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
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idprofessorFuncionario != null ? idprofessorFuncionario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProfessorFuncionario)) {
            return false;
        }
        ProfessorFuncionario other = (ProfessorFuncionario) object;
        if ((this.idprofessorFuncionario == null && other.idprofessorFuncionario != null) || (this.idprofessorFuncionario != null && !this.idprofessorFuncionario.equals(other.idprofessorFuncionario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.muranodesign.model.ProfessorFuncionario[ idprofessorFuncionario=" + idprofessorFuncionario + " ]";
    }
    
}
