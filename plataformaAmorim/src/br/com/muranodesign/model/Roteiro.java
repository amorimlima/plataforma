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
@Table(name = "roteiro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Roteiro.findAll", query = "SELECT r FROM Roteiro r"),
    @NamedQuery(name = "Roteiro.findByIdroteiro", query = "SELECT r FROM Roteiro r WHERE r.idroteiro = :idroteiro")})
public class Roteiro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idroteiro")
    private Integer idroteiro;
    @Basic(optional = false)
    @Lob
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Lob
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "ativo")
    private int ativo;

    
    
    @OneToMany(mappedBy = "roteiro")
    private Collection<ForumQuestao> forumQuestaoCollection;
    @OneToMany(mappedBy = "roteiro")
    private Collection<Objetivo> objetivoCollection;
    @OneToMany(mappedBy = "roteiro")
    private Collection<ProducaoAluno> producaoAlunoCollection;
    @OneToMany(mappedBy = "roteiro")
    private Collection<RecursoAprendizagem> recursoAprendizagemCollection;
    @JoinColumn(name = "ano_estudo", referencedColumnName = "idano_estudo")
    @ManyToOne(optional = false)
    private AnoEstudo anoEstudo;
    @OneToMany(mappedBy = "roteiro")
    private Collection<AtribuicaoRoteiroExtra> atribuicaoRoteiroExtraCollection;

    public Roteiro() {
    }

    public Roteiro(Integer idroteiro) {
        this.idroteiro = idroteiro;
    }

    public Roteiro(Integer idroteiro, String nome, String descricao) {
        this.idroteiro = idroteiro;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Integer getIdroteiro() {
        return idroteiro;
    }

    public void setIdroteiro(Integer idroteiro) {
        this.idroteiro = idroteiro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public Collection<ForumQuestao> getForumQuestaoCollection() {
        return forumQuestaoCollection;
    }

    public void setForumQuestaoCollection(Collection<ForumQuestao> forumQuestaoCollection) {
        this.forumQuestaoCollection = forumQuestaoCollection;
    }

    
    
    public int getAtivo() {
		return ativo;
	}

	public void setAtivo(int ativo) {
		this.ativo = ativo;
	}

	@XmlTransient
    public Collection<Objetivo> getObjetivoCollection() {
        return objetivoCollection;
    }

    public void setObjetivoCollection(Collection<Objetivo> objetivoCollection) {
        this.objetivoCollection = objetivoCollection;
    }

    @XmlTransient
    public Collection<ProducaoAluno> getProducaoAlunoCollection() {
        return producaoAlunoCollection;
    }

    public void setProducaoAlunoCollection(Collection<ProducaoAluno> producaoAlunoCollection) {
        this.producaoAlunoCollection = producaoAlunoCollection;
    }

    @XmlTransient
    public Collection<RecursoAprendizagem> getRecursoAprendizagemCollection() {
        return recursoAprendizagemCollection;
    }

    public void setRecursoAprendizagemCollection(Collection<RecursoAprendizagem> recursoAprendizagemCollection) {
        this.recursoAprendizagemCollection = recursoAprendizagemCollection;
    }

    public AnoEstudo getAnoEstudo() {
        return anoEstudo;
    }

    public void setAnoEstudo(AnoEstudo anoEstudo) {
        this.anoEstudo = anoEstudo;
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
        hash += (idroteiro != null ? idroteiro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Roteiro)) {
            return false;
        }
        Roteiro other = (Roteiro) object;
        if ((this.idroteiro == null && other.idroteiro != null) || (this.idroteiro != null && !this.idroteiro.equals(other.idroteiro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.muranodesign.model.Roteiro[ idroteiro=" + idroteiro + " ]";
    }
    
}
