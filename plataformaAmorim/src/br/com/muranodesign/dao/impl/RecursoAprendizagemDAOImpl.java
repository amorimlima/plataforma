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

import br.com.muranodesign.dao.RecursoAprendizagemDAO;
import br.com.muranodesign.hibernate.AbstractHibernateDAO;
import br.com.muranodesign.hibernate.HibernatePersistenceContext;
import br.com.muranodesign.model.RecursoAprendizagem;


/**
 * Abstração do dao e implementação do GRUD
 *
 * @author Rogerio Lima dos Santos
 * @version 1.00
 * @since Release 1 da aplicação
 */
public class RecursoAprendizagemDAOImpl extends AbstractHibernateDAO implements RecursoAprendizagemDAO {

	/**
	 * Instantiates a new plano estudo dao impl.
	 *
	 * @param persistenceContext the persistence context
	 */
	public RecursoAprendizagemDAOImpl(HibernatePersistenceContext persistenceContext) {
		super(persistenceContext);
		
	}

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.RecursoAprendizagemDAO#listAll()
	 */
	public List<RecursoAprendizagem> listAll() {
		
		Criteria criteria = getSession().createCriteria(RecursoAprendizagem.class);
		List<RecursoAprendizagem> result = criteria.list();
		
		
		return result;
	} 
	

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.RecursoAprendizagemDAO#criar(br.com.muranodesign.model.RecursoAprendizagem)
	 */
	public void criar(RecursoAprendizagem c) {
		synchronized (RecursoAprendizagemDAOImpl.class) {
			getSession().persist(c);
			getSession().flush();

		}
	}

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.RecursoAprendizagemDAO#deletar(br.com.muranodesign.model.RecursoAprendizagem)
	 */
	public void deletar(RecursoAprendizagem c) {
		getSession().delete(c);
		getSession().flush();
	}

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.RecursoAprendizagemDAO#atualizar(br.com.muranodesign.model.RecursoAprendizagem)
	 */
	public void atualizar(RecursoAprendizagem p) {
		getSession().merge(p);
		getSession().flush();
	}
	
	
	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.RecursoAprendizagemDAO#listarKey(int)
	 */
	public List<RecursoAprendizagem> listarKey(int key){
		Criteria criteria = getSession().createCriteria(RecursoAprendizagem.class);
		criteria.add(Restrictions.eq("idrecursoAprendizagem", key));
		List<RecursoAprendizagem> result = criteria.list();
		return result;
	}



	

}