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
import javax.persistence.CascadeType;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author rogerio
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByIdusuario", query = "SELECT u FROM Usuario u WHERE u.idusuario = :idusuario"),
    @NamedQuery(name = "Usuario.findByLogin", query = "SELECT u FROM Usuario u WHERE u.login = :login"),
    @NamedQuery(name = "Usuario.findBySenha", query = "SELECT u FROM Usuario u WHERE u.senha = :senha"),
    @NamedQuery(name = "Usuario.findByEmail", query = "SELECT u FROM Usuario u WHERE u.email = :email"),
    @NamedQuery(name = "Usuario.findByModerador", query = "SELECT u FROM Usuario u WHERE u.moderador = :moderador")})
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idusuario")
    private Integer idusuario;
    @Basic(optional = false)
    @Column(name = "login")
    private String login;
    @Basic(optional = false)
    @Column(name = "senha")
    private String senha;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Column(name = "moderador")
    private String moderador;
    @OneToMany(mappedBy = "usuario")
    private Collection<ForumResposta> forumRespostaCollection;
    @OneToMany(mappedBy = "usuario")
    private Collection<ForumQuestao> forumQuestaoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "remetente")
    
    private Collection<Mensagens> mensagensCollection1;
    @JoinColumn(name = "aluno", referencedColumnName = "ID_ALUNO")
    @ManyToOne
    private Aluno aluno;
   
    @JoinColumn(name = "perfil", referencedColumnName = "idperfil")
    @ManyToOne
    private Perfil perfil;
    
    @JoinColumn(name = "professor", referencedColumnName = "idprofessor_funcionario")
    @ManyToOne
    private ProfessorFuncionario professor;
    
    @JoinColumn(name = "perfil3", referencedColumnName = "idperfil")
    @ManyToOne
    private Perfil perfil3;
   
    
    
    @JoinColumn(name = "perfil2", referencedColumnName = "idperfil")
    @ManyToOne
    private Perfil perfil2;
   

    public Usuario() {
    }

    public Usuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public Usuario(Integer idusuario, String login, String senha, String email) {
        this.idusuario = idusuario;
        this.login = login;
        this.senha = senha;
        this.email = email;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getModerador() {
        return moderador;
    }

    public void setModerador(String moderador) {
        this.moderador = moderador;
    }

    @XmlTransient
    public Collection<ForumResposta> getForumRespostaCollection() {
        return forumRespostaCollection;
    }

    public void setForumRespostaCollection(Collection<ForumResposta> forumRespostaCollection) {
        this.forumRespostaCollection = forumRespostaCollection;
    }

    @XmlTransient
    public Collection<ForumQuestao> getForumQuestaoCollection() {
        return forumQuestaoCollection;
    }

    public void setForumQuestaoCollection(Collection<ForumQuestao> forumQuestaoCollection) {
        this.forumQuestaoCollection = forumQuestaoCollection;
    }

    

    @XmlTransient
    public Collection<Mensagens> getMensagensCollection1() {
        return mensagensCollection1;
    }

    public void setMensagensCollection1(Collection<Mensagens> mensagensCollection1) {
        this.mensagensCollection1 = mensagensCollection1;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public ProfessorFuncionario getProfessor() {
        return professor;
    }

    public void setProfessor(ProfessorFuncionario professor) {
        this.professor = professor;
    }

    
    
    public Perfil getPerfil3() {
		return perfil3;
	}

	public void setPerfil3(Perfil perfil3) {
		this.perfil3 = perfil3;
	}

	public Perfil getPerfil2() {
		return perfil2;
	}

	public void setPerfil2(Perfil perfil2) {
		this.perfil2 = perfil2;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idusuario != null ? idusuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idusuario == null && other.idusuario != null) || (this.idusuario != null && !this.idusuario.equals(other.idusuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.muranodesign.model.Usuario[ idusuario=" + idusuario + " ]";
    }
    
}
