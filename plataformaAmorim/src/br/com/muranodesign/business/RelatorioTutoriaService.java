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
import br.com.muranodesign.dao.RelatorioTutoriaDAO;
import br.com.muranodesign.hibernate.impl.PersistenceContext;
import br.com.muranodesign.model.RelatorioTutoria;



// TODO: Auto-generated Javadoc
/**
 * The Class RelatorioTutoriaService.
 */
public class RelatorioTutoriaService {
	
	/**
	 * Listar todos.
	 *
	 * @return the list
	 */
	public List<RelatorioTutoria> listarTodos() {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		RelatorioTutoriaDAO dao = DAOFactory.getRelatorioTutoriaDAO(pc);
		List<RelatorioTutoria> result = dao.listAll();
				
		pc.commitAndClose();
		return result;
	}
	
	/**
	 * Listarkey.
	 *
	 * @param key the key
	 * @return the list
	 */
	public List<RelatorioTutoria> listarkey(int key) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		RelatorioTutoriaDAO dao = DAOFactory.getRelatorioTutoriaDAO(pc);
		List<RelatorioTutoria> result = dao.listarKey(key);
		pc.commitAndClose();
		return result;
	}
	
	
	/**
	 * Criar relatorio tutoria.
	 *
	 * @param p the p
	 * @return the relatorio tutoria
	 */
	public RelatorioTutoria criarRelatorioTutoria(RelatorioTutoria p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		RelatorioTutoriaDAO dao = DAOFactory.getRelatorioTutoriaDAO(pc);
		dao.criar(p);
		pc.commitAndClose();
		return p;
	}
	
	
	/**
	 * Deletar relatorio tutoria.
	 *
	 * @param p the p
	 * @return the relatorio tutoria
	 */
	public RelatorioTutoria deletarRelatorioTutoria(RelatorioTutoria p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		RelatorioTutoriaDAO dao = DAOFactory.getRelatorioTutoriaDAO(pc);
		dao.deletar(p);
		pc.commitAndClose();
		return p;
	}
	
	
	/**
	 * Atualizar relatorio tutoria.
	 *
	 * @param p the p
	 * @return the relatorio tutoria
	 */
	public RelatorioTutoria atualizarRelatorioTutoria(RelatorioTutoria p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		RelatorioTutoriaDAO dao = DAOFactory.getRelatorioTutoriaDAO(pc);
		dao.atualizar(p);
		pc.commitAndClose();
		return p;
	}

	
}
