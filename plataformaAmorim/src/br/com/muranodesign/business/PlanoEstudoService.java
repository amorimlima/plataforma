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
import br.com.muranodesign.dao.PlanoEstudoDAO;
import br.com.muranodesign.hibernate.impl.PersistenceContext;
import br.com.muranodesign.model.PlanoEstudo;



// TODO: Auto-generated Javadoc
/**
 * The Class PlanoEstudoService.
 */
public class PlanoEstudoService {
	
	/**
	 * Listar todos.
	 *
	 * @return the list
	 */
	public List<PlanoEstudo> listarTodos() {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		PlanoEstudoDAO dao = DAOFactory.getPlanoEstudoDAO(pc);
		List<PlanoEstudo> result = dao.listAll();
				
		pc.commitAndClose();
		return result;
	}
	
	/**
	 * Listarkey.
	 *
	 * @param key the key
	 * @return the list
	 */
	public List<PlanoEstudo> listarkey(int key) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		PlanoEstudoDAO dao = DAOFactory.getPlanoEstudoDAO(pc);
		List<PlanoEstudo> result = dao.listarKey(key);
		pc.commitAndClose();
		return result;
	}
	
	
	public List<PlanoEstudo> utimoPlanoEstudos(int idAluno) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		PlanoEstudoDAO dao = DAOFactory.getPlanoEstudoDAO(pc);
		List<PlanoEstudo> result = dao.utimoPlanoEstudos(idAluno);
		pc.commitAndClose();
		return result;
	}
	
	
	
	/**
	 * Criar plano estudo.
	 *
	 * @param p the p
	 * @return the plano estudo
	 */
	public PlanoEstudo criarPlanoEstudo(PlanoEstudo p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		PlanoEstudoDAO dao = DAOFactory.getPlanoEstudoDAO(pc);
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
	public PlanoEstudo deletarPlanoEstudo(PlanoEstudo p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		PlanoEstudoDAO dao = DAOFactory.getPlanoEstudoDAO(pc);
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
	public PlanoEstudo atualizarPlanoEstudo(PlanoEstudo p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		PlanoEstudoDAO dao = DAOFactory.getPlanoEstudoDAO(pc);
		dao.atualizar(p);
		pc.commitAndClose();
		return p;
	}

	
}
