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

import br.com.muranodesign.dao.TipoRecursoAprendizagemDAO;
import br.com.muranodesign.hibernate.AbstractHibernateDAO;
import br.com.muranodesign.hibernate.HibernatePersistenceContext;
import br.com.muranodesign.model.TipoRecursoAprendizagem;



/**
 * Abstração do dao e implementação do GRUD
 *
 * @author Rogerio Lima dos Santos
 * @version 1.00
 * @since Release 1 da aplicação
 */
public class TipoRecursoAprendizagemDAOImpl extends AbstractHibernateDAO implements TipoRecursoAprendizagemDAO {

	/**
	 * Instantiates a new tipo recurso aprendizagem dao impl.
	 *
	 * @param persistenceContext the persistence context
	 */
	public TipoRecursoAprendizagemDAOImpl(HibernatePersistenceContext persistenceContext) {
		super(persistenceContext);
		
	}

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.TipoRecursoAprendizagemDAO#listAll()
	 */
	public List<TipoRecursoAprendizagem> listAll() {
		
		Criteria criteria = getSession().createCriteria(TipoRecursoAprendizagem.class);
		List<TipoRecursoAprendizagem> result = criteria.list();
		
		
		return result;
	} 
	

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.TipoRecursoAprendizagemDAO#criar(br.com.muranodesign.model.TipoRecursoAprendizagem)
	 */
	public void criar(TipoRecursoAprendizagem c) {
		synchronized (TipoRecursoAprendizagemDAOImpl.class) {
			getSession().persist(c);
			getSession().flush();

		}
	}

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.TipoRecursoAprendizagemDAO#deletar(br.com.muranodesign.model.TipoRecursoAprendizagem)
	 */
	public void deletar(TipoRecursoAprendizagem c) {
		getSession().delete(c);
		getSession().flush();
	}

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.TipoRecursoAprendizagemDAO#atualizar(br.com.muranodesign.model.TipoRecursoAprendizagem)
	 */
	public void atualizar(TipoRecursoAprendizagem p) {
		getSession().merge(p);
		getSession().flush();
	}
	
	
	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.TipoRecursoAprendizagemDAO#listarKey(int)
	 */
	public List<TipoRecursoAprendizagem> listarKey(int key){
		Criteria criteria = getSession().createCriteria(TipoRecursoAprendizagem.class);
		criteria.add(Restrictions.eq("idtipoRecursoAprendizagem", key));
		List<TipoRecursoAprendizagem> result = criteria.list();
		return result;
	}

	





	

}