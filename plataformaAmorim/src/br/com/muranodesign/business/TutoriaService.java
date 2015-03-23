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
import br.com.muranodesign.dao.TutoriaDAO;
import br.com.muranodesign.hibernate.impl.PersistenceContext;
import br.com.muranodesign.model.Tutoria;



// TODO: Auto-generated Javadoc
/**
 * The Class TutoriaService.
 */
public class TutoriaService {
	
	/**
	 * Listar todos.
	 *
	 * @return the list
	 */
	public List<Tutoria> listarTodos() {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		TutoriaDAO dao = DAOFactory.getTutoriaDAO(pc);
		List<Tutoria> result = dao.listAll();
				
		pc.commitAndClose();
		return result;
	}
	
	/**
	 * Listarkey.
	 *
	 * @param key the key
	 * @return the list
	 */
	public List<Tutoria> listarkey(int key) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		TutoriaDAO dao = DAOFactory.getTutoriaDAO(pc);
		List<Tutoria> result = dao.listarKey(key);
		pc.commitAndClose();
		return result;
	}
	
	
	/**
	 * Criar tutoria.
	 *
	 * @param p the p
	 * @return the tutoria
	 */
	public Tutoria criarTutoria(Tutoria p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		TutoriaDAO dao = DAOFactory.getTutoriaDAO(pc);
		dao.criar(p);
		pc.commitAndClose();
		return p;
	}
	
	
	/**
	 * Deletar tutoria.
	 *
	 * @param p the p
	 * @return the tutoria
	 */
	public Tutoria deletarTutoria(Tutoria p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		TutoriaDAO dao = DAOFactory.getTutoriaDAO(pc);
		dao.deletar(p);
		pc.commitAndClose();
		return p;
	}
	
	
	/**
	 * Atualizar tutoria.
	 *
	 * @param p the p
	 * @return the tutoria
	 */
	public Tutoria atualizarTutoria(Tutoria p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		TutoriaDAO dao = DAOFactory.getTutoriaDAO(pc);
		dao.atualizar(p);
		pc.commitAndClose();
		return p;
	}

	
}
