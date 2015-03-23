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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author rogerio
 */
@Entity
@Table(name = "acoes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Acoes.findAll", query = "SELECT a FROM Acoes a"),
    @NamedQuery(name = "Acoes.findByIdacoes", query = "SELECT a FROM Acoes a WHERE a.idacoes = :idacoes"),
    @NamedQuery(name = "Acoes.findByServico", query = "SELECT a FROM Acoes a WHERE a.servico = :servico"),
    @NamedQuery(name = "Acoes.findByDeletar", query = "SELECT a FROM Acoes a WHERE a.deletar = :deletar"),
    @NamedQuery(name = "Acoes.findByAtualizar", query = "SELECT a FROM Acoes a WHERE a.atualizar = :atualizar"),
    @NamedQuery(name = "Acoes.findByCriar", query = "SELECT a FROM Acoes a WHERE a.criar = :criar"),
    @NamedQuery(name = "Acoes.findByListar", query = "SELECT a FROM Acoes a WHERE a.listar = :listar")})
public class Acoes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idacoes")
    private Integer idacoes;
    @Column(name = "servico")
    private String servico;
    @Column(name = "deletar")
    private Integer deletar;
    @Column(name = "atualizar")
    private Integer atualizar;
    @Column(name = "criar")
    private Integer criar;
    @Column(name = "listar")
    private Integer listar;
    @JoinTable(name = "perfil_acoes", joinColumns = {
        @JoinColumn(name = "acoes", referencedColumnName = "idacoes")}, inverseJoinColumns = {
        @JoinColumn(name = "perfil", referencedColumnName = "idperfil")})
    @ManyToMany
    private Collection<Perfil> perfilCollection;

    public Acoes() {
    }

    public Acoes(Integer idacoes) {
        this.idacoes = idacoes;
    }

    public Integer getIdacoes() {
        return idacoes;
    }

    public void setIdacoes(Integer idacoes) {
        this.idacoes = idacoes;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public Integer getDeletar() {
        return deletar;
    }

    public void setDeletar(Integer deletar) {
        this.deletar = deletar;
    }

    public Integer getAtualizar() {
        return atualizar;
    }

    public void setAtualizar(Integer atualizar) {
        this.atualizar = atualizar;
    }

    public Integer getCriar() {
        return criar;
    }

    public void setCriar(Integer criar) {
        this.criar = criar;
    }

    public Integer getListar() {
        return listar;
    }

    public void setListar(Integer listar) {
        this.listar = listar;
    }

    @XmlTransient
    public Collection<Perfil> getPerfilCollection() {
        return perfilCollection;
    }

    public void setPerfilCollection(Collection<Perfil> perfilCollection) {
        this.perfilCollection = perfilCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idacoes != null ? idacoes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Acoes)) {
            return false;
        }
        Acoes other = (Acoes) object;
        if ((this.idacoes == null && other.idacoes != null) || (this.idacoes != null && !this.idacoes.equals(other.idacoes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.muranodesign.model.Acoes[ idacoes=" + idacoes + " ]";
    }
    
}
