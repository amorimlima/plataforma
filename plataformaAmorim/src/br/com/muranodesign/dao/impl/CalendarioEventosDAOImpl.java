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

import br.com.muranodesign.dao.CalendarioEventosDAO;
import br.com.muranodesign.hibernate.AbstractHibernateDAO;
import br.com.muranodesign.hibernate.HibernatePersistenceContext;
import br.com.muranodesign.model.CalendarioEventos;



/**
 * Abstração do dao e implementação do GRUD
 *
 * @author Rogerio Lima dos Santos
 * @version 1.00
 * @since Release 1 da aplicação
 */
public class CalendarioEventosDAOImpl extends AbstractHibernateDAO implements CalendarioEventosDAO {

	/**
	 * Instantiates a new calendario eventos dao impl.
	 *
	 * @param persistenceContext the persistence context
	 */
	public CalendarioEventosDAOImpl(HibernatePersistenceContext persistenceContext) {
		super(persistenceContext);
		
	}

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.CalendarioEventosDAO#listAll()
	 */
	public List<CalendarioEventos> listAll() {
		
		Criteria criteria = getSession().createCriteria(CalendarioEventos.class);
		List<CalendarioEventos> result = criteria.list();
		
		
		return result;
	} 
	

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.CalendarioEventosDAO#criar(br.com.muranodesign.model.CalendarioEventos)
	 */
	public void criar(CalendarioEventos c) {
		synchronized (CalendarioEventosDAOImpl.class) {
			getSession().persist(c);
			getSession().flush();

		}
	}

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.CalendarioEventosDAO#deletar(br.com.muranodesign.model.CalendarioEventos)
	 */
	public void deletar(CalendarioEventos c) {
		getSession().delete(c);
		getSession().flush();
	}

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.CalendarioEventosDAO#atualizar(br.com.muranodesign.model.CalendarioEventos)
	 */
	public void atualizar(CalendarioEventos p) {
		getSession().merge(p);
		getSession().flush();
	}
	
	
	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.CalendarioEventosDAO#listarKey(int)
	 */
	public List<CalendarioEventos> listarKey(int key){
		Criteria criteria = getSession().createCriteria(CalendarioEventos.class);
		criteria.add(Restrictions.eq("ideventos", key));
		List<CalendarioEventos> result = criteria.list();
		return result;
	}

	





	

}