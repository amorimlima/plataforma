/**
 *   Este codigo é software livre você e pode resdistribuir e/ou modificar ele seguindo os termos da
 *   Creative Commons Attribution 4.0 International Pare visualizar uma copia desta 
 *   licensa em ingles visite http://creativecommons.org/licenses/by/4.0/.
 *   
 *   This code is free software; you can redistribute it and/or modify it
 *   under the terms of Creative Commons Attribution 4.0 International License. 
 *   To view a copy of this license, visit http://creativecommons.org/licenses/by/4.0/.
 */
package br.com.muranodesign.hibernate.impl;


/**
 * Classe tem como objetivo interface de Contexto de persistencia
 * @author Rogerio Lima dos Santos
 * @version 1.00
 * @since Release 1 da aplicação
 */

public interface PersistenceContext {

	
	/**
	 * pega contexto
	 *
	 * @return  contexto
	 */
	public Object getContext();

	/**
	 * Commit and close.
	 */
	public void commitAndClose();

	/**
	 * Rollback and close.
	 */
	public void rollbackAndClose();
	
	/**
	 * Detach.
	 *
	 * @param o the o
	 */
	public void detach(Object o);
}
