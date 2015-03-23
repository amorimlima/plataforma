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
@Table(name = "recurso_aprendizagem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RecursoAprendizagem.findAll", query = "SELECT r FROM RecursoAprendizagem r"),
    @NamedQuery(name = "RecursoAprendizagem.findByIdrecursoAprendizagem", query = "SELECT r FROM RecursoAprendizagem r WHERE r.idrecursoAprendizagem = :idrecursoAprendizagem"),
    @NamedQuery(name = "RecursoAprendizagem.findByNomeRecurso", query = "SELECT r FROM RecursoAprendizagem r WHERE r.nomeRecurso = :nomeRecurso"),
    @NamedQuery(name = "RecursoAprendizagem.findByCurtir", query = "SELECT r FROM RecursoAprendizagem r WHERE r.curtir = :curtir"),
    @NamedQuery(name = "RecursoAprendizagem.findByImagem", query = "SELECT r FROM RecursoAprendizagem r WHERE r.imagem = :imagem"),
    @NamedQuery(name = "RecursoAprendizagem.findByArquivo", query = "SELECT r FROM RecursoAprendizagem r WHERE r.arquivo = :arquivo")})
public class RecursoAprendizagem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idrecurso_aprendizagem")
    private Integer idrecursoAprendizagem;
    @Column(name = "nome_recurso")
    private String nomeRecurso;
    @Lob
    @Column(name = "descricao_recurso")
    private String descricaoRecurso;
    @Column(name = "curtir")
    private Long curtir;
    @Column(name = "imagem")
    private String imagem;
    @Column(name = "arquivo")
    private String arquivo;
    @Column(name = "link")
    private String link;
    @JoinColumn(name = "tipo_recurso_aprendizagem", referencedColumnName = "idtipo_recurso_aprendizagem")
    @ManyToOne
    private TipoRecursoAprendizagem tipoRecursoAprendizagem;
    @JoinColumn(name = "materia", referencedColumnName = "idmateria")
    @ManyToOne
    private Materia materia;
    @JoinColumn(name = "roteiro", referencedColumnName = "idroteiro")
    @ManyToOne
    private Roteiro roteiro;

    public RecursoAprendizagem() {
    }

    public RecursoAprendizagem(Integer idrecursoAprendizagem) {
        this.idrecursoAprendizagem = idrecursoAprendizagem;
    }

    public Integer getIdrecursoAprendizagem() {
        return idrecursoAprendizagem;
    }

    public void setIdrecursoAprendizagem(Integer idrecursoAprendizagem) {
        this.idrecursoAprendizagem = idrecursoAprendizagem;
    }

    public String getNomeRecurso() {
        return nomeRecurso;
    }

    public void setNomeRecurso(String nomeRecurso) {
        this.nomeRecurso = nomeRecurso;
    }

    public String getDescricaoRecurso() {
        return descricaoRecurso;
    }

    public void setDescricaoRecurso(String descricaoRecurso) {
        this.descricaoRecurso = descricaoRecurso;
    }

    public Long getCurtir() {
        return curtir;
    }

    public void setCurtir(Long curtir) {
        this.curtir = curtir;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getArquivo() {
        return arquivo;
    }

    public void setArquivo(String arquivo) {
        this.arquivo = arquivo;
    }

    public TipoRecursoAprendizagem getTipoRecursoAprendizagem() {
        return tipoRecursoAprendizagem;
    }

    public void setTipoRecursoAprendizagem(TipoRecursoAprendizagem tipoRecursoAprendizagem) {
        this.tipoRecursoAprendizagem = tipoRecursoAprendizagem;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Roteiro getRoteiro() {
        return roteiro;
    }

    public void setRoteiro(Roteiro roteiro) {
        this.roteiro = roteiro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrecursoAprendizagem != null ? idrecursoAprendizagem.hashCode() : 0);
        return hash;
    }

    
    
    public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RecursoAprendizagem)) {
            return false;
        }
        RecursoAprendizagem other = (RecursoAprendizagem) object;
        if ((this.idrecursoAprendizagem == null && other.idrecursoAprendizagem != null) || (this.idrecursoAprendizagem != null && !this.idrecursoAprendizagem.equals(other.idrecursoAprendizagem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.muranodesign.model.RecursoAprendizagem[ idrecursoAprendizagem=" + idrecursoAprendizagem + " ]";
    }
    
}
