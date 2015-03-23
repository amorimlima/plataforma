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

import br.com.muranodesign.business.PeriodoService;
import br.com.muranodesign.model.Periodo;


/**
 * Classe tem como objetivo disponibilizar os serviços relacionandos periodo
 *
 * @author Rogerio Lima dos Santos
 * @version 1.00
 * @since Release 1 da aplicação
 */

@Path("Periodo")
public class PeriodoResource {

	/** The logger. */
	private Logger logger = Logger.getLogger(PeriodoResource.class.getName());

	/**
	 * Gets the periodo.
	 *
	 * @return the periodo
	 */
	@GET
	@Produces("application/json")
	public List<Periodo> getPeriodo() {
		logger.info("Listar Periodo ...");
		List<Periodo> resultado;
		resultado = new PeriodoService().listarTodos();
		logger.info("QTD Periodo : " + resultado.size());
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
	public Periodo getEvento(@PathParam("id") int id) {
		logger.info("Lista Periodo  por id " + id);
		List<Periodo> resultado;
		resultado = new PeriodoService().listarkey(id);
		Periodo evento = resultado.get(0);

		return evento;

	}
	
	/**
	 * Removes the periodo.
	 *
	 * @param action the action
	 * @param id the id
	 * @return the string
	 */
	@Path("{action}/{id}")
	@Produces("text/plain")
	public String removePeriodo(@PathParam("action") String action,
			@PathParam("id") int id) {

		logger.info("Periodo  " + action);
		if ( action.equals("delete")) {
			List<Periodo> resultado;
			resultado = new PeriodoService().listarkey(id);
			Periodo periodo = resultado.get(0);
			new PeriodoService().deletarPeriodo(periodo);
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
			@FormParam("ano") String periodo
			
			
			) {
		Periodo objPeriodo= new Periodo();
		
		Periodo resutado;
		logger.info("eventoAction ...");
		

		if (action.equals("create")) {
			objPeriodo.setPeriodo(periodo);
			resutado = new PeriodoService().criarPeriodo(objPeriodo);
			
		}  else if (action.equals("update")) {
			
			int id=Integer.parseInt(strid);
			List<Periodo> rsPeriodo;
			rsPeriodo= new PeriodoService().listarkey(id);
			objPeriodo= rsPeriodo.get(0);
			objPeriodo.setIdperiodo(id);
			objPeriodo.setPeriodo(periodo);
			
			resutado = new PeriodoService().atualizarPeriodo(objPeriodo);
			
		} else {
			return "0";
		}
	    return Integer.toString(resutado.getIdperiodo());
	
		}
	
	

}
