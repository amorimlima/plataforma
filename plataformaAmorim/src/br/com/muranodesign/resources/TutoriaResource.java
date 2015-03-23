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

import br.com.muranodesign.business.TutoriaService;
import br.com.muranodesign.model.Tutoria;


/**
 * Classe tem como objetivo disponibilizar os serviços relacionandos tipo de tutoria
 *
 * @author Rogerio Lima dos Santos
 * @version 1.00
 * @since Release 1 da aplicação
 */
@Path("Tutoria")
public class TutoriaResource {

	/** The logger. */
	private Logger logger = Logger.getLogger(TutoriaResource.class.getName());

	/**
	 * Gets the tutoria.
	 *
	 * @return the tutoria
	 */
	@GET
	@Produces("application/json")
	public List<Tutoria> getTutoria() {
		logger.info("Listar Tutoria ...");
		List<Tutoria> resultado;
		resultado = new TutoriaService().listarTodos();
		logger.info("QTD Tutoria : " + resultado.size());
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
	public Tutoria getEvento(@PathParam("id") int id) {
		logger.info("Lista Tutoria  por id " + id);
		List<Tutoria> resultado;
		resultado = new TutoriaService().listarkey(id);
		Tutoria evento = resultado.get(0);

		return evento;

	}
	
	/**
	 * Removes the tutoria.
	 *
	 * @param action the action
	 * @param id the id
	 * @return the string
	 */
	@Path("{action}/{id}")
	@Produces("text/plain")
	public String removeTutoria(@PathParam("action") String action,
			@PathParam("id") int id) {

		logger.info("Tutoria  " + action);
		if ( action.equals("delete")) {
			List<Tutoria> resultado;
			resultado = new TutoriaService().listarkey(id);
			Tutoria evento = resultado.get(0);
			new TutoriaService().deletarTutoria(evento);
			return "true";
		} else {
			return "false";
		}

	}
	
	

}
