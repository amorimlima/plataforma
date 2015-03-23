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

import br.com.muranodesign.dao.RoteiroDAO;
import br.com.muranodesign.hibernate.AbstractHibernateDAO;
import br.com.muranodesign.hibernate.HibernatePersistenceContext;
import br.com.muranodesign.model.Roteiro;



/**
 * Abstração do dao e implementação do GRUD
 *
 * @author Rogerio Lima dos Santos
 * @version 1.00
 * @since Release 1 da aplicação
 */
public class RoteiroDAOImpl extends AbstractHibernateDAO implements RoteiroDAO {

	/**
	 * Instantiates a new roteiro dao impl.
	 *
	 * @param persistenceContext the persistence context
	 */
	public RoteiroDAOImpl(HibernatePersistenceContext persistenceContext) {
		super(persistenceContext);
		
	}

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.RoteiroDAO#listAll()
	 */
	public List<Roteiro> listAll() {
		
		Criteria criteria = getSession().createCriteria(Roteiro.class);
		criteria.add(Restrictions.eq("ativo",1));
		
		List<Roteiro> result = criteria.list();
		
		
		return result;
	} 
	

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.RoteiroDAO#criar(br.com.muranodesign.model.Roteiro)
	 */
	public void criar(Roteiro c) {
		synchronized (RoteiroDAOImpl.class) {
			getSession().persist(c);
			getSession().flush();

		}
	}

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.RoteiroDAO#deletar(br.com.muranodesign.model.Roteiro)
	 */
	public void deletar(Roteiro c) {
		getSession().delete(c);
		getSession().flush();
	}

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.RoteiroDAO#atualizar(br.com.muranodesign.model.Roteiro)
	 */
	public void atualizar(Roteiro p) {
		getSession().merge(p);
		getSession().flush();
	}
	
	
	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.RoteiroDAO#listarKey(int)
	 */
	public List<Roteiro> listarKey(int key){
		Criteria criteria = getSession().createCriteria(Roteiro.class);
		criteria.add(Restrictions.eq("idroteiro", key));
		List<Roteiro> result = criteria.list();
		return result;
	}

	
	

}