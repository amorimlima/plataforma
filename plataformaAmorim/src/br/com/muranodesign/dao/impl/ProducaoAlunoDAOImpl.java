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

import br.com.muranodesign.dao.ProducaoAlunoDAO;
import br.com.muranodesign.hibernate.AbstractHibernateDAO;
import br.com.muranodesign.hibernate.HibernatePersistenceContext;
import br.com.muranodesign.model.ProducaoAluno;



/**
 * Abstração do dao e implementação do GRUD
 *
 * @author Rogerio Lima dos Santos
 * @version 1.00
 * @since Release 1 da aplicação
 */
public class ProducaoAlunoDAOImpl extends AbstractHibernateDAO implements ProducaoAlunoDAO {

	/**
	 * Instantiates a new producao aluno dao impl.
	 *
	 * @param persistenceContext the persistence context
	 */
	public ProducaoAlunoDAOImpl(HibernatePersistenceContext persistenceContext) {
		super(persistenceContext);
		
	}

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.ProducaoAlunoDAO#listAll()
	 */
	public List<ProducaoAluno> listAll() {
		
		Criteria criteria = getSession().createCriteria(ProducaoAluno.class);
		List<ProducaoAluno> result = criteria.list();
		
		
		return result;
	} 
	

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.ProducaoAlunoDAO#criar(br.com.muranodesign.model.ProducaoAluno)
	 */
	public void criar(ProducaoAluno c) {
		synchronized (ProducaoAlunoDAOImpl.class) {
			getSession().persist(c);
			getSession().flush();

		}
	}

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.ProducaoAlunoDAO#deletar(br.com.muranodesign.model.ProducaoAluno)
	 */
	public void deletar(ProducaoAluno c) {
		getSession().delete(c);
		getSession().flush();
	}

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.ProducaoAlunoDAO#atualizar(br.com.muranodesign.model.ProducaoAluno)
	 */
	public void atualizar(ProducaoAluno p) {
		getSession().merge(p);
		getSession().flush();
	}
	
	
	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.ProducaoAlunoDAO#listarKey(int)
	 */
	public List<ProducaoAluno> listarKey(int key){
		Criteria criteria = getSession().createCriteria(ProducaoAluno.class);
		criteria.add(Restrictions.eq("idproducaoAluno", key));
		List<ProducaoAluno> result = criteria.list();
		return result;
	}

		

}