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

import br.com.muranodesign.dao.AlunoVariavelDAO;
import br.com.muranodesign.hibernate.AbstractHibernateDAO;
import br.com.muranodesign.hibernate.HibernatePersistenceContext;
import br.com.muranodesign.model.AlunoVariavel;



/**
 * Abstração do dao e implementação do GRUD
 *
 * @author Rogerio Lima dos Santos
 * @version 1.00
 * @since Release 1 da aplicação
 */
public class AlunoVariavelDAOImpl extends AbstractHibernateDAO implements AlunoVariavelDAO {

	/**
	 * Instantiates a new aluno variavel dao impl.
	 *
	 * @param persistenceContext the persistence context
	 */
	public AlunoVariavelDAOImpl(HibernatePersistenceContext persistenceContext) {
		super(persistenceContext);
		
	}

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.AlunoVariavelDAO#listAll()
	 */
	public List<AlunoVariavel> listAll() {
		
		Criteria criteria = getSession().createCriteria(AlunoVariavel.class);
		
		//criteria.createAlias("grupo", "grupo");
		
		
		//criteria.addOrder(Order.desc("grupo.nomeGrupo"));
		
		List<AlunoVariavel> result = criteria.list();
		
		
		return result;
	} 
	

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.AlunoVariavelDAO#listAll()
	 */
	public List<AlunoVariavel> listAll(int status) {
		
		Criteria criteria = getSession().createCriteria(AlunoVariavel.class);
		
		criteria.add(Restrictions.eq("ativo", status));
		
		
		//criteria.addOrder(Order.desc("grupo.nomeGrupo"));
		
		List<AlunoVariavel> result = criteria.list();
		
		
		return result;
	} 
	

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.AlunoVariavelDAO#criar(br.com.muranodesign.model.AlunoVariavel)
	 */
	public void criar(AlunoVariavel c) {
		synchronized (AlunoVariavelDAOImpl.class) {
			getSession().persist(c);
			getSession().flush();

		}
	}

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.AlunoVariavelDAO#deletar(br.com.muranodesign.model.AlunoVariavel)
	 */
	public void deletar(AlunoVariavel c) {
		getSession().delete(c);
		getSession().flush();
	}

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.AlunoVariavelDAO#atualizar(br.com.muranodesign.model.AlunoVariavel)
	 */
	public void atualizar(AlunoVariavel p) {
		getSession().merge(p);
		getSession().flush();
	}
	
	
	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.AlunoVariavelDAO#listarKey(int)
	 */
	public List<AlunoVariavel> listarKey(int key){
		Criteria criteria = getSession().createCriteria(AlunoVariavel.class);
		criteria.add(Restrictions.eq("idalunoVariavel", key));
		List<AlunoVariavel> result = criteria.list();
		return result;
	}
	
	public List<AlunoVariavel> listaAluno(int idAluno){
		Criteria criteria = getSession().createCriteria(AlunoVariavel.class);
		criteria.createAlias("aluno", "aluno");
		criteria.add(Restrictions.eq("aluno.idAluno", idAluno));
		List<AlunoVariavel> result = criteria.list();
		return result;
	}
	
	
	public List<AlunoVariavel> listaGrupo(int idGrupo){
		Criteria criteria = getSession().createCriteria(AlunoVariavel.class);
		criteria.createAlias("grupo", "grupo");
		criteria.add(Restrictions.eq("grupo.idgrupo", idGrupo));
		List<AlunoVariavel> result = criteria.list();
		return result;
	}

	@Override
	public AlunoVariavel getAluno(int aluno) {
		
		Criteria criteria = getSession().createCriteria(AlunoVariavel.class);

		//criteria.createAlias("aluno", "aluno");
		
		//criteria.addOrder(Order.desc("aluno.idAluno"));
		
	    criteria.add(Restrictions.eq("idalunoVariavel", aluno));
		List<AlunoVariavel> result = criteria.list();
		
		if (result.isEmpty()) {
			return null;
		}else {
			return result.get(0);
		}
		
		
	}

	




	

}