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

import br.com.muranodesign.dao.AlunoDAO;
import br.com.muranodesign.hibernate.AbstractHibernateDAO;
import br.com.muranodesign.hibernate.HibernatePersistenceContext;
import br.com.muranodesign.model.Aluno;

/**
 * Abstração do dao e implementação do GRUD
 *
 * @author Rogerio Lima dos Santos
 * @version 1.00
 * @since Release 1 da aplicação
 */

public class AlunoDAOImpl extends AbstractHibernateDAO implements AlunoDAO {

	/**
	 * Instantiates a new aluno dao impl.
	 *
	 * @param persistenceContext the persistence context
	 */
	public AlunoDAOImpl(HibernatePersistenceContext persistenceContext) {
		super(persistenceContext);
		
	}

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.AlunoDAO#listAll()
	 */
	public List<Aluno> listAll() {
		
		Criteria criteria = getSession().createCriteria(Aluno.class);
		List<Aluno> result = criteria.list();
		
		
		return result;
	} 
	

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.AlunoDAO#criar(br.com.muranodesign.model.Aluno)
	 */
	public void criar(Aluno c) {
		synchronized (AlunoDAOImpl.class) {
			getSession().persist(c);
			getSession().flush();

		}
	}

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.AlunoDAO#deletar(br.com.muranodesign.model.Aluno)
	 */
	public void deletar(Aluno c) {
		getSession().delete(c);
		getSession().flush();
	}

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.AlunoDAO#atualizar(br.com.muranodesign.model.Aluno)
	 */
	public void atualizar(Aluno p) {
		getSession().merge(p);
		getSession().flush();
	}
	
	
	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.AlunoDAO#listarKey(int)
	 */
	public List<Aluno> listarKey(int key){
		Criteria criteria = getSession().createCriteria(Aluno.class);
		criteria.add(Restrictions.eq("idAluno", key));
		List<Aluno> result = criteria.list();
		return result;
	}

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.AlunoDAO#listarAluno(java.lang.String)
	 */
	public List<Aluno> listarAluno(String user) {
		
		Criteria criteria = getSession().createCriteria(Aluno.class);
		criteria.add(Restrictions.eq("userName", user));
		//.add(Order.asc("alarmeLevel"));
		List<Aluno> result = criteria.list();
		
		
		return result;
	}





	

}