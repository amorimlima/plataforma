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

import br.com.muranodesign.model.TipoEvento;


// TODO: Auto-generated Javadoc
/**
 * The Interface TipoEventoDAO.
 */
public interface TipoEventoDAO {

		/**
		 * List all.
		 *
		 * @return the list
		 */
		public List<TipoEvento> listAll();
		
		/**
		 * Criar.
		 *
		 * @param p the p
		 */
		public void criar(TipoEvento p);
		
		/**
		 * Deletar.
		 *
		 * @param p the p
		 */
		public void deletar(TipoEvento p);
		
		/**
		 * Atualizar.
		 *
		 * @param p the p
		 */
		public void atualizar(TipoEvento p);
		
		/**
		 * Listar key.
		 *
		 * @param key the key
		 * @return the list
		 */
		public List<TipoEvento> listarKey(int key);
		
		/**
		 * Listar tipo evento.
		 *
		 * @param tipoEvento the tipo evento
		 * @return the list
		 */
		public List<TipoEvento> listarTipoEvento(String tipoEvento);
	

}
