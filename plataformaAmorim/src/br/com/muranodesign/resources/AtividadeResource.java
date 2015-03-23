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

import br.com.muranodesign.business.AtividadeService;
import br.com.muranodesign.business.ObjetivoService;
import br.com.muranodesign.model.Atividade;
import br.com.muranodesign.model.Objetivo;



/**
 * Classe tem como objetivo disponibilizar os serviços relacionandos cadastra de atividades.
 *
 * @author Rogerio Lima dos Santos
 * @version 1.00
 * @since Release 1 da aplicação
 */
@Path("Atividade")
public class AtividadeResource {
	
	/** logger. */
	private Logger logger = Logger.getLogger(AtividadeResource.class.getName());
	
	/**
	 * Listar as atividades.
	 *
	 * @return atividades
	 */
	@GET
	@Produces("application/json")
	public List<Atividade> getAtividade() {
		logger.debug("Listar Atividade ...");

		List<Atividade> resultado;
	    resultado = new AtividadeService().listarTodos();
	    
	    logger.debug("QTD Atividade : " +  resultado.size());
		return resultado;
	}

	/**
	 * Lista  atividade em especifico.
	 *
	 * @param id the id
	 * @return the atividade
	 */
	@Path("{id}")
	@GET
	@Produces("application/json")
	public Atividade getAtividade(@PathParam("id") int id) {
		logger.debug("Lista Atividade  por id " + id );
		List<Atividade> resultado;
		resultado = new AtividadeService().listarkey(id);
		Atividade res = resultado.get(0);
		return res;
		
	}

   
	/**
	 * Remove  atividade.
	 *
	 * @param id da atividade
	 * @return Atividade
	 */
	@Path("{id}")
	@DELETE
	@Produces("text/plain")
	public String removeAtividade(@PathParam("id") int id) {
		logger.debug("remover Atividade " + id );
		List<Atividade> resultado;
		resultado = new AtividadeService().listarkey(id);
		Atividade res = resultado.get(0);
		new AtividadeService().deletarAtividade(res);
		return "Deletado";

	}
	
	/**
	 * Serviço reponsavel por cadastra e atualizar dados da atividade
	 *
	 * @param action Metodo a ser executado create ou update
	 * @param strid id para update
	 * @param nome da atividade
	 * @param descricao da atividade
	 * @param numero 
	 * @param pagina 
	 * @param livro 
	 * @param objetivo 
	 * @return  identificador de controle interno da aplicação
	 */
	@POST
	@Produces("text/plain")
	public String eventoAction(
			
			@FormParam("action") String action,
			@FormParam("id") String strid,
			@FormParam("nome") String nome,
			@FormParam("descricao") String descricao,
			@FormParam("numero") String numero,
			@FormParam("paginaLivro") String paginaLivro,
			@FormParam("livro") String livro,
			@FormParam("objetivo") String objetivo, 
			@FormParam("ativo") String ativo
			
			
			
			) {
		Atividade objAtividade= new Atividade();
		logger.info("eventoAction ...");
		Atividade resultado;
		
		
		List<Objetivo> rsObjetivo;
		rsObjetivo= new ObjetivoService().listarkey(Integer.parseInt(objetivo));
		Objetivo objObjetivo = rsObjetivo.get(0);
		
		if (action.equals("create")) {
			
			//objUsuario.setLogin(login);
			objAtividade.setNome(nome);
			objAtividade.setDescricao(descricao);
			objAtividade.setNumero(Integer.parseInt(numero));
			objAtividade.setPaginaLivro(paginaLivro);
			objAtividade.setLivro(livro);
			objAtividade.setObjetivo(objObjetivo);
			objAtividade.setAtivo(Integer.parseInt(ativo));
			resultado = new AtividadeService().criarAtividade(objAtividade);
			
		} else if (action.equals("update")) {
			int id=Integer.parseInt(strid);
			List<Atividade> rsAtividade;
			rsAtividade = new AtividadeService().listarkey(id);
			objAtividade= rsAtividade.get(0);
			objAtividade.setIdatividade(id);
			
			objAtividade.setNome(nome);
			objAtividade.setDescricao(descricao);
			objAtividade.setNumero(Integer.parseInt(numero));
			objAtividade.setAtivo(Integer.parseInt(ativo));
			objAtividade.setPaginaLivro(paginaLivro);
			objAtividade.setLivro(livro);
			objAtividade.setObjetivo(objObjetivo);
			
			resultado = new AtividadeService().atualizarAtividade(objAtividade);
			
		} else {
			return "0";
		}
		
		return Integer.toString(resultado.getIdatividade());
	}
	
	
	
}
