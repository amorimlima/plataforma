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

import br.com.muranodesign.dao.AlunoDAO;
import br.com.muranodesign.dao.DAOFactory;
import br.com.muranodesign.hibernate.impl.PersistenceContext;
import br.com.muranodesign.model.Aluno;




/**
 * Classe tem como objetivo sequir os padrões de projetos para utilização de hibernate.
 *
 * @author Rogerio Lima dos Santos
 * @version 1.00
 * @since Release 1 da aplicação
 */
public class AlunoService {
	
	/**
	 * Listar todos.
	 *
	 * @return lista de alunos
	 */
	public List<Aluno> listarTodos() {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		AlunoDAO dao = DAOFactory.getAlunoDAO(pc);
		List<Aluno> result = dao.listAll();
		pc.commitAndClose();
		return result;
	}
	
	/**
	 * Lisat atraves do id..
	 *
	 * @param id do aluno
	 * @return aluno
	 */
	public List<Aluno> listarkey(int key) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		AlunoDAO dao = DAOFactory.getAlunoDAO(pc);
		List<Aluno> result = dao.listarKey(key);
		pc.commitAndClose();
		return result;
	}
	
	
	/**
	 * cria um novo aluno
	 *
	 * @param aluno
	 * @return aluno
	 */
	public Aluno criarAluno(Aluno p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		AlunoDAO dao = DAOFactory.getAlunoDAO(pc);
		dao.criar(p);
		pc.commitAndClose();
		return p;
	}
	
	/**
	 * Atualizar aluno
	 *
	 * @param aluno
	 * @return aluno
	 */
	public Aluno atualizarAluno(Aluno p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		AlunoDAO dao = DAOFactory.getAlunoDAO(pc);
		dao.atualizar(p);
		pc.commitAndClose();
		return p;
	}
	
	

	
	/**
	 * Deletar Aluno.
	 *
	 * @param aluno
	 * @return aluno
	 */
	public Aluno deletarAluno(Aluno p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		AlunoDAO dao = DAOFactory.getAlunoDAO(pc);
		dao.deletar(p);
		pc.commitAndClose();
		return p;
	}
	
	
	
}
