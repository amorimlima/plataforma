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
import br.com.muranodesign.dao.TipoEventoDAO;
import br.com.muranodesign.hibernate.impl.PersistenceContext;
import br.com.muranodesign.model.TipoEvento;



// TODO: Auto-generated Javadoc
/**
 * The Class TipoEventoService.
 */
public class TipoEventoService {
	
	/**
	 * Listar todos.
	 *
	 * @return the list
	 */
	public List<TipoEvento> listarTodos() {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		TipoEventoDAO dao = DAOFactory.getTipoEventoDAO(pc);
		List<TipoEvento> result = dao.listAll();
				
		pc.commitAndClose();
		return result;
	}
	
	/**
	 * Listarkey.
	 *
	 * @param key the key
	 * @return the list
	 */
	public List<TipoEvento> listarkey(int key) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		TipoEventoDAO dao = DAOFactory.getTipoEventoDAO(pc);
		List<TipoEvento> result = dao.listarKey(key);
		pc.commitAndClose();
		return result;
	}
	
	
	/**
	 * Criar tipo evento.
	 *
	 * @param p the p
	 * @return the tipo evento
	 */
	public TipoEvento criarTipoEvento(TipoEvento p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		TipoEventoDAO dao = DAOFactory.getTipoEventoDAO(pc);
		dao.criar(p);
		pc.commitAndClose();
		return p;
	}
	
	
	/**
	 * Deletar tipo evento.
	 *
	 * @param p the p
	 * @return the tipo evento
	 */
	public TipoEvento deletarTipoEvento(TipoEvento p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		TipoEventoDAO dao = DAOFactory.getTipoEventoDAO(pc);
		dao.deletar(p);
		pc.commitAndClose();
		return p;
	}
	
	
	/**
	 * Atualizar tipo evento.
	 *
	 * @param p the p
	 * @return the tipo evento
	 */
	public TipoEvento atualizarTipoEvento(TipoEvento p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		TipoEventoDAO dao = DAOFactory.getTipoEventoDAO(pc);
		dao.atualizar(p);
		pc.commitAndClose();
		return p;
	}

	
}
