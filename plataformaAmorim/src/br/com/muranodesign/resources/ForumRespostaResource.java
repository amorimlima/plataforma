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

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import br.com.muranodesign.business.ForumQuestaoService;
import br.com.muranodesign.business.ForumRespostaService;
import br.com.muranodesign.business.UsuarioService;
import br.com.muranodesign.model.ForumQuestao;
import br.com.muranodesign.model.ForumResposta;
import br.com.muranodesign.model.Usuario;
import br.com.muranodesign.util.StringUtil;
import br.com.muranodesign.util.Upload;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;



/**
 * Classe tem como objetivo disponibilizar os serviços criação respota do forum
 *
 * @author Rogerio Lima dos Santos
 * @version 1.00
 * @since Release 1 da aplicação
 */
@Path("ForumResposta")
public class ForumRespostaResource {

	/** The logger. */
	private Logger logger = Logger.getLogger(ForumRespostaResource.class.getName());

	/**
	 * Gets the forum resposta.
	 *
	 * @return the forum resposta
	 */
	@GET
	@Produces("application/json")
	public List<ForumResposta> getForumResposta() {
		logger.info("Listar ForumResposta ...");
		List<ForumResposta> resultado;
		resultado = new ForumRespostaService().listarTodos();
		logger.info("QTD ForumResposta : " + resultado.size());
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
	public ForumResposta getEvento(@PathParam("id") int id) {
		logger.info("Lista ForumResposta  por id " + id);
		List<ForumResposta> resultado;
		resultado = new ForumRespostaService().listarkey(id);
		ForumResposta evento = resultado.get(0);

		return evento;

	}
	
	/**
	 * Removes the forum resposta.
	 *
	 * @param action the action
	 * @param id the id
	 * @return the string
	 */
	@Path("{action}/{id}")
	@Produces("text/plain")
	public String removeForumResposta(@PathParam("action") String action,
			@PathParam("id") int id) {

		logger.info("ForumResposta  " + action);
		if ( action.equals("delete")) {
			List<ForumResposta> resultado;
			resultado = new ForumRespostaService().listarkey(id);
			ForumResposta res = resultado.get(0);
			new ForumRespostaService().deletarForumResposta(res);
			return "true";
		} else {
			return "false";
		}

	}
	
	
	@POST
	//@Path("upload")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public String eventoAction(

			@FormDataParam("action") String action,
			@FormDataParam("id") String strid,

			@FormDataParam("resposta") String resposta,
			@FormDataParam("anexo") InputStream uploadedInputStream,
			@FormDataParam("anexo") FormDataContentDisposition fileDetail,
			@FormDataParam("usuario") String usuario,
			@FormDataParam("forumQuestao") String forumQuestao

			) {
		
		
		//TODO: Criar uma configiracao para o caminho
		StringUtil stringUtil = new StringUtil();
		String arquivo = stringUtil.geraNomeAleatorio(fileDetail.getFileName(),50);
		String uploadedFileLocation = "/home/tomcat/webapps/files/" + arquivo;
		
		
		
		 
		Upload upload = new Upload (); 
		// save it
		upload.writeToFile(uploadedInputStream, uploadedFileLocation);
		
		
 
		String anexo = "http://177.55.99.90/files/"+ arquivo;
 

		
		
		
		ForumResposta objForumResposta = new ForumResposta();
		logger.info("eventoAction ...");
		ForumResposta  resultado;
	

		// get tipo usuario
		List<Usuario> rsUsuario;
		rsUsuario = new UsuarioService().listarkey(Integer.parseInt(usuario));
		Usuario objUsuario= rsUsuario.get(0);
		//TODO: Validar valores.

		// get tipo Roteiro
		List<ForumQuestao> rsForumQuestao;
		rsForumQuestao = new ForumQuestaoService().listarkey(Integer.parseInt(forumQuestao));
		ForumQuestao objForumQuestao= rsForumQuestao.get(0);
		//TODO: Validar valores.




		if (action.equals("create")) {
			logger.info("Criando no  Forum Questao");

			objForumResposta.setResposta(resposta);
			objForumResposta.setData(new Date());
			objForumResposta.setUsuario(objUsuario);
			objForumResposta.setForumQuestao(objForumQuestao);
			objForumResposta.setAnexo(anexo);
		

			resultado = new ForumRespostaService().criarForumResposta(objForumResposta);


		} else if (action.equals("update")) {
			
			int id=Integer.parseInt(strid);
			List<ForumResposta> rsForumResposta;
			rsForumResposta= new ForumRespostaService().listarkey(id);
			objForumResposta = rsForumResposta.get(0);
			objForumResposta.setResposta(resposta);
			objForumResposta.setData(new Date());
			objForumResposta.setUsuario(objUsuario);
			objForumResposta.setForumQuestao(objForumQuestao);
			objForumResposta.setAnexo(anexo);

			resultado = new ForumRespostaService().atualizarForumResposta(objForumResposta);
			




		}else {
			logger.info("Erro na URI  " + action);
			return "0";
		}



		return Integer.toString(resultado.getIdforumResposta());


	}
	
	
	
	

}
