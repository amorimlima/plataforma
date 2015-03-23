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
@Table(name = "planejamento_roteiro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlanejamentoRoteiro.findAll", query = "SELECT p FROM PlanejamentoRoteiro p"),
    @NamedQuery(name = "PlanejamentoRoteiro.findByIdplanejamentoRoteiro", query = "SELECT p FROM PlanejamentoRoteiro p WHERE p.idplanejamentoRoteiro = :idplanejamentoRoteiro"),
    @NamedQuery(name = "PlanejamentoRoteiro.findByStatus", query = "SELECT p FROM PlanejamentoRoteiro p WHERE p.status = :status"),
    @NamedQuery(name = "PlanejamentoRoteiro.findByDataStatusPlanejado", query = "SELECT p FROM PlanejamentoRoteiro p WHERE p.dataStatusPlanejado = :dataStatusPlanejado"),
    @NamedQuery(name = "PlanejamentoRoteiro.findByDataStatusEntregue", query = "SELECT p FROM PlanejamentoRoteiro p WHERE p.dataStatusEntregue = :dataStatusEntregue"),
    @NamedQuery(name = "PlanejamentoRoteiro.findByDataStatusVisto", query = "SELECT p FROM PlanejamentoRoteiro p WHERE p.dataStatusVisto = :dataStatusVisto")})
public class PlanejamentoRoteiro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idplanejamento_roteiro")
    private Integer idplanejamentoRoteiro;
    @Column(name = "status")
    private String status;
    @Column(name = "data_status_planejado")
    @Temporal(TemporalType.DATE)
    private Date dataStatusPlanejado;
    
    @Column(name = "id_aluno")
    private Integer idAluno;
    
    
    
    
    @Column(name = "data_status_entregue")
    @Temporal(TemporalType.DATE)
    private Date dataStatusEntregue;
    @Column(name = "data_status_visto")
    @Temporal(TemporalType.DATE)
    private Date dataStatusVisto;
    @JoinColumn(name = "objetivo", referencedColumnName = "idobjetivo")
    @ManyToOne
    private Objetivo objetivo;
    @JoinColumn(name = "plano_estudo", referencedColumnName = "idplano_estudo")
    @ManyToOne
    private PlanoEstudo planoEstudo;

    public PlanejamentoRoteiro() {
    }

    public PlanejamentoRoteiro(Integer idplanejamentoRoteiro) {
        this.idplanejamentoRoteiro = idplanejamentoRoteiro;
    }

    public Integer getIdplanejamentoRoteiro() {
        return idplanejamentoRoteiro;
    }

    public void setIdplanejamentoRoteiro(Integer idplanejamentoRoteiro) {
        this.idplanejamentoRoteiro = idplanejamentoRoteiro;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDataStatusPlanejado() {
        return dataStatusPlanejado;
    }

    public void setDataStatusPlanejado(Date dataStatusPlanejado) {
        this.dataStatusPlanejado = dataStatusPlanejado;
    }

    public Date getDataStatusEntregue() {
        return dataStatusEntregue;
    }

    public void setDataStatusEntregue(Date dataStatusEntregue) {
        this.dataStatusEntregue = dataStatusEntregue;
    }

    public Date getDataStatusVisto() {
        return dataStatusVisto;
    }

    public void setDataStatusVisto(Date dataStatusVisto) {
        this.dataStatusVisto = dataStatusVisto;
    }

    public Objetivo getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(Objetivo objetivo) {
        this.objetivo = objetivo;
    }

    public PlanoEstudo getPlanoEstudo() {
        return planoEstudo;
    }

    public void setPlanoEstudo(PlanoEstudo planoEstudo) {
        this.planoEstudo = planoEstudo;
    }
    
    

    public Integer getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(Integer idAluno) {
		this.idAluno = idAluno;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idplanejamentoRoteiro != null ? idplanejamentoRoteiro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlanejamentoRoteiro)) {
            return false;
        }
        PlanejamentoRoteiro other = (PlanejamentoRoteiro) object;
        if ((this.idplanejamentoRoteiro == null && other.idplanejamentoRoteiro != null) || (this.idplanejamentoRoteiro != null && !this.idplanejamentoRoteiro.equals(other.idplanejamentoRoteiro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.muranodesign.model.PlanejamentoRoteiro[ idplanejamentoRoteiro=" + idplanejamentoRoteiro + " ]";
    }
    
}
