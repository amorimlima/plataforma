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

import br.com.muranodesign.dao.AnoLetivoDAO;
import br.com.muranodesign.dao.DAOFactory;
import br.com.muranodesign.hibernate.impl.PersistenceContext;
import br.com.muranodesign.model.AnoLetivo;



// TODO: Auto-generated Javadoc
/**
 * The Class AnoLetivoService.
 */
public class AnoLetivoService {
	
	/**
	 * Listar todos.
	 *
	 * @return the list
	 */
	public List<AnoLetivo> listarTodos() {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		AnoLetivoDAO dao = DAOFactory.getAnoLetivoDAO(pc);
		List<AnoLetivo> result = dao.listAll();
				
		pc.commitAndClose();
		return result;
	}
	
	/**
	 * Listarkey.
	 *
	 * @param key the key
	 * @return the list
	 */
	public List<AnoLetivo> listarkey(int key) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		AnoLetivoDAO dao = DAOFactory.getAnoLetivoDAO(pc);
		List<AnoLetivo> result = dao.listarKey(key);
		pc.commitAndClose();
		return result;
	}
	
	
	/**
	 * Criar ano letivo.
	 *
	 * @param p the p
	 * @return the ano letivo
	 */
	public AnoLetivo criarAnoLetivo(AnoLetivo p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		AnoLetivoDAO dao = DAOFactory.getAnoLetivoDAO(pc);
		dao.criar(p);
		pc.commitAndClose();
		return p;
	}
	
	
	/**
	 * Deletar ano letivo.
	 *
	 * @param p the p
	 * @return the ano letivo
	 */
	public AnoLetivo deletarAnoLetivo(AnoLetivo p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		AnoLetivoDAO dao = DAOFactory.getAnoLetivoDAO(pc);
		dao.deletar(p);
		pc.commitAndClose();
		return p;
	}
	
	
	/**
	 * Atualizar ano letivo.
	 *
	 * @param p the p
	 * @return the ano letivo
	 */
	public AnoLetivo atualizarAnoLetivo(AnoLetivo p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		AnoLetivoDAO dao = DAOFactory.getAnoLetivoDAO(pc);
		dao.atualizar(p);
		pc.commitAndClose();
		return p;
	}

	
}
