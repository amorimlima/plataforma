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
import br.com.muranodesign.business.RelatorioTutoriaService;
import br.com.muranodesign.business.TutoriaService;
import br.com.muranodesign.model.Aluno;
import br.com.muranodesign.model.RelatorioTutoria;
import br.com.muranodesign.model.Tutoria;
import br.com.muranodesign.util.StringUtil;


/**
 * Classe tem como objetivo disponibilizar os serviços relacionandos relatorio tutoria
 *
 * @author Rogerio Lima dos Santos
 * @version 1.00
 * @since Release 1 da aplicação
 */
@Path("RelatorioTutoria")
public class RelatorioTutoriaResource {

	/** The logger. */
	private Logger logger = Logger.getLogger(RelatorioTutoriaResource.class.getName());

	/**
	 * Gets the relatorio tutoria.
	 *
	 * @return the relatorio tutoria
	 */
	@GET
	@Produces("application/json")
	public List<RelatorioTutoria> getRelatorioTutoria() {
		logger.info("Listar RelatorioTutoria ...");
		List<RelatorioTutoria> resultado;
		resultado = new RelatorioTutoriaService().listarTodos();
		logger.info("QTD RelatorioTutoria : " + resultado.size());
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
	public RelatorioTutoria getEvento(@PathParam("id") int id) {
		logger.info("Lista RelatorioTutoria  por id " + id);
		List<RelatorioTutoria> resultado;
		resultado = new RelatorioTutoriaService().listarkey(id);
		RelatorioTutoria evento = resultado.get(0);

		return evento;

	}
	
	/**
	 * Removes the relatorio tutoria.
	 *
	 * @param action the action
	 * @param id the id
	 * @return the string
	 */
	@Path("{action}/{id}")
	@Produces("text/plain")
	public String removeRelatorioTutoria(@PathParam("action") String action,
			@PathParam("id") int id) {

		logger.info("RelatorioTutoria  " + action);
		if ( action.equals("delete")) {
			List<RelatorioTutoria> resultado;
			resultado = new RelatorioTutoriaService().listarkey(id);
			RelatorioTutoria res = resultado.get(0);
			new RelatorioTutoriaService().deletarRelatorioTutoria(res);
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
			
			@FormParam("relatorio") String relatorio,
			@FormParam("data") String data,
			
			@FormParam("tutoria") String tutoria,
			@FormParam("aluno") String aluno
			
			
			) {
		RelatorioTutoria objRelatorioTutoria = new RelatorioTutoria();
		logger.info("eventoAction ...");
		logger.info("aluno  ..." + aluno );
		logger.info("Tutoria  ..." + tutoria );
		logger.info("relatorio  ..." + relatorio );
		logger.info("data  ..." + data );
		
		
		RelatorioTutoria resultado;

		
		List<Tutoria> rsTutoria;
	
		rsTutoria = new TutoriaService().listarkey(Integer.parseInt(tutoria));
		Tutoria objTutoria= rsTutoria.get(0);
		
		logger.info("aluno  ..." + aluno );
		List<Aluno> rsAluno;
		rsAluno = new AlunoService().listarkey(Integer.parseInt(aluno));
		Aluno objAluno= rsAluno.get(0);
		
		
		StringUtil stringUtil = new StringUtil();
		
		
		
		if (action.equals("create")) {
			
			objRelatorioTutoria.setAluno(objAluno);
			objRelatorioTutoria.setData(stringUtil.converteStringData(data));
			objRelatorioTutoria.setTutoria(objTutoria);
			objRelatorioTutoria.setRelatorio(relatorio);
			
			resultado = new RelatorioTutoriaService().criarRelatorioTutoria(objRelatorioTutoria);
			
		}  else if (action.equals("update")) {
			
			int id=Integer.parseInt(strid);
			List<RelatorioTutoria> rsRelatorioTutoria;
			rsRelatorioTutoria= new RelatorioTutoriaService().listarkey(id);
			objRelatorioTutoria= rsRelatorioTutoria.get(0);
		
			objRelatorioTutoria.setAluno(objAluno);
			objRelatorioTutoria.setData(stringUtil.converteStringData(data));
			objRelatorioTutoria.setTutoria(objTutoria);
			objRelatorioTutoria.setRelatorio(relatorio);
			
			 resultado =  new RelatorioTutoriaService().atualizarRelatorioTutoria(objRelatorioTutoria);
			
		} else {
			return "0";
		}
	    return Integer.toString(resultado.getIdrelatorioTutoria());
	
		}
	

}
