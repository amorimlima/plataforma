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

import br.com.muranodesign.dao.AnoEstudoDAO;
import br.com.muranodesign.dao.DAOFactory;
import br.com.muranodesign.hibernate.impl.PersistenceContext;
import br.com.muranodesign.model.AnoEstudo;



// TODO: Auto-generated Javadoc
/**
 * The Class AnoEstudoService.
 */
public class AnoEstudoService {
	
	/**
	 * Listar todos.
	 *
	 * @return the list
	 */
	public List<AnoEstudo> listarTodos() {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		AnoEstudoDAO dao = DAOFactory.getAnoEstudoDAO(pc);
		List<AnoEstudo> result = dao.listAll();
				
		pc.commitAndClose();
		return result;
	}
	
	/**
	 * Listarkey.
	 *
	 * @param key the key
	 * @return the list
	 */
	public List<AnoEstudo> listarkey(int key) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		AnoEstudoDAO dao = DAOFactory.getAnoEstudoDAO(pc);
		List<AnoEstudo> result = dao.listarKey(key);
		pc.commitAndClose();
		return result;
	}
	
	
	/**
	 * Criar ano estudo.
	 *
	 * @param p the p
	 * @return the ano estudo
	 */
	public AnoEstudo criarAnoEstudo(AnoEstudo p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		AnoEstudoDAO dao = DAOFactory.getAnoEstudoDAO(pc);
		dao.criar(p);
		pc.commitAndClose();
		return p;
	}
	
	
	/**
	 * Deletar ano estudo.
	 *
	 * @param p the p
	 * @return the ano estudo
	 */
	public AnoEstudo deletarAnoEstudo(AnoEstudo p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		AnoEstudoDAO dao = DAOFactory.getAnoEstudoDAO(pc);
		dao.deletar(p);
		pc.commitAndClose();
		return p;
	}
	
	
	/**
	 * Atualizar ano estudo.
	 *
	 * @param p the p
	 * @return the ano estudo
	 */
	public AnoEstudo atualizarAnoEstudo(AnoEstudo p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		AnoEstudoDAO dao = DAOFactory.getAnoEstudoDAO(pc);
		dao.atualizar(p);
		pc.commitAndClose();
		return p;
	}

	
}
