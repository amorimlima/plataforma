/**
 *   Este codigo é software livre você e pode resdistribuir e/ou modificar ele seguindo os termos da
 *   Creative Commons Attribution 4.0 International Pare visualizar uma copia desta 
 *   licensa em ingles visite http://creativecommons.org/licenses/by/4.0/.
 *   
 *   This code is free software; you can redistribute it and/or modify it
 *   under the terms of Creative Commons Attribution 4.0 International License. 
 *   To view a copy of this license, visit http://creativecommons.org/licenses/by/4.0/.
 */
package br.com.muranodesign.business;

import java.util.List;

import br.com.muranodesign.dao.DAOFactory;
import br.com.muranodesign.dao.ProfessorFuncionarioVariavelDAO;
import br.com.muranodesign.hibernate.impl.PersistenceContext;
import br.com.muranodesign.model.ProfessorFuncionarioVariavel;



// TODO: Auto-generated Javadoc
/**
 * The Class ProfessorFuncionarioVariavelService.
 */
public class ProfessorFuncionarioVariavelService {
	
	/**
	 * Listar todos.
	 *
	 * @return the list
	 */
	public List<ProfessorFuncionarioVariavel> listarTodos() {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		ProfessorFuncionarioVariavelDAO dao = DAOFactory.getProfessorFuncionarioVariavelDAO(pc);
		List<ProfessorFuncionarioVariavel> result = dao.listAll();
				
		pc.commitAndClose();
		return result;
	}
	
	
	/**
	 * Listar todos.
	 *
	 * @return the list
	 */
	public List<ProfessorFuncionarioVariavel> listarTodos(int status) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		ProfessorFuncionarioVariavelDAO dao = DAOFactory.getProfessorFuncionarioVariavelDAO(pc);
		List<ProfessorFuncionarioVariavel> result = dao.listAll(status);
				
		pc.commitAndClose();
		return result;
	}
	
	
	/**
	 * Listarkey.
	 *
	 * @param key the key
	 * @return the list
	 */
	public List<ProfessorFuncionarioVariavel> listarkey(int key) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		ProfessorFuncionarioVariavelDAO dao = DAOFactory.getProfessorFuncionarioVariavelDAO(pc);
		List<ProfessorFuncionarioVariavel> result = dao.listarKey(key);
		pc.commitAndClose();
		return result;
	}
	
	
	/**
	 * Criar professor funcionario variavel.
	 *
	 * @param p the p
	 * @return the professor funcionario variavel
	 */
	public ProfessorFuncionarioVariavel criarProfessorFuncionarioVariavel(ProfessorFuncionarioVariavel p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		ProfessorFuncionarioVariavelDAO dao = DAOFactory.getProfessorFuncionarioVariavelDAO(pc);
		dao.criar(p);
		pc.commitAndClose();
		return p;
	}
	
	
	/**
	 * Deletar professor funcionario variavel.
	 *
	 * @param p the p
	 * @return the professor funcionario variavel
	 */
	public ProfessorFuncionarioVariavel deletarProfessorFuncionarioVariavel(ProfessorFuncionarioVariavel p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		ProfessorFuncionarioVariavelDAO dao = DAOFactory.getProfessorFuncionarioVariavelDAO(pc);
		dao.deletar(p);
		pc.commitAndClose();
		return p;
	}
	
	
	/**
	 * Atualizar professor funcionario variavel.
	 *
	 * @param p the p
	 * @return the professor funcionario variavel
	 */
	public ProfessorFuncionarioVariavel atualizarProfessorFuncionarioVariavel(ProfessorFuncionarioVariavel p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		ProfessorFuncionarioVariavelDAO dao = DAOFactory.getProfessorFuncionarioVariavelDAO(pc);
		dao.atualizar(p);
		pc.commitAndClose();
		return p;
	}

	
}
