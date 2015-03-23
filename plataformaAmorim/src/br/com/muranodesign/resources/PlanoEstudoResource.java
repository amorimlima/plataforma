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

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.log4j.Logger;

import br.com.muranodesign.business.AlunoService;
import br.com.muranodesign.business.PlanoEstudoService;
import br.com.muranodesign.model.Aluno;
import br.com.muranodesign.model.PlanoEstudo;


/**
 * Classe tem como objetivo disponibilizar os serviços relacionandos plano de estudo
 *
 * @author Rogerio Lima dos Santos
 * @version 1.00
 * @since Release 1 da aplicação
 */
@Path("PlanoEstudo")
public class PlanoEstudoResource {

	/** The logger. */
	private Logger logger = Logger.getLogger(PlanoEstudoResource.class.getName());

	/**
	 * Gets the plano estudo.
	 *
	 * @return the plano estudo
	 */
	@GET
	@Produces("application/json")
	public List<PlanoEstudo> getPlanoEstudo() {
		logger.info("Listar PlanoEstudo ...");
		List<PlanoEstudo> resultado;
		resultado = new PlanoEstudoService().listarTodos();
		logger.info("QTD PlanoEstudo : " + resultado.size());
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
	public PlanoEstudo getEvento(@PathParam("id") int id) {
		logger.info("Lista PlanoEstudo  por id " + id);
		List<PlanoEstudo> resultado;
		resultado = new PlanoEstudoService().listarkey(id);
		PlanoEstudo evento = resultado.get(0);

		return evento;

	}
	
	@Path("aluno/{id}")
	@GET
	@Produces("application/json")
	public List<PlanoEstudo> getAluno(@PathParam("id") int id) {
		logger.info("Lista AlunoVariavel  por id " + id);
		List<PlanoEstudo> resultado;
		resultado = new PlanoEstudoService().utimoPlanoEstudos(id);
		//PlanoEstudo evento = resultado.get(0);

		return resultado;

	}
	
	
	
	
	
	/**
	 * Removes the plano estudo.
	 *
	 * @param action the action
	 * @param id the id
	 * @return the string
	 */
	@Path("{action}/{id}")
	@Produces("text/plain")
	public String removePlanoEstudo(@PathParam("action") String action,
			@PathParam("id") int id) {

		logger.info("PlanoEstudo  " + action);
		if ( action.equals("delete")) {
			List<PlanoEstudo> resultado;
			resultado = new PlanoEstudoService().listarkey(id);
			PlanoEstudo res = resultado.get(0);
			new PlanoEstudoService().deletarPlanoEstudo(res);
			return "true";
		} else {
			return "false";
		}

	}
	
	
	/**
	 * Evento action.
	 *
	 * @param strid the strid
	 * @param dataInicio the data inicio
	 * @param action the action
	 * @param objetivoTutoria the objetivo tutoria
	 * @param objetivoPessoal the objetivo pessoal
	 * @param tarefaDeCasa the tarefa de casa
	 * @param autoAvaliacao the auto avaliacao
	 * @param observacoesTutor the observacoes tutor
	 * @param observacoesPais the observacoes pais
	 * @param status the status
	 * @param dataFim the data fim
	 * @param aluno the aluno
	 * @return the string
	 */
	@POST
	@Produces("text/plain")
	public String eventoAction(
			
			@FormParam("id") String strid,
			@FormParam("dataInicio") String dataInicio,
			@FormParam("action") String action,
			@FormParam("objetivoTutoria") String objetivoTutoria,
			@FormParam("objetivoPessoal") String objetivoPessoal,
			@FormParam("tarefaDeCasa") String tarefaDeCasa, 
			@FormParam("autoAvaliacao") String autoAvaliacao,
			@FormParam("observacoesTutor") String observacoesTutor,
			@FormParam("observacoesPais") String observacoesPais,
			@FormParam("status") String status,
			@FormParam("dataFim") String dataFim,
			@FormParam("aluno") String aluno
			
			) {
		PlanoEstudo objPlanoEstudo;

		
		logger.info("eventoAction ...");
		
		Date dataIncioConvertido = null;
		Date dataFimConvertido = null;
		//TODO: Ajustar o tratamento de erro DD-MM-YYYY
		DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		try {
			dataIncioConvertido = (Date) formatter.parse(dataInicio);
			dataFimConvertido = (Date) formatter.parse(dataFim);
		} catch (ParseException e) {
			e.printStackTrace();
			
		}
		
		logger.info("eventoAction  2...");
		
		objPlanoEstudo = new PlanoEstudo();
		PlanoEstudo resultado;
			
		
		// get tipo aluno
		List<Aluno> rsAluno;
		rsAluno = new AlunoService().listarkey(Integer.parseInt(aluno));
		Aluno objAluno = rsAluno.get(0);
		//TODO: Validar valores.
		
		
		
		
	
		if (action.equals("create")) {
			logger.info("Criando no  Plano de Estudos");
			objPlanoEstudo.setDataInicio(dataIncioConvertido);
			objPlanoEstudo.setObjetivoTutoria(objetivoTutoria);
			
			objPlanoEstudo.setObjetivoPessoal(objetivoPessoal);
			objPlanoEstudo.setTarefaDeCasa(tarefaDeCasa);
			objPlanoEstudo.setAutoAvaliacao(autoAvaliacao);
			objPlanoEstudo.setObservacoesTutor(observacoesTutor);
			objPlanoEstudo.setObservacoesPais(observacoesPais);
			objPlanoEstudo.setStatus(Short.parseShort(status));
			objPlanoEstudo.setAluno(objAluno);
			objPlanoEstudo.setDataFim(dataFimConvertido);
			
			
			resultado=new PlanoEstudoService().criarPlanoEstudo(objPlanoEstudo);
		}else if (action.equals("update")) {
			int id=Integer.parseInt(strid);
			
			
			
			
			List<PlanoEstudo> rsPlanoEstudo;
			rsPlanoEstudo = new PlanoEstudoService().listarkey(id);
			objPlanoEstudo = rsPlanoEstudo.get(0);
			objPlanoEstudo.setIdplanoEstudo(id);
			objPlanoEstudo.setDataInicio(dataIncioConvertido);
			objPlanoEstudo.setObjetivoTutoria(objetivoTutoria);
			objPlanoEstudo.setObjetivoPessoal(objetivoPessoal);
			objPlanoEstudo.setTarefaDeCasa(tarefaDeCasa);
			objPlanoEstudo.setAutoAvaliacao(autoAvaliacao);
			objPlanoEstudo.setObservacoesTutor(observacoesTutor);
			objPlanoEstudo.setObservacoesPais(observacoesPais);
			objPlanoEstudo.setStatus(Short.parseShort(status));
			objPlanoEstudo.setAluno(objAluno);
			objPlanoEstudo.setDataFim(dataFimConvertido);
			
			//objEventoEdit = objEvento;
			
			resultado=new PlanoEstudoService().atualizarPlanoEstudo(objPlanoEstudo);
			
		} else {
			
			logger.info("Erro na URI  " + action);
			return "0";
			
		}
		
		return Integer.toString(resultado.getIdplanoEstudo());

	}
	
	

}
