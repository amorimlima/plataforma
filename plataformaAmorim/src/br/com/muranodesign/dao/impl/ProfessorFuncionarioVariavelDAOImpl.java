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

import br.com.muranodesign.dao.ProfessorFuncionarioVariavelDAO;
import br.com.muranodesign.hibernate.AbstractHibernateDAO;
import br.com.muranodesign.hibernate.HibernatePersistenceContext;
import br.com.muranodesign.model.ProfessorFuncionarioVariavel;



/**
 * Abstração do dao e implementação do GRUD
 *
 * @author Rogerio Lima dos Santos
 * @version 1.00
 * @since Release 1 da aplicação
 */
public class ProfessorFuncionarioVariavelDAOImpl extends AbstractHibernateDAO implements ProfessorFuncionarioVariavelDAO {

	/**
	 * Instantiates a new professor funcionario variavel dao impl.
	 *
	 * @param persistenceContext the persistence context
	 */
	public ProfessorFuncionarioVariavelDAOImpl(HibernatePersistenceContext persistenceContext) {
		super(persistenceContext);
		
	}

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.ProfessorFuncionarioVariavelDAO#listAll()
	 */
	public List<ProfessorFuncionarioVariavel> listAll() {
		
		Criteria criteria = getSession().createCriteria(ProfessorFuncionarioVariavel.class);
		List<ProfessorFuncionarioVariavel> result = criteria.list();
		
		
		return result;
	} 
	
	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.ProfessorFuncionarioVariavelDAO#listAll()
	 */
	public List<ProfessorFuncionarioVariavel> listAll(int status) {
		
		Criteria criteria = getSession().createCriteria(ProfessorFuncionarioVariavel.class);
		criteria.add(Restrictions.eq("ativo", status));
		List<ProfessorFuncionarioVariavel> result = criteria.list();
		
		
		return result;
	} 
	

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.ProfessorFuncionarioVariavelDAO#criar(br.com.muranodesign.model.ProfessorFuncionarioVariavel)
	 */
	public void criar(ProfessorFuncionarioVariavel c) {
		synchronized (ProfessorFuncionarioVariavelDAOImpl.class) {
			getSession().persist(c);
			getSession().flush();

		}
	}

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.ProfessorFuncionarioVariavelDAO#deletar(br.com.muranodesign.model.ProfessorFuncionarioVariavel)
	 */
	public void deletar(ProfessorFuncionarioVariavel c) {
		getSession().delete(c);
		getSession().flush();
	}

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.ProfessorFuncionarioVariavelDAO#atualizar(br.com.muranodesign.model.ProfessorFuncionarioVariavel)
	 */
	public void atualizar(ProfessorFuncionarioVariavel p) {
		getSession().merge(p);
		getSession().flush();
	}
	
	
	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.ProfessorFuncionarioVariavelDAO#listarKey(int)
	 */
	public List<ProfessorFuncionarioVariavel> listarKey(int key){
		Criteria criteria = getSession().createCriteria(ProfessorFuncionarioVariavel.class);
		criteria.add(Restrictions.eq("idprofessorFuncionarioVariavel", key));
		List<ProfessorFuncionarioVariavel> result = criteria.list();
		return result;
	}

	
}