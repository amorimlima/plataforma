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

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.log4j.Logger;

import br.com.muranodesign.business.AvaliacaoProducaoAlunoService;
import br.com.muranodesign.model.AvaliacaoProducaoAluno;


/**
 * Classe tem como objetivo disponibilizar os serviços relacionandos avaliação produção
 *
 * @author Rogerio Lima dos Santos
 * @version 1.00
 * @since Release 1 da aplicação
 */
@Path("AvaliacaoProducaoAluno")
public class AvaliacaoProducaoAlunoResource {

	/** logger. */
	private Logger logger = Logger.getLogger(AvaliacaoProducaoAlunoResource.class.getName());

	/**
	 * Lista as avaliacões producao aluno.
	 *
	 * @return  avaliacões producao aluno
	 */
	@GET
	@Produces("application/json")
	public List<AvaliacaoProducaoAluno> getAvaliacaoProducaoAluno() {
		logger.info("Listar AvaliacaoProducaoAluno ...");
		List<AvaliacaoProducaoAluno> resultado;
		resultado = new AvaliacaoProducaoAlunoService().listarTodos();
		logger.info("QTD AvaliacaoProducaoAluno : " + resultado.size());
		return resultado;
	}

	/**
	 * Lista avaliacão producao aluno. especifico.
	 *
	 * @param id da avaliação
	 * @return avaliacão producao aluno.
	 */
	@Path("{id}")
	@GET
	@Produces("application/json")
	public AvaliacaoProducaoAluno getEvento(@PathParam("id") int id) {
		logger.info("Lista AvaliacaoProducaoAluno  por id " + id);
		List<AvaliacaoProducaoAluno> resultado;
		resultado = new AvaliacaoProducaoAlunoService().listarkey(id);
		AvaliacaoProducaoAluno evento = resultado.get(0);

		return evento;

	}
	
	/**
	 * Remove the avaliacao producao aluno.
	 *
	 * @param action the action
	 * @param id da registro a ser deletado
	 * @return true para deleção com sucesso e false para erro durante a deleção.
	 */
	@Path("{action}/{id}")
	@Produces("text/plain")
	public String removeAvaliacaoProducaoAluno(@PathParam("action") String action,
			@PathParam("id") int id) {

		logger.info("AvaliacaoProducaoAluno  " + action);
		if ( action.equals("delete")) {
			List<AvaliacaoProducaoAluno> resultado;
			resultado = new AvaliacaoProducaoAlunoService().listarkey(id);
			AvaliacaoProducaoAluno res = resultado.get(0);
			new AvaliacaoProducaoAlunoService().deletarAvaliacaoProducaoAluno(res);
			return "true";
		} else {
			return "false";
		}

	}
	
	

}
