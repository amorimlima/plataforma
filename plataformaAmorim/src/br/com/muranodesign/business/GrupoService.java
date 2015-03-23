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
import br.com.muranodesign.dao.GrupoDAO;
import br.com.muranodesign.hibernate.impl.PersistenceContext;
import br.com.muranodesign.model.Grupo;



// TODO: Auto-generated Javadoc
/**
 * The Class GrupoService.
 */
public class GrupoService {
	
	/**
	 * Listar todos.
	 *
	 * @return the list
	 */
	public List<Grupo> listarTodos() {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		GrupoDAO dao = DAOFactory.getGrupoDAO(pc);
		List<Grupo> result = dao.listAll();
				
		pc.commitAndClose();
		return result;
	}
	
	/**
	 * Listarkey.
	 *
	 * @param key the key
	 * @return the list
	 */
	public List<Grupo> listarkey(int key) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		GrupoDAO dao = DAOFactory.getGrupoDAO(pc);
		List<Grupo> result = dao.listarKey(key);
		pc.commitAndClose();
		return result;
	}
	
	
	/**
	 * Criar grupo.
	 *
	 * @param p the p
	 * @return the grupo
	 */
	public Grupo criarGrupo(Grupo p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		GrupoDAO dao = DAOFactory.getGrupoDAO(pc);
		dao.criar(p);
		pc.commitAndClose();
		return p;
	}
	
	
	/**
	 * Deletar grupo.
	 *
	 * @param p the p
	 * @return the grupo
	 */
	public Grupo deletarGrupo(Grupo p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		GrupoDAO dao = DAOFactory.getGrupoDAO(pc);
		dao.deletar(p);
		pc.commitAndClose();
		return p;
	}
	
	
	/**
	 * Atualizar grupo.
	 *
	 * @param p the p
	 * @return the grupo
	 */
	public Grupo atualizarGrupo(Grupo p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		GrupoDAO dao = DAOFactory.getGrupoDAO(pc);
		dao.atualizar(p);
		pc.commitAndClose();
		return p;
	}

	
}
