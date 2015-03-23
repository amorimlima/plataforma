/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
@Table(name = "calendario_eventos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CalendarioEventos.findAll", query = "SELECT c FROM CalendarioEventos c"),
    @NamedQuery(name = "CalendarioEventos.findByIdeventos", query = "SELECT c FROM CalendarioEventos c WHERE c.ideventos = :ideventos"),
    @NamedQuery(name = "CalendarioEventos.findByDataInicio", query = "SELECT c FROM CalendarioEventos c WHERE c.dataInicio = :dataInicio"),
    @NamedQuery(name = "CalendarioEventos.findByDataFim", query = "SELECT c FROM CalendarioEventos c WHERE c.dataFim = :dataFim"),
    @NamedQuery(name = "CalendarioEventos.findByEvento", query = "SELECT c FROM CalendarioEventos c WHERE c.evento = :evento"),
    @NamedQuery(name = "CalendarioEventos.findByImagem", query = "SELECT c FROM CalendarioEventos c WHERE c.imagem = :imagem"),
    @NamedQuery(name = "CalendarioEventos.findByFeriado", query = "SELECT c FROM CalendarioEventos c WHERE c.feriado = :feriado"),
    @NamedQuery(name = "CalendarioEventos.findByAula", query = "SELECT c FROM CalendarioEventos c WHERE c.aula = :aula")})
public class CalendarioEventos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ideventos")
    private Integer ideventos;
    @Column(name = "data_inicio")
    @Temporal(TemporalType.DATE)
    private Date dataInicio;
    @Column(name = "data_fim")
    @Temporal(TemporalType.DATE)
    private Date dataFim;
    @Column(name = "evento")
    private String evento;
    @Lob
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "imagem")
    private String imagem;
    @Basic(optional = false)
    @Column(name = "feriado")
    private String feriado;
    @Basic(optional = false)
    @Column(name = "aula")
    private String aula;
    @JoinColumn(name = "calendario", referencedColumnName = "idcalendario")
    @ManyToOne
    private Calendario calendario;
    @JoinColumn(name = "ano", referencedColumnName = "idano_letivo")
    @ManyToOne
    private AnoLetivo ano;
    @JoinColumn(name = "tipo_evento", referencedColumnName = "idtipo_evento")
    @ManyToOne
    private TipoEvento tipoEvento;

    public CalendarioEventos() {
    }

    public CalendarioEventos(Integer ideventos) {
        this.ideventos = ideventos;
    }

    public CalendarioEventos(Integer ideventos, String feriado, String aula) {
        this.ideventos = ideventos;
        this.feriado = feriado;
        this.aula = aula;
    }

    public Integer getIdeventos() {
        return ideventos;
    }

    public void setIdeventos(Integer ideventos) {
        this.ideventos = ideventos;
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

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getFeriado() {
        return feriado;
    }

    public void setFeriado(String feriado) {
        this.feriado = feriado;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public Calendario getCalendario() {
        return calendario;
    }

    public void setCalendario(Calendario calendario) {
        this.calendario = calendario;
    }

    public AnoLetivo getAno() {
        return ano;
    }

    public void setAno(AnoLetivo ano) {
        this.ano = ano;
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
        hash += (ideventos != null ? ideventos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CalendarioEventos)) {
            return false;
        }
        CalendarioEventos other = (CalendarioEventos) object;
        if ((this.ideventos == null && other.ideventos != null) || (this.ideventos != null && !this.ideventos.equals(other.ideventos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.muranodesign.model.CalendarioEventos[ ideventos=" + ideventos + " ]";
    }
    
}
