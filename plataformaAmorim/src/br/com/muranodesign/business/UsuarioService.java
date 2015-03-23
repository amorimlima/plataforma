/**
 *   Este codigo é software livre você e pode resdistribuir e/ou modificar ele seguindo os termos da
 *   Creative Commons Attribution 4.0 International Pare visualizar uma copia desta 
 *   licensa em ingles visite http://creativecommons.org/licenses/by/4.0/.
 *   
 *   This code is free software; you can redistribute it and/or modify it
 *   under the terms of Creative Commons Attribution 4.0 International License. 
 *   To view a copy of this license, visit http://creativecommons.org/licenses/by/4.0/.
 */
package br.com.muranodesign.business;

import java.util.List;

import br.com.muranodesign.dao.DAOFactory;
import br.com.muranodesign.dao.UsuarioDAO;
import br.com.muranodesign.hibernate.impl.PersistenceContext;
import br.com.muranodesign.model.Usuario;



// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioService.
 */
public class UsuarioService {
	
	/**
	 * Listar todos.
	 *
	 * @return the list
	 */
	public List<Usuario> listarTodos() {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		UsuarioDAO dao = DAOFactory.getUsuarioDAO(pc);
		List<Usuario> result = dao.listAll();
				
		pc.commitAndClose();
		return result;
	}
	
	/**
	 * Listarkey.
	 *
	 * @param key the key
	 * @return the list
	 */
	public List<Usuario> listarkey(int key) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		UsuarioDAO dao = DAOFactory.getUsuarioDAO(pc);
		List<Usuario> result = dao.listarKey(key);
		pc.commitAndClose();
		return result;
	}
	
	
	public List<Usuario> listaAluno(int idAluno) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		UsuarioDAO dao = DAOFactory.getUsuarioDAO(pc);
		List<Usuario> result = dao.listaAluno(idAluno);
		pc.commitAndClose();
		return result;
	}
	

	public List<Usuario> listaAlunoEmail(String email) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		UsuarioDAO dao = DAOFactory.getUsuarioDAO(pc);
		List<Usuario> result = dao.listaUsuarioEmail(email);
		pc.commitAndClose();
		return result;
	}
	
	
	/**
	 * Listar login.
	 *
	 * @param login the login
	 * @return the list
	 */
	public List<Usuario> listarLogin(String login) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		UsuarioDAO dao = DAOFactory.getUsuarioDAO(pc);
		List<Usuario> result = dao.listarUsuario(login);
		pc.commitAndClose();
		return result;
	}
	
	
	/**
	 * Criar usuario.
	 *
	 * @param p the p
	 * @return the usuario
	 */
	public Usuario criarUsuario(Usuario p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		UsuarioDAO dao = DAOFactory.getUsuarioDAO(pc);
		dao.criar(p);
		pc.commitAndClose();
		return p;
	}
	
	
	/**
	 * Deletar usuario.
	 *
	 * @param p the p
	 * @return the usuario
	 */
	public Usuario deletarUsuario(Usuario p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		UsuarioDAO dao = DAOFactory.getUsuarioDAO(pc);
		dao.deletar(p);
		pc.commitAndClose();
		return p;
	}
	
	
	/**
	 * Atualizar usuario.
	 *
	 * @param p the p
	 * @return the usuario
	 */
	public Usuario atualizarUsuario(Usuario p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		UsuarioDAO dao = DAOFactory.getUsuarioDAO(pc);
		dao.atualizar(p);
		pc.commitAndClose();
		return p;
	}

	
}
