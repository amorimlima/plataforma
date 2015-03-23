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

import br.com.muranodesign.dao.AtividadeDAO;
import br.com.muranodesign.dao.DAOFactory;
import br.com.muranodesign.hibernate.impl.PersistenceContext;
import br.com.muranodesign.model.Atividade;



// TODO: Auto-generated Javadoc
/**
 * The Class AtividadeService.
 */
public class AtividadeService {
	
	/**
	 * Listar todos.
	 *
	 * @return the list
	 */
	public List<Atividade> listarTodos() {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		AtividadeDAO dao = DAOFactory.getAtividadeDAO(pc);
		List<Atividade> result = dao.listAll();
				
		pc.commitAndClose();
		return result;
	}
	
	/**
	 * Listarkey.
	 *
	 * @param key the key
	 * @return the list
	 */
	public List<Atividade> listarkey(int key) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		AtividadeDAO dao = DAOFactory.getAtividadeDAO(pc);
		List<Atividade> result = dao.listarKey(key);
		pc.commitAndClose();
		return result;
	}
	
	
	/**
	 * Criar atividade.
	 *
	 * @param p the p
	 * @return the atividade
	 */
	public Atividade criarAtividade(Atividade p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		AtividadeDAO dao = DAOFactory.getAtividadeDAO(pc);
		dao.criar(p);
		pc.commitAndClose();
		return p;
	}
	
	
	/**
	 * Deletar atividade.
	 *
	 * @param p the p
	 * @return the atividade
	 */
	public Atividade deletarAtividade(Atividade p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		AtividadeDAO dao = DAOFactory.getAtividadeDAO(pc);
		dao.deletar(p);
		pc.commitAndClose();
		return p;
	}
	
	
	/**
	 * Atualizar atividade.
	 *
	 * @param p the p
	 * @return the atividade
	 */
	public Atividade atualizarAtividade(Atividade p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		AtividadeDAO dao = DAOFactory.getAtividadeDAO(pc);
		dao.atualizar(p);
		pc.commitAndClose();
		return p;
	}

	
}
