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

import br.com.muranodesign.dao.TutoriaDAO;
import br.com.muranodesign.hibernate.AbstractHibernateDAO;
import br.com.muranodesign.hibernate.HibernatePersistenceContext;
import br.com.muranodesign.model.Tutoria;


/**
 * Abstração do dao e implementação do GRUD
 *
 * @author Rogerio Lima dos Santos
 * @version 1.00
 * @since Release 1 da aplicação
 */
public class TutoriaDAOImpl extends AbstractHibernateDAO implements TutoriaDAO {

	/**
	 * Instantiates a new tutoria dao impl.
	 *
	 * @param persistenceContext the persistence context
	 */
	public TutoriaDAOImpl(HibernatePersistenceContext persistenceContext) {
		super(persistenceContext);
		
	}

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.TutoriaDAO#listAll()
	 */
	public List<Tutoria> listAll() {
		
		Criteria criteria = getSession().createCriteria(Tutoria.class);
		List<Tutoria> result = criteria.list();
		
		
		return result;
	} 
	

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.TutoriaDAO#criar(br.com.muranodesign.model.Tutoria)
	 */
	public void criar(Tutoria c) {
		synchronized (TutoriaDAOImpl.class) {
			getSession().persist(c);
			getSession().flush();

		}
	}

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.TutoriaDAO#deletar(br.com.muranodesign.model.Tutoria)
	 */
	public void deletar(Tutoria c) {
		getSession().delete(c);
		getSession().flush();
	}

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.TutoriaDAO#atualizar(br.com.muranodesign.model.Tutoria)
	 */
	public void atualizar(Tutoria p) {
		getSession().merge(p);
		getSession().flush();
	}
	
	
	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.TutoriaDAO#listarKey(int)
	 */
	public List<Tutoria> listarKey(int key){
		Criteria criteria = getSession().createCriteria(Tutoria.class);
		criteria.add(Restrictions.eq("idtutoria", key));
		List<Tutoria> result = criteria.list();
		return result;
	}


	





	

}