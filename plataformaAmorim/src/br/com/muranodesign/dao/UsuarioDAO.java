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

import br.com.muranodesign.model.Usuario;


// TODO: Auto-generated Javadoc
/**
 * The Interface UsuarioDAO.
 */
public interface UsuarioDAO {

		/**
		 * List all.
		 *
		 * @return the list
		 */
		public List<Usuario> listAll();
		
		/**
		 * Criar.
		 *
		 * @param p the p
		 */
		public void criar(Usuario p);
		
		/**
		 * Deletar.
		 *
		 * @param p the p
		 */
		public void deletar(Usuario p);
		
		/**
		 * Atualizar.
		 *
		 * @param p the p
		 */
		public void atualizar(Usuario p);
		
		/**
		 * Listar key.
		 *
		 * @param key the key
		 * @return the list
		 */
		public List<Usuario> listarKey(int key);
		
		/**
		 * Listar usuario.
		 *
		 * @param usuario the usuario
		 * @return the list
		 */
		public List<Usuario> listarUsuario(String usuario);
		
		public List<Usuario> listaAluno(int idAluno);
		
		public List<Usuario> listaUsuarioEmail(String email);
		
	

}
