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
import br.com.muranodesign.dao.ProfessorFuncionarioDAO;
import br.com.muranodesign.hibernate.impl.PersistenceContext;
import br.com.muranodesign.model.ProfessorFuncionario;



// TODO: Auto-generated Javadoc
/**
 * The Class ProfessorFuncionarioService.
 */
public class ProfessorFuncionarioService {
	
	/**
	 * Listar todos.
	 *
	 * @return the list
	 */
	public List<ProfessorFuncionario> listarTodos() {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		ProfessorFuncionarioDAO dao = DAOFactory.getProfessorFuncionarioDAO(pc);
		List<ProfessorFuncionario> result = dao.listAll();
				
		pc.commitAndClose();
		return result;
	}
	
	/**
	 * Listarkey.
	 *
	 * @param key the key
	 * @return the list
	 */
	public List<ProfessorFuncionario> listarkey(int key) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		ProfessorFuncionarioDAO dao = DAOFactory.getProfessorFuncionarioDAO(pc);
		List<ProfessorFuncionario> result = dao.listarKey(key);
		pc.commitAndClose();
		return result;
	}
	
	
	/**
	 * Criar professor funcionario.
	 *
	 * @param p the p
	 * @return the professor funcionario
	 */
	public ProfessorFuncionario criarProfessorFuncionario(ProfessorFuncionario p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		ProfessorFuncionarioDAO dao = DAOFactory.getProfessorFuncionarioDAO(pc);
		dao.criar(p);
		pc.commitAndClose();
		return p;
	}
	
	
	/**
	 * Deletar professor funcionario.
	 *
	 * @param p the p
	 * @return the professor funcionario
	 */
	public ProfessorFuncionario deletarProfessorFuncionario(ProfessorFuncionario p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		ProfessorFuncionarioDAO dao = DAOFactory.getProfessorFuncionarioDAO(pc);
		dao.deletar(p);
		pc.commitAndClose();
		return p;
	}
	
	
	/**
	 * Atualizar professor funcionario.
	 *
	 * @param p the p
	 * @return the professor funcionario
	 */
	public ProfessorFuncionario atualizarProfessorFuncionario(ProfessorFuncionario p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		ProfessorFuncionarioDAO dao = DAOFactory.getProfessorFuncionarioDAO(pc);
		dao.atualizar(p);
		pc.commitAndClose();
		return p;
	}

	
}
