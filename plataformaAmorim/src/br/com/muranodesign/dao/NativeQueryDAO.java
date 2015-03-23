/**
 *   Este codigo é software livre você e pode resdistribuir e/ou modificar ele seguindo os termos da
 *   Creative Commons Attribution 4.0 International Pare visualizar uma copia desta 
 *   licensa em ingles visite http://creativecommons.org/licenses/by/4.0/.
 *   
 *   This code is free software; you can redistribute it and/or modify it
 *   under the terms of Creative Commons Attribution 4.0 International License. 
 *   To view a copy of this license, visit http://creativecommons.org/licenses/by/4.0/.
 */
package br.com.muranodesign.dao;

import java.util.List;





// TODO: Auto-generated Javadoc
/**
 * The Interface NativeQueryDAO.
 */
public interface NativeQueryDAO {

	/**
	 * List all.
	 *
	 * @param query the query
	 * @return the list
	 */
	public List listAll(String query);
	public List listArgs(String query,String ... args);
	
	

}
