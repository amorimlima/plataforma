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
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import br.com.muranodesign.business.MateriaService;
import br.com.muranodesign.business.RecursoAprendizagemService;
import br.com.muranodesign.business.RoteiroService;
import br.com.muranodesign.business.TipoRecursoAprendizagemService;
import br.com.muranodesign.model.Materia;
import br.com.muranodesign.model.RecursoAprendizagem;
import br.com.muranodesign.model.Roteiro;
import br.com.muranodesign.model.TipoRecursoAprendizagem;
import br.com.muranodesign.util.StringUtil;
import br.com.muranodesign.util.Upload;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;


/**
 * Classe tem como objetivo disponibilizar os serviços relacionandos recurso aprendizado
 *
 * @author Rogerio Lima dos Santos
 * @version 1.00
 * @since Release 1 da aplicação
 */

@Path("RecursoAprendizagem")
public class RecursoAprendizagemResource {

	/** The logger. */
	private Logger logger = Logger.getLogger(RecursoAprendizagemResource.class.getName());

	/**
	 * Gets the recurso aprendizagem.
	 *
	 * @return the recurso aprendizagem
	 */
	@GET
	@Produces("application/json")
	public List<RecursoAprendizagem> getRecursoAprendizagem() {
		logger.info("Listar RecursoAprendizagem ...");
		List<RecursoAprendizagem> resultado;
		resultado = new RecursoAprendizagemService().listarTodos();
		logger.info("QTD RecursoAprendizagem : " + resultado.size());
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
	public RecursoAprendizagem getEvento(@PathParam("id") int id) {
		logger.info("Lista RecursoAprendizagem  por id " + id);
		List<RecursoAprendizagem> resultado;
		resultado = new RecursoAprendizagemService().listarkey(id);
		RecursoAprendizagem evento = resultado.get(0);

		return evento;

	}
	
	/**
	 * Removes the recurso aprendizagem.
	 *
	 * @param action the action
	 * @param id the id
	 * @return the string
	 */
	@Path("{action}/{id}")
	@Produces("text/plain")
	public String removeRecursoAprendizagem(@PathParam("action") String action,
			@PathParam("id") int id) {

		logger.info("RecursoAprendizagem  " + action);
		if ( action.equals("delete")) {
			List<RecursoAprendizagem> resultado;
			resultado = new RecursoAprendizagemService().listarkey(id);
			RecursoAprendizagem res = resultado.get(0);
			new RecursoAprendizagemService().deletarRecursoAprendizagem(res);
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
			
			@FormParam("nomeRecurso") String nomeRecurso,
			@FormParam("descricaoRecurso") String descricaoRecurso,
			@FormParam("curtir") String curtir,
			
			@FormParam("link") String link,
			
			
		
			@FormParam("tipoRecursoAprendizagem") String tipoRecursoAprendizagem,
			@FormParam("materia") String materia,
			@FormParam("roteiro") String roteiro
			
			
			
			
			) {
		RecursoAprendizagem objRecursoAprendizagem = new RecursoAprendizagem();
		logger.info("eventoAction ...");
		RecursoAprendizagem resultado;

		
		List<TipoRecursoAprendizagem> rsTipoRecursoAprendizagem;
		rsTipoRecursoAprendizagem = new TipoRecursoAprendizagemService().listarkey(Integer.parseInt(tipoRecursoAprendizagem));
		TipoRecursoAprendizagem objTipoRecursoAprendizagem= rsTipoRecursoAprendizagem.get(0);
		
		
		
		List<Materia> rsMateria;
		rsMateria= new MateriaService().listarkey(Integer.parseInt(materia));
		Materia objMateria = rsMateria.get(0);
		
		List<Roteiro> rsRoteiro;
		rsRoteiro= new RoteiroService().listarkey(Integer.parseInt(roteiro));
		Roteiro objRoteiro = rsRoteiro.get(0);
		
		
		
		if (action.equals("create")) {
			
			objRecursoAprendizagem.setNomeRecurso(nomeRecurso);
			objRecursoAprendizagem.setDescricaoRecurso(descricaoRecurso);
			objRecursoAprendizagem.setCurtir(Long.parseLong(curtir));
			
			objRecursoAprendizagem.setMateria(objMateria);
			objRecursoAprendizagem.setTipoRecursoAprendizagem(objTipoRecursoAprendizagem);
			objRecursoAprendizagem.setRoteiro(objRoteiro);
			objRecursoAprendizagem.setLink(link);
			
			
			resultado = new RecursoAprendizagemService().criarRecursoAprendizagem(objRecursoAprendizagem);
			
		}  else if (action.equals("update")) {
			
			int id=Integer.parseInt(strid);
			List<RecursoAprendizagem> rsRecursoAprendizagem;
			rsRecursoAprendizagem= new RecursoAprendizagemService().listarkey(id);
			objRecursoAprendizagem= rsRecursoAprendizagem.get(0);
			
		
			objRecursoAprendizagem.setNomeRecurso(nomeRecurso);
			objRecursoAprendizagem.setDescricaoRecurso(descricaoRecurso);
			objRecursoAprendizagem.setCurtir(Long.parseLong(curtir));
			
			objRecursoAprendizagem.setMateria(objMateria);
			objRecursoAprendizagem.setTipoRecursoAprendizagem(objTipoRecursoAprendizagem);
			objRecursoAprendizagem.setRoteiro(objRoteiro);
			
			
			
			
			
			 resultado =  new RecursoAprendizagemService().atualizarRecursoAprendizagem(objRecursoAprendizagem);
			
		} else {
			return "0";
		}
	    return Integer.toString(resultado.getIdrecursoAprendizagem());
	
		}
	
	
	
	
	@POST
	@Path("upload/recursoAprendizagem/imagem/{id}")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public RecursoAprendizagem eventoAction(

			@PathParam("id") String strId,
			@FormDataParam("imagem") InputStream uploadedInputStream,
			@FormDataParam("imagem") FormDataContentDisposition fileDetail


			) {

		RecursoAprendizagem objRecursoAprendizagem = new RecursoAprendizagem();
		RecursoAprendizagem resultado = new RecursoAprendizagem();
		
		int id=Integer.parseInt(strId);
		List<RecursoAprendizagem> rsRecursoAprendizagem;
		rsRecursoAprendizagem= new RecursoAprendizagemService().listarkey(id);
		objRecursoAprendizagem= rsRecursoAprendizagem.get(0);
		
		StringUtil stringUtil = new StringUtil();
		String arquivo = stringUtil.geraNomeAleatorio(fileDetail.getFileName(),50);
		String uploadedFileLocation = "/home/tomcat/webapps/files/" + arquivo;
		String anexo = "http://177.55.99.90/files/"+ arquivo;
		
		Upload upload = new Upload (); 
		upload.writeToFile(uploadedInputStream, uploadedFileLocation);
		
		logger.info("anexo" + anexo);     
		
		objRecursoAprendizagem.setImagem(anexo);
		
		resultado =  new RecursoAprendizagemService().atualizarRecursoAprendizagem(objRecursoAprendizagem);

		return resultado;


	}
	
	
	@POST
	@Path("upload/recursoAprendizagem/arquivo/{id}")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public RecursoAprendizagem eventoAction2(

			@PathParam("id") String strId,
			@FormDataParam("arquivo") InputStream uploadedInputStream,
			@FormDataParam("arquivo") FormDataContentDisposition fileDetail


			) {

		RecursoAprendizagem objRecursoAprendizagem = new RecursoAprendizagem();
		RecursoAprendizagem resultado = new RecursoAprendizagem();
		
		int id=Integer.parseInt(strId);
		List<RecursoAprendizagem> rsRecursoAprendizagem;
		rsRecursoAprendizagem= new RecursoAprendizagemService().listarkey(id);
		objRecursoAprendizagem= rsRecursoAprendizagem.get(0);
		
		StringUtil stringUtil = new StringUtil();
		String arquivo = stringUtil.geraNomeAleatorio(fileDetail.getFileName(),50);
		String uploadedFileLocation = "/home/tomcat/webapps/files/" + arquivo;
		String anexo = "http://177.55.99.90/files/"+ arquivo;
		
		Upload upload = new Upload (); 
		upload.writeToFile(uploadedInputStream, uploadedFileLocation);
		
		logger.info("anexo" + anexo);     
		
		objRecursoAprendizagem.setArquivo(anexo);
		
		resultado =  new RecursoAprendizagemService().atualizarRecursoAprendizagem(objRecursoAprendizagem);

		return resultado;


	}
	
	
	
	
	@Path("update/curtir/{id}/{curtir}")
	public RecursoAprendizagem eventoAction3(

			@PathParam("id") String strId,
			@PathParam("curtir") String curtir
	
			) {

		
		RecursoAprendizagem objRecursoAprendizagem = new RecursoAprendizagem();
		logger.info("eventoAction3");  
		int id=Integer.parseInt(strId);
		List<RecursoAprendizagem> rsRecursoAprendizagem;
		rsRecursoAprendizagem= new RecursoAprendizagemService().listarkey(id);
		objRecursoAprendizagem= rsRecursoAprendizagem.get(0);
		logger.info("curtir:" + curtir );
		objRecursoAprendizagem.setCurtir(Long.parseLong(curtir));
	
		
		return new RecursoAprendizagemService().atualizarRecursoAprendizagem(objRecursoAprendizagem);

	}

	//RecursosAprendizagem
	
	
	

}
