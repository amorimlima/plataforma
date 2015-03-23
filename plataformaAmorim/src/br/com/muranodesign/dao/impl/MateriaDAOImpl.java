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

import br.com.muranodesign.dao.MateriaDAO;
import br.com.muranodesign.hibernate.AbstractHibernateDAO;
import br.com.muranodesign.hibernate.HibernatePersistenceContext;
import br.com.muranodesign.model.Materia;



/**
 * Abstração do dao e implementação do GRUD
 *
 * @author Rogerio Lima dos Santos
 * @version 1.00
 * @since Release 1 da aplicação
 */
public class MateriaDAOImpl extends AbstractHibernateDAO implements MateriaDAO {

	/**
	 * Instantiates a new materia dao impl.
	 *
	 * @param persistenceContext the persistence context
	 */
	public MateriaDAOImpl(HibernatePersistenceContext persistenceContext) {
		super(persistenceContext);
		
	}

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.MateriaDAO#listAll()
	 */
	public List<Materia> listAll() {
		
		Criteria criteria = getSession().createCriteria(Materia.class);
		List<Materia> result = criteria.list();
		
		
		return result;
	} 
	

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.MateriaDAO#criar(br.com.muranodesign.model.Materia)
	 */
	public void criar(Materia c) {
		synchronized (MateriaDAOImpl.class) {
			getSession().persist(c);
			getSession().flush();

		}
	}

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.MateriaDAO#deletar(br.com.muranodesign.model.Materia)
	 */
	public void deletar(Materia c) {
		getSession().delete(c);
		getSession().flush();
	}

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.MateriaDAO#atualizar(br.com.muranodesign.model.Materia)
	 */
	public void atualizar(Materia p) {
		getSession().merge(p);
		getSession().flush();
	}
	
	
	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.MateriaDAO#listarKey(int)
	 */
	public List<Materia> listarKey(int key){
		Criteria criteria = getSession().createCriteria(Materia.class);
		criteria.add(Restrictions.eq("idmateria", key));
		List<Materia> result = criteria.list();
		return result;
	}





	

}