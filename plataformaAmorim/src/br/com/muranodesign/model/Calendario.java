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
@Table(name = "calendario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Calendario.findAll", query = "SELECT c FROM Calendario c"),
    @NamedQuery(name = "Calendario.findByIdcalendario", query = "SELECT c FROM Calendario c WHERE c.idcalendario = :idcalendario"),
    @NamedQuery(name = "Calendario.findByAno", query = "SELECT c FROM Calendario c WHERE c.ano = :ano"),
    @NamedQuery(name = "Calendario.findByDataInicio", query = "SELECT c FROM Calendario c WHERE c.dataInicio = :dataInicio"),
    @NamedQuery(name = "Calendario.findByDataFim", query = "SELECT c FROM Calendario c WHERE c.dataFim = :dataFim"),
    @NamedQuery(name = "Calendario.findByEvento", query = "SELECT c FROM Calendario c WHERE c.evento = :evento"),
    @NamedQuery(name = "Calendario.findByFeriado", query = "SELECT c FROM Calendario c WHERE c.feriado = :feriado"),
    @NamedQuery(name = "Calendario.findByAula", query = "SELECT c FROM Calendario c WHERE c.aula = :aula"),
    @NamedQuery(name = "Calendario.findByImagem", query = "SELECT c FROM Calendario c WHERE c.imagem = :imagem")})
public class Calendario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcalendario")
    private Integer idcalendario;
    @Column(name = "ano")
    private Integer ano;
    @Column(name = "data_inicio")
    @Temporal(TemporalType.DATE)
    private Date dataInicio;
    @Column(name = "data_fim")
    @Temporal(TemporalType.DATE)
    private Date dataFim;
    @Lob
    @Column(name = "descricao")
    private String descricao;
    @Basic(optional = false)
    @Column(name = "evento")
    private String evento;
    @Basic(optional = false)
    @Column(name = "feriado")
    private int feriado;
    @Basic(optional = false)
    @Column(name = "aula")
    private int aula;
    @Column(name = "imagem")
    private String imagem;
    @JoinColumn(name = "tipo_evento", referencedColumnName = "idtipo_evento")
    @ManyToOne
    private TipoEvento tipoEvento;

    public Calendario() {
    }

    public Calendario(Integer idcalendario) {
        this.idcalendario = idcalendario;
    }

    public Calendario(Integer idcalendario, String evento, int feriado, int aula) {
        this.idcalendario = idcalendario;
        this.evento = evento;
        this.feriado = feriado;
        this.aula = aula;
    }

    public Integer getIdcalendario() {
        return idcalendario;
    }

    public void setIdcalendario(Integer idcalendario) {
        this.idcalendario = idcalendario;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public int getFeriado() {
        return feriado;
    }

    public void setFeriado(int feriado) {
        this.feriado = feriado;
    }

    public int getAula() {
        return aula;
    }

    public void setAula(int aula) {
        this.aula = aula;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcalendario != null ? idcalendario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Calendario)) {
            return false;
        }
        Calendario other = (Calendario) object;
        if ((this.idcalendario == null && other.idcalendario != null) || (this.idcalendario != null && !this.idcalendario.equals(other.idcalendario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.muranodesign.model.Calendario[ idcalendario=" + idcalendario + " ]";
    }
    
}
