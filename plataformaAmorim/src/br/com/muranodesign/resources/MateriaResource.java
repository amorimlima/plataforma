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

import br.com.muranodesign.business.MateriaService;
import br.com.muranodesign.model.Materia;


/**
 * Classe tem como objetivo disponibilizar os serviços relacionandos Materia
 *
 * @author Rogerio Lima dos Santos
 * @version 1.00
 * @since Release 1 da aplicação
 */
@Path("Materia")
public class MateriaResource {

	/** The logger. */
	private Logger logger = Logger.getLogger(MateriaResource.class.getName());

	/**
	 * Gets the materia.
	 *
	 * @return the materia
	 */
	@GET
	@Produces("application/json")
	public List<Materia> getMateria() {
		logger.info("Listar Materia ...");
		List<Materia> resultado;
		resultado = new MateriaService().listarTodos();
		logger.info("QTD Materia : " + resultado.size());
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
	public Materia getEvento(@PathParam("id") int id) {
		logger.info("Lista Materia  por id " + id);
		List<Materia> resultado;
		resultado = new MateriaService().listarkey(id);
		Materia evento = resultado.get(0);

		return evento;

	}
	
	/**
	 * Removes the materia.
	 *
	 * @param action the action
	 * @param id the id
	 * @return the string
	 */
	@Path("{action}/{id}")
	@Produces("text/plain")
	public String removeMateria(@PathParam("action") String action,
			@PathParam("id") int id) {

		logger.info("Materia  " + action);
		if ( action.equals("delete")) {
			List<Materia> resultado;
			resultado = new MateriaService().listarkey(id);
			Materia res = resultado.get(0);
			new MateriaService().deletarMateria(res);
			return "true";
		} else {
			return "false";
		}

	}
	
	

}
