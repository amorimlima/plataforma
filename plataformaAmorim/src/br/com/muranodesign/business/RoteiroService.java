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
import br.com.muranodesign.dao.RoteiroDAO;
import br.com.muranodesign.hibernate.impl.PersistenceContext;
import br.com.muranodesign.model.Roteiro;



// TODO: Auto-generated Javadoc
/**
 * The Class RoteiroService.
 */
public class RoteiroService {
	
	/**
	 * Listar todos.
	 *
	 * @return the list
	 */
	public List<Roteiro> listarTodos() {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		RoteiroDAO dao = DAOFactory.getRoteiroDAO(pc);
		List<Roteiro> result = dao.listAll();
				
		pc.commitAndClose();
		return result;
	}
	
	/**
	 * Listarkey.
	 *
	 * @param key the key
	 * @return the list
	 */
	public List<Roteiro> listarkey(int key) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		RoteiroDAO dao = DAOFactory.getRoteiroDAO(pc);
		List<Roteiro> result = dao.listarKey(key);
		pc.commitAndClose();
		return result;
	}
	
	
	/**
	 * Criar roteiro.
	 *
	 * @param p the p
	 * @return the roteiro
	 */
	public Roteiro criarRoteiro(Roteiro p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		RoteiroDAO dao = DAOFactory.getRoteiroDAO(pc);
		dao.criar(p);
		pc.commitAndClose();
		return p;
	}
	
	
	/**
	 * Deletar roteiro.
	 *
	 * @param p the p
	 * @return the roteiro
	 */
	public Roteiro deletarRoteiro(Roteiro p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		RoteiroDAO dao = DAOFactory.getRoteiroDAO(pc);
		dao.deletar(p);
		pc.commitAndClose();
		return p;
	}
	
	
	/**
	 * Atualizar roteiro.
	 *
	 * @param p the p
	 * @return the roteiro
	 */
	public Roteiro atualizarRoteiro(Roteiro p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		RoteiroDAO dao = DAOFactory.getRoteiroDAO(pc);
		dao.atualizar(p);
		pc.commitAndClose();
		return p;
	}

	
}
