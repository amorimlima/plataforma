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
import br.com.muranodesign.dao.PresencaProfessorDAO;
import br.com.muranodesign.hibernate.impl.PersistenceContext;
import br.com.muranodesign.model.PresencaProfessor;



// TODO: Auto-generated Javadoc
/**
 * The Class PresencaProfessorService.
 */
public class PresencaProfessorService {
	
	/**
	 * Listar todos.
	 *
	 * @return the list
	 */
	public List<PresencaProfessor> listarTodos() {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		PresencaProfessorDAO dao = DAOFactory.getPresencaProfessorDAO(pc);
		List<PresencaProfessor> result = dao.listAll();
				
		pc.commitAndClose();
		return result;
	}
	
	/**
	 * Listarkey.
	 *
	 * @param key the key
	 * @return the list
	 */
	public List<PresencaProfessor> listarkey(int key) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		PresencaProfessorDAO dao = DAOFactory.getPresencaProfessorDAO(pc);
		List<PresencaProfessor> result = dao.listarKey(key);
		pc.commitAndClose();
		return result;
	}
	
	
	/**
	 * Criar presenca professor.
	 *
	 * @param p the p
	 * @return the presenca professor
	 */
	public PresencaProfessor criarPresencaProfessor(PresencaProfessor p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		PresencaProfessorDAO dao = DAOFactory.getPresencaProfessorDAO(pc);
		dao.criar(p);
		pc.commitAndClose();
		return p;
	}
	
	
	/**
	 * Deletar presenca professor.
	 *
	 * @param p the p
	 * @return the presenca professor
	 */
	public PresencaProfessor deletarPresencaProfessor(PresencaProfessor p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		PresencaProfessorDAO dao = DAOFactory.getPresencaProfessorDAO(pc);
		dao.deletar(p);
		pc.commitAndClose();
		return p;
	}
	
	
	/**
	 * Atualizar presenca professor.
	 *
	 * @param p the p
	 * @return the presenca professor
	 */
	public PresencaProfessor atualizarPresencaProfessor(PresencaProfessor p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		PresencaProfessorDAO dao = DAOFactory.getPresencaProfessorDAO(pc);
		dao.atualizar(p);
		pc.commitAndClose();
		return p;
	}

	
}
