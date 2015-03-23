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

import br.com.muranodesign.business.AnoEstudoService;
import br.com.muranodesign.model.AnoEstudo;


/**
 * Classe tem como objetivo disponibilizar os serviços relacionandos ano de estudo
 * 
 * @author Rogerio Lima dos Santos
 * @version 1.00
 * @since Release 1 da aplicação
 */
@Path("AnoEstudo")
public class AnoEstudoResource {

	/**  logger. */
	private Logger logger = Logger.getLogger(AnoEstudoResource.class.getName());

	/**
	 * Lista ano estudo.
	 *
	 * @return anos estudo
	 */
	@GET
	@Produces("application/json")
	public List<AnoEstudo> getAnoEstudo() {
		logger.info("Listar AnoEstudo ...");
		List<AnoEstudo> resultado;
		resultado = new AnoEstudoService().listarTodos();
		logger.info("QTD AnoEstudo : " + resultado.size());
		return resultado;
	}

	/**
	 * Lista AnoEstudo de estudo especifico.
	 *
	 * @param id do ano letivo
	 * @return the ano letivo
	 */
	@Path("{id}")
	@GET
	@Produces("application/json")
	public AnoEstudo getEvento(@PathParam("id") int id) {
		logger.info("Lista AnoEstudo  por id " + id);
		List<AnoEstudo> resultado;
		resultado = new AnoEstudoService().listarkey(id);
		AnoEstudo evento = resultado.get(0);

		return evento;

	}
	
	/**
	 * Remove o ano estudo.
	 *
	 * @param action
	 * @param id do ano a ser deletado
	 * @return true se for excluido e false se der erro.
	 */
	@Path("{action}/{id}")
	@Produces("text/plain")
	public String removeAnoEstudo(@PathParam("action") String action,
			@PathParam("id") int id) {

		logger.info("AnoEstudo  " + action);
		if ( action.equals("delete")) {
			List<AnoEstudo> resultado;
			resultado = new AnoEstudoService().listarkey(id);
			AnoEstudo res = resultado.get(0);
			new AnoEstudoService().deletarAnoEstudo(res);
			return "true";
		} else {
			return "false";
		}

	}
	
	
	/**
	 * Serviço reponsavel por cadastra e atualizar dados do ano de estudo
	 *
	 * @param action Metodo a ser executado create ou update
	 * @param strid id para update
	 * @param ano  
	 * @return identificador de controle interno da aplicação
	 */
	@POST
	@Produces("text/plain")
	public String eventoAction(
			
			@FormParam("action") String action,
			@FormParam("id") String strid,
			@FormParam("ano") String ano
			
			
			) {
		AnoEstudo objAnoEstudo= new AnoEstudo();
		logger.info("eventoAction ...");
		AnoEstudo resultado;

		if (action.equals("create")) {
			objAnoEstudo.setAno(ano);
			 resultado = new AnoEstudoService().criarAnoEstudo(objAnoEstudo);
			
		}  else if (action.equals("update")) {
			
			int id=Integer.parseInt(strid);
			List<AnoEstudo> rsAnoEstudo;
			rsAnoEstudo= new AnoEstudoService().listarkey(id);
			objAnoEstudo= rsAnoEstudo.get(0);
			objAnoEstudo.setIdanoEstudo(id);
			objAnoEstudo.setAno(ano);
			
			 resultado =  new AnoEstudoService().atualizarAnoEstudo(objAnoEstudo);
			
		} else {
			return "0";
		}
	    return Integer.toString(resultado.getIdanoEstudo());
	
		}
	
	
	
	
	

}
