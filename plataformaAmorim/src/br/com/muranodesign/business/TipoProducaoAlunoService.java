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
import br.com.muranodesign.dao.TipoProducaoAlunoDAO;
import br.com.muranodesign.hibernate.impl.PersistenceContext;
import br.com.muranodesign.model.TipoProducaoAluno;



// TODO: Auto-generated Javadoc
/**
 * The Class TipoProducaoAlunoService.
 */
public class TipoProducaoAlunoService {
	
	/**
	 * Listar todos.
	 *
	 * @return the list
	 */
	public List<TipoProducaoAluno> listarTodos() {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		TipoProducaoAlunoDAO dao = DAOFactory.getTipoProducaoAlunoDAO(pc);
		List<TipoProducaoAluno> result = dao.listAll();
				
		pc.commitAndClose();
		return result;
	}
	
	/**
	 * Listarkey.
	 *
	 * @param key the key
	 * @return the list
	 */
	public List<TipoProducaoAluno> listarkey(int key) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		TipoProducaoAlunoDAO dao = DAOFactory.getTipoProducaoAlunoDAO(pc);
		List<TipoProducaoAluno> result = dao.listarKey(key);
		pc.commitAndClose();
		return result;
	}
	
	
	/**
	 * Criar tipo producao aluno.
	 *
	 * @param p the p
	 * @return the tipo producao aluno
	 */
	public TipoProducaoAluno criarTipoProducaoAluno(TipoProducaoAluno p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		TipoProducaoAlunoDAO dao = DAOFactory.getTipoProducaoAlunoDAO(pc);
		dao.criar(p);
		pc.commitAndClose();
		return p;
	}
	
	
	/**
	 * Deletar tipo producao aluno.
	 *
	 * @param p the p
	 * @return the tipo producao aluno
	 */
	public TipoProducaoAluno deletarTipoProducaoAluno(TipoProducaoAluno p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		TipoProducaoAlunoDAO dao = DAOFactory.getTipoProducaoAlunoDAO(pc);
		dao.deletar(p);
		pc.commitAndClose();
		return p;
	}
	
	
	/**
	 * Atualizar tipo producao aluno.
	 *
	 * @param p the p
	 * @return the tipo producao aluno
	 */
	public TipoProducaoAluno atualizarTipoProducaoAluno(TipoProducaoAluno p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		TipoProducaoAlunoDAO dao = DAOFactory.getTipoProducaoAlunoDAO(pc);
		dao.atualizar(p);
		pc.commitAndClose();
		return p;
	}

	
}
