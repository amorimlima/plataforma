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

import br.com.muranodesign.business.AlunoService;
import br.com.muranodesign.business.ChamadaService;
import br.com.muranodesign.model.Aluno;
import br.com.muranodesign.model.Chamada;
import br.com.muranodesign.util.StringUtil;


/**
 * Classe tem como objetivo disponibilizar os serviços chamada
 *
 * @author Rogerio Lima dos Santos
 * @version 1.00
 * @since Release 1 da aplicação
 */

@Path("Chamada")
public class ChamadaResource {

	/** The logger. */
	private Logger logger = Logger.getLogger(ChamadaResource.class.getName());

	/**
	 * Gets the chamada.
	 *
	 * @return the chamada
	 */
	@GET
	@Produces("application/json")
	public List<Chamada> getChamada() {
		logger.info("Listar Chamada ...");
		List<Chamada> resultado;
		resultado = new ChamadaService().listarTodos();
		logger.info("QTD Chamada : " + resultado.size());
		return resultado;
	}

	/**
	 * Gets Chamada.
	 *
	 * @param id do aluno
	 * @return the Chamada
	 */
	@Path("{id}")
	@GET
	@Produces("application/json")
	public Chamada getChamada(@PathParam("id") int id) {
		logger.info("Lista Chamada  por id " + id);
		List<Chamada> resultado;
		resultado = new ChamadaService().listarkey(id);
		Chamada evento = resultado.get(0);

		return evento;

	}
	
	
	/**
	 * Gets Chamada.
	 *
	 * @param id do aluno
	 * @param precenca
	 * @return the Chamada
	 */
	@Path("{idAluno}/{precenca}")
	@GET
	@Produces("application/json")
	public List<Chamada> getPrecenca(@PathParam("idAluno") int idAluno , @PathParam("precenca") int precenca ) {
		logger.info("Buscar precenca por id do Aluno " + idAluno);
		
		//int id = Integer.parseInt(strid);
		List<Aluno> rsAluno;
		rsAluno = new AlunoService().listarkey(idAluno);
		Aluno objAluno = null;
		Chamada chamada = null;
		List<Chamada> resultado = null;
		if (! rsAluno.isEmpty()){
			objAluno = rsAluno.get(0);
			
			
			logger.info("Buscar precenca por id do Aluno " + idAluno + "precenca = " + precenca  );
			resultado = new ChamadaService().listaPrecenca(objAluno, precenca);
		} 
		
		
		return resultado;

	}
	
	
	/**
	 * Gets Chamada.
	 *
	 * @param id do aluno
	 * @param precenca
	 * @return Total de precenca
	 */
	@Path("total/{idAluno}/{precenca}")
	@GET
	@Produces("application/json")
	public int getPrecencaTotal(@PathParam("idAluno") int idAluno , @PathParam("precenca") int precenca ) {
		logger.info("Buscar precenca por id do Aluno " + idAluno);
		
		//int id = Integer.parseInt(strid);
		List<Aluno> rsAluno;
		rsAluno = new AlunoService().listarkey(idAluno);
		Aluno objAluno = null;
		Chamada chamada = null;
		int total = 0;
		if (! rsAluno.isEmpty()){
			objAluno = rsAluno.get(0);
			List<Chamada> resultado;
			
			logger.info("Buscar precenca por id do Aluno " + idAluno + "precenca = " + precenca  );
			resultado = new ChamadaService().listaPrecenca(objAluno, precenca);
			total = resultado.size();
		} 
		
		
		return total;

	}
	
	
	
	/**
	 * Removes the chamada.
	 *
	 * @param action the action
	 * @param id the id
	 * @return the string
	 */
	@Path("{action}/{id}")
	@Produces("text/plain")
	public String removeChamada(@PathParam("action") String action,
			@PathParam("id") int id) {

		logger.info("Chamada  " + action);
		if ( action.equals("delete")) {
			List<Chamada> resultado;
			resultado = new ChamadaService().listarkey(id);
			Chamada evento = resultado.get(0);
			new ChamadaService().deletarChamada(evento);
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
			@FormParam("aluno") String aluno
			
			
			
			) {
		Chamada objChamada = new Chamada();
		logger.info("eventoAction ...");
		Chamada resultado;

		
		List<Aluno> rsAluno;
		rsAluno = new AlunoService().listarkey(Integer.parseInt(aluno));
		Aluno objAluno= rsAluno.get(0);
		StringUtil stringUtil = new StringUtil();
		
		
	
		
		
		
		if (action.equals("create")) {
			
			objChamada.setAluno(objAluno);
			objChamada.setData(stringUtil.converteStringData(data));
			objChamada.setPresenca(Short.parseShort(presenca));
			
			resultado = new ChamadaService().criarChamada(objChamada);
			
		}  else if (action.equals("update")) {
			
			int id=Integer.parseInt(strid);
			List<Chamada> rsChamada;
			rsChamada= new ChamadaService().listarkey(id);
			objChamada= rsChamada.get(0);
		
			objChamada.setAluno(objAluno);
			objChamada.setData(stringUtil.converteStringData(data));
			objChamada.setPresenca(Short.parseShort(presenca));
			
			
			
			 resultado =  new ChamadaService().atualizarChamada(objChamada);
			
		} else {
			return "0";
		}
	    return Integer.toString(resultado.getIdchamada());
	
		}
	

}
