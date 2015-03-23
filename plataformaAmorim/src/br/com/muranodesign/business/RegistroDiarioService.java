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
import br.com.muranodesign.dao.RegistroDiarioDAO;
import br.com.muranodesign.hibernate.impl.PersistenceContext;
import br.com.muranodesign.model.RegistroDiario;



// TODO: Auto-generated Javadoc
/**
 * The Class RegistroDiarioService.
 */
public class RegistroDiarioService {
	
	/**
	 * Listar todos.
	 *
	 * @return the list
	 */
	public List<RegistroDiario> listarTodos() {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		RegistroDiarioDAO dao = DAOFactory.getRegistroDiarioDAO(pc);
		List<RegistroDiario> result = dao.listAll();
				
		pc.commitAndClose();
		return result;
	}
	
	/**
	 * Listarkey.
	 *
	 * @param key the key
	 * @return the list
	 */
	public List<RegistroDiario> listarkey(int key) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		RegistroDiarioDAO dao = DAOFactory.getRegistroDiarioDAO(pc);
		List<RegistroDiario> result = dao.listarKey(key);
		pc.commitAndClose();
		return result;
	}
	
	
	
	/**
	 * Criar registro diario.
	 *
	 * @param p the p
	 * @return the registro diario
	 */
	public RegistroDiario criarRegistroDiario(RegistroDiario p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		RegistroDiarioDAO dao = DAOFactory.getRegistroDiarioDAO(pc);
		dao.criar(p);
		pc.commitAndClose();
		return p;
		
	}
	
	
	/**
	 * Deletar registro diario.
	 *
	 * @param p the p
	 * @return the registro diario
	 */
	public RegistroDiario deletarRegistroDiario(RegistroDiario p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		RegistroDiarioDAO dao = DAOFactory.getRegistroDiarioDAO(pc);
		dao.deletar(p);
		pc.commitAndClose();
		return p;
	}
	
	
	/**
	 * Atualizar registro diario.
	 *
	 * @param p the p
	 * @return the registro diario
	 */
	public RegistroDiario atualizarRegistroDiario(RegistroDiario p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		RegistroDiarioDAO dao = DAOFactory.getRegistroDiarioDAO(pc);
		dao.atualizar(p);
		pc.commitAndClose();
		return p;
	}

	
}
