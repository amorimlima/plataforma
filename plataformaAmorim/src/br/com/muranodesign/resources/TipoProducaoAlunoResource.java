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

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.log4j.Logger;

import br.com.muranodesign.business.TipoProducaoAlunoService;
import br.com.muranodesign.model.TipoProducaoAluno;


/**
 * Classe tem como objetivo disponibilizar os serviços relacionandos tipo de produção do aluno
 *
 * @author Rogerio Lima dos Santos
 * @version 1.00
 * @since Release 1 da aplicação
 */
@Path("TipoProducaoAluno")
public class TipoProducaoAlunoResource {

	/** The logger. */
	private Logger logger = Logger.getLogger(TipoProducaoAlunoResource.class.getName());

	/**
	 * Gets the tipo producao aluno.
	 *
	 * @return the tipo producao aluno
	 */
	@GET
	@Produces("application/json")
	public List<TipoProducaoAluno> getTipoProducaoAluno() {
		logger.info("Listar TipoProducaoAluno ...");
		List<TipoProducaoAluno> resultado;
		resultado = new TipoProducaoAlunoService().listarTodos();
		logger.info("QTD TipoProducaoAluno : " + resultado.size());
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
	public TipoProducaoAluno getEvento(@PathParam("id") int id) {
		logger.info("Lista TipoProducaoAluno  por id " + id);
		List<TipoProducaoAluno> resultado;
		resultado = new TipoProducaoAlunoService().listarkey(id);
		TipoProducaoAluno evento = resultado.get(0);

		return evento;

	}
	
	/**
	 * Removes the tipo producao aluno.
	 *
	 * @param action the action
	 * @param id the id
	 * @return the string
	 */
	@Path("{action}/{id}")
	@Produces("text/plain")
	public String removeTipoProducaoAluno(@PathParam("action") String action,
			@PathParam("id") int id) {

		logger.info("TipoProducaoAluno  " + action);
		if ( action.equals("delete")) {
			List<TipoProducaoAluno> resultado;
			resultado = new TipoProducaoAlunoService().listarkey(id);
			TipoProducaoAluno result = resultado.get(0);
			new TipoProducaoAlunoService().deletarTipoProducaoAluno(result);
			return "true";
		} else {
			return "false";
		}

	}
	
	
	@POST
	@Produces("text/plain")
	public String eventoAction(
			
			@FormParam("action") String action,
			@FormParam("id") String strid,
			@FormParam("tipo") String tipo
			
			
			) {
		TipoProducaoAluno objTipoProducaoAluno= new TipoProducaoAluno();
		logger.info("eventoAction ...");
		TipoProducaoAluno resultado;

		if (action.equals("create")) {
			objTipoProducaoAluno.setTipo(tipo);
			resultado = new TipoProducaoAlunoService().criarTipoProducaoAluno(objTipoProducaoAluno);
			
		}  else if (action.equals("update")) {
			
			int id=Integer.parseInt(strid);
			List<TipoProducaoAluno> rsTipoProducaoAluno;
			rsTipoProducaoAluno= new TipoProducaoAlunoService().listarkey(id);
			objTipoProducaoAluno= rsTipoProducaoAluno.get(0);
			objTipoProducaoAluno.setIdtipoProducaoAluno(id);
			objTipoProducaoAluno.setTipo(tipo);
			
			resultado = new TipoProducaoAlunoService().atualizarTipoProducaoAluno(objTipoProducaoAluno);
			
		} else {
			return "0";
		}
	    return Integer.toString(resultado.getIdtipoProducaoAluno());
	
		}
		
		

}
