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
import br.com.muranodesign.dao.TipoRecursoAprendizagemDAO;
import br.com.muranodesign.hibernate.impl.PersistenceContext;
import br.com.muranodesign.model.TipoRecursoAprendizagem;



// TODO: Auto-generated Javadoc
/**
 * The Class TipoRecursoAprendizagemService.
 */
public class TipoRecursoAprendizagemService {
	
	/**
	 * Listar todos.
	 *
	 * @return the list
	 */
	public List<TipoRecursoAprendizagem> listarTodos() {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		TipoRecursoAprendizagemDAO dao = DAOFactory.getTipoRecursoAprendizagemDAO(pc);
		List<TipoRecursoAprendizagem> result = dao.listAll();
				
		pc.commitAndClose();
		return result;
	}
	
	/**
	 * Listarkey.
	 *
	 * @param key the key
	 * @return the list
	 */
	public List<TipoRecursoAprendizagem> listarkey(int key) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		TipoRecursoAprendizagemDAO dao = DAOFactory.getTipoRecursoAprendizagemDAO(pc);
		List<TipoRecursoAprendizagem> result = dao.listarKey(key);
		pc.commitAndClose();
		return result;
	}
	
	
	/**
	 * Criar tipo recurso aprendizagem.
	 *
	 * @param p the p
	 * @return the tipo recurso aprendizagem
	 */
	public TipoRecursoAprendizagem criarTipoRecursoAprendizagem(TipoRecursoAprendizagem p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		TipoRecursoAprendizagemDAO dao = DAOFactory.getTipoRecursoAprendizagemDAO(pc);
		dao.criar(p);
		pc.commitAndClose();
		return p;
	}
	
	
	/**
	 * Deletar tipo recurso aprendizagem.
	 *
	 * @param p the p
	 * @return the tipo recurso aprendizagem
	 */
	public TipoRecursoAprendizagem deletarTipoRecursoAprendizagem(TipoRecursoAprendizagem p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		TipoRecursoAprendizagemDAO dao = DAOFactory.getTipoRecursoAprendizagemDAO(pc);
		dao.deletar(p);
		pc.commitAndClose();
		return p;
	}
	
	
	/**
	 * Atualizar tipo recurso aprendizagem.
	 *
	 * @param p the p
	 * @return the tipo recurso aprendizagem
	 */
	public TipoRecursoAprendizagem atualizarTipoRecursoAprendizagem(TipoRecursoAprendizagem p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		TipoRecursoAprendizagemDAO dao = DAOFactory.getTipoRecursoAprendizagemDAO(pc);
		dao.atualizar(p);
		pc.commitAndClose();
		return p;
	}

	
}
