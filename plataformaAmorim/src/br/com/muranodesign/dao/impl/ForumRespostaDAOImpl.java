/**
 *   Este codigo é software livre você e pode resdistribuir e/ou modificar ele seguindo os termos da
 *   Creative Commons Attribution 4.0 International Pare visualizar uma copia desta 
 *   licensa em ingles visite http://creativecommons.org/licenses/by/4.0/.
 *   
 *   This code is free software; you can redistribute it and/or modify it
 *   under the terms of Creative Commons Attribution 4.0 International License. 
 *   To view a copy of this license, visit http://creativecommons.org/licenses/by/4.0/.
 */

package br.com.muranodesign.dao.impl;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.com.muranodesign.dao.ForumRespostaDAO;
import br.com.muranodesign.hibernate.AbstractHibernateDAO;
import br.com.muranodesign.hibernate.HibernatePersistenceContext;
import br.com.muranodesign.model.ForumResposta;



/**
 * Abstração do dao e implementação do GRUD
 *
 * @author Rogerio Lima dos Santos
 * @version 1.00
 * @since Release 1 da aplicação
 */
public class ForumRespostaDAOImpl extends AbstractHibernateDAO implements ForumRespostaDAO {

	/**
	 * Instantiates a new forum resposta dao impl.
	 *
	 * @param persistenceContext the persistence context
	 */
	public ForumRespostaDAOImpl(HibernatePersistenceContext persistenceContext) {
		super(persistenceContext);
		
	}

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.ForumRespostaDAO#listAll()
	 */
	public List<ForumResposta> listAll() {
		
		Criteria criteria = getSession().createCriteria(ForumResposta.class);
		List<ForumResposta> result = criteria.list();
		
		
		return result;
	} 
	

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.ForumRespostaDAO#criar(br.com.muranodesign.model.ForumResposta)
	 */
	public void criar(ForumResposta c) {
		synchronized (ForumRespostaDAOImpl.class) {
			getSession().persist(c);
			getSession().flush();

		}
	}

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.ForumRespostaDAO#deletar(br.com.muranodesign.model.ForumResposta)
	 */
	public void deletar(ForumResposta c) {
		getSession().delete(c);
		getSession().flush();
	}

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.ForumRespostaDAO#atualizar(br.com.muranodesign.model.ForumResposta)
	 */
	public void atualizar(ForumResposta p) {
		getSession().merge(p);
		getSession().flush();
	}
	
	
	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.ForumRespostaDAO#listarKey(int)
	 */
	public List<ForumResposta> listarKey(int key){
		Criteria criteria = getSession().createCriteria(ForumResposta.class);
		criteria.add(Restrictions.eq("idforumResposta", key));
		List<ForumResposta> result = criteria.list();
		return result;
	}

	





	

}