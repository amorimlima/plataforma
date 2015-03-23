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

import br.com.muranodesign.business.PerfilService;
import br.com.muranodesign.model.Perfil;


/**
 * Classe tem como objetivo disponibilizar os serviços relacionandos perfil.
 *
 * @author Rogerio Lima dos Santos
 * @version 1.00
 * @since Release 1 da aplicação
 */
@Path("Perfil")
public class PerfilResource {

	/** The logger. */
	private Logger logger = Logger.getLogger(PerfilResource.class.getName());

	/**
	 * Gets the perfil.
	 *
	 * @return the perfil
	 */
	@GET
	@Produces("application/json")
	public List<Perfil> getPerfil() {
		logger.info("Listar Perfil ...");
		List<Perfil> resultado;
		resultado = new PerfilService().listarTodos();
		logger.info("QTD Perfil : " + resultado.size());
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
	public Perfil getEvento(@PathParam("id") int id) {
		logger.info("Lista Perfil  por id " + id);
		List<Perfil> resultado;
		resultado = new PerfilService().listarkey(id);
		Perfil evento = resultado.get(0);

		return evento;

	}
	
	/**
	 * Removes the perfil.
	 *
	 * @param action the action
	 * @param id the id
	 * @return the string
	 */
	@Path("{action}/{id}")
	@Produces("text/plain")
	public String removePerfil(@PathParam("action") String action,
			@PathParam("id") int id) {

		logger.info("Perfil  " + action);
		if ( action.equals("delete")) {
			List<Perfil> resultado;
			resultado = new PerfilService().listarkey(id);
			Perfil res = resultado.get(0);
			new PerfilService().deletarPerfil(res);
			return "true";
		} else {
			return "false";
		}

	}
	
	/**
	 * Evento action.
	 *
	 * @param action the action
	 * @param strid the strid
	 * @param perfil the perfil
	 * @param descricao the descricao
	 * @return the string
	 */
	@POST
	@Produces("text/plain")
	public String eventoAction(
			
			@FormParam("action") String action,
			@FormParam("id") String strid,
			
			@FormParam("perfil") String perfil,
			@FormParam("descricao") String descricao
			
			) {
		Perfil objPerfil = new Perfil();
		logger.info("eventoAction ...");
		Perfil resultado;
		
		if (action.equals("create")) {
			
			//objUsuario.setLogin(login);
			objPerfil.setPerfil(perfil);
			objPerfil.setDescricao(descricao);
			resultado= new PerfilService().criarPerfil(objPerfil);
			
		} else if (action.equals("update")) {
			int id=Integer.parseInt(strid);
			List<Perfil> rsPerfil;
			rsPerfil = new PerfilService().listarkey(id);
			objPerfil = rsPerfil.get(0);
			objPerfil.setIdperfil(id);
			objPerfil.setPerfil(perfil);
			objPerfil.setDescricao(descricao);
			resultado= new PerfilService().atualizarPerfil(objPerfil);
			
		} else {
			return "0";
		}
		
		return Integer.toString(resultado.getIdperfil());
	}
		
	
	

}
