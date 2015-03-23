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

import br.com.muranodesign.dao.PeriodoDAO;
import br.com.muranodesign.hibernate.AbstractHibernateDAO;
import br.com.muranodesign.hibernate.HibernatePersistenceContext;
import br.com.muranodesign.model.Periodo;



/**
 * Abstração do dao e implementação do GRUD
 *
 * @author Rogerio Lima dos Santos
 * @version 1.00
 * @since Release 1 da aplicação
 */
public class PeriodoDAOImpl extends AbstractHibernateDAO implements PeriodoDAO {

	/**
	 * Instantiates a new periodo dao impl.
	 *
	 * @param persistenceContext the persistence context
	 */
	public PeriodoDAOImpl(HibernatePersistenceContext persistenceContext) {
		super(persistenceContext);
		
	}

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.PeriodoDAO#listAll()
	 */
	public List<Periodo> listAll() {
		
		Criteria criteria = getSession().createCriteria(Periodo.class);
		List<Periodo> result = criteria.list();
		
		
		return result;
	} 
	

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.PeriodoDAO#criar(br.com.muranodesign.model.Periodo)
	 */
	public void criar(Periodo c) {
		synchronized (PeriodoDAOImpl.class) {
			getSession().persist(c);
			getSession().flush();

		}
	}

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.PeriodoDAO#deletar(br.com.muranodesign.model.Periodo)
	 */
	public void deletar(Periodo c) {
		getSession().delete(c);
		getSession().flush();
	}

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.PeriodoDAO#atualizar(br.com.muranodesign.model.Periodo)
	 */
	public void atualizar(Periodo p) {
		getSession().merge(p);
		getSession().flush();
	}
	
	
	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.PeriodoDAO#listarKey(int)
	 */
	public List<Periodo> listarKey(int key){
		Criteria criteria = getSession().createCriteria(Periodo.class);
		criteria.add(Restrictions.eq("idperiodo", key));
		List<Periodo> result = criteria.list();
		return result;
	}



	

}