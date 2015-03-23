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
@Table(name = "forum_resposta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ForumResposta.findAll", query = "SELECT f FROM ForumResposta f"),
    @NamedQuery(name = "ForumResposta.findByIdforumResposta", query = "SELECT f FROM ForumResposta f WHERE f.idforumResposta = :idforumResposta"),
    @NamedQuery(name = "ForumResposta.findByResposta", query = "SELECT f FROM ForumResposta f WHERE f.resposta = :resposta"),
    @NamedQuery(name = "ForumResposta.findByAnexo", query = "SELECT f FROM ForumResposta f WHERE f.anexo = :anexo"),
    @NamedQuery(name = "ForumResposta.findByData", query = "SELECT f FROM ForumResposta f WHERE f.data = :data")})
public class ForumResposta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idforum_resposta")
    private Integer idforumResposta;
    @Column(name = "resposta")
    private String resposta;
    @Column(name = "anexo")
    private String anexo;
    @Column(name = "data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @JoinColumn(name = "forum_questao", referencedColumnName = "idforum_questao")
    @ManyToOne
    private ForumQuestao forumQuestao;
    @JoinColumn(name = "usuario", referencedColumnName = "idusuario")
    @ManyToOne
    private Usuario usuario;

    public ForumResposta() {
    }

    public ForumResposta(Integer idforumResposta) {
        this.idforumResposta = idforumResposta;
    }

    public Integer getIdforumResposta() {
        return idforumResposta;
    }

    public void setIdforumResposta(Integer idforumResposta) {
        this.idforumResposta = idforumResposta;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public String getAnexo() {
        return anexo;
    }

    public void setAnexo(String anexo) {
        this.anexo = anexo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public ForumQuestao getForumQuestao() {
        return forumQuestao;
    }

    public void setForumQuestao(ForumQuestao forumQuestao) {
        this.forumQuestao = forumQuestao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idforumResposta != null ? idforumResposta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ForumResposta)) {
            return false;
        }
        ForumResposta other = (ForumResposta) object;
        if ((this.idforumResposta == null && other.idforumResposta != null) || (this.idforumResposta != null && !this.idforumResposta.equals(other.idforumResposta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.muranodesign.model.ForumResposta[ idforumResposta=" + idforumResposta + " ]";
    }
    
}
