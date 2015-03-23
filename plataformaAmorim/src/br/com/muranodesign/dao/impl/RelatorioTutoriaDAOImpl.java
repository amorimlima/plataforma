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

import br.com.muranodesign.dao.RelatorioTutoriaDAO;
import br.com.muranodesign.hibernate.AbstractHibernateDAO;
import br.com.muranodesign.hibernate.HibernatePersistenceContext;
import br.com.muranodesign.model.RelatorioTutoria;



/**
 * Abstração do dao e implementação do GRUD
 *
 * @author Rogerio Lima dos Santos
 * @version 1.00
 * @since Release 1 da aplicação
 */
public class RelatorioTutoriaDAOImpl extends AbstractHibernateDAO implements RelatorioTutoriaDAO {

	/**
	 * Instantiates a new relatorio tutoria dao impl.
	 *
	 * @param persistenceContext the persistence context
	 */
	public RelatorioTutoriaDAOImpl(HibernatePersistenceContext persistenceContext) {
		super(persistenceContext);
		
	}

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.RelatorioTutoriaDAO#listAll()
	 */
	public List<RelatorioTutoria> listAll() {
		
		Criteria criteria = getSession().createCriteria(RelatorioTutoria.class);
		List<RelatorioTutoria> result = criteria.list();
		
		
		return result;
	} 
	

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.RelatorioTutoriaDAO#criar(br.com.muranodesign.model.RelatorioTutoria)
	 */
	public void criar(RelatorioTutoria c) {
		synchronized (RelatorioTutoriaDAOImpl.class) {
			getSession().persist(c);
			getSession().flush();

		}
	}

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.RelatorioTutoriaDAO#deletar(br.com.muranodesign.model.RelatorioTutoria)
	 */
	public void deletar(RelatorioTutoria c) {
		getSession().delete(c);
		getSession().flush();
	}

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.RelatorioTutoriaDAO#atualizar(br.com.muranodesign.model.RelatorioTutoria)
	 */
	public void atualizar(RelatorioTutoria p) {
		getSession().merge(p);
		getSession().flush();
	}
	
	
	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.RelatorioTutoriaDAO#listarKey(int)
	 */
	public List<RelatorioTutoria> listarKey(int key){
		Criteria criteria = getSession().createCriteria(RelatorioTutoria.class);
		criteria.add(Restrictions.eq("idrelatorioTutoria", key));
		List<RelatorioTutoria> result = criteria.list();
		return result;
	}


	





	

}