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
import br.com.muranodesign.business.RoteiroService;
import br.com.muranodesign.business.UsuarioService;
import br.com.muranodesign.model.ForumQuestao;
import br.com.muranodesign.model.Roteiro;
import br.com.muranodesign.model.Usuario;
import br.com.muranodesign.util.StringUtil;
import br.com.muranodesign.util.Upload;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;


/**
 * Classe tem como objetivo disponibilizar os serviços relacionandos criação de questões no forum
 *
 * @author Rogerio Lima dos Santos
 * @version 1.00
 * @since Release 1 da aplicação
 */
@Path("ForumQuestao")
public class ForumQuestaoResource {

	/** The logger. */
	private Logger logger = Logger.getLogger(ForumQuestaoResource.class.getName());

	/**
	 * Gets the forum questao.
	 *
	 * @return the forum questao
	 */
	@GET
	@Produces("application/json")
	public List<ForumQuestao> getForumQuestao() {
		logger.info("Listar ForumQuestao ...");
		List<ForumQuestao> resultado;
		resultado = new ForumQuestaoService().listarTodos();
		logger.info("QTD ForumQuestao : " + resultado.size());
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
	public ForumQuestao getEvento(@PathParam("id") int id) {
		logger.info("Lista ForumQuestao  por id " + id);
		List<ForumQuestao> resultado;
		resultado = new ForumQuestaoService().listarkey(id);
		ForumQuestao evento = resultado.get(0);

		return evento;

	}

	/**
	 * Removes the forum questao.
	 *
	 * @param action the action
	 * @param id the id
	 * @return the string
	 */
	@Path("{action}/{id}")
	@Produces("text/plain")
	public String removeForumQuestao(@PathParam("action") String action,
			@PathParam("id") int id) {

		logger.info("ForumQuestao  " + action);
		if ( action.equals("delete")) {
			List<ForumQuestao> resultado;
			resultado = new ForumQuestaoService().listarkey(id);
			ForumQuestao res = resultado.get(0);
			new ForumQuestaoService().deletarForumQuestao(res);
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

			@FormDataParam("questao") String questao,
			@FormDataParam("anexo") InputStream uploadedInputStream,
			@FormDataParam("anexo") FormDataContentDisposition fileDetail,
			@FormDataParam("usuario") String usuario,
			@FormDataParam("roteiro") String roteiro

			) {
		
		
	
				StringUtil stringUtil = new StringUtil();
				String arquivo = stringUtil.geraNomeAleatorio(fileDetail.getFileName(),50);
				String uploadedFileLocation = "/home/tomcat/webapps/files/" + arquivo;
				
				
				
				 
				Upload upload = new Upload (); 
				// save it
				upload.writeToFile(uploadedInputStream, uploadedFileLocation);
				
				
		 
				String anexo = "http://177.55.99.90/files/"+ arquivo;
 

		
		
		
		ForumQuestao objForumQuestao = new ForumQuestao();
		logger.info("eventoAction ...");
		ForumQuestao  resultado;
		/*
		Date dataConvertida = null;

		DateFormat formatter = new SimpleDateFormat("yy-MM-dd");
		try {
			dataConvertida = (Date) formatter.parse(data);
			
		} catch (ParseException e) {
			e.printStackTrace();
			
		}
		*/

		// get tipo usuario
		List<Usuario> rsUsuario;
		rsUsuario = new UsuarioService().listarkey(Integer.parseInt(usuario));
		Usuario objUsuario= rsUsuario.get(0);
		//TODO: Validar valores.

		// get tipo Roteiro
		List<Roteiro> rsRoteiro;
		rsRoteiro = new RoteiroService().listarkey(Integer.parseInt(roteiro));
		Roteiro objRoteiro= rsRoteiro.get(0);
		//TODO: Validar valores.




		if (action.equals("create")) {
			logger.info("Criando no  Forum Questao");

			objForumQuestao.setQuestao(questao);
			objForumQuestao.setData(new Date());
			objForumQuestao.setUsuario(objUsuario);
			objForumQuestao.setRoteiro(objRoteiro);
			objForumQuestao.setAnexo(anexo);
		

			resultado = new ForumQuestaoService().criarForumQuestao(objForumQuestao);


		} else if (action.equals("update")) {
			
			int id=Integer.parseInt(strid);
			List<ForumQuestao> rsForumQuestao;
			rsForumQuestao = new ForumQuestaoService().listarkey(id);
			objForumQuestao = rsForumQuestao.get(0);
			objForumQuestao.setQuestao(questao);
			//objForumQuestao.setQuestao(questao);
			objForumQuestao.setData(new Date());
			objForumQuestao.setUsuario(objUsuario);
			objForumQuestao.setRoteiro(objRoteiro);

			resultado = new ForumQuestaoService().atualizarForumQuestao(objForumQuestao);
			




		}else {
			logger.info("Erro na URI  " + action);
			return "0";
		}



		return Integer.toString(resultado.getIdforumQuestao());


	}
	
	
	
	



}
