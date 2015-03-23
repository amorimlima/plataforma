/**
 *   Este codigo é software livre você e pode resdistribuir e/ou modificar ele seguindo os termos da
 *   Creative Commons Attribution 4.0 International Pare visualizar uma copia desta 
 *   licensa em ingles visite http://creativecommons.org/licenses/by/4.0/.
 *   
 *   This code is free software; you can redistribute it and/or modify it
 *   under the terms of Creative Commons Attribution 4.0 International License. 
 *   To view a copy of this license, visit http://creativecommons.org/licenses/by/4.0/.
 */
package br.com.muranodesign.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.log4j.Logger;

import br.com.muranodesign.business.CategoriaProducaoAlunoService;
import br.com.muranodesign.model.CategoriaProducaoAluno;


/**
 * Classe tem como objetivo disponibilizar os serviços relacionandos categoria Producao Aluno
 *
 * @author Rogerio Lima dos Santos
 * @version 1.00
 * @since Release 1 da aplicação
 */

@Path("CategoriaProducaoAluno")
public class CategoriaProducaoAlunoResource {

	/** The logger. */
	private Logger logger = Logger.getLogger(CategoriaProducaoAlunoResource.class.getName());

	/**
	 * Gets the categoria producao aluno.
	 *
	 * @return the categoria producao aluno
	 */
	@GET
	@Produces("application/json")
	public List<CategoriaProducaoAluno> getCategoriaProducaoAluno() {
		logger.info("Listar CategoriaProducaoAluno ...");
		List<CategoriaProducaoAluno> resultado;
		resultado = new CategoriaProducaoAlunoService().listarTodos();
		logger.info("QTD CategoriaProducaoAluno : " + resultado.size());
		return resultado;
	}

	/**
	 * Gets the evento.
	 *
	 * @param id the id
	 * @return the evento
	 */
	@Path("{id}")
	@GET
	@Produces("application/json")
	public CategoriaProducaoAluno getEvento(@PathParam("id") int id) {
		logger.info("Lista CategoriaProducaoAluno  por id " + id);
		List<CategoriaProducaoAluno> resultado;
		resultado = new CategoriaProducaoAlunoService().listarkey(id);
		CategoriaProducaoAluno evento = resultado.get(0);

		return evento;

	}
	
	/**
	 * Removes the categoria producao aluno.
	 *
	 * @param action the action
	 * @param id the id
	 * @return the string
	 */
	@Path("{action}/{id}")
	@Produces("text/plain")
	public String removeCategoriaProducaoAluno(@PathParam("action") String action,
			@PathParam("id") int id) {

		logger.info("CategoriaProducaoAluno  " + action);
		if ( action.equals("delete")) {
			List<CategoriaProducaoAluno> resultado;
			resultado = new CategoriaProducaoAlunoService().listarkey(id);
			CategoriaProducaoAluno res = resultado.get(0);
			new CategoriaProducaoAlunoService().deletarCategoriaProducaoAluno(res);
			return "true";
		} else {
			return "false";
		}

	}
	
	

}
