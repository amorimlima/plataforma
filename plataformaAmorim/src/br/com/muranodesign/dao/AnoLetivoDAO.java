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

import br.com.muranodesign.model.AnoLetivo;


// TODO: Auto-generated Javadoc
/**
 * The Interface AnoLetivoDAO.
 */
public interface AnoLetivoDAO {

		/**
		 * List all.
		 *
		 * @return the list
		 */
		public List<AnoLetivo> listAll();
		
		/**
		 * Criar.
		 *
		 * @param p the p
		 */
		public void criar(AnoLetivo p);
		
		/**
		 * Deletar.
		 *
		 * @param p the p
		 */
		public void deletar(AnoLetivo p);
		
		/**
		 * Atualizar.
		 *
		 * @param p the p
		 */
		public void atualizar(AnoLetivo p);
		
		/**
		 * Listar key.
		 *
		 * @param key the key
		 * @return the list
		 */
		public List<AnoLetivo> listarKey(int key);
		
		/**
		 * Listar ano letivo.
		 *
		 * @param anoLetivo the ano letivo
		 * @return the list
		 */
		public List<AnoLetivo> listarAnoLetivo(String anoLetivo);
	

}
