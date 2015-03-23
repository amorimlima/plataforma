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

import br.com.muranodesign.business.AlunoService;
import br.com.muranodesign.business.AnoLetivoService;
import br.com.muranodesign.business.CategoriaProducaoAlunoService;
import br.com.muranodesign.business.ProducaoAlunoService;
import br.com.muranodesign.business.RoteiroService;
import br.com.muranodesign.business.TipoProducaoAlunoService;
import br.com.muranodesign.model.Aluno;
import br.com.muranodesign.model.AnoLetivo;
import br.com.muranodesign.model.CategoriaProducaoAluno;
import br.com.muranodesign.model.ProducaoAluno;
import br.com.muranodesign.model.Roteiro;
import br.com.muranodesign.model.TipoProducaoAluno;
import br.com.muranodesign.util.StringUtil;
import br.com.muranodesign.util.Upload;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;


/**
 * Classe tem como objetivo disponibilizar os serviços relacionandos producao do aluno 
 *
 * @author Rogerio Lima dos Santos
 * @version 1.00
 * @since Release 1 da aplicação
 */


@Path("ProducaoAluno")
public class ProducaoAlunoResource {

	/** The logger. */
	private Logger logger = Logger.getLogger(ProducaoAlunoResource.class.getName());

	/**
	 * Gets the producao aluno.
	 *
	 * @return the producao aluno
	 */
	@GET
	@Produces("application/json")
	public List<ProducaoAluno> getProducaoAluno() {
		logger.info("Listar ProducaoAluno ...");
		List<ProducaoAluno> resultado;
		resultado = new ProducaoAlunoService().listarTodos();
		logger.info("QTD ProducaoAluno : " + resultado.size());
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
	public ProducaoAluno getEvento(@PathParam("id") int id) {
		logger.info("Lista ProducaoAluno  por id " + id);
		List<ProducaoAluno> resultado;
		resultado = new ProducaoAlunoService().listarkey(id);
		ProducaoAluno evento = resultado.get(0);

		return evento;

	}
	
	/**
	 * Removes the producao aluno.
	 *
	 * @param action the action
	 * @param id the id
	 * @return the string
	 */
	@Path("{action}/{id}")
	@Produces("text/plain")
	public String removeProducaoAluno(@PathParam("action") String action,
			@PathParam("id") int id) {

		logger.info("ProducaoAluno  " + action);
		if ( action.equals("delete")) {
			List<ProducaoAluno> resultado;
			resultado = new ProducaoAlunoService().listarkey(id);
			ProducaoAluno evento = resultado.get(0);
			new ProducaoAlunoService().deletarProducaoAluno(evento);
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
			
			@FormParam("anoLetivo") String anoLetivo,
			@FormParam("texto") String texto,
			@FormParam("data") String data,
			
		
			@FormParam("aluno") String aluno,
			@FormParam("tipo") String tipo,
			@FormParam("roteiro") String roteiro,
			@FormParam("categoria") String categoria
			
			
			
			
			) {
		ProducaoAluno objProducaoAluno = new ProducaoAluno();
		logger.info("eventoAction ...");
		ProducaoAluno resultado = null;

		
		List<Aluno> rsAluno;
		rsAluno = new AlunoService().listarkey(Integer.parseInt(aluno));
		Aluno objAluno= rsAluno.get(0);
		
		
		
		List<TipoProducaoAluno> rsTipoProducaoAluno;
		rsTipoProducaoAluno = new TipoProducaoAlunoService().listarkey(Integer.parseInt(tipo));
		TipoProducaoAluno objTipoProducaoAluno= rsTipoProducaoAluno.get(0);
		
		
		List<Roteiro> rsRoteiro;
		rsRoteiro = new RoteiroService().listarkey(Integer.parseInt(roteiro));
		Roteiro objRoteiro= rsRoteiro.get(0);
		
		
		List<CategoriaProducaoAluno> rsCategoriaProducaoAluno;
		rsCategoriaProducaoAluno = new CategoriaProducaoAlunoService().listarkey(Integer.parseInt(categoria));
		CategoriaProducaoAluno objCategoriaProducaoAluno= rsCategoriaProducaoAluno.get(0);
		
		
		List<AnoLetivo> rsAnoLetivo;
		rsAnoLetivo = new AnoLetivoService().listarkey(Integer.parseInt(anoLetivo));
		AnoLetivo objAnoLetivo= rsAnoLetivo.get(0);
		
		

		
		StringUtil stringUtil = new StringUtil();
		
		if (action.equals("create")) {
		
			
		    objProducaoAluno.setTexto(texto);
		    objProducaoAluno.setAnoLetivo(objAnoLetivo);
		    objProducaoAluno.setData(stringUtil.converteStringData(data));
		    objProducaoAluno.setAluno(objAluno);
		    objProducaoAluno.setTipo(objTipoProducaoAluno);
		    objProducaoAluno.setRoteiro(objRoteiro);
		    objProducaoAluno.setCategoria(objCategoriaProducaoAluno);
		
			
			resultado = new ProducaoAlunoService().criarProducaoAluno(objProducaoAluno);
			
		}  else if (action.equals("update")) {
			
			int id=Integer.parseInt(strid);
			List<ProducaoAluno> rsProducaoAluno;
			rsProducaoAluno= new ProducaoAlunoService().listarkey(id);
			objProducaoAluno= rsProducaoAluno.get(0);
			
			  objProducaoAluno.setTexto(texto);
			    objProducaoAluno.setAnoLetivo(objAnoLetivo);
			    objProducaoAluno.setData(stringUtil.converteStringData(data));
			    objProducaoAluno.setAluno(objAluno);
			    objProducaoAluno.setTipo(objTipoProducaoAluno);
			    objProducaoAluno.setRoteiro(objRoteiro);
			    objProducaoAluno.setCategoria(objCategoriaProducaoAluno);
			
			
			 resultado =  new ProducaoAlunoService().atualizarProducaoAluno(objProducaoAluno);
			
			
		} else {
			return "0";
		}
	    return Integer.toString(resultado.getIdproducaoAluno());
	
		}

	
	
	
	
	
	

	@POST
	@Path("upload/producaoAluno/imagem/{id}")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public ProducaoAluno eventoAction(

			@PathParam("id") String strId,
			@FormDataParam("imagem") InputStream uploadedInputStream,
			@FormDataParam("imagem") FormDataContentDisposition fileDetail


			) {

		ProducaoAluno objProducaoAluno = new ProducaoAluno();
		ProducaoAluno resultado = new ProducaoAluno();
		
		int id=Integer.parseInt(strId);
		List<ProducaoAluno> rsProducaoAluno;
		rsProducaoAluno= new ProducaoAlunoService().listarkey(id);
		objProducaoAluno= rsProducaoAluno.get(0);
		
		StringUtil stringUtil = new StringUtil();
		String arquivo = stringUtil.geraNomeAleatorio(fileDetail.getFileName(),50);
		String uploadedFileLocation = "/home/tomcat/webapps/files/" + arquivo;
		String anexo = "http://177.55.99.90/files/"+ arquivo;
		
		Upload upload = new Upload (); 
		upload.writeToFile(uploadedInputStream, uploadedFileLocation);
		
		logger.info("anexo" + anexo);     
		
		objProducaoAluno.setImagem(anexo);
		
		resultado =  new ProducaoAlunoService().atualizarProducaoAluno(objProducaoAluno);

		return resultado;


	}
	
	
	@POST
	@Path("upload/producaoAluno/arquivo/{id}")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public ProducaoAluno eventoAction2(

			@PathParam("id") String strId,
			@FormDataParam("arquivo") InputStream uploadedInputStream,
			@FormDataParam("arquivo") FormDataContentDisposition fileDetail


			) {

		ProducaoAluno objProducaoAluno = new ProducaoAluno();
		ProducaoAluno resultado = new ProducaoAluno();
		
		int id=Integer.parseInt(strId);
		List<ProducaoAluno> rsProducaoAluno;
		rsProducaoAluno= new ProducaoAlunoService().listarkey(id);
		objProducaoAluno= rsProducaoAluno.get(0);
		
		StringUtil stringUtil = new StringUtil();
		String arquivo = stringUtil.geraNomeAleatorio(fileDetail.getFileName(),50);
		String uploadedFileLocation = "/home/tomcat/webapps/files/" + arquivo;
		String anexo = "http://177.55.99.90/files/"+ arquivo;
		
		Upload upload = new Upload (); 
		upload.writeToFile(uploadedInputStream, uploadedFileLocation);
		
		logger.info("anexo" + anexo);     
		
		objProducaoAluno.setArquivo(anexo);
		
		resultado =  new ProducaoAlunoService().atualizarProducaoAluno(objProducaoAluno);

		return resultado;


	}


	
	

}
