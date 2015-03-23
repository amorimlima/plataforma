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

import br.com.muranodesign.dao.PerfilDAO;
import br.com.muranodesign.hibernate.AbstractHibernateDAO;
import br.com.muranodesign.hibernate.HibernatePersistenceContext;
import br.com.muranodesign.model.Perfil;



/**
 * Abstração do dao e implementação do GRUD
 *
 * @author Rogerio Lima dos Santos
 * @version 1.00
 * @since Release 1 da aplicação
 */
public class PerfilDAOImpl extends AbstractHibernateDAO implements PerfilDAO {

	/**
	 * Instantiates a new perfil dao impl.
	 *
	 * @param persistenceContext the persistence context
	 */
	public PerfilDAOImpl(HibernatePersistenceContext persistenceContext) {
		super(persistenceContext);
		
	}

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.PerfilDAO#listAll()
	 */
	public List<Perfil> listAll() {
		
		Criteria criteria = getSession().createCriteria(Perfil.class);
		List<Perfil> result = criteria.list();
		
		
		return result;
	} 
	

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.PerfilDAO#criar(br.com.muranodesign.model.Perfil)
	 */
	public void criar(Perfil c) {
		synchronized (PerfilDAOImpl.class) {
			getSession().persist(c);
			getSession().flush();

		}
	}

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.PerfilDAO#deletar(br.com.muranodesign.model.Perfil)
	 */
	public void deletar(Perfil c) {
		getSession().delete(c);
		getSession().flush();
	}

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.PerfilDAO#atualizar(br.com.muranodesign.model.Perfil)
	 */
	public void atualizar(Perfil p) {
		getSession().merge(p);
		getSession().flush();
	}
	
	
	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.PerfilDAO#listarKey(int)
	 */
	public List<Perfil> listarKey(int key){
		Criteria criteria = getSession().createCriteria(Perfil.class);
		criteria.add(Restrictions.eq("idperfil", key));
		List<Perfil> result = criteria.list();
		return result;
	}





	

}