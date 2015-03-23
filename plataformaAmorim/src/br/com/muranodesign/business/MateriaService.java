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
import br.com.muranodesign.dao.MateriaDAO;
import br.com.muranodesign.hibernate.impl.PersistenceContext;
import br.com.muranodesign.model.Materia;



// TODO: Auto-generated Javadoc
/**
 * The Class MateriaService.
 */
public class MateriaService {
	
	/**
	 * Listar todos.
	 *
	 * @return the list
	 */
	public List<Materia> listarTodos() {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		MateriaDAO dao = DAOFactory.getMateriaDAO(pc);
		List<Materia> result = dao.listAll();
				
		pc.commitAndClose();
		return result;
	}
	
	/**
	 * Listarkey.
	 *
	 * @param key the key
	 * @return the list
	 */
	public List<Materia> listarkey(int key) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		MateriaDAO dao = DAOFactory.getMateriaDAO(pc);
		List<Materia> result = dao.listarKey(key);
		pc.commitAndClose();
		return result;
	}
	
	
	/**
	 * Criar materia.
	 *
	 * @param p the p
	 * @return the materia
	 */
	public Materia criarMateria(Materia p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		MateriaDAO dao = DAOFactory.getMateriaDAO(pc);
		dao.criar(p);
		pc.commitAndClose();
		return p;
	}
	
	
	/**
	 * Deletar materia.
	 *
	 * @param p the p
	 * @return the materia
	 */
	public Materia deletarMateria(Materia p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		MateriaDAO dao = DAOFactory.getMateriaDAO(pc);
		dao.deletar(p);
		pc.commitAndClose();
		return p;
	}
	
	
	/**
	 * Atualizar materia.
	 *
	 * @param p the p
	 * @return the materia
	 */
	public Materia atualizarMateria(Materia p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		MateriaDAO dao = DAOFactory.getMateriaDAO(pc);
		dao.atualizar(p);
		pc.commitAndClose();
		return p;
	}

	
}
