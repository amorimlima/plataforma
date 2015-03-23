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

import org.hibernate.SQLQuery;

import br.com.muranodesign.dao.NativeQueryDAO;
import br.com.muranodesign.hibernate.AbstractHibernateDAO;
import br.com.muranodesign.hibernate.HibernatePersistenceContext;



/**
 * Abstração do dao e implementação de query nativas
 *
 * @author Rogerio Lima dos Santos
 * @version 1.00
 * @since Release 1 da aplicação
 */
public class NativeQueryDAOImpl extends AbstractHibernateDAO implements NativeQueryDAO {


	/**
	 * Instantiates a new native query dao impl.
	 *
	 * @param persistenceContext the persistence context
	 */
	public NativeQueryDAOImpl(HibernatePersistenceContext persistenceContext) {
		super(persistenceContext);
		
	}

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.NativeQueryDAO#listAll(java.lang.String)
	 */
	public List<Object[]> listAll(String query){
		SQLQuery q = getSession().createSQLQuery(query);
	    List<Object[]> entities = q.list();
		return entities;
		
	}
	
    public List listArgs(String query,String ... args){
		
		SQLQuery q = getSession().createSQLQuery(query);
		int qtdArq = 0;
		for (String string : args) {
			q.setString( qtdArq , string );
			qtdArq ++;
		}
		List<Object[]> entities = q.list();
		return entities;
	}
	
	
	

}
