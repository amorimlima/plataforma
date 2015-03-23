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
import br.com.muranodesign.business.AlunoVariavelService;
import br.com.muranodesign.business.AnoEstudoService;
import br.com.muranodesign.business.AnoLetivoService;
import br.com.muranodesign.business.GrupoService;
import br.com.muranodesign.business.PeriodoService;
import br.com.muranodesign.model.Aluno;
import br.com.muranodesign.model.AlunoVariavel;
import br.com.muranodesign.model.AnoEstudo;
import br.com.muranodesign.model.AnoLetivo;
import br.com.muranodesign.model.Grupo;
import br.com.muranodesign.model.Periodo;
import br.com.muranodesign.util.StringUtil;


/**
 * Classe tem como objetivo disponibilizar os serviços relacionandos a Aluno Variavel.
 * 
 * @author Rogerio Lima dos Santos
 * @version 1.00
 * @since Release 1 da aplicação
 */
@Path("AlunoVariavel")
public class AlunoVariavelResource {

	/** The logger. */
	private Logger logger = Logger.getLogger(AlunoVariavelResource.class.getName());

	/**
	 * Serviço reponsavel por Lista todos os alunos variaveis.
	 * 
	 * @return Alunos Variavel
	 */
	@GET
	@Produces("application/json")
	public List<AlunoVariavel> getAlunoVariavel() {
		logger.info("Listar AlunoVariavel ...");
		List<AlunoVariavel> resultado;
		resultado = new AlunoVariavelService().listarTodos();
		logger.info("QTD AlunoVariavel : " + resultado.size());
		return resultado;
	}
	
	/**
	 * Serviço reponsavel por Lista todos os alunos variaveis por status.
	 * 
	 * @return Alunos Variavel
	 */
	@Path("listar/{status}")
	@GET
	@Produces("application/json")
	public List<AlunoVariavel> getAlunoVariavel(@PathParam("status") int status) {
		logger.info("Listar AlunoVariavel ...");
		List<AlunoVariavel> resultado;
		resultado = new AlunoVariavelService().listarTodos(status);
		logger.info("QTD AlunoVariavel : " + resultado.size());
		return resultado;
	}
	

	/**
	 * Lista Aluno Variavel especifico.
	 *
	 * @param id do  Aluno Variavel
	 * @return the Aluno Variavel
	 */
	@Path("{id}")
	@GET
	@Produces("application/json")
	public AlunoVariavel getEvento(@PathParam("id") int id) {
		logger.info("Lista AlunoVariavel  por id " + id);
		List<AlunoVariavel> resultado;
		resultado = new AlunoVariavelService().listarkey(id);
		AlunoVariavel evento = resultado.get(0);

		return evento;

	}
	
	
	@Path("aluno/{id}")
	@GET
	@Produces("application/json")
	public AlunoVariavel getAluno(@PathParam("id") int id) {
		logger.info("Lista AlunoVariavel  por id " + id);
		List<AlunoVariavel> resultado;
		resultado = new AlunoVariavelService().listaAluno(id);
		AlunoVariavel evento = resultado.get(0);

		return evento;

	}
	
	@Path("grupo/{id}")
	@GET
	@Produces("application/json")
	public List<AlunoVariavel> getGrupo(@PathParam("id") int id) {
		logger.info("Lista AlunoVariavel  por grupo " + id);
		List<AlunoVariavel> resultado;
		resultado = new AlunoVariavelService().listaGrupo(id);
		///AlunoVariavel evento = resultado.get(0);

		return resultado;

	}
	
	
	
	/**
	 * Removes o aluno variavel.
	 *
	 * @param action  Metodo a ser executado create ou update
	 * @param id  id do aluno variavel
	 * @return true se for removido e false se der erro.
	 */
	@Path("{action}/{id}")
	@Produces("text/plain")
	public String removeAlunoVariavel(@PathParam("action") String action,
			@PathParam("id") int id) {

		logger.info("AlunoVariavel  " + action);
		if ( action.equals("delete")) {
			List<AlunoVariavel> resultado;
			resultado = new AlunoVariavelService().listarkey(id);
			AlunoVariavel res = resultado.get(0);
			new AlunoVariavelService().deletarAlunoVariavel(res);
			return "true";
		} else {
			return "false";
		}

	}
	

	/**
	 * Serviço reponsavel por cadastra e atualizar dados do aluno variavel
	 *
	 * @param action Metodo a ser executado create ou update
	 * @param strid id para update
	 * @param inicio data inicio
	 * @param programaSocial faz parte de algum programa social
	 * @param anoEstudo  ano estudo
	 * @param anoLetivo  ano letivo
	 * @param aluno id do aluno aluno
	 * @param periodo  periodo
	 * @param grupo  grupo
	 * @param ativo  status do aluno 0 deletado 1 valido
	 * @return identificador de controle interno da aplicação
	 */
	@POST
	@Produces("text/plain")
	public String eventoAction(
			
			@FormParam("action") String action,
			@FormParam("id") String strid,
			
			@FormParam("inicio") String inicio,
			@FormParam("programaSocial") String programaSocial,
			
			@FormParam("anoEstudo") String anoEstudo,
			@FormParam("anoLetivo") String anoLetivo,
			@FormParam("aluno") String aluno,
			@FormParam("periodo") String periodo,
			@FormParam("grupo") String grupo,
			@FormParam("ativo") int ativo
			
			
			
			) {
		AlunoVariavel objAlunoVariavel = new AlunoVariavel();
		logger.info("eventoAction ...");
		AlunoVariavel resultado;

		
		List<AnoEstudo> rsAnoEstudo;
		rsAnoEstudo = new AnoEstudoService().listarkey(Integer.parseInt(anoEstudo));
		AnoEstudo objAnoEstudo= rsAnoEstudo.get(0);
		
		List<AnoLetivo> rsAnoLetivo;
		rsAnoLetivo = new AnoLetivoService().listarkey(Integer.parseInt(anoLetivo));
		AnoLetivo objAnoLetivo= rsAnoLetivo.get(0);
		
		
		
		List<Periodo> rsPeriodo;
		rsPeriodo= new PeriodoService().listarkey(Integer.parseInt(periodo));
		Periodo objPeriodo= rsPeriodo.get(0);
		
		
		List<Aluno> rsAluno;
		rsAluno = new AlunoService().listarkey(Integer.parseInt(aluno));
		Aluno objAluno= rsAluno.get(0);
		
		Grupo objGrupo = new Grupo();
		
		if (!grupo.isEmpty()){
			List<Grupo> rsGrupo;
			rsGrupo = new GrupoService().listarkey(Integer.parseInt(grupo));
			objGrupo= rsGrupo.get(0);
		} else {
			objGrupo = null;
		}
		
		
		
		
		StringUtil stringUtil = new StringUtil();
		
		
	
		
		
		
		if (action.equals("create")) {
			
			objAlunoVariavel.setAluno(objAluno);
			objAlunoVariavel.setInicio(stringUtil.converteStringData(inicio));
			
			objAlunoVariavel.setAnoEstudo(objAnoEstudo);
			objAlunoVariavel.setAnoLetivo(objAnoLetivo);
			objAlunoVariavel.setPeriodo(objPeriodo);
			objAlunoVariavel.setAluno(objAluno);
			objAlunoVariavel.setGrupo(objGrupo);
			objAlunoVariavel.setProgramaSocial(programaSocial);
			objAlunoVariavel.setAtivo(ativo);
			
			
			
			resultado = new AlunoVariavelService().criarAlunoVariavel(objAlunoVariavel);
			
		}  else if (action.equals("update")) {
			
			int id=Integer.parseInt(strid);
			List<AlunoVariavel> rsAlunoVariavel;
			rsAlunoVariavel= new AlunoVariavelService().listarkey(id);
			objAlunoVariavel= rsAlunoVariavel.get(0);
		
			objAlunoVariavel.setAluno(objAluno);
			objAlunoVariavel.setInicio(stringUtil.converteStringData(inicio));
			
			objAlunoVariavel.setAnoEstudo(objAnoEstudo);
			objAlunoVariavel.setAnoLetivo(objAnoLetivo);
			objAlunoVariavel.setPeriodo(objPeriodo);
			objAlunoVariavel.setAluno(objAluno);
			objAlunoVariavel.setGrupo(objGrupo);
			objAlunoVariavel.setAtivo(ativo);
			objAlunoVariavel.setProgramaSocial(programaSocial);
			
			
			
			
			 resultado =  new AlunoVariavelService().atualizarAlunoVariavel(objAlunoVariavel);
			
		} else {
			return "0";
		}
	    return Integer.toString(resultado.getIdalunoVariavel());
	
		}
	
	
	/**
	 * Servico de divine grupo para uma lista de alunos
	 *
	 * @param lista de alunos separados por ";"
	 * @param id do grupo 
	 * @return retorna true se foi alterado o grupo com sucesso.
	 */
	@Path("alunoGrupo")
	@POST
	@Produces("text/plain")
	public String eventoAction2( @FormParam("alunos") String alunos,
			@FormParam("grupo") String grupo){
		
		
        logger.info("Buscando Grupo ...");
		
        Grupo objGrupo = new Grupo();
        
        if (!grupo.isEmpty()) {
        	List<Grupo> rsGrupo;
    		rsGrupo = new GrupoService().listarkey(Integer.parseInt(grupo));
    		objGrupo= rsGrupo.get(0);
    		
        }else {
        	objGrupo = null;
        }
        String [] arrayAlunos = alunos.split(";");
		logger.info("QTD Alunos " +  arrayAlunos.length);
		
		for (String aluno :  arrayAlunos ){
			logger.info("Buscando aluno ..." + aluno );
			AlunoVariavel objAlunoVariavel;
			int id=Integer.parseInt(aluno);
			List<AlunoVariavel> rsAlunoVariavel;
			
			objAlunoVariavel= new AlunoVariavelService().getAluno(id);
			
			if (objAlunoVariavel == null ) {
				
				logger.info("Não foi possivel completar a operacao buscando aluno ..." + aluno );
				
			}else {
				//objAlunoVariavel= rsAlunoVariavel.get(0);
				objAlunoVariavel.setGrupo(objGrupo);
				new AlunoVariavelService().atualizarAlunoVariavel(objAlunoVariavel);
			}
			
			
		}
		
		
		return "true";
	}
	
	

}
