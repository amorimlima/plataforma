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

import br.com.muranodesign.business.ObjetivoService;
import br.com.muranodesign.business.RoteiroService;
import br.com.muranodesign.model.Objetivo;
import br.com.muranodesign.model.Roteiro;




/**
 * Classe tem como objetivo disponibilizar os serviços relacionandos a objetivo
 *
 * @author Rogerio Lima dos Santos
 * @version 1.00
 * @since Release 1 da aplicação
 */
@Path("Objetivo")
public class ObjetivoResource {

	/** The logger. */
	private Logger logger = Logger.getLogger(ObjetivoResource.class.getName());
	
	/**
	 * Gets the objetivo.
	 *
	 * @return the objetivo
	 */
	@GET
	//@Produces("text/xml")
	@Produces("application/json")
	public List<Objetivo> getObjetivo() {
		logger.debug("Listar Objetivo ...");
		List<Objetivo> resultado;
		 resultado = new ObjetivoService().listarTodos();
		 logger.debug("QTD Objetivo : " +  resultado.size());
		return resultado;
	}

	/**
	 * Gets the objetivo.
	 *
	 * @param id the id
	 * @return the objetivo
	 */
	@Path("{id}")
	@GET
	//@Produces("text/xml")
	@Produces("application/json")
	public Objetivo getObjetivo(@PathParam("id") int id) {
		
		logger.debug("Lista Evento  por id " + id );
		 List<Objetivo> resultado;
		 resultado = new ObjetivoService().listarkey(id);
		 Objetivo Objetivo = resultado.get(0);
		 
		return Objetivo;
		
	}

  
	/**
	 * Removes the objetivo.
	 *
	 * @param id the id
	 * @return the string
	 */
	@Path("{id}")
	@DELETE
	@Produces("text/plain")
	public String removeObjetivo(@PathParam("id") int id) {
		
		logger.debug("Remover Objetivo " + id );
		
		List<Objetivo> resultado;
		 resultado = new ObjetivoService().listarkey(id);
		 Objetivo Objetivo = resultado.get(0);

		new ObjetivoService().deletarObjetivo(Objetivo);

		return "Deletado";

	}
	
	
	
	
	/**
	 * Evento action.
	 *
	 * @param action the action
	 * @param strid the strid
	 * @param nome the nome
	 * @param descricao the descricao
	 * @param numero the numero
	 * @param roteiro the roteiro
	 * @return the string
	 */
	@POST
	@Produces("text/plain")
	public String eventoAction(
			
			@FormParam("action") String action,
			@FormParam("id") String strid,
			@FormParam("nome") String nome,
			@FormParam("descricao") String descricao,
			@FormParam("numero") String numero,
			@FormParam("roteiro") String roteiro,
			@FormParam("ativo") String ativo
			
			) {
		Objetivo objObjetivo= new Objetivo();
		logger.info("eventoAction ...");
		Objetivo resultado;
		
		
		List<Roteiro> rsRoteiro;
		rsRoteiro = new RoteiroService().listarkey(Integer.parseInt(roteiro));
		Roteiro objRoteiro = rsRoteiro.get(0);
		
		if (action.equals("create")) {
			
			//objUsuario.setLogin(login);
			objObjetivo.setNome(nome);
			objObjetivo.setDescricao(descricao);
			objObjetivo.setNumero(Integer.parseInt(numero));
			objObjetivo.setRoteiro(objRoteiro);
			objObjetivo.setAtivo(Integer.parseInt(ativo));
			
			resultado = new ObjetivoService().criarObjetivo(objObjetivo);
			
		} else if (action.equals("update")) {
			int id=Integer.parseInt(strid);
			List<Objetivo> rsObjetivo;
			rsObjetivo = new ObjetivoService().listarkey(id);
			objObjetivo= rsObjetivo.get(0);
			objObjetivo.setIdobjetivo(id);
			objObjetivo.setAtivo(Integer.parseInt(ativo));
			objObjetivo.setNome(nome);
			objObjetivo.setDescricao(descricao);
			objObjetivo.setNumero(Integer.parseInt(numero));
			objObjetivo.setRoteiro(objRoteiro);
			
			
			resultado = new ObjetivoService().atualizarObjetivo(objObjetivo);
			
		} else {
			return "0";
		}
		
		return Integer.toString(resultado.getIdobjetivo());
	}
	
	
	
	
}
