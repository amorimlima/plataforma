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

import br.com.muranodesign.dao.ChamadaDAO;
import br.com.muranodesign.hibernate.AbstractHibernateDAO;
import br.com.muranodesign.hibernate.HibernatePersistenceContext;
import br.com.muranodesign.model.Aluno;
import br.com.muranodesign.model.Chamada;



/**
 * Abstração do dao e implementação do GRUD
 *
 * @author Rogerio Lima dos Santos
 * @version 1.00
 * @since Release 1 da aplicação
 */
public class ChamadaDAOImpl extends AbstractHibernateDAO implements ChamadaDAO {

	/**
	 * Instantiates a new chamada dao impl.
	 *
	 * @param persistenceContext the persistence context
	 */
	public ChamadaDAOImpl(HibernatePersistenceContext persistenceContext) {
		super(persistenceContext);
		
	}

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.ChamadaDAO#listAll()
	 */
	public List<Chamada> listAll() {
		
		Criteria criteria = getSession().createCriteria(Chamada.class);
		List<Chamada> result = criteria.list();
		
		
		return result;
	} 
	
	
	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.ChamadaDAO#listAll()
	 */
	public List<Chamada> listaPrecenca(Aluno aluno , int precenca) {
		
		Criteria criteria = getSession().createCriteria(Chamada.class);
		short shortPrecenca;
		shortPrecenca = (short) precenca;
		
		criteria.add(Restrictions.eq("aluno", aluno));
		criteria.add(Restrictions.eq("presenca", shortPrecenca));
		
		List<Chamada> result = criteria.list();
		
		
		return result;
	} 
	
	

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.ChamadaDAO#criar(br.com.muranodesign.model.Chamada)
	 */
	public void criar(Chamada c) {
		synchronized (ChamadaDAOImpl.class) {
			getSession().persist(c);
			getSession().flush();

		}
	}

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.ChamadaDAO#deletar(br.com.muranodesign.model.Chamada)
	 */
	public void deletar(Chamada c) {
		getSession().delete(c);
		getSession().flush();
	}

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.ChamadaDAO#atualizar(br.com.muranodesign.model.Chamada)
	 */
	public void atualizar(Chamada p) {
		getSession().merge(p);
		getSession().flush();
	}
	
	
	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.ChamadaDAO#listarKey(int)
	 */
	public List<Chamada> listarKey(int key){
		Criteria criteria = getSession().createCriteria(Chamada.class);
		criteria.add(Restrictions.eq("idchamada", key));
		List<Chamada> result = criteria.list();
		return result;
	}

	
	





	

}