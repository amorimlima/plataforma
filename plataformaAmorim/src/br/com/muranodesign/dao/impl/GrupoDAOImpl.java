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

import br.com.muranodesign.dao.GrupoDAO;
import br.com.muranodesign.hibernate.AbstractHibernateDAO;
import br.com.muranodesign.hibernate.HibernatePersistenceContext;
import br.com.muranodesign.model.Grupo;



/**
 * Abstração do dao e implementação do GRUD
 *
 * @author Rogerio Lima dos Santos
 * @version 1.00
 * @since Release 1 da aplicação
 */
public class GrupoDAOImpl extends AbstractHibernateDAO implements GrupoDAO {

	/**
	 * Instantiates a new grupo dao impl.
	 *
	 * @param persistenceContext the persistence context
	 */
	public GrupoDAOImpl(HibernatePersistenceContext persistenceContext) {
		super(persistenceContext);
		
	}

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.GrupoDAO#listAll()
	 */
	public List<Grupo> listAll() {
		
		Criteria criteria = getSession().createCriteria(Grupo.class);
		List<Grupo> result = criteria.list();
		
		
		return result;
	} 
	

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.GrupoDAO#criar(br.com.muranodesign.model.Grupo)
	 */
	public void criar(Grupo c) {
		synchronized (GrupoDAOImpl.class) {
			getSession().persist(c);
			getSession().flush();

		}
	}

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.GrupoDAO#deletar(br.com.muranodesign.model.Grupo)
	 */
	public void deletar(Grupo c) {
		getSession().delete(c);
		getSession().flush();
	}

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.GrupoDAO#atualizar(br.com.muranodesign.model.Grupo)
	 */
	public void atualizar(Grupo p) {
		getSession().merge(p);
		getSession().flush();
	}
	
	
	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.GrupoDAO#listarKey(int)
	 */
	public List<Grupo> listarKey(int key){
		Criteria criteria = getSession().createCriteria(Grupo.class);
		criteria.add(Restrictions.eq("idgrupo", key));
		List<Grupo> result = criteria.list();
		return result;
	}

	





	

}