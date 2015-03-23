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

import br.com.muranodesign.model.PlanejamentoRoteiro;


// TODO: Auto-generated Javadoc
/**
 * The Interface PlanejamentoRoteiroDAO.
 */
public interface PlanejamentoRoteiroDAO {

		/**
		 * List all.
		 *
		 * @return the list
		 */
		public List<PlanejamentoRoteiro> listAll();
		
		/**
		 * Criar.
		 *
		 * @param p the p
		 */
		public void criar(PlanejamentoRoteiro p);
		
		/**
		 * Deletar.
		 *
		 * @param p the p
		 */
		public void deletar(PlanejamentoRoteiro p);
		
		/**
		 * Atualizar.
		 *
		 * @param p the p
		 */
		public void atualizar(PlanejamentoRoteiro p);
		
		/**
		 * Listar key.
		 *
		 * @param key the key
		 * @return the list
		 */
		public List<PlanejamentoRoteiro> listarKey(int key);

		
		/**
		 * Listar key.
		 *
		 * @param key the key
		 * @return the list
		 */
		public List<PlanejamentoRoteiro> listarIdAluno(int id) ;
	

}
