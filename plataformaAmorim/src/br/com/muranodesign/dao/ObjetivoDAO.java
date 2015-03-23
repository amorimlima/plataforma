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

import br.com.muranodesign.model.Objetivo;


// TODO: Auto-generated Javadoc
/**
 * The Interface ObjetivoDAO.
 */
public interface ObjetivoDAO {

		/**
		 * List all.
		 *
		 * @return the list
		 */
		public List<Objetivo> listAll();
		
		/**
		 * Criar.
		 *
		 * @param p the p
		 */
		public void criar(Objetivo p);
		
		/**
		 * Deletar.
		 *
		 * @param p the p
		 */
		public void deletar(Objetivo p);
		
		/**
		 * Atualizar.
		 *
		 * @param p the p
		 */
		public void atualizar(Objetivo p);
		
		/**
		 * Listar key.
		 *
		 * @param key the key
		 * @return the list
		 */
		public List<Objetivo> listarKey(int key);
		
	

}
