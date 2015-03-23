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
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import br.com.muranodesign.dao.PlanoEstudoDAO;
import br.com.muranodesign.hibernate.AbstractHibernateDAO;
import br.com.muranodesign.hibernate.HibernatePersistenceContext;
import br.com.muranodesign.model.PlanoEstudo;


/**
 * Abstração do dao e implementação do GRUD
 *
 * @author Rogerio Lima dos Santos
 * @version 1.00
 * @since Release 1 da aplicação
 */
public class PlanoEstudoDAOImpl extends AbstractHibernateDAO implements PlanoEstudoDAO {

	/**
	 * Instantiates a new plano estudo dao impl.
	 *
	 * @param persistenceContext the persistence context
	 */
	public PlanoEstudoDAOImpl(HibernatePersistenceContext persistenceContext) {
		super(persistenceContext);
		
	}

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.PlanoEstudoDAO#listAll()
	 */
	public List<PlanoEstudo> listAll() {
		
		Criteria criteria = getSession().createCriteria(PlanoEstudo.class);
		List<PlanoEstudo> result = criteria.list();
		
		
		return result;
	} 
	

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.PlanoEstudoDAO#criar(br.com.muranodesign.model.PlanoEstudo)
	 */
	public void criar(PlanoEstudo c) {
		synchronized (PlanoEstudoDAOImpl.class) {
			getSession().persist(c);
			getSession().flush();

		}
	}

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.PlanoEstudoDAO#deletar(br.com.muranodesign.model.PlanoEstudo)
	 */
	public void deletar(PlanoEstudo c) {
		getSession().delete(c);
		getSession().flush();
	}

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.PlanoEstudoDAO#atualizar(br.com.muranodesign.model.PlanoEstudo)
	 */
	public void atualizar(PlanoEstudo p) {
		getSession().merge(p);
		getSession().flush();
	}
	
	
	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.PlanoEstudoDAO#listarKey(int)
	 */
	public List<PlanoEstudo> listarKey(int key){
		Criteria criteria = getSession().createCriteria(PlanoEstudo.class);
		criteria.add(Restrictions.eq("idplanoEstudo", key));
		List<PlanoEstudo> result = criteria.list();
		return result;
	}


	
	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.PlanoEstudoDAO#listarKey(int)
	 */
	public List<PlanoEstudo> utimoPlanoEstudos(int idAluno){
		
		Criteria criteria = getSession().createCriteria(PlanoEstudo.class);
		criteria.createAlias("aluno", "aluno");
		
		Criteria criteria2 = getSession().createCriteria(PlanoEstudo.class);
		criteria2.createAlias("aluno", "aluno");
		
		
		criteria2.add(Restrictions.eq("aluno.idAluno", idAluno));
		criteria2.setProjection(Projections.max("dataInicio")); 
		
		
		criteria.add(Restrictions.eq("aluno.idAluno", idAluno));
		criteria.add(Restrictions.eq("dataInicio", criteria2.uniqueResult()));
		
		
		///criteria.add(Restrictions.eq("idplanoEstudo.idAluno", idAluno));
		
		//return (Integer) c.uniqueResult();  
		
		
		//criteria.add(Restrictions.eq("idplanoEstudo", key));
		List<PlanoEstudo> result = criteria.list();
		return result;
	}

	

}