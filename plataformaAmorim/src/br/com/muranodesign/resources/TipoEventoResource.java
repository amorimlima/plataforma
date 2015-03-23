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

import br.com.muranodesign.business.TipoEventoService;
import br.com.muranodesign.model.TipoEvento;




/**
 * Classe tem como objetivo disponibilizar os serviços relacionandos tipo de evento
 *
 * @author Rogerio Lima dos Santos
 * @version 1.00
 * @since Release 1 da aplicação
 */


@Path("TipoEvento")
public class TipoEventoResource {

	/** The logger. */
	private Logger logger = Logger.getLogger(TipoEventoResource.class.getName());
	
	/**
	 * Gets the tipo evento.
	 *
	 * @return the tipo evento
	 */
	@GET
	@Produces("application/json")
	public List<TipoEvento> getTipoEvento() {
		logger.debug("Listar TipoEvento ...");
		List<TipoEvento> resultado;
		 resultado = new TipoEventoService().listarTodos();
		 logger.debug("QTD TipoEvento : " +  resultado.size());
		return resultado;
	}

	/**
	 * Gets the tipo evento.
	 *
	 * @param id the id
	 * @return the tipo evento
	 */
	@Path("{id}")
	@GET
	@Produces("application/json")
	public TipoEvento getTipoEvento(@PathParam("id") int id) {
		
		logger.debug("Lista TipoEvento  por id " + id );
		 List<TipoEvento> resultado;
		 resultado = new TipoEventoService().listarkey(id);
		 TipoEvento tipoEvento = resultado.get(0);
		 
		return tipoEvento;
		
	}

  
	/**
	 * Removes the tipo evento.
	 *
	 * @param id the id
	 * @return the string
	 */
	@Path("{id}")
	@DELETE
	@Produces("text/plain")
	public String removeTipoEvento(@PathParam("id") int id) {
		
		logger.debug("Remover TipoEvento " + id );
		
		List<TipoEvento> resultado;
		 resultado = new TipoEventoService().listarkey(id);
		 TipoEvento tipoEvento = resultado.get(0);

		new TipoEventoService().deletarTipoEvento(tipoEvento);

		return "Deletado";

	}
	
	/**
	 * Ataualiza tipo evento.
	 *
	 * @param id the id
	 * @return the string
	 */
	@Path("{id}")
	@POST
	@Produces("text/plain")
	public String ataualizaTipoEvento(@PathParam("id") int id) {
		
		logger.debug("Remover TipoEvento " + id );
		
		List<TipoEvento> resultado;
		 resultado = new TipoEventoService().listarkey(id);
		 TipoEvento tipoEvento = resultado.get(0);

		new TipoEventoService().deletarTipoEvento(tipoEvento);

		return "Deletado";

	}
	
	/**
	 * Evento action.
	 *
	 * @param tipoEvento the tipo evento
	 * @param strid the strid
	 * @param action the action
	 * @return the string
	 */
	@POST
	@Produces("text/plain")
	public String eventoAction(
			
			@FormParam("tipoEvento") String tipoEvento,
			@FormParam("id") String strid,
			@FormParam("action") String action
	
			) {
		TipoEvento obj;
		obj = new TipoEvento();
		
		TipoEvento resutado;
		
		
		
	
		if (action.equals("create")) {
			logger.info("Criando no  evento");
			obj.setTipoEvento(tipoEvento);
			resutado = new TipoEventoService().criarTipoEvento(obj);
		}else if (action.equals("update")) {
			int id=Integer.parseInt(strid);
			logger.info("Atualizando tipoEvento" + id);
			logger.info("tipoEvento " + tipoEvento);
		
			List<TipoEvento> lst;
			lst = new TipoEventoService().listarkey(id);
			TipoEvento objEdit = lst.get(0);
			objEdit.setIdtipoEvento(id);
			objEdit.setTipoEvento(tipoEvento);
			
			
			
			resutado= new TipoEventoService().atualizarTipoEvento(objEdit);
			
		} else {
			
			logger.info("Erro na URI  " + action);
			return "0";
			
		}
		
		return  Integer.toString(resutado.getIdtipoEvento());

	}
	
	
	
}
