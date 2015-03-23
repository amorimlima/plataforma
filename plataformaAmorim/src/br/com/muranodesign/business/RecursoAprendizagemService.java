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
import br.com.muranodesign.dao.RecursoAprendizagemDAO;
import br.com.muranodesign.hibernate.impl.PersistenceContext;
import br.com.muranodesign.model.RecursoAprendizagem;



// TODO: Auto-generated Javadoc
/**
 * The Class RecursoAprendizagemService.
 */
public class RecursoAprendizagemService {
	
	/**
	 * Listar todos.
	 *
	 * @return the list
	 */
	public List<RecursoAprendizagem> listarTodos() {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		RecursoAprendizagemDAO dao = DAOFactory.getRecursoAprendizagemDAO(pc);
		List<RecursoAprendizagem> result = dao.listAll();
				
		pc.commitAndClose();
		return result;
	}
	
	/**
	 * Listarkey.
	 *
	 * @param key the key
	 * @return the list
	 */
	public List<RecursoAprendizagem> listarkey(int key) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		RecursoAprendizagemDAO dao = DAOFactory.getRecursoAprendizagemDAO(pc);
		List<RecursoAprendizagem> result = dao.listarKey(key);
		pc.commitAndClose();
		return result;
	}
	
	
	/**
	 * Criar recurso aprendizagem.
	 *
	 * @param p the p
	 * @return the recurso aprendizagem
	 */
	public RecursoAprendizagem criarRecursoAprendizagem(RecursoAprendizagem p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		RecursoAprendizagemDAO dao = DAOFactory.getRecursoAprendizagemDAO(pc);
		dao.criar(p);
		pc.commitAndClose();
		return p;
	}
	
	
	/**
	 * Deletar recurso aprendizagem.
	 *
	 * @param p the p
	 * @return the recurso aprendizagem
	 */
	public RecursoAprendizagem deletarRecursoAprendizagem(RecursoAprendizagem p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		RecursoAprendizagemDAO dao = DAOFactory.getRecursoAprendizagemDAO(pc);
		dao.deletar(p);
		pc.commitAndClose();
		return p;
	}
	
	
	/**
	 * Atualizar recurso aprendizagem.
	 *
	 * @param p the p
	 * @return the recurso aprendizagem
	 */
	public RecursoAprendizagem atualizarRecursoAprendizagem(RecursoAprendizagem p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		RecursoAprendizagemDAO dao = DAOFactory.getRecursoAprendizagemDAO(pc);
		dao.atualizar(p);
		pc.commitAndClose();
		return p;
	}

	
}
