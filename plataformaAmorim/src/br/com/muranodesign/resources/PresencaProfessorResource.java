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

import br.com.muranodesign.business.CalendarioService;
import br.com.muranodesign.business.PresencaProfessorService;
import br.com.muranodesign.business.ProfessorFuncionarioVariavelService;
import br.com.muranodesign.model.Calendario;
import br.com.muranodesign.model.PresencaProfessor;
import br.com.muranodesign.model.ProfessorFuncionarioVariavel;
import br.com.muranodesign.util.StringUtil;


/**
 * Classe tem como objetivo disponibilizar os serviços relacionandos presenca professor
 *
 * @author Rogerio Lima dos Santos
 * @version 1.00
 * @since Release 1 da aplicação
 */

@Path("PresencaProfessor")
public class PresencaProfessorResource {

	/** The logger. */
	private Logger logger = Logger.getLogger(PresencaProfessorResource.class.getName());

	/**
	 * Gets the presenca professor.
	 *
	 * @return the presenca professor
	 */
	@GET
	@Produces("application/json")
	public List<PresencaProfessor> getPresencaProfessor() {
		logger.info("Listar PresencaProfessor ...");
		List<PresencaProfessor> resultado;
		resultado = new PresencaProfessorService().listarTodos();
		logger.info("QTD PresencaProfessor : " + resultado.size());
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
	public PresencaProfessor getEvento(@PathParam("id") int id) {
		logger.info("Lista PresencaProfessor  por id " + id);
		List<PresencaProfessor> resultado;
		resultado = new PresencaProfessorService().listarkey(id);
		PresencaProfessor evento = resultado.get(0);

		return evento;

	}
	
	/**
	 * Removes the presenca professor.
	 *
	 * @param action the action
	 * @param id the id
	 * @return the string
	 */
	@Path("{action}/{id}")
	@Produces("text/plain")
	public String removePresencaProfessor(@PathParam("action") String action,
			@PathParam("id") int id) {

		logger.info("PresencaProfessor  " + action);
		if ( action.equals("delete")) {
			List<PresencaProfessor> resultado;
			resultado = new PresencaProfessorService().listarkey(id);
			PresencaProfessor res = resultado.get(0);
			new PresencaProfessorService().deletarPresencaProfessor(res);
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
			
			@FormParam("presenca") String presenca,
			@FormParam("data") String data,
			@FormParam("professor") String professor,
			@FormParam("calendario") String calendario
			
			
			
			) {
		PresencaProfessor objPresencaProfessor = new PresencaProfessor();
		logger.info("eventoAction ...");
		PresencaProfessor resultado;

		
		List<ProfessorFuncionarioVariavel> rsProfessor;
		rsProfessor = new ProfessorFuncionarioVariavelService().listarkey(Integer.parseInt(professor));
		ProfessorFuncionarioVariavel objProfessor= rsProfessor.get(0);
		StringUtil stringUtil = new StringUtil();
		
		List<Calendario> rsCalendario = null;
		Calendario objCalendario = null;
		if (!calendario.isEmpty()){
			rsCalendario = new CalendarioService().listarkey(Integer.parseInt(calendario));
			objCalendario= rsCalendario.get(0);
		}
		
		
		if (action.equals("create")) {
			
			objPresencaProfessor.setProfessor(objProfessor);
			objPresencaProfessor.setData(stringUtil.converteStringData(data));
			objPresencaProfessor.setPresenca(Short.parseShort(presenca));
			objPresencaProfessor.setCalendario(objCalendario);
	
			resultado = new PresencaProfessorService().criarPresencaProfessor(objPresencaProfessor);
			
		}  else if (action.equals("update")) {
			
			int id=Integer.parseInt(strid);
			List<PresencaProfessor> rsPresencaProfessor;
			rsPresencaProfessor= new PresencaProfessorService().listarkey(id);
			objPresencaProfessor= rsPresencaProfessor.get(0);
		
			objPresencaProfessor.setProfessor(objProfessor);
			objPresencaProfessor.setData(stringUtil.converteStringData(data));
			objPresencaProfessor.setPresenca(Short.parseShort(presenca));
			objPresencaProfessor.setCalendario(objCalendario);
			
			
			
			 resultado =  new PresencaProfessorService().atualizarPresencaProfessor(objPresencaProfessor);
			
		} else {
			return "0";
		}
	    return Integer.toString(resultado.getIdpresencaProfessor());
	
		}
	
	

}
