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
import br.com.muranodesign.dao.ForumRespostaDAO;
import br.com.muranodesign.hibernate.impl.PersistenceContext;
import br.com.muranodesign.model.ForumResposta;



// TODO: Auto-generated Javadoc
/**
 * The Class ForumRespostaService.
 */
public class ForumRespostaService {
	
	/**
	 * Listar todos.
	 *
	 * @return the list
	 */
	public List<ForumResposta> listarTodos() {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		ForumRespostaDAO dao = DAOFactory.getForumRespostaDAO(pc);
		List<ForumResposta> result = dao.listAll();
				
		pc.commitAndClose();
		return result;
	}
	
	/**
	 * Listarkey.
	 *
	 * @param key the key
	 * @return the list
	 */
	public List<ForumResposta> listarkey(int key) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		ForumRespostaDAO dao = DAOFactory.getForumRespostaDAO(pc);
		List<ForumResposta> result = dao.listarKey(key);
		pc.commitAndClose();
		return result;
	}
	
	
	/**
	 * Criar forum resposta.
	 *
	 * @param p the p
	 * @return the forum resposta
	 */
	public ForumResposta criarForumResposta(ForumResposta p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		ForumRespostaDAO dao = DAOFactory.getForumRespostaDAO(pc);
		dao.criar(p);
		pc.commitAndClose();
		return p;
	}
	
	
	/**
	 * Deletar forum resposta.
	 *
	 * @param p the p
	 * @return the forum resposta
	 */
	public ForumResposta deletarForumResposta(ForumResposta p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		ForumRespostaDAO dao = DAOFactory.getForumRespostaDAO(pc);
		dao.deletar(p);
		pc.commitAndClose();
		return p;
	}
	
	
	/**
	 * Atualizar forum resposta.
	 *
	 * @param p the p
	 * @return the forum resposta
	 */
	public ForumResposta atualizarForumResposta(ForumResposta p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		ForumRespostaDAO dao = DAOFactory.getForumRespostaDAO(pc);
		dao.atualizar(p);
		pc.commitAndClose();
		return p;
	}

	
}
