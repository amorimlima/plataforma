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
import br.com.muranodesign.dao.ProducaoAlunoDAO;
import br.com.muranodesign.hibernate.impl.PersistenceContext;
import br.com.muranodesign.model.ProducaoAluno;



// TODO: Auto-generated Javadoc
/**
 * The Class ProducaoAlunoService.
 */
public class ProducaoAlunoService {
	
	/**
	 * Listar todos.
	 *
	 * @return the list
	 */
	public List<ProducaoAluno> listarTodos() {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		ProducaoAlunoDAO dao = DAOFactory.getProducaoAlunoDAO(pc);
		List<ProducaoAluno> result = dao.listAll();
				
		pc.commitAndClose();
		return result;
	}
	
	/**
	 * Listarkey.
	 *
	 * @param key the key
	 * @return the list
	 */
	public List<ProducaoAluno> listarkey(int key) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		ProducaoAlunoDAO dao = DAOFactory.getProducaoAlunoDAO(pc);
		List<ProducaoAluno> result = dao.listarKey(key);
		pc.commitAndClose();
		return result;
	}
	
	
	/**
	 * Criar producao aluno.
	 *
	 * @param p the p
	 * @return the producao aluno
	 */
	public ProducaoAluno criarProducaoAluno(ProducaoAluno p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		ProducaoAlunoDAO dao = DAOFactory.getProducaoAlunoDAO(pc);
		dao.criar(p);
		pc.commitAndClose();
		return p;
	}
	
	
	/**
	 * Deletar producao aluno.
	 *
	 * @param p the p
	 * @return the producao aluno
	 */
	public ProducaoAluno deletarProducaoAluno(ProducaoAluno p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		ProducaoAlunoDAO dao = DAOFactory.getProducaoAlunoDAO(pc);
		dao.deletar(p);
		pc.commitAndClose();
		return p;
	}
	
	
	/**
	 * Atualizar producao aluno.
	 *
	 * @param p the p
	 * @return the producao aluno
	 */
	public ProducaoAluno atualizarProducaoAluno(ProducaoAluno p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		ProducaoAlunoDAO dao = DAOFactory.getProducaoAlunoDAO(pc);
		dao.atualizar(p);
		pc.commitAndClose();
		return p;
	}

	
}
