/**
 *   Este codigo é software livre você e pode resdistribuir e/ou modificar ele seguindo os termos da
 *   Creative Commons Attribution 4.0 International Pare visualizar uma copia desta 
 *   licensa em ingles visite http://creativecommons.org/licenses/by/4.0/.
 *   
 *   This code is free software; you can redistribute it and/or modify it
 *   under the terms of Creative Commons Attribution 4.0 International License. 
 *   To view a copy of this license, visit http://creativecommons.org/licenses/by/4.0/.
 */
package br.com.muranodesign.hibernate;

import org.hibernate.Session;


/**
 * Classe base para criacaoo dos DAOs da aplicacaoo.
 * Implementado sobre Hibernate, armazena o PersistenceContext como atributo, que
 * deve ser uma instancia de HibernatePersistenceContext.
 * @author Rogerio Lima dos Santos
 * @version 1.00
 * @since Release 1 da aplicação
 */


public abstract class AbstractHibernateDAO {

	private HibernatePersistenceContext persistenceContext;
	
	public AbstractHibernateDAO(HibernatePersistenceContext persistenceContext) {
		this.persistenceContext = persistenceContext;
	}

	protected Session getSession() {
		return (Session) persistenceContext.getContext();
	}
}
