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
import br.com.muranodesign.dao.MensagensDAO;
import br.com.muranodesign.hibernate.impl.PersistenceContext;
import br.com.muranodesign.model.Mensagens;
import br.com.muranodesign.model.Usuario;



// TODO: Auto-generated Javadoc
/**
 * The Class MensagensService.
 */
public class MensagensService {
	
	/**
	 * Listar todos.
	 *
	 * @return the list
	 */
	public List<Mensagens> listarTodos() {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		MensagensDAO dao = DAOFactory.getMensagensDAO(pc);
		List<Mensagens> result = dao.listAll();
				
		pc.commitAndClose();
		return result;
	}
	
	/**
	 * Listarkey.
	 *
	 * @param key the key
	 * @return the list
	 */
	public List<Mensagens> listarkey(int key) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		MensagensDAO dao = DAOFactory.getMensagensDAO(pc);
		List<Mensagens> result = dao.listarKey(key);
		pc.commitAndClose();
		return result;
	}
	
	
	public List<Mensagens> listarProprietario(Usuario proprietario) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		MensagensDAO dao = DAOFactory.getMensagensDAO(pc);
		List<Mensagens> result = dao.listarProprietario(proprietario);
		pc.commitAndClose();
		return result;
	}
	
	
	public List<Mensagens> listarProprietario(Usuario proprietario,String caixa) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		MensagensDAO dao = DAOFactory.getMensagensDAO(pc);
		List<Mensagens> result = dao.listarProprietario(proprietario,caixa);
		pc.commitAndClose();
		return result;
	}
	
	/**
	 * Criar mensagens.
	 *
	 * @param p the p
	 * @return the mensagens
	 */
	public Mensagens criarMensagens(Mensagens p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		MensagensDAO dao = DAOFactory.getMensagensDAO(pc);
		dao.criar(p);
		pc.commitAndClose();
		return p;
	}
	
	
	/**
	 * Deletar mensagens.
	 *
	 * @param p the p
	 * @return the mensagens
	 */
	public Mensagens deletarMensagens(Mensagens p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		MensagensDAO dao = DAOFactory.getMensagensDAO(pc);
		dao.deletar(p);
		pc.commitAndClose();
		return p;
	}
	
	
	/**
	 * Atualizar mensagens.
	 *
	 * @param p the p
	 * @return the mensagens
	 */
	public Mensagens atualizarMensagens(Mensagens p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		MensagensDAO dao = DAOFactory.getMensagensDAO(pc);
		dao.atualizar(p);
		pc.commitAndClose();
		return p;
	}

	
}
