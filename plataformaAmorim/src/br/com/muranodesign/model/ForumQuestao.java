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
@Table(name = "forum_questao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ForumQuestao.findAll", query = "SELECT f FROM ForumQuestao f"),
    @NamedQuery(name = "ForumQuestao.findByIdforumQuestao", query = "SELECT f FROM ForumQuestao f WHERE f.idforumQuestao = :idforumQuestao"),
    @NamedQuery(name = "ForumQuestao.findByQuestao", query = "SELECT f FROM ForumQuestao f WHERE f.questao = :questao"),
    @NamedQuery(name = "ForumQuestao.findByAnexo", query = "SELECT f FROM ForumQuestao f WHERE f.anexo = :anexo"),
    @NamedQuery(name = "ForumQuestao.findByData", query = "SELECT f FROM ForumQuestao f WHERE f.data = :data")})
public class ForumQuestao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idforum_questao")
    private Integer idforumQuestao;
    @Column(name = "questao")
    private String questao;
    @Column(name = "anexo")
    private String anexo;
    @Column(name = "data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @OneToMany(mappedBy = "forumQuestao")
    private Collection<ForumResposta> forumRespostaCollection;
    @JoinColumn(name = "roteiro", referencedColumnName = "idroteiro")
    @ManyToOne
    private Roteiro roteiro;
    @JoinColumn(name = "usuario", referencedColumnName = "idusuario")
    @ManyToOne
    private Usuario usuario;

    public ForumQuestao() {
    }

    public ForumQuestao(Integer idforumQuestao) {
        this.idforumQuestao = idforumQuestao;
    }

    public Integer getIdforumQuestao() {
        return idforumQuestao;
    }

    public void setIdforumQuestao(Integer idforumQuestao) {
        this.idforumQuestao = idforumQuestao;
    }

    public String getQuestao() {
        return questao;
    }

    public void setQuestao(String questao) {
        this.questao = questao;
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

    @XmlTransient
    public Collection<ForumResposta> getForumRespostaCollection() {
        return forumRespostaCollection;
    }

    public void setForumRespostaCollection(Collection<ForumResposta> forumRespostaCollection) {
        this.forumRespostaCollection = forumRespostaCollection;
    }

    public Roteiro getRoteiro() {
        return roteiro;
    }

    public void setRoteiro(Roteiro roteiro) {
        this.roteiro = roteiro;
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
        hash += (idforumQuestao != null ? idforumQuestao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ForumQuestao)) {
            return false;
        }
        ForumQuestao other = (ForumQuestao) object;
        if ((this.idforumQuestao == null && other.idforumQuestao != null) || (this.idforumQuestao != null && !this.idforumQuestao.equals(other.idforumQuestao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.muranodesign.model.ForumQuestao[ idforumQuestao=" + idforumQuestao + " ]";
    }
    
}
