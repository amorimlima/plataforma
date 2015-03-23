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
@Table(name = "objetivo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Objetivo.findAll", query = "SELECT o FROM Objetivo o"),
    @NamedQuery(name = "Objetivo.findByIdobjetivo", query = "SELECT o FROM Objetivo o WHERE o.idobjetivo = :idobjetivo"),
    @NamedQuery(name = "Objetivo.findByNumero", query = "SELECT o FROM Objetivo o WHERE o.numero = :numero")})
public class Objetivo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idobjetivo")
    private Integer idobjetivo;
    @Basic(optional = false)
    @Lob
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Lob
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "numero")
    private Integer numero;
    @Column(name = "ativo")
    private int ativo;

    
    @JoinColumn(name = "roteiro", referencedColumnName = "idroteiro")
    @ManyToOne
    private Roteiro roteiro;
    @OneToMany(mappedBy = "objetivo")
    private Collection<PlanejamentoRoteiro> planejamentoRoteiroCollection;
    @OneToMany(mappedBy = "objetivo")
    private Collection<Atividade> atividadeCollection;

    public Objetivo() {
    }

    public Objetivo(Integer idobjetivo) {
        this.idobjetivo = idobjetivo;
    }

    public Objetivo(Integer idobjetivo, String nome, String descricao) {
        this.idobjetivo = idobjetivo;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Integer getIdobjetivo() {
        return idobjetivo;
    }

    public void setIdobjetivo(Integer idobjetivo) {
        this.idobjetivo = idobjetivo;
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

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Roteiro getRoteiro() {
        return roteiro;
    }

    public void setRoteiro(Roteiro roteiro) {
        this.roteiro = roteiro;
    }
    
    
    public int getAtivo() {
		return ativo;
	}

	public void setAtivo(int ativo) {
		this.ativo = ativo;
	}


    @XmlTransient
    public Collection<PlanejamentoRoteiro> getPlanejamentoRoteiroCollection() {
        return planejamentoRoteiroCollection;
    }

    public void setPlanejamentoRoteiroCollection(Collection<PlanejamentoRoteiro> planejamentoRoteiroCollection) {
        this.planejamentoRoteiroCollection = planejamentoRoteiroCollection;
    }

    @XmlTransient
    public Collection<Atividade> getAtividadeCollection() {
        return atividadeCollection;
    }

    public void setAtividadeCollection(Collection<Atividade> atividadeCollection) {
        this.atividadeCollection = atividadeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idobjetivo != null ? idobjetivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Objetivo)) {
            return false;
        }
        Objetivo other = (Objetivo) object;
        if ((this.idobjetivo == null && other.idobjetivo != null) || (this.idobjetivo != null && !this.idobjetivo.equals(other.idobjetivo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.muranodesign.model.Objetivo[ idobjetivo=" + idobjetivo + " ]";
    }
    
}
