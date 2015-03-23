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
import br.com.muranodesign.business.GrupoService;
import br.com.muranodesign.business.TutoriaService;
import br.com.muranodesign.model.Aluno;
import br.com.muranodesign.model.Grupo;
import br.com.muranodesign.model.Tutoria;


/**
 * Classe tem como objetivo disponibilizar os serviços relacionandosa grupos
 *
 * @author Rogerio Lima dos Santos
 * @version 1.00
 * @since Release 1 da aplicação
 */
@Path("Grupo")
public class GrupoResource {

	/** The logger. */
	private Logger logger = Logger.getLogger(GrupoResource.class.getName());

	/**
	 * Gets the grupo.
	 *
	 * @return the grupo
	 */
	@GET
	@Produces("application/json")
	public List<Grupo> getGrupo() {
		logger.info("Listar Grupo ...");
		List<Grupo> resultado;
		resultado = new GrupoService().listarTodos();
		logger.info("QTD Grupo : " + resultado.size());
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
	public Grupo getEvento(@PathParam("id") int id) {
		logger.info("Lista Grupo  por id " + id);
		List<Grupo> resultado;
		resultado = new GrupoService().listarkey(id);
		Grupo evento = resultado.get(0);

		return evento;

	}
	
	/**
	 * Removes the grupo.
	 *
	 * @param action the action
	 * @param id the id
	 * @return the string
	 */
	@Path("{action}/{id}")
	@Produces("text/plain")
	public String removeGrupo(@PathParam("action") String action,
			@PathParam("id") int id) {

		logger.info("Grupo  " + action);
		if ( action.equals("delete")) {
			List<Grupo> resultado;
			resultado = new GrupoService().listarkey(id);
			Grupo res = resultado.get(0);
			new GrupoService().deletarGrupo(res);
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
			
			@FormParam("nomeGrupo") String nomeGrupo,
			@FormParam("lider") String lider,
			@FormParam("tutoria") String tutoria
			
			
			
			) {
		Grupo objGrupo = new Grupo();
		logger.info("eventoAction ...");
		Grupo resultado;

		Aluno objAluno = null;
		if (!lider.isEmpty()){
			List<Aluno> rsAluno;
			rsAluno = new AlunoService().listarkey(Integer.parseInt(lider));
			if (!rsAluno.isEmpty()){
				objAluno= rsAluno.get(0);
			}
		
		}
		
		
		
		List<Tutoria> rsTutoria;
		rsTutoria= new TutoriaService().listarkey(Integer.parseInt(tutoria));
		Tutoria objTutoria = rsTutoria.get(0);
		
		
		
		if (action.equals("create")) {
			
			objGrupo.setNomeGrupo(nomeGrupo);
			objGrupo.setLider(objAluno);
			objGrupo.setTutoria(objTutoria);
			
			resultado = new GrupoService().criarGrupo(objGrupo);
			
		}  else if (action.equals("update")) {
			
			int id=Integer.parseInt(strid);
			List<Grupo> rsGrupo;
			rsGrupo= new GrupoService().listarkey(id);
			objGrupo= rsGrupo.get(0);
			objGrupo.setNomeGrupo(nomeGrupo);
			objGrupo.setLider(objAluno);
			objGrupo.setTutoria(objTutoria);
			
			
			
			
			 resultado =  new GrupoService().atualizarGrupo(objGrupo);
			
		} else {
			return "0";
		}
	    return Integer.toString(resultado.getIdgrupo());
	
		}
	
	
	@Path("liderGrupo")
	@POST
	@Produces("text/plain")
	public String eventoAction2( @FormParam("lider") String lider,
			@FormParam("grupo") String grupo){
		
		  Grupo objGrupo = new Grupo();
		  Aluno objAluno = new Aluno();
	   
	        	List<Grupo> rsGrupo;
	    		rsGrupo = new GrupoService().listarkey(Integer.parseInt(grupo));
	    		if (!rsGrupo.isEmpty()) {
	    			objGrupo= rsGrupo.get(0);
	    			List<Aluno> rsAluno;
		    		rsAluno = new AlunoService().listarkey(Integer.parseInt(lider));
		    		objAluno= rsAluno.get(0);
	    			objGrupo.setLider(objAluno);
	    			 new GrupoService().atualizarGrupo(objGrupo);
	    			
	    		} else {
	    			logger.info("Não foi possivel completar a operacao");
	    			return "false";
	    			
	    		}
	    		
	    		
	
		
		return "true";
	}
	
	
	

}
