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

import br.com.muranodesign.dao.CalendarioEventosDAO;
import br.com.muranodesign.dao.DAOFactory;
import br.com.muranodesign.hibernate.impl.PersistenceContext;
import br.com.muranodesign.model.CalendarioEventos;



// TODO: Auto-generated Javadoc
/**
 * The Class CalendarioEventosService.
 */
public class CalendarioEventosService {
	
	/**
	 * Listar todos.
	 *
	 * @return the list
	 */
	public List<CalendarioEventos> listarTodos() {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		CalendarioEventosDAO dao = DAOFactory.getCalendarioEventosDAO(pc);
		List<CalendarioEventos> result = dao.listAll();
				
		pc.commitAndClose();
		return result;
	}
	
	/**
	 * Listarkey.
	 *
	 * @param key the key
	 * @return the list
	 */
	public List<CalendarioEventos> listarkey(int key) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		CalendarioEventosDAO dao = DAOFactory.getCalendarioEventosDAO(pc);
		List<CalendarioEventos> result = dao.listarKey(key);
		pc.commitAndClose();
		return result;
	}
	
	
	/**
	 * Criar calendario eventos.
	 *
	 * @param p the p
	 * @return the calendario eventos
	 */
	public CalendarioEventos criarCalendarioEventos(CalendarioEventos p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		CalendarioEventosDAO dao = DAOFactory.getCalendarioEventosDAO(pc);
		dao.criar(p);
		pc.commitAndClose();
		return p;
	}
	
	
	/**
	 * Deletar calendario eventos.
	 *
	 * @param p the p
	 * @return the calendario eventos
	 */
	public CalendarioEventos deletarCalendarioEventos(CalendarioEventos p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		CalendarioEventosDAO dao = DAOFactory.getCalendarioEventosDAO(pc);
		dao.deletar(p);
		pc.commitAndClose();
		return p;
	}
	
	
	/**
	 * Atualizar calendario eventos.
	 *
	 * @param p the p
	 * @return the calendario eventos
	 */
	public CalendarioEventos atualizarCalendarioEventos(CalendarioEventos p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		CalendarioEventosDAO dao = DAOFactory.getCalendarioEventosDAO(pc);
		dao.atualizar(p);
		pc.commitAndClose();
		return p;
	}

	
}
