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

import br.com.muranodesign.dao.ChamadaDAO;
import br.com.muranodesign.dao.DAOFactory;
import br.com.muranodesign.hibernate.impl.PersistenceContext;
import br.com.muranodesign.model.Aluno;
import br.com.muranodesign.model.Chamada;



// TODO: Auto-generated Javadoc
/**
 *  Classe responsavel pela chamada do aluno ChamadaService.
 * @author Rogerio Lima dos Santos
 * @version 1.00
 * @since Release 1 da aplicação
 */
public class ChamadaService {
	
	/**
	 * Listar todos.
	 *
	 * @return the list
	 */
	public List<Chamada> listarTodos() {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		ChamadaDAO dao = DAOFactory.getChamadaDAO(pc);
		List<Chamada> result = dao.listAll();
				
		pc.commitAndClose();
		return result;
	}
	
	/**
	 * Listarkey.
	 *
	 * @param key the key
	 * @return the list
	 */
	public List<Chamada> listarkey(int key) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		ChamadaDAO dao = DAOFactory.getChamadaDAO(pc);
		List<Chamada> result = dao.listarKey(key);
		pc.commitAndClose();
		return result;
	}
	
	
	/**
	 * Criar chamada.
	 *
	 * @param p the p
	 * @return the chamada
	 */
	public Chamada criarChamada(Chamada p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		ChamadaDAO dao = DAOFactory.getChamadaDAO(pc);
		dao.criar(p);
		pc.commitAndClose();
		return p;
	}
	
	
	/**
	 * Deletar chamada.
	 *
	 * @param p the p
	 * @return the chamada
	 */
	public Chamada deletarChamada(Chamada p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		ChamadaDAO dao = DAOFactory.getChamadaDAO(pc);
		dao.deletar(p);
		pc.commitAndClose();
		return p;
	}
	
	
	/**
	 * Atualizar chamada.
	 *
	 * @param p the p
	 * @return the chamada
	 */
	public Chamada atualizarChamada(Chamada p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		ChamadaDAO dao = DAOFactory.getChamadaDAO(pc);
		dao.atualizar(p);
		pc.commitAndClose();
		return p;
	}
	
	public List<Chamada> listaPrecenca(Aluno aluno , int precenca) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		ChamadaDAO dao = DAOFactory.getChamadaDAO(pc);
		List<Chamada> result = dao.listaPrecenca(aluno,precenca);
				
		pc.commitAndClose();
		return result;
	}

	
}
