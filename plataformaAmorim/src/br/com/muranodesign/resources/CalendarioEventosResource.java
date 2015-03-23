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

import br.com.muranodesign.business.AnoLetivoService;
import br.com.muranodesign.business.CalendarioEventosService;
import br.com.muranodesign.business.CalendarioService;
import br.com.muranodesign.business.TipoEventoService;
import br.com.muranodesign.model.AnoLetivo;
import br.com.muranodesign.model.Calendario;
import br.com.muranodesign.model.CalendarioEventos;
import br.com.muranodesign.model.TipoEvento;
import br.com.muranodesign.util.StringUtil;
import br.com.muranodesign.util.Upload;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;


// TODO: Auto-generated Javadoc
/**
 * Classe tem como objetivo disponibilizar os serviços calendario evento.
 *
 * @author Rogerio Lima dos Santos
 * @version 1.00
 * @since Release 1 da aplicação
 */
@Path("CalendarioEventos")
public class CalendarioEventosResource {

	/** The logger. */
	private Logger logger = Logger.getLogger(CalendarioEventosResource.class.getName());

	/**
	 * lista  calendario eventos.
	 *
	 * @return lista de caledario calendario eventos
	 */
	@GET
	@Produces("application/json")
	public List<CalendarioEventos> getCalendarioEventos() {
		logger.info("Listar CalendarioEventos ...");
		List<CalendarioEventos> resultado;
		resultado = new CalendarioEventosService().listarTodos();
		logger.info("QTD CalendarioEventos : " + resultado.size());
		return resultado;
	}

	/**
	 * lista calendario evento em especifico.
	 *
	 * @param id do calendario evento
	 * @return calendario evento
	 */
	@Path("{id}")
	@GET
	@Produces("application/json")
	public CalendarioEventos getEvento(@PathParam("id") int id) {
		logger.info("Lista CalendarioEventos  por id " + id);
		List<CalendarioEventos> resultado;
		resultado = new CalendarioEventosService().listarkey(id);
		CalendarioEventos evento = resultado.get(0);

		return evento;

	}
	
	/**
	 * Remove  calendario eventos.
	 *
	 * @param action delete para remover
	 * @param id  id do Calendario Evento
	 * @return true para deleção com sucesso e false para no action
	 */
	@Path("{action}/{id}")
	@Produces("text/plain")
	public String removeCalendarioEventos(@PathParam("action") String action,
			@PathParam("id") int id) {

		logger.info("CalendarioEventos  " + action);
		if ( action.equals("delete")) {
			List<CalendarioEventos> resultado;
			resultado = new CalendarioEventosService().listarkey(id);
			CalendarioEventos res = resultado.get(0);
			new CalendarioEventosService().deletarCalendarioEventos(res);
			return "true";
		} else {
			return "false";
		}

	}
	
	
	
	
	
	
	/**
	 * Serviço reponsavel por cadastra e atualizar dados
	 *
	 * @param action Metodo a ser executado create ou update
	 * @param strid id para update
	 * @param dataInicio  data inicio
	 * @param dataFim  data fim
	 * @param evento  evento
	 * @param descricao  descricao
	 * @param calendario  calendario
	 * @param anoLetivo  ano letivo
	 * @param tipoEvento  tipo evento
	 * @return identificador de controle interno da aplicação
	 */
	@POST
	@Produces("text/plain")
	public String eventoAction(
			
			@FormParam("action") String action,
			@FormParam("id") String strid,
			
			@FormParam("dataInicio") String dataInicio,
			@FormParam("dataFim") String dataFim,
			@FormParam("evento") String evento,
			@FormParam("descricao") String descricao,
			
			@FormParam("calendario") String calendario,
			@FormParam("anoLetivo") String anoLetivo,
			@FormParam("tipoEvento") String tipoEvento
			
			
			
			
			) {
		CalendarioEventos objCalendarioEventos = new CalendarioEventos();
		logger.info("eventoAction ...");
		CalendarioEventos resultado;
		StringUtil stringUtil = new StringUtil();
		
		
		
		
		List<TipoEvento> rsTipoEvento;
		rsTipoEvento = new TipoEventoService().listarkey(Integer.parseInt(tipoEvento));
		TipoEvento objTipoEvento= rsTipoEvento.get(0);
		
		
		
		List<AnoLetivo> rsAnoLetivo;
		rsAnoLetivo = new AnoLetivoService().listarkey(Integer.parseInt(anoLetivo));
		AnoLetivo objAnoLetivo= rsAnoLetivo.get(0);
		
		
		Calendario objCalendario = null;
		
		if (!calendario.isEmpty()) {
			List<Calendario> rsCalendario;
			rsCalendario = new CalendarioService().listarkey(Integer.parseInt(calendario));
			objCalendario= rsCalendario.get(0);
		}
		
	
		
		
		
		if (action.equals("create")) {
			
		
			objCalendarioEventos.setDataInicio(stringUtil.converteStringData(dataInicio));
			objCalendarioEventos.setDataFim(stringUtil.converteStringData(dataFim));
			objCalendarioEventos.setEvento(evento);
			objCalendarioEventos.setDescricao(descricao);
			
			//objCalendarioEventos.setAnoLetivo(objAnoLetivo);
			objCalendarioEventos.setTipoEvento(objTipoEvento);
			if (!calendario.isEmpty()) {
			objCalendarioEventos.setCalendario(objCalendario);
			}
			
	
			resultado = new CalendarioEventosService().criarCalendarioEventos(objCalendarioEventos);
			
		}  else if (action.equals("update")) {
			
			int id=Integer.parseInt(strid);
			List<CalendarioEventos> rsCalendarioEventos;
			rsCalendarioEventos= new CalendarioEventosService().listarkey(id);
			objCalendarioEventos= rsCalendarioEventos.get(0);
		
			objCalendarioEventos.setDataInicio(stringUtil.converteStringData(dataInicio));
			objCalendarioEventos.setDataFim(stringUtil.converteStringData(dataFim));
			objCalendarioEventos.setEvento(evento);
			objCalendarioEventos.setDescricao(descricao);
			
			//objCalendarioEventos.setAnoLetivo(objAnoLetivo);
			objCalendarioEventos.setTipoEvento(objTipoEvento);
			if (!calendario.isEmpty()) {
			objCalendarioEventos.setCalendario(objCalendario);
			}
			
			
			
			 resultado =  new CalendarioEventosService().atualizarCalendarioEventos(objCalendarioEventos);
			
		} else {
			return "0";
		}
	    return Integer.toString(resultado.getIdeventos());
	
		}
	
	
	
	
	
	/**
	 * upload de  imagem
	 *
	 * @param strId identificador calendario evento
	 * @param uploadedInputStream campo do tipo file html
	 * @param fileDetail  campo campo do tipo  file html
	 * @return the calendario eventos
	 */
	@POST
	@Path("upload/CalendarioEventos/imagem/{id}")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public CalendarioEventos eventoAction2(

			@PathParam("id") String strId,
			@FormDataParam("imagem") InputStream uploadedInputStream,
			@FormDataParam("imagem") FormDataContentDisposition fileDetail


			) {

		CalendarioEventos objCalendarioEventos = new CalendarioEventos();
		CalendarioEventos resultado = new CalendarioEventos();
		
		int id=Integer.parseInt(strId);
		List<CalendarioEventos> rsCalendarioEventos;
		rsCalendarioEventos= new CalendarioEventosService().listarkey(id);
		objCalendarioEventos= rsCalendarioEventos.get(0);
		
		StringUtil stringUtil = new StringUtil();
		String imagem = stringUtil.geraNomeAleatorio(fileDetail.getFileName(),50);
		String uploadedFileLocation = "/home/tomcat/webapps/files/" + imagem;
		String anexo = "http://177.55.99.90/files/"+ imagem;
		
		Upload upload = new Upload (); 
		upload.writeToFile(uploadedInputStream, uploadedFileLocation);
		
		logger.info("anexo" + anexo);     
		
		objCalendarioEventos.setImagem(anexo);
		
		resultado =  new CalendarioEventosService().atualizarCalendarioEventos(objCalendarioEventos);

		return resultado;


	}

	

}
