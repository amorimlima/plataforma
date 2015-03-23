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

import br.com.muranodesign.dao.TipoProducaoAlunoDAO;
import br.com.muranodesign.hibernate.AbstractHibernateDAO;
import br.com.muranodesign.hibernate.HibernatePersistenceContext;
import br.com.muranodesign.model.TipoProducaoAluno;



/**
 * Abstração do dao e implementação do GRUD
 *
 * @author Rogerio Lima dos Santos
 * @version 1.00
 * @since Release 1 da aplicação
 */
public class TipoProducaoAlunoDAOImpl extends AbstractHibernateDAO implements TipoProducaoAlunoDAO {

	/**
	 * Instantiates a new tipo producao aluno dao impl.
	 *
	 * @param persistenceContext the persistence context
	 */
	public TipoProducaoAlunoDAOImpl(HibernatePersistenceContext persistenceContext) {
		super(persistenceContext);
		
	}

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.TipoProducaoAlunoDAO#listAll()
	 */
	public List<TipoProducaoAluno> listAll() {
		
		Criteria criteria = getSession().createCriteria(TipoProducaoAluno.class);
		List<TipoProducaoAluno> result = criteria.list();
		
		
		return result;
	} 
	

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.TipoProducaoAlunoDAO#criar(br.com.muranodesign.model.TipoProducaoAluno)
	 */
	public void criar(TipoProducaoAluno c) {
		synchronized (TipoProducaoAlunoDAOImpl.class) {
			getSession().persist(c);
			getSession().flush();

		}
	}

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.TipoProducaoAlunoDAO#deletar(br.com.muranodesign.model.TipoProducaoAluno)
	 */
	public void deletar(TipoProducaoAluno c) {
		getSession().delete(c);
		getSession().flush();
	}

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.TipoProducaoAlunoDAO#atualizar(br.com.muranodesign.model.TipoProducaoAluno)
	 */
	public void atualizar(TipoProducaoAluno p) {
		getSession().merge(p);
		getSession().flush();
	}
	
	
	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.TipoProducaoAlunoDAO#listarKey(int)
	 */
	public List<TipoProducaoAluno> listarKey(int key){
		Criteria criteria = getSession().createCriteria(TipoProducaoAluno.class);
		criteria.add(Restrictions.eq("idtipoProducaoAluno", key));
		List<TipoProducaoAluno> result = criteria.list();
		return result;
	}

	

	





	

}