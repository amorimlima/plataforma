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

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.log4j.Logger;

import br.com.muranodesign.business.AnoLetivoService;
import br.com.muranodesign.model.AnoLetivo;


/**
 * Classe tem como objetivo disponibilizar os serviços relacionandos ano letivo.
 *
 * @author Rogerio Lima dos Santos
 * @version 1.00
 * @since Release 1 da aplicação
 */
@Path("AnoLetivo")
public class AnoLetivoResource {

	/**  logger. */
	private Logger logger = Logger.getLogger(AnoLetivoResource.class.getName());
	
	/**
	 * Lista ano letivo.
	 *
	 * @return anos letivo
	 */
	@GET
	//@Produces("text/xml")
	@Produces("application/json")
	public List<AnoLetivo> getAnoLetivo() {
		logger.debug("Listar AnoLetivo ...");
		List<AnoLetivo> resultado;
		 resultado = new AnoLetivoService().listarTodos();
		 logger.debug("QTD AnoLetivo : " +  resultado.size());
		return resultado;
	}

	/**
	 * Lista ano letivo de estudo especifico.
	 *
	 * @param id do ano letivo
	 * @return  ano letivo
	 */
	@Path("{id}")
	@GET
	//@Produces("text/xml")
	@Produces("application/json")
	public AnoLetivo getAnoLetivo(@PathParam("id") int id) {
		
		logger.debug("Lista Evento  por id " + id );
		 List<AnoLetivo> resultado;
		 resultado = new AnoLetivoService().listarkey(id);
		 AnoLetivo anoLetivo = resultado.get(0);
		 
		return anoLetivo;
		
	}

  
	/**
	 * Remove ano letivo.
	 *
	 * @param id do  ano letivo
	 * @return Deletado quando houver sucesso na deleção.
	 */
	@Path("{id}")
	@DELETE
	@Produces("text/plain")
	public String removeAnoLetivo(@PathParam("id") int id) {
		
		logger.debug("Remover AnoLetivo " + id );
		
		List<AnoLetivo> resultado;
		 resultado = new AnoLetivoService().listarkey(id);
		 AnoLetivo anoLetivo = resultado.get(0);

		new AnoLetivoService().deletarAnoLetivo(anoLetivo);

		return "Deletado";

	}
	
	
	
	
	/**
	 * Serviço reponsavel por cadastra e atualizar dados do  ano letivo
	 *
	 * @param action Metodo a ser executado create ou update
	 * @param strid id para update
	 * @param ano letivo
	 * @return identificador de controle interno da aplicação
	 */
	@POST
	@Produces("text/plain")
	public String eventoAction(
			
			@FormParam("action") String action,
			@FormParam("id") String strid,
			@FormParam("ano") String ano
			
			
			) {
		AnoLetivo objAnoLetivo= new AnoLetivo();
		logger.info("eventoAction ...");
		AnoLetivo resultado;

		
		
		if (action.equals("create")) {
			objAnoLetivo.setAno(ano);
			 resultado = new AnoLetivoService().criarAnoLetivo(objAnoLetivo);
			
		}  else if (action.equals("update")) {
			
			int id=Integer.parseInt(strid);
			List<AnoLetivo> rsAnoLetivo;
			rsAnoLetivo= new AnoLetivoService().listarkey(id);
			objAnoLetivo= rsAnoLetivo.get(0);
			objAnoLetivo.setIdanoLetivo(id);
			objAnoLetivo.setAno(ano);
			
			 resultado =  new AnoLetivoService().atualizarAnoLetivo(objAnoLetivo);
			
		} else {
			return "0";
		}
	    return Integer.toString(resultado.getIdanoLetivo());
	
		}
	
	
	
	
}
