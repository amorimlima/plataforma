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
@Table(name = "mensagens")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mensagens.findAll", query = "SELECT m FROM Mensagens m"),
    @NamedQuery(name = "Mensagens.findByIdmensagens", query = "SELECT m FROM Mensagens m WHERE m.idmensagens = :idmensagens"),
    @NamedQuery(name = "Mensagens.findByAssunto", query = "SELECT m FROM Mensagens m WHERE m.assunto = :assunto"),
    @NamedQuery(name = "Mensagens.findByMensagem", query = "SELECT m FROM Mensagens m WHERE m.mensagem = :mensagem"),
    @NamedQuery(name = "Mensagens.findByLida", query = "SELECT m FROM Mensagens m WHERE m.lida = :lida"),
    @NamedQuery(name = "Mensagens.findByCxEntrada", query = "SELECT m FROM Mensagens m WHERE m.cxEntrada = :cxEntrada"),
    @NamedQuery(name = "Mensagens.findByCxEnviada", query = "SELECT m FROM Mensagens m WHERE m.cxEnviada = :cxEnviada"),
    @NamedQuery(name = "Mensagens.findByTipoMensagem", query = "SELECT m FROM Mensagens m WHERE m.tipoMensagem = :tipoMensagem"),
    @NamedQuery(name = "Mensagens.findByData", query = "SELECT m FROM Mensagens m WHERE m.data = :data"),
    @NamedQuery(name = "Mensagens.findByProprietario", query = "SELECT m FROM Mensagens m WHERE m.proprietario = :proprietario")})
public class Mensagens implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmensagens")
    private Integer idmensagens;
    @Column(name = "assunto")
    private String assunto;
    @Column(name = "mensagem")
    private String mensagem;
    @Column(name = "lida")
    private String lida;
    @Column(name = "cx_entrada")
    private String cxEntrada;
    @Column(name = "cx_enviada")
    private String cxEnviada;
    @Column(name = "tipo_mensagem")
    private String tipoMensagem;
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
  
    @Column(name = "destinatarios")
    private String destinatarios;
   
    
    @Column(name = "anexo")
    private String anexo;
    
    @JoinColumn(name = "proprietario", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario proprietario;
    
    
    @JoinColumn(name = "remetente", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario remetente;
 

    public Mensagens() {
    }

    public Mensagens(Integer idmensagens) {
        this.idmensagens = idmensagens;
    }

    public Integer getIdmensagens() {
        return idmensagens;
    }

    public void setIdmensagens(Integer idmensagens) {
        this.idmensagens = idmensagens;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getLida() {
        return lida;
    }

    public void setLida(String lida) {
        this.lida = lida;
    }

    public String getCxEntrada() {
        return cxEntrada;
    }

    public void setCxEntrada(String cxEntrada) {
        this.cxEntrada = cxEntrada;
    }

    public String getCxEnviada() {
        return cxEnviada;
    }

    public void setCxEnviada(String cxEnviada) {
        this.cxEnviada = cxEnviada;
    }

    public String getTipoMensagem() {
        return tipoMensagem;
    }

    public void setTipoMensagem(String tipoMensagem) {
        this.tipoMensagem = tipoMensagem;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }



    public Usuario getRemetente() {
        return remetente;
    }

    public void setRemetente(Usuario remetente) {
        this.remetente = remetente;
    }

  
    
    
    
    
    public Usuario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Usuario proprietario) {
		this.proprietario = proprietario;
	}

	public String getAnexo() {
		return anexo;
	}

	public void setAnexo(String anexo) {
		this.anexo = anexo;
	}
	
	

	public String getDestinatarios() {
		return destinatarios;
	}

	public void setDestinatarios(String destinatarios) {
		this.destinatarios = destinatarios;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idmensagens != null ? idmensagens.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mensagens)) {
            return false;
        }
        Mensagens other = (Mensagens) object;
        if ((this.idmensagens == null && other.idmensagens != null) || (this.idmensagens != null && !this.idmensagens.equals(other.idmensagens))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.muranodesign.model.Mensagens[ idmensagens=" + idmensagens + " ]";
    }
    
}
