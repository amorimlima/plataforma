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

import br.com.muranodesign.model.Roteiro;


// TODO: Auto-generated Javadoc
/**
 * The Interface RoteiroDAO.
 */
public interface RoteiroDAO {

		/**
		 * List all.
		 *
		 * @return the list
		 */
		public List<Roteiro> listAll();
		
		/**
		 * Criar.
		 *
		 * @param p the p
		 */
		public void criar(Roteiro p);
		
		/**
		 * Deletar.
		 *
		 * @param p the p
		 */
		public void deletar(Roteiro p);
		
		/**
		 * Atualizar.
		 *
		 * @param p the p
		 */
		public void atualizar(Roteiro p);
		
		/**
		 * Listar key.
		 *
		 * @param key the key
		 * @return the list
		 */
		public List<Roteiro> listarKey(int key);
		
	

}
