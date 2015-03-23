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

import br.com.muranodesign.dao.ObjetivoDAO;
import br.com.muranodesign.hibernate.AbstractHibernateDAO;
import br.com.muranodesign.hibernate.HibernatePersistenceContext;
import br.com.muranodesign.model.Objetivo;



/**
 * Abstração do dao e implementação do GRUD
 *
 * @author Rogerio Lima dos Santos
 * @version 1.00
 * @since Release 1 da aplicação
 */
public class ObjetivoDAOImpl extends AbstractHibernateDAO implements ObjetivoDAO {

	/**
	 * Instantiates a new objetivo dao impl.
	 *
	 * @param persistenceContext the persistence context
	 */
	public ObjetivoDAOImpl(HibernatePersistenceContext persistenceContext) {
		super(persistenceContext);
		
	}

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.ObjetivoDAO#listAll()
	 */
	public List<Objetivo> listAll() {
		
		Criteria criteria = getSession().createCriteria(Objetivo.class);
		criteria.add(Restrictions.eq("ativo",1));
		List<Objetivo> result = criteria.list();
		
		
		return result;
	} 
	

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.ObjetivoDAO#criar(br.com.muranodesign.model.Objetivo)
	 */
	public void criar(Objetivo c) {
		synchronized (ObjetivoDAOImpl.class) {
			getSession().persist(c);
			getSession().flush();

		}
	}

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.ObjetivoDAO#deletar(br.com.muranodesign.model.Objetivo)
	 */
	public void deletar(Objetivo c) {
		getSession().delete(c);
		getSession().flush();
	}

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.ObjetivoDAO#atualizar(br.com.muranodesign.model.Objetivo)
	 */
	public void atualizar(Objetivo p) {
		getSession().merge(p);
		getSession().flush();
	}
	
	
	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.ObjetivoDAO#listarKey(int)
	 */
	public List<Objetivo> listarKey(int key){
		Criteria criteria = getSession().createCriteria(Objetivo.class);
		criteria.add(Restrictions.eq("idobjetivo", key));
		List<Objetivo> result = criteria.list();
		return result;
	}






	

}