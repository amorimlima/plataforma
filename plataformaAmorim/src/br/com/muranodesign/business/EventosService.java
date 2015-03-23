/**
 *   Este codigo é software livre você e pode resdistribuir e/ou modificar ele seguindo os termos da
 *   Creative Commons Attribution 4.0 International Pare visualizar uma copia desta 
 *   licensa em ingles visite http://creativecommons.org/licenses/by/4.0/.
 *   
 *   This code is free software; you can redistribute it and/or modify it
 *   under the terms of Creative Commons Attribution 4.0 International License. 
 *   To view a copy of this license, visit http://creativecommons.org/licenses/by/4.0/.
 */

/*
package br.com.muranodesign.business;

import java.util.List;


import br.com.muranodesign.dao.DAOFactory;
import br.com.muranodesign.dao.EventosDAO;
import br.com.muranodesign.hibernate.impl.PersistenceContext;
import br.com.muranodesign.model.Eventos;



public class EventosService {
	
	public List<Eventos> listarTodos() {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		EventosDAO dao = DAOFactory.getEventosDAO(pc);
		List<Eventos> result = dao.listAll();
				
		pc.commitAndClose();
		return result;
	}
	
	public List<Eventos> listarkey(int key) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		EventosDAO dao = DAOFactory.getEventosDAO(pc);
		List<Eventos> result = dao.listarKey(key);
		pc.commitAndClose();
		return result;
	}
	
	
	public Eventos criarEventos(Eventos p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		EventosDAO dao = DAOFactory.getEventosDAO(pc);
		dao.criar(p);
		pc.commitAndClose();
		return p;
	}
	
	
	public Eventos deletarEventos(Eventos p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		EventosDAO dao = DAOFactory.getEventosDAO(pc);
		dao.deletar(p);
		pc.commitAndClose();
		return p;
	}
	
	
	public Eventos atualizarEventos(Eventos p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		EventosDAO dao = DAOFactory.getEventosDAO(pc);
		dao.atualizar(p);
		pc.commitAndClose();
		return p;
	}

	
}
*/