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

import br.com.muranodesign.dao.AvaliacaoProducaoAlunoDAO;
import br.com.muranodesign.dao.DAOFactory;
import br.com.muranodesign.hibernate.impl.PersistenceContext;
import br.com.muranodesign.model.AvaliacaoProducaoAluno;



// TODO: Auto-generated Javadoc
/**
 * The Class AvaliacaoProducaoAlunoService.
 */
public class AvaliacaoProducaoAlunoService {
	
	/**
	 * Listar todos.
	 *
	 * @return the list
	 */
	public List<AvaliacaoProducaoAluno> listarTodos() {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		AvaliacaoProducaoAlunoDAO dao = DAOFactory.getAvaliacaoProducaoAlunoDAO(pc);
		List<AvaliacaoProducaoAluno> result = dao.listAll();
				
		pc.commitAndClose();
		return result;
	}
	
	/**
	 * Listarkey.
	 *
	 * @param key the key
	 * @return the list
	 */
	public List<AvaliacaoProducaoAluno> listarkey(int key) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		AvaliacaoProducaoAlunoDAO dao = DAOFactory.getAvaliacaoProducaoAlunoDAO(pc);
		List<AvaliacaoProducaoAluno> result = dao.listarKey(key);
		pc.commitAndClose();
		return result;
	}
	
	
	/**
	 * Criar avaliacao producao aluno.
	 *
	 * @param p the p
	 * @return the avaliacao producao aluno
	 */
	public AvaliacaoProducaoAluno criarAvaliacaoProducaoAluno(AvaliacaoProducaoAluno p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		AvaliacaoProducaoAlunoDAO dao = DAOFactory.getAvaliacaoProducaoAlunoDAO(pc);
		dao.criar(p);
		pc.commitAndClose();
		return p;
	}
	
	
	/**
	 * Deletar avaliacao producao aluno.
	 *
	 * @param p the p
	 * @return the avaliacao producao aluno
	 */
	public AvaliacaoProducaoAluno deletarAvaliacaoProducaoAluno(AvaliacaoProducaoAluno p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		AvaliacaoProducaoAlunoDAO dao = DAOFactory.getAvaliacaoProducaoAlunoDAO(pc);
		dao.deletar(p);
		pc.commitAndClose();
		return p;
	}
	
	
	/**
	 * Atualizar avaliacao producao aluno.
	 *
	 * @param p the p
	 * @return the avaliacao producao aluno
	 */
	public AvaliacaoProducaoAluno atualizarAvaliacaoProducaoAluno(AvaliacaoProducaoAluno p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		AvaliacaoProducaoAlunoDAO dao = DAOFactory.getAvaliacaoProducaoAlunoDAO(pc);
		dao.atualizar(p);
		pc.commitAndClose();
		return p;
	}

	
}
