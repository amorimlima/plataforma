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
import javax.persistence.Lob;
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
@Table(name = "producao_aluno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProducaoAluno.findAll", query = "SELECT p FROM ProducaoAluno p"),
    @NamedQuery(name = "ProducaoAluno.findByIdproducaoAluno", query = "SELECT p FROM ProducaoAluno p WHERE p.idproducaoAluno = :idproducaoAluno"),
    @NamedQuery(name = "ProducaoAluno.findByImagem", query = "SELECT p FROM ProducaoAluno p WHERE p.imagem = :imagem"),
    @NamedQuery(name = "ProducaoAluno.findByData", query = "SELECT p FROM ProducaoAluno p WHERE p.data = :data"),
    @NamedQuery(name = "ProducaoAluno.findByArquivo", query = "SELECT p FROM ProducaoAluno p WHERE p.arquivo = :arquivo")})
public class ProducaoAluno implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idproducao_aluno")
    private Integer idproducaoAluno;
    @Basic(optional = false)
    @Lob
    @Column(name = "texto")
    private String texto;
    
    @Column(name = "imagem")
    private String imagem;
    @Basic(optional = false)
    @Column(name = "data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @Column(name = "arquivo")
    private String arquivo;
    @JoinColumn(name = "ano_letivo", referencedColumnName = "idano_letivo")
    @ManyToOne(optional = false)
    private AnoLetivo anoLetivo;
    @JoinColumn(name = "categoria", referencedColumnName = "idcategoria_producao_aluno")
    @ManyToOne(optional = false)
    private CategoriaProducaoAluno categoria;
    @JoinColumn(name = "aluno", referencedColumnName = "ID_ALUNO")
    @ManyToOne(optional = false)
    private Aluno aluno;
    @JoinColumn(name = "roteiro", referencedColumnName = "idroteiro")
    @ManyToOne
    private Roteiro roteiro;
    @JoinColumn(name = "tipo", referencedColumnName = "idtipo_producao_aluno")
    @ManyToOne(optional = false)
    private TipoProducaoAluno tipo;

    public ProducaoAluno() {
    }

    public ProducaoAluno(Integer idproducaoAluno) {
        this.idproducaoAluno = idproducaoAluno;
    }

    public ProducaoAluno(Integer idproducaoAluno, String texto, String imagem, Date data) {
        this.idproducaoAluno = idproducaoAluno;
        this.texto = texto;
        this.imagem = imagem;
        this.data = data;
    }

    public Integer getIdproducaoAluno() {
        return idproducaoAluno;
    }

    public void setIdproducaoAluno(Integer idproducaoAluno) {
        this.idproducaoAluno = idproducaoAluno;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getArquivo() {
        return arquivo;
    }

    public void setArquivo(String arquivo) {
        this.arquivo = arquivo;
    }

    public AnoLetivo getAnoLetivo() {
        return anoLetivo;
    }

    public void setAnoLetivo(AnoLetivo anoLetivo) {
        this.anoLetivo = anoLetivo;
    }

    public CategoriaProducaoAluno getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaProducaoAluno categoria) {
        this.categoria = categoria;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Roteiro getRoteiro() {
        return roteiro;
    }

    public void setRoteiro(Roteiro roteiro) {
        this.roteiro = roteiro;
    }

    public TipoProducaoAluno getTipo() {
        return tipo;
    }

    public void setTipo(TipoProducaoAluno tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idproducaoAluno != null ? idproducaoAluno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProducaoAluno)) {
            return false;
        }
        ProducaoAluno other = (ProducaoAluno) object;
        if ((this.idproducaoAluno == null && other.idproducaoAluno != null) || (this.idproducaoAluno != null && !this.idproducaoAluno.equals(other.idproducaoAluno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.muranodesign.model.ProducaoAluno[ idproducaoAluno=" + idproducaoAluno + " ]";
    }
    
}
