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

import br.com.muranodesign.dao.PresencaProfessorDAO;
import br.com.muranodesign.hibernate.AbstractHibernateDAO;
import br.com.muranodesign.hibernate.HibernatePersistenceContext;
import br.com.muranodesign.model.PresencaProfessor;



/**
 * Abstração do dao e implementação do GRUD
 *
 * @author Rogerio Lima dos Santos
 * @version 1.00
 * @since Release 1 da aplicação
 */
public class PresencaProfessorDAOImpl extends AbstractHibernateDAO implements PresencaProfessorDAO {

	/**
	 * Instantiates a new presenca professor dao impl.
	 *
	 * @param persistenceContext the persistence context
	 */
	public PresencaProfessorDAOImpl(HibernatePersistenceContext persistenceContext) {
		super(persistenceContext);
		
	}

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.PresencaProfessorDAO#listAll()
	 */
	public List<PresencaProfessor> listAll() {
		
		Criteria criteria = getSession().createCriteria(PresencaProfessor.class);
		List<PresencaProfessor> result = criteria.list();
		
		
		return result;
	} 
	

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.PresencaProfessorDAO#criar(br.com.muranodesign.model.PresencaProfessor)
	 */
	public void criar(PresencaProfessor c) {
		synchronized (PresencaProfessorDAOImpl.class) {
			getSession().persist(c);
			getSession().flush();

		}
	}

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.PresencaProfessorDAO#deletar(br.com.muranodesign.model.PresencaProfessor)
	 */
	public void deletar(PresencaProfessor c) {
		getSession().delete(c);
		getSession().flush();
	}

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.PresencaProfessorDAO#atualizar(br.com.muranodesign.model.PresencaProfessor)
	 */
	public void atualizar(PresencaProfessor p) {
		getSession().merge(p);
		getSession().flush();
	}
	
	
	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.PresencaProfessorDAO#listarKey(int)
	 */
	public List<PresencaProfessor> listarKey(int key){
		Criteria criteria = getSession().createCriteria(PresencaProfessor.class);
		criteria.add(Restrictions.eq("idpresencaProfessor", key));
		List<PresencaProfessor> result = criteria.list();
		return result;
	}






	

}