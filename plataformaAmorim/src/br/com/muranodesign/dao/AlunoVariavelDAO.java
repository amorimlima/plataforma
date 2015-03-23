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

import br.com.muranodesign.model.AlunoVariavel;


// TODO: Auto-generated Javadoc
/**
 * The Interface AlunoVariavelDAO.
 */
public interface AlunoVariavelDAO {

		/**
		 * List all.
		 *
		 * @return the list
		 */
		public List<AlunoVariavel> listAll();
		
		
		/**
		 * List all.
		 *
		 * @return the list
		 */
		public List<AlunoVariavel> listAll(int status);
		
		/**
		 * Criar.
		 *
		 * @param p the p
		 */
		public void criar(AlunoVariavel p);
		
		/**
		 * Deletar.
		 *
		 * @param p the p
		 */
		public void deletar(AlunoVariavel p);
		
		/**
		 * Atualizar.
		 *
		 * @param p the p
		 */
		public void atualizar(AlunoVariavel p);
		
		/**
		 * Listar key.
		 *
		 * @param key the key
		 * @return the list
		 */
		public List<AlunoVariavel> listarKey(int key);
		
		
		/**
		 * Gets the aluno.
		 *
		 * @param aluno the aluno
		 * @return the aluno
		 */
		public AlunoVariavel getAluno(int aluno);
		
	
		public List<AlunoVariavel> listaAluno(int idAluno);
		
		public List<AlunoVariavel> listaGrupo(int idGrupo);
}
