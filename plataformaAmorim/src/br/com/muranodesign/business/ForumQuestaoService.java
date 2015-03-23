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
import br.com.muranodesign.dao.ForumQuestaoDAO;
import br.com.muranodesign.hibernate.impl.PersistenceContext;
import br.com.muranodesign.model.ForumQuestao;



// TODO: Auto-generated Javadoc
/**
 * The Class ForumQuestaoService.
 */
public class ForumQuestaoService {
	
	/**
	 * Listar todos.
	 *
	 * @return the list
	 */
	public List<ForumQuestao> listarTodos() {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		ForumQuestaoDAO dao = DAOFactory.getForumQuestaoDAO(pc);
		List<ForumQuestao> result = dao.listAll();
				
		pc.commitAndClose();
		return result;
	}
	
	/**
	 * Listarkey.
	 *
	 * @param key the key
	 * @return the list
	 */
	public List<ForumQuestao> listarkey(int key) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		ForumQuestaoDAO dao = DAOFactory.getForumQuestaoDAO(pc);
		List<ForumQuestao> result = dao.listarKey(key);
		pc.commitAndClose();
		return result;
	}
	
	
	/**
	 * Criar forum questao.
	 *
	 * @param p the p
	 * @return the forum questao
	 */
	public ForumQuestao criarForumQuestao(ForumQuestao p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		ForumQuestaoDAO dao = DAOFactory.getForumQuestaoDAO(pc);
		dao.criar(p);
		pc.commitAndClose();
		return p;
	}
	
	
	/**
	 * Deletar forum questao.
	 *
	 * @param p the p
	 * @return the forum questao
	 */
	public ForumQuestao deletarForumQuestao(ForumQuestao p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		ForumQuestaoDAO dao = DAOFactory.getForumQuestaoDAO(pc);
		dao.deletar(p);
		pc.commitAndClose();
		return p;
	}
	
	
	/**
	 * Atualizar forum questao.
	 *
	 * @param p the p
	 * @return the forum questao
	 */
	public ForumQuestao atualizarForumQuestao(ForumQuestao p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		ForumQuestaoDAO dao = DAOFactory.getForumQuestaoDAO(pc);
		dao.atualizar(p);
		pc.commitAndClose();
		return p;
	}

	
}
