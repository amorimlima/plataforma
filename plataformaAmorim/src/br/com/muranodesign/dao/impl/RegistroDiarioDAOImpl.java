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

import br.com.muranodesign.dao.RegistroDiarioDAO;
import br.com.muranodesign.hibernate.AbstractHibernateDAO;
import br.com.muranodesign.hibernate.HibernatePersistenceContext;
import br.com.muranodesign.model.RegistroDiario;



/**
 * Abstração do dao e implementação do GRUD
 *
 * @author Rogerio Lima dos Santos
 * @version 1.00
 * @since Release 1 da aplicação
 */
public class RegistroDiarioDAOImpl extends AbstractHibernateDAO implements RegistroDiarioDAO {

	/**
	 * Instantiates a new registro diario dao impl.
	 *
	 * @param persistenceContext the persistence context
	 */
	public RegistroDiarioDAOImpl(HibernatePersistenceContext persistenceContext) {
		super(persistenceContext);
		
	}

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.RegistroDiarioDAO#listAll()
	 */
	public List<RegistroDiario> listAll() {
		
		Criteria criteria = getSession().createCriteria(RegistroDiario.class);
		List<RegistroDiario> result = criteria.list();
		
		
		return result;
	} 
	

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.RegistroDiarioDAO#criar(br.com.muranodesign.model.RegistroDiario)
	 */
	public void criar(RegistroDiario c) {
		synchronized (RegistroDiarioDAOImpl.class) {
			getSession().persist(c);
			getSession().flush();

		}
	}

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.RegistroDiarioDAO#deletar(br.com.muranodesign.model.RegistroDiario)
	 */
	public void deletar(RegistroDiario c) {
		getSession().delete(c);
		getSession().flush();
	}

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.RegistroDiarioDAO#atualizar(br.com.muranodesign.model.RegistroDiario)
	 */
	public void atualizar(RegistroDiario p) {
		getSession().merge(p);
		getSession().flush();
	}
	
	
	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.RegistroDiarioDAO#listarKey(int)
	 */
	public List<RegistroDiario> listarKey(int key){
		Criteria criteria = getSession().createCriteria(RegistroDiario.class);
		criteria.add(Restrictions.eq("idregistroDiario", key));
		List<RegistroDiario> result = criteria.list();
		return result;
	}






	

}