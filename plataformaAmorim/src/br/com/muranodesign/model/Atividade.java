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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rogerio
 */
@Entity
@Table(name = "atividade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Atividade.findAll", query = "SELECT a FROM Atividade a"),
    @NamedQuery(name = "Atividade.findByIdatividade", query = "SELECT a FROM Atividade a WHERE a.idatividade = :idatividade"),
    @NamedQuery(name = "Atividade.findByNome", query = "SELECT a FROM Atividade a WHERE a.nome = :nome"),
    @NamedQuery(name = "Atividade.findByNumero", query = "SELECT a FROM Atividade a WHERE a.numero = :numero"),
    @NamedQuery(name = "Atividade.findByPaginaLivro", query = "SELECT a FROM Atividade a WHERE a.paginaLivro = :paginaLivro"),
    @NamedQuery(name = "Atividade.findByLivro", query = "SELECT a FROM Atividade a WHERE a.livro = :livro")})
public class Atividade implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idatividade")
    private Integer idatividade;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Lob
    @Column(name = "descricao")
    private String descricao;
    @Basic(optional = false)
    @Column(name = "numero")
    private int numero;
    @Basic(optional = false)
    @Column(name = "pagina_livro")
    private String paginaLivro;
    @Column(name = "livro")
    private String livro;
    @JoinColumn(name = "objetivo", referencedColumnName = "idobjetivo")
    @ManyToOne
    private Objetivo objetivo;
    
    @Column(name = "ativo")
    private int ativo;

    public Atividade() {
    }

    public Atividade(Integer idatividade) {
        this.idatividade = idatividade;
    }

    public Atividade(Integer idatividade, String nome, String descricao, int numero, String paginaLivro) {
        this.idatividade = idatividade;
        this.nome = nome;
        this.descricao = descricao;
        this.numero = numero;
        this.paginaLivro = paginaLivro;
    }

    public Integer getIdatividade() {
        return idatividade;
    }

    public void setIdatividade(Integer idatividade) {
        this.idatividade = idatividade;
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

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getPaginaLivro() {
        return paginaLivro;
    }

    public void setPaginaLivro(String paginaLivro) {
        this.paginaLivro = paginaLivro;
    }

    public String getLivro() {
        return livro;
    }

    public void setLivro(String livro) {
        this.livro = livro;
    }

    public Objetivo getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(Objetivo objetivo) {
        this.objetivo = objetivo;
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
        hash += (idatividade != null ? idatividade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Atividade)) {
            return false;
        }
        Atividade other = (Atividade) object;
        if ((this.idatividade == null && other.idatividade != null) || (this.idatividade != null && !this.idatividade.equals(other.idatividade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.muranodesign.model.Atividade[ idatividade=" + idatividade + " ]";
    }
    
}
