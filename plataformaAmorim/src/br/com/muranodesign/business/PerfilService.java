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
import br.com.muranodesign.dao.PerfilDAO;
import br.com.muranodesign.hibernate.impl.PersistenceContext;
import br.com.muranodesign.model.Perfil;



// TODO: Auto-generated Javadoc
/**
 * The Class PerfilService.
 */
public class PerfilService {
	
	/**
	 * Listar todos.
	 *
	 * @return the list
	 */
	public List<Perfil> listarTodos() {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		PerfilDAO dao = DAOFactory.getPerfilDAO(pc);
		List<Perfil> result = dao.listAll();
				
		pc.commitAndClose();
		return result;
	}
	
	/**
	 * Listarkey.
	 *
	 * @param key the key
	 * @return the list
	 */
	public List<Perfil> listarkey(int key) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		PerfilDAO dao = DAOFactory.getPerfilDAO(pc);
		List<Perfil> result = dao.listarKey(key);
		pc.commitAndClose();
		return result;
	}
	
	
	/**
	 * Criar perfil.
	 *
	 * @param p the p
	 * @return the perfil
	 */
	public Perfil criarPerfil(Perfil p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		PerfilDAO dao = DAOFactory.getPerfilDAO(pc);
		dao.criar(p);
		pc.commitAndClose();
		return p;
	}
	
	
	/**
	 * Deletar perfil.
	 *
	 * @param p the p
	 * @return the perfil
	 */
	public Perfil deletarPerfil(Perfil p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		PerfilDAO dao = DAOFactory.getPerfilDAO(pc);
		dao.deletar(p);
		pc.commitAndClose();
		return p;
	}
	
	
	/**
	 * Atualizar perfil.
	 *
	 * @param p the p
	 * @return the perfil
	 */
	public Perfil atualizarPerfil(Perfil p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		PerfilDAO dao = DAOFactory.getPerfilDAO(pc);
		dao.atualizar(p);
		pc.commitAndClose();
		return p;
	}

	
}
