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
import br.com.muranodesign.dao.PeriodoDAO;
import br.com.muranodesign.hibernate.impl.PersistenceContext;
import br.com.muranodesign.model.Periodo;



// TODO: Auto-generated Javadoc
/**
 * The Class PeriodoService.
 */
public class PeriodoService {
	
	/**
	 * Listar todos.
	 *
	 * @return the list
	 */
	public List<Periodo> listarTodos() {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		PeriodoDAO dao = DAOFactory.getPeriodoDAO(pc);
		List<Periodo> result = dao.listAll();
				
		pc.commitAndClose();
		return result;
	}
	
	/**
	 * Listarkey.
	 *
	 * @param key the key
	 * @return the list
	 */
	public List<Periodo> listarkey(int key) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		PeriodoDAO dao = DAOFactory.getPeriodoDAO(pc);
		List<Periodo> result = dao.listarKey(key);
		pc.commitAndClose();
		return result;
	}
	
	
	/**
	 * Criar periodo.
	 *
	 * @param p the p
	 * @return the periodo
	 */
	public Periodo criarPeriodo(Periodo p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		PeriodoDAO dao = DAOFactory.getPeriodoDAO(pc);
		dao.criar(p);
		pc.commitAndClose();
		return p;
	}
	
	
	/**
	 * Deletar periodo.
	 *
	 * @param p the p
	 * @return the periodo
	 */
	public Periodo deletarPeriodo(Periodo p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		PeriodoDAO dao = DAOFactory.getPeriodoDAO(pc);
		dao.deletar(p);
		pc.commitAndClose();
		return p;
	}
	
	
	/**
	 * Atualizar periodo.
	 *
	 * @param p the p
	 * @return the periodo
	 */
	public Periodo atualizarPeriodo(Periodo p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		PeriodoDAO dao = DAOFactory.getPeriodoDAO(pc);
		dao.atualizar(p);
		pc.commitAndClose();
		return p;
	}

	
}
