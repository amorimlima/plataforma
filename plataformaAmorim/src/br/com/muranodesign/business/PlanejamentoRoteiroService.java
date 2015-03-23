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
import br.com.muranodesign.dao.PlanejamentoRoteiroDAO;
import br.com.muranodesign.hibernate.impl.PersistenceContext;
import br.com.muranodesign.model.PlanejamentoRoteiro;



// TODO: Auto-generated Javadoc
/**
 * The Class PlanejamentoRoteiroService.
 */
public class PlanejamentoRoteiroService {
	
	/**
	 * Listar todos.
	 *
	 * @return the list
	 */
	public List<PlanejamentoRoteiro> listarTodos() {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		PlanejamentoRoteiroDAO dao = DAOFactory.getPlanejamentoRoteiroDAO(pc);
		List<PlanejamentoRoteiro> result = dao.listAll();
				
		pc.commitAndClose();
		return result;
	}
	
	/**
	 * Listarkey.
	 *
	 * @param key the key
	 * @return the list
	 */
	public List<PlanejamentoRoteiro> listarkey(int key) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		PlanejamentoRoteiroDAO dao = DAOFactory.getPlanejamentoRoteiroDAO(pc);
		List<PlanejamentoRoteiro> result = dao.listarKey(key);
		pc.commitAndClose();
		return result;
	}
	
	
	/**
	 * Listar por id Aluno
	 *
	 * @param idAluno id do aluno
	 * @return the list
	 */
	public List<PlanejamentoRoteiro> listarIdAluno(int id) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		PlanejamentoRoteiroDAO dao = DAOFactory.getPlanejamentoRoteiroDAO(pc);
		List<PlanejamentoRoteiro> result = dao.listarIdAluno(id);
		pc.commitAndClose();
		return result;
	}
	
	
	/**
	 * Criar plano estudo.
	 *
	 * @param p the p
	 * @return the plano estudo
	 */
	public PlanejamentoRoteiro criarPlanejamentoRoteiro(PlanejamentoRoteiro p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		PlanejamentoRoteiroDAO dao = DAOFactory.getPlanejamentoRoteiroDAO(pc);
		dao.criar(p);
		pc.commitAndClose();
		return p;
	}
	
	
	/**
	 * Deletar plano estudo.
	 *
	 * @param p the p
	 * @return the plano estudo
	 */
	public PlanejamentoRoteiro deletarPlanejamentoRoteiro(PlanejamentoRoteiro p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		PlanejamentoRoteiroDAO dao = DAOFactory.getPlanejamentoRoteiroDAO(pc);
		dao.deletar(p);
		pc.commitAndClose();
		return p;
	}
	
	
	/**
	 * Atualizar plano estudo.
	 *
	 * @param p the p
	 * @return the plano estudo
	 */
	public PlanejamentoRoteiro atualizarPlanejamentoRoteiro(PlanejamentoRoteiro p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		PlanejamentoRoteiroDAO dao = DAOFactory.getPlanejamentoRoteiroDAO(pc);
		dao.atualizar(p);
		pc.commitAndClose();
		return p;
	}

	
}
