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

import br.com.muranodesign.business.ObjetivoService;
import br.com.muranodesign.business.PlanejamentoRoteiroService;
import br.com.muranodesign.business.PlanoEstudoService;
import br.com.muranodesign.model.Objetivo;
import br.com.muranodesign.model.PlanejamentoRoteiro;
import br.com.muranodesign.model.PlanoEstudo;


/**
 * Classe tem como objetivo disponibilizar os serviços relacionandos planejamento Roteiro
 *
 * @author Rogerio Lima dos Santos
 * @version 1.00
 * @since Release 1 da aplicação
 */


@Path("PlanejamentoRoteiro")
public class PlanejamentoRoteiroResource {

	/** The logger. */
	private Logger logger = Logger.getLogger(PlanejamentoRoteiroResource.class.getName());

	/**
	 * Gets the planejamento roteiro.
	 *
	 * @return the planejamento roteiro
	 */
	@GET
	@Produces("application/json")
	public List<PlanejamentoRoteiro> getPlanejamentoRoteiro() {
		logger.info("Listar PlanejamentoRoteiro ...");
		List<PlanejamentoRoteiro> resultado;
		resultado = new PlanejamentoRoteiroService().listarTodos();
		logger.info("QTD PlanejamentoRoteiro : " + resultado.size());
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
	public PlanejamentoRoteiro getEvento(@PathParam("id") int id) {
		logger.info("Lista PlanejamentoRoteiro  por id " + id);
		List<PlanejamentoRoteiro> resultado;
		resultado = new PlanejamentoRoteiroService().listarkey(id);
		PlanejamentoRoteiro evento = resultado.get(0);

		return evento;

	}
	
	
	/**
	 * Gets the evento.
	 *
	 * @param id the id
	 * @return the evento
	 */
	@Path("aluno/{id}")
	@GET
	@Produces("application/json")
	public  List<PlanejamentoRoteiro>  getIdAluno(@PathParam("id") int id) {
		logger.info("Lista PlanejamentoRoteiro  por id Aluno" + id);
		List<PlanejamentoRoteiro> resultado;
		resultado = new PlanejamentoRoteiroService().listarIdAluno(id);
		

		return resultado;

	}
	
	/**
	 * Removes the planejamento roteiro.
	 *
	 * @param action the action
	 * @param id the id
	 * @return the string
	 */
	@Path("{action}/{id}")
	@Produces("text/plain")
	public String removePlanejamentoRoteiro(@PathParam("action") String action,
			@PathParam("id") int id) {

		logger.info("PlanejamentoRoteiro  " + action);
		if ( action.equals("delete")) {
			List<PlanejamentoRoteiro> resultado;
			resultado = new PlanejamentoRoteiroService().listarkey(id);
			PlanejamentoRoteiro res = resultado.get(0);
			new PlanejamentoRoteiroService().deletarPlanejamentoRoteiro(res);
			return "true";
		} else {
			return "false";
		}

	}
	
	
	
	/**
	 * Evento action.
	 *
	 * @param strid the strid
	 * @param action the action
	 * @param status the status
	 * @param objetivo the objetivo
	 * @param planoEstudo the plano estudo
	 * @return the string
	 */
	@POST
	@Produces("text/plain")
	public String eventoAction(
			
			@FormParam("id") String strid,
			@FormParam("action") String action,
			
			@FormParam("status") String status,
			@FormParam("objetivo") String objetivo,
			@FormParam("planoEstudo") String planoEstudo,
			@FormParam("idAluno") String idAluno
			
			
			
			
			) {
		PlanejamentoRoteiro objPlanejamentoRoteiro;
		PlanejamentoRoteiro resultado;
		
		logger.info("eventoAction ...");
		
		
		objPlanejamentoRoteiro = new PlanejamentoRoteiro();
		
			
		// get tipo Objetivo
		List<Objetivo> rsObjetivo;
		rsObjetivo = new ObjetivoService().listarkey(Integer.parseInt(objetivo));
		Objetivo objObjetivo = rsObjetivo.get(0);
		//TODO: Validar valores.
		
		// get tipo Objetivo
		List<PlanoEstudo> rsPlanoEstudo;
		rsPlanoEstudo= new PlanoEstudoService().listarkey(Integer.parseInt(planoEstudo));
		PlanoEstudo objPlanoEstudo = rsPlanoEstudo.get(0);
		//TODO: Validar valores.
		
		
		
		
	
		if (action.equals("create")) {
			logger.info("Craindo no  Planejamento Roteiro");
			
			objPlanejamentoRoteiro.setObjetivo(objObjetivo);
			objPlanejamentoRoteiro.setPlanoEstudo(objPlanoEstudo);
			objPlanejamentoRoteiro.setStatus(status);
			objPlanejamentoRoteiro.setIdAluno(Integer.parseInt(idAluno));
			resultado = new PlanejamentoRoteiroService().criarPlanejamentoRoteiro(objPlanejamentoRoteiro);
			
		}else if (action.equals("update")) {
			int id=Integer.parseInt(strid);
			List<PlanejamentoRoteiro> rsPlanejamentoRoteiro;
			rsPlanejamentoRoteiro= new PlanejamentoRoteiroService().listarkey(id);
			objPlanejamentoRoteiro= rsPlanejamentoRoteiro.get(0);
			objPlanejamentoRoteiro.setObjetivo(objObjetivo);
			objPlanejamentoRoteiro.setPlanoEstudo(objPlanoEstudo);
			objPlanejamentoRoteiro.setIdAluno(Integer.parseInt(idAluno));
			objPlanejamentoRoteiro.setStatus(status);
			//objEventoEdit = objEvento;
			
			resultado = new PlanejamentoRoteiroService().atualizarPlanejamentoRoteiro(objPlanejamentoRoteiro);
			
		} else {
			
			logger.info("Erro na URI  " + action);
			return "0";
			
		}
		
		return Integer.toString(resultado.getIdplanejamentoRoteiro());

	}
	
	
	
	

}
