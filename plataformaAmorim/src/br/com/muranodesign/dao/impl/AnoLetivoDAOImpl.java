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

import br.com.muranodesign.dao.AnoLetivoDAO;
import br.com.muranodesign.hibernate.AbstractHibernateDAO;
import br.com.muranodesign.hibernate.HibernatePersistenceContext;
import br.com.muranodesign.model.AnoLetivo;



/**
 * Abstração do dao e implementação do GRUD
 *
 * @author Rogerio Lima dos Santos
 * @version 1.00
 * @since Release 1 da aplicação
 */
public class AnoLetivoDAOImpl extends AbstractHibernateDAO implements AnoLetivoDAO {

	/**
	 * Instantiates a new ano letivo dao impl.
	 *
	 * @param persistenceContext the persistence context
	 */
	public AnoLetivoDAOImpl(HibernatePersistenceContext persistenceContext) {
		super(persistenceContext);
		
	}

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.AnoLetivoDAO#listAll()
	 */
	public List<AnoLetivo> listAll() {
		
		Criteria criteria = getSession().createCriteria(AnoLetivo.class);
		List<AnoLetivo> result = criteria.list();
		
		
		return result;
	} 
	

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.AnoLetivoDAO#criar(br.com.muranodesign.model.AnoLetivo)
	 */
	public void criar(AnoLetivo c) {
		synchronized (AnoLetivoDAOImpl.class) {
			getSession().persist(c);
			getSession().flush();

		}
	}

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.AnoLetivoDAO#deletar(br.com.muranodesign.model.AnoLetivo)
	 */
	public void deletar(AnoLetivo c) {
		getSession().delete(c);
		getSession().flush();
	}

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.AnoLetivoDAO#atualizar(br.com.muranodesign.model.AnoLetivo)
	 */
	public void atualizar(AnoLetivo p) {
		getSession().merge(p);
		getSession().flush();
	}
	
	
	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.AnoLetivoDAO#listarKey(int)
	 */
	public List<AnoLetivo> listarKey(int key){
		Criteria criteria = getSession().createCriteria(AnoLetivo.class);
		criteria.add(Restrictions.eq("idanoLetivo", key));
		List<AnoLetivo> result = criteria.list();
		return result;
	}

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.AnoLetivoDAO#listarAnoLetivo(java.lang.String)
	 */
	public List<AnoLetivo> listarAnoLetivo(String anoLetivo) {
		
		Criteria criteria = getSession().createCriteria(AnoLetivo.class);
		criteria.add(Restrictions.eq("anoLetivo", anoLetivo));
		List<AnoLetivo> result = criteria.list();
		
		
		return result;
	}





	

}