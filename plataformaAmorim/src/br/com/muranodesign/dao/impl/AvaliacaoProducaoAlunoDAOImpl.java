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

import br.com.muranodesign.dao.AvaliacaoProducaoAlunoDAO;
import br.com.muranodesign.hibernate.AbstractHibernateDAO;
import br.com.muranodesign.hibernate.HibernatePersistenceContext;
import br.com.muranodesign.model.AvaliacaoProducaoAluno;



/**
 * Abstração do dao e implementação do GRUD
 *
 * @author Rogerio Lima dos Santos
 * @version 1.00
 * @since Release 1 da aplicação
 */
public class AvaliacaoProducaoAlunoDAOImpl extends AbstractHibernateDAO implements AvaliacaoProducaoAlunoDAO {

	/**
	 * Instantiates a new avaliacao producao aluno dao impl.
	 *
	 * @param persistenceContext the persistence context
	 */
	public AvaliacaoProducaoAlunoDAOImpl(HibernatePersistenceContext persistenceContext) {
		super(persistenceContext);
		
	}

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.AvaliacaoProducaoAlunoDAO#listAll()
	 */
	public List<AvaliacaoProducaoAluno> listAll() {
		
		Criteria criteria = getSession().createCriteria(AvaliacaoProducaoAluno.class);
		List<AvaliacaoProducaoAluno> result = criteria.list();
		
		
		return result;
	} 
	

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.AvaliacaoProducaoAlunoDAO#criar(br.com.muranodesign.model.AvaliacaoProducaoAluno)
	 */
	public void criar(AvaliacaoProducaoAluno c) {
		synchronized (AvaliacaoProducaoAlunoDAOImpl.class) {
			getSession().persist(c);
			getSession().flush();

		}
	}

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.AvaliacaoProducaoAlunoDAO#deletar(br.com.muranodesign.model.AvaliacaoProducaoAluno)
	 */
	public void deletar(AvaliacaoProducaoAluno c) {
		getSession().delete(c);
		getSession().flush();
	}

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.AvaliacaoProducaoAlunoDAO#atualizar(br.com.muranodesign.model.AvaliacaoProducaoAluno)
	 */
	public void atualizar(AvaliacaoProducaoAluno p) {
		getSession().merge(p);
		getSession().flush();
	}
	
	
	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.AvaliacaoProducaoAlunoDAO#listarKey(int)
	 */
	public List<AvaliacaoProducaoAluno> listarKey(int key){
		Criteria criteria = getSession().createCriteria(AvaliacaoProducaoAluno.class);
		criteria.add(Restrictions.eq("idavaliacaoProducaoAluno", key));
		List<AvaliacaoProducaoAluno> result = criteria.list();
		return result;
	}

	/**
	 * Listar avaliacao producao aluno.
	 *
	 * @param AvaliacaoProducaoAluno the avaliacao producao aluno
	 * @return the list
	 */
	public List<AvaliacaoProducaoAluno> listarAvaliacaoProducaoAluno(String AvaliacaoProducaoAluno) {
		
		Criteria criteria = getSession().createCriteria(AvaliacaoProducaoAluno.class);
		//criteria.add(Restrictions.eq("userName", user));
		//.add(Order.asc("alarmeLevel"));
		List<AvaliacaoProducaoAluno> result = criteria.list();
		
		
		return result;
	}

	





	

}