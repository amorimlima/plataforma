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

import br.com.muranodesign.business.TipoRecursoAprendizagemService;
import br.com.muranodesign.model.TipoRecursoAprendizagem;


/**
 * Classe tem como objetivo disponibilizar os serviços relacionandos recurso aprendizagem
 *
 * @author Rogerio Lima dos Santos
 * @version 1.00
 * @since Release 1 da aplicação
 */

@Path("TipoRecursoAprendizagem")
public class TipoRecursoAprendizagemResource {

	/** The logger. */
	private Logger logger = Logger.getLogger(TipoRecursoAprendizagemResource.class.getName());

	/**
	 * Gets the tipo recurso aprendizagem.
	 *
	 * @return the tipo recurso aprendizagem
	 */
	@GET
	@Produces("application/json")
	public List<TipoRecursoAprendizagem> getTipoRecursoAprendizagem() {
		logger.info("Listar TipoRecursoAprendizagem ...");
		List<TipoRecursoAprendizagem> resultado;
		resultado = new TipoRecursoAprendizagemService().listarTodos();
		logger.info("QTD TipoRecursoAprendizagem : " + resultado.size());
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
	public TipoRecursoAprendizagem getEvento(@PathParam("id") int id) {
		logger.info("Lista TipoRecursoAprendizagem  por id " + id);
		List<TipoRecursoAprendizagem> resultado;
		resultado = new TipoRecursoAprendizagemService().listarkey(id);
		TipoRecursoAprendizagem evento = resultado.get(0);

		return evento;

	}
	
	/**
	 * Removes the tipo recurso aprendizagem.
	 *
	 * @param action the action
	 * @param id the id
	 * @return the string
	 */
	@Path("{action}/{id}")
	@Produces("text/plain")
	public String removeTipoRecursoAprendizagem(@PathParam("action") String action,
			@PathParam("id") int id) {

		logger.info("TipoRecursoAprendizagem  " + action);
		if ( action.equals("delete")) {
			List<TipoRecursoAprendizagem> resultado;
			resultado = new TipoRecursoAprendizagemService().listarkey(id);
			TipoRecursoAprendizagem res = resultado.get(0);
			new TipoRecursoAprendizagemService().deletarTipoRecursoAprendizagem(res);
			return "true";
		} else {
			return "false";
		}

	}
	
	

}
