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

import br.com.muranodesign.dao.AtividadeDAO;
import br.com.muranodesign.hibernate.AbstractHibernateDAO;
import br.com.muranodesign.hibernate.HibernatePersistenceContext;
import br.com.muranodesign.model.Atividade;



/**
 * Abstração do dao e implementação do GRUD
 *
 * @author Rogerio Lima dos Santos
 * @version 1.00
 * @since Release 1 da aplicação
 */
public class AtividadeDAOImpl extends AbstractHibernateDAO implements AtividadeDAO {

	/**
	 * Instantiates a new atividade dao impl.
	 *
	 * @param persistenceContext the persistence context
	 */
	public AtividadeDAOImpl(HibernatePersistenceContext persistenceContext) {
		super(persistenceContext);
		
	}

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.AtividadeDAO#listAll()
	 */
	public List<Atividade> listAll() {
		
		Criteria criteria = getSession().createCriteria(Atividade.class);
		criteria.add(Restrictions.eq("ativo",1));
		List<Atividade> result = criteria.list();
		
		
		return result;
	} 
	

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.AtividadeDAO#criar(br.com.muranodesign.model.Atividade)
	 */
	public void criar(Atividade c) {
		synchronized (AtividadeDAOImpl.class) {
			getSession().persist(c);
			getSession().flush();

		}
	}

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.AtividadeDAO#deletar(br.com.muranodesign.model.Atividade)
	 */
	public void deletar(Atividade c) {
		getSession().delete(c);
		getSession().flush();
	}

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.AtividadeDAO#atualizar(br.com.muranodesign.model.Atividade)
	 */
	public void atualizar(Atividade p) {
		getSession().merge(p);
		getSession().flush();
	}
	
	
	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.AtividadeDAO#listarKey(int)
	 */
	public List<Atividade> listarKey(int key){
		Criteria criteria = getSession().createCriteria(Atividade.class);
		criteria.add(Restrictions.eq("idatividade", key));
		List<Atividade> result = criteria.list();
		return result;
	}

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.AtividadeDAO#listarAtividade(java.lang.String)
	 */
	public List<Atividade> listarAtividade(String atividade) {
		
		Criteria criteria = getSession().createCriteria(Atividade.class);
		//criteria.add(Restrictions.eq("userName", user));
		//.add(Order.asc("alarmeLevel"));
		List<Atividade> result = criteria.list();
		
		
		return result;
	}

	





	

}