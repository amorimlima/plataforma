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

import java.util.Date;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.log4j.Logger;

import br.com.muranodesign.business.MensagensService;
import br.com.muranodesign.business.UsuarioService;
import br.com.muranodesign.model.Mensagens;
import br.com.muranodesign.model.Usuario;


/**
 * Classe tem como objetivo disponibilizar os serviços relacionandos mensagem.
 *
 * @author Rogerio Lima dos Santos
 * @version 1.00
 * @since Release 1 da aplicação
 */
@Path("Mensagens")
public class MensagensResource {

	/** The logger. */
	private Logger logger = Logger.getLogger(MensagensResource.class.getName());

	/**
	 * Gets the materia.
	 *
	 * @return the materia
	 */
	@GET
	@Produces("application/json")
	public List<Mensagens> getMensagens() {
		logger.info("Listar Mensagens ...");
		List<Mensagens> resultado;
		resultado = new MensagensService().listarTodos();
		logger.info("QTD Mensagens : " + resultado.size());
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
	public Mensagens getEvento(@PathParam("id") int id) {
		logger.info("Lista Mensagens  por id " + id);
		List<Mensagens> resultado;
		resultado = new MensagensService().listarkey(id);
		Mensagens evento = resultado.get(0);

		return evento;

	}
	
	
	/**
	 * Gets the evento.
	 *
	 * @param id the id
	 * @return the evento
	 */
	@Path("email/{proprietario}")
	@GET
	@Produces("application/json")
	public List<Mensagens> getMensagemProprietario(@PathParam("proprietario") int proprietario) {
		logger.info("Lista Mensagens  por id " + proprietario);
		
		List<Usuario> rsUsuario;
		rsUsuario = new UsuarioService().listarkey(proprietario);
		Usuario obj = rsUsuario.get(0);
		
		
		List<Mensagens> resultado;
		resultado = new MensagensService().listarProprietario(obj);
	

		return resultado;

	}
	
	/**
	 * Gets the evento.
	 *
	 * @param id the id
	 * @return the evento
	 */
	@Path("email/{caixa}/{proprietario}")
	@GET
	@Produces("application/json")
	public List<Mensagens> getMensagemProprietarioCaixa(@PathParam("proprietario") int proprietario , @PathParam("caixa") String caixa ) {
		logger.info("Lista Mensagens  por id " + proprietario);
		
		List<Usuario> rsUsuario;
		rsUsuario = new UsuarioService().listarkey(proprietario);
		Usuario obj = rsUsuario.get(0);
		
		
		List<Mensagens> resultado;
		resultado = new MensagensService().listarProprietario(obj,caixa);
	

		return resultado;

	}
	
	
	
	
	/**
	 * Removes the Mensagens.
	 *
	 * @param action the action
	 * @param id the id
	 * @return the string
	 */
	@Path("{action}/{id}")
	@Produces("text/plain")
	public String removeMensagens(@PathParam("action") String action,
			@PathParam("id") int id) {

		logger.info("Mensagens  " + action);
		if ( action.equals("delete")) {
			List<Mensagens> resultado;
			resultado = new MensagensService().listarkey(id);
			Mensagens res = resultado.get(0);
			new MensagensService().deletarMensagens(res);
			return "true";
		} else {
			return "false";
		}

	}
	
	@POST
	//@Path("upload")
	//@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces("application/json")
	public String eventoAction(

			@FormParam("action") String action,
			@FormParam("id") String strid,

			@FormParam("assunto") String assunto,
			@FormParam("mensagem") String mensagem,
			@FormParam("lida") String lida,
			//@FormDataParam("cxEntrada") String cxEntrada,
			//@FormDataParam("cxEnviada") String cxEnviada,
			//@FormDataParam("proprietario") String proprietario,
			@FormParam("remetente") String remetente,
			//@FormDataParam("destinatario") String destinatario,
			@FormParam("destinatarios")  List<String>  destinatarios
			
			//@FormDataParam("anexo") InputStream uploadedInputStream,
			//@FormDataParam("anexo") FormDataContentDisposition fileDetail
	

			) {
		
	
		
		
 		
		
		logger.info("eventoAction ...");
		
		Mensagens  resultado = null;
	
		List<Usuario> rsUsuario;
		rsUsuario = new UsuarioService().listarkey(Integer.parseInt(remetente));
		Usuario objRementente = rsUsuario.get(0);
		
		

		String strDestinatarios = "";
	    Boolean firstDestinatario = true ;
		
	   
			
		// Gravando origen da msg
		
		for (String dest : destinatarios) {
			
			List<Usuario> rsUsuario2;
			rsUsuario2 = new UsuarioService().listarkey(Integer.parseInt(dest));
			Usuario objRementente2 = rsUsuario2.get(0);
			
			if (firstDestinatario )
			{
				strDestinatarios = objRementente2.getLogin();
				firstDestinatario = false;
			}else {
				strDestinatarios +=  ";" + objRementente2.getLogin();
			}
			
			logger.info("strDestinatarios ..." + strDestinatarios);
		}
		

		if (action.equals("create")) {
			logger.info("Gravando origen da msg ...");
			
			String fileAnexo = null;
			
			/*if ( fileDetail != null ){
				StringUtil stringUtil = new StringUtil();
				String arquivo = stringUtil.geraNomeAleatorio(fileDetail.getFileName(),50);
				String uploadedFileLocation = "/home/tomcat/webapps/files/" + arquivo;
			 
				Upload upload = new Upload (); 
				// save it
				upload.writeToFile(uploadedInputStream, uploadedFileLocation);
			
				fileAnexo = "http://177.55.99.90/files/"+ arquivo;
			}
			
*/
			
		    
		    
			for (String dest : destinatarios) {
				rsUsuario = new UsuarioService().listarkey(Integer.parseInt(dest));
				Mensagens objMensagens = new Mensagens();
				//objDestinatario.add(rsUsuario.get(0));
				
				
				objMensagens.setDestinatarios(strDestinatarios);
				objMensagens.setRemetente(objRementente);
				objMensagens.setAssunto(assunto);
				objMensagens.setData(new Date());
				objMensagens.setMensagem(mensagem);
				objMensagens.setLida("N");
				objMensagens.setCxEntrada("S");
				objMensagens.setCxEnviada("N");
				objMensagens.setProprietario(rsUsuario.get(0));
				objMensagens.setAnexo(fileAnexo);
			    resultado = new MensagensService().criarMensagens(objMensagens);
			    
				
				
			}
		    
			Mensagens objMensagens = new Mensagens();
		    
		    objMensagens.setDestinatarios(strDestinatarios);
			objMensagens.setRemetente(objRementente);
			objMensagens.setAssunto(assunto);
			objMensagens.setData(new Date());
			objMensagens.setMensagem(mensagem);
			objMensagens.setLida("S");
			objMensagens.setCxEntrada("N");
			objMensagens.setCxEnviada("S");
			objMensagens.setProprietario(objRementente);
			objMensagens.setAnexo(fileAnexo);
		    resultado = new MensagensService().criarMensagens(objMensagens);
		        
		        
		} else if (action.equals("update")) {
			Mensagens objMensagens = new Mensagens();
			int id=Integer.parseInt(strid);
			List<Mensagens> rsMensagens;
			rsMensagens= new MensagensService().listarkey(id);
			objMensagens = rsMensagens.get(0);
			
			objMensagens.setLida(lida);
			
			resultado = new MensagensService().atualizarMensagens(objMensagens);
			

		}else {
			logger.info("Erro na URI  " + action);
			return "0";
		}
		
		
		
		
		

		
		
		return Integer.toString(resultado.getIdmensagens());
		
		
		
		
		
	}
	
	
	@Path("update/lida/{id}/{lida}")
	public Mensagens eventoAction2(

			@PathParam("id") String strId,
			@PathParam("lida") String lida
	
			) {

		Mensagens objMensagens = new Mensagens();
		int id=Integer.parseInt(strId);
		List<Mensagens> rsMensagens;
		rsMensagens= new MensagensService().listarkey(id);
		objMensagens = rsMensagens.get(0);
		
		objMensagens.setLida(lida);
		
		return new MensagensService().atualizarMensagens(objMensagens);
	

	}

	
	/*
	
	@POST
	//@Path("upload")
	@Produces("application/json")
	public void eventoAction(

			@FormParam("action") String action,
			@FormParam("id") String strid,
			@FormParam("usuario") String usuario,
			@FormParam("destinatario") List<String> destinatario,
			@FormParam("mensagem") String mensagem){
		
		
		for (String string : destinatario) {
			
			System.out.println("destinatario " + string);
			
		}
		
	
	
	
	}
	*/
	
	
	
	
	

}
