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
import br.com.muranodesign.business.PeriodoService;
import br.com.muranodesign.business.ProfessorFuncionarioService;
import br.com.muranodesign.business.ProfessorFuncionarioVariavelService;
import br.com.muranodesign.model.AnoLetivo;
import br.com.muranodesign.model.Periodo;
import br.com.muranodesign.model.ProfessorFuncionario;
import br.com.muranodesign.model.ProfessorFuncionarioVariavel;
import br.com.muranodesign.util.StringUtil;
import br.com.muranodesign.util.Upload;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;


// TODO: Auto-generated Javadoc
/**
 * Classe tem como objetivo disponibilizar os serviços relacionandos professor funcionario valiavel.
 *
 * @author Rogerio Lima dos Santos
 * @version 1.00
 * @since Release 1 da aplicação
 */
@Path("ProfessorFuncionarioVariavel")
public class ProfessorFuncionarioVariavelResource {

	/** The logger. */
	private Logger logger = Logger
			.getLogger(ProfessorFuncionarioVariavelResource.class.getName());

	/**
	 * Gets the professor funcionario variavel.
	 * 
	 * @return the professor funcionario variavel
	 */
	@Path("listar/{status}")
	@GET
	@Produces("application/json")
	public List<ProfessorFuncionarioVariavel> getProfessorFuncionarioVariavel(@PathParam("status") int status) {
		logger.info("Listar ProfessorFuncionarioVariavel ...");
		List<ProfessorFuncionarioVariavel> resultado;
		resultado = new ProfessorFuncionarioVariavelService().listarTodos(status);
		logger.info("QTD ProfessorFuncionarioVariavel : " + resultado.size());
		return resultado;
	}
	
	
	/**
	 * Gets the professor funcionario variavel.
	 * 
	 * @return the professor funcionario variavel
	 */
	@GET
	@Produces("application/json")
	public List<ProfessorFuncionarioVariavel> getProfessorFuncionarioVariavel() {
		logger.info("Listar ProfessorFuncionarioVariavel ...");
		List<ProfessorFuncionarioVariavel> resultado;
		resultado = new ProfessorFuncionarioVariavelService().listarTodos();
		logger.info("QTD ProfessorFuncionarioVariavel : " + resultado.size());
		return resultado;
	}

	

	/**
	 * Gets the evento.
	 * 
	 * @param id
	 *            the id
	 * @return the evento
	 */
	@Path("{id}")
	@GET
	@Produces("application/json")
	public ProfessorFuncionarioVariavel getEvento(@PathParam("id") int id) {
		logger.info("Lista ProfessorFuncionarioVariavel  por id " + id);
		List<ProfessorFuncionarioVariavel> resultado;
		resultado = new ProfessorFuncionarioVariavelService().listarkey(id);
		ProfessorFuncionarioVariavel evento = resultado.get(0);

		return evento;

	}

	/**
	 * Removes the professor funcionario variavel.
	 * 
	 * @param action
	 *            the action
	 * @param id
	 *            the id
	 * @return the string
	 */
	@Path("{action}/{id}")
	@Produces("text/plain")
	public String removeProfessorFuncionarioVariavel(
			@PathParam("action") String action, @PathParam("id") int id) {

		logger.info("ProfessorFuncionarioVariavel  " + action);
		if (action.equals("delete")) {
			List<ProfessorFuncionarioVariavel> resultado;
			resultado = new ProfessorFuncionarioVariavelService().listarkey(id);
			ProfessorFuncionarioVariavel res = resultado.get(0);
			new ProfessorFuncionarioVariavelService()
					.deletarProfessorFuncionarioVariavel(res);
			return "true";
		} else {
			return "false";
		}

	}

	
	
	/**
	 * Evento action.
	 *
	 * @param action the action
	 * @param strid the strid
	 * @param formacao the formacao
	 * @param quinquenio the quinquenio
	 * @param letra the letra
	 * @param descontoQuinquenio the desconto quinquenio
	 * @param observacao the observacao
	 * @param cargo the cargo
	 * @param professorFuncionario the professor funcionario
	 * @param periodo the periodo
	 * @param anoLetivo the ano letivo
	 * @param ativo  status do professor 0 deletado 1 valido
	 * @return the string
	 */
	@POST
	@Produces("text/plain")
	public String eventoAction(

	@FormParam("action") String action, @FormParam("id") String strid,

	@FormParam("formacao") String formacao,
			@FormParam("quinquenio") String quinquenio,
			@FormParam("letra") String letra,
			@FormParam("descontoQuinquenio") String descontoQuinquenio,

			@FormParam("observacao") String observacao,
			@FormParam("cargo") String cargo,
			@FormParam("professorFuncionario") String professorFuncionario,

			@FormParam("periodo") String periodo,
			@FormParam("anoLetivo") String anoLetivo,
			@FormParam("ativo") int ativo,
			@FormParam("qpe") String qpe
			
			

	) {
		ProfessorFuncionarioVariavel objProfessorFuncionarioVariavel = new ProfessorFuncionarioVariavel();
		logger.info("eventoAction ...");
		ProfessorFuncionarioVariavel resultado;
		StringUtil stringUtil = new StringUtil();

		List<ProfessorFuncionario> rsProfessorFuncionario;
		rsProfessorFuncionario = new ProfessorFuncionarioService()
				.listarkey(Integer.parseInt(professorFuncionario));
		ProfessorFuncionario objProfessorFuncionario = rsProfessorFuncionario
				.get(0);

		List<Periodo> rsPeriodo;
		rsPeriodo = new PeriodoService().listarkey(Integer.parseInt(periodo));
		Periodo objPeriodo = rsPeriodo.get(0);

		List<AnoLetivo> rsAnoLetivo;
		rsAnoLetivo = new AnoLetivoService().listarkey(Integer
				.parseInt(anoLetivo));
		AnoLetivo objAnoLetivo = rsAnoLetivo.get(0);

		if (action.equals("create")) {

			// objProfessorFuncionarioVariavel.setDataInicio(stringUtil.converteStringParaData(dataInicio));

			objProfessorFuncionarioVariavel.setFormacao(formacao);
			objProfessorFuncionarioVariavel.setQuinquenio(Short
					.parseShort(quinquenio));
			objProfessorFuncionarioVariavel.setLetra(letra);

			objProfessorFuncionarioVariavel.setDescontoQuinquenio(Short
					.parseShort(descontoQuinquenio));
			objProfessorFuncionarioVariavel.setObservacao(observacao);
			objProfessorFuncionarioVariavel.setCargo(cargo);
			
			objProfessorFuncionarioVariavel.setQpe(qpe);

			objProfessorFuncionarioVariavel
					.setProfessorFuncionario(objProfessorFuncionario);
			objProfessorFuncionarioVariavel.setPeriodo(objPeriodo);
			objProfessorFuncionarioVariavel.setAnoLetivo(objAnoLetivo);
			objProfessorFuncionarioVariavel.setAtivo(ativo);

			resultado = new ProfessorFuncionarioVariavelService()
					.criarProfessorFuncionarioVariavel(objProfessorFuncionarioVariavel);

		} else if (action.equals("update")) {

			int id = Integer.parseInt(strid);
			List<ProfessorFuncionarioVariavel> rsProfessorFuncionarioVariavel;
			rsProfessorFuncionarioVariavel = new ProfessorFuncionarioVariavelService()
					.listarkey(id);
			objProfessorFuncionarioVariavel = rsProfessorFuncionarioVariavel
					.get(0);

			objProfessorFuncionarioVariavel.setFormacao(formacao);
			objProfessorFuncionarioVariavel.setQuinquenio(Short
					.parseShort(quinquenio));
			objProfessorFuncionarioVariavel.setLetra(letra);

			objProfessorFuncionarioVariavel.setDescontoQuinquenio(Short
					.parseShort(descontoQuinquenio));
			objProfessorFuncionarioVariavel.setObservacao(observacao);
			objProfessorFuncionarioVariavel.setCargo(cargo);
			objProfessorFuncionarioVariavel.setQpe(qpe);

			objProfessorFuncionarioVariavel
					.setProfessorFuncionario(objProfessorFuncionario);
			objProfessorFuncionarioVariavel.setPeriodo(objPeriodo);
			objProfessorFuncionarioVariavel.setAnoLetivo(objAnoLetivo);
			objProfessorFuncionarioVariavel.setAtivo(ativo);

			resultado = new ProfessorFuncionarioVariavelService()
					.atualizarProfessorFuncionarioVariavel(objProfessorFuncionarioVariavel);

		} else {
			return "0";
		}
		return Integer.toString(resultado.getIdprofessorFuncionarioVariavel());

	}

	/**
	 * Evento action2.
	 *
	 * @param strId the str id
	 * @param uploadedInputStream the uploaded input stream
	 * @param fileDetail the file detail
	 * @return the professor funcionario variavel
	 */
	@POST
	@Path("upload/ProfessorFuncionarioVariavel/imagem/{id}")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public ProfessorFuncionarioVariavel eventoAction2(

	@PathParam("id") String strId,
			@FormDataParam("imagem") InputStream uploadedInputStream,
			@FormDataParam("imagem") FormDataContentDisposition fileDetail

	) {

		ProfessorFuncionarioVariavel objProfessorFuncionarioVariavel = new ProfessorFuncionarioVariavel();
		ProfessorFuncionarioVariavel resultado = new ProfessorFuncionarioVariavel();

		int id = Integer.parseInt(strId);
		List<ProfessorFuncionarioVariavel> rsProfessorFuncionarioVariavel;
		rsProfessorFuncionarioVariavel = new ProfessorFuncionarioVariavelService()
				.listarkey(id);
		objProfessorFuncionarioVariavel = rsProfessorFuncionarioVariavel.get(0);

		StringUtil stringUtil = new StringUtil();
		String imagem = stringUtil.geraNomeAleatorio(fileDetail.getFileName(),
				50);
		String uploadedFileLocation = "/home/tomcat/webapps/files/" + imagem;
		String anexo = "http://177.55.99.90/files/" + imagem;

		Upload upload = new Upload();
		upload.writeToFile(uploadedInputStream, uploadedFileLocation);

		logger.info("anexo" + anexo);

		objProfessorFuncionarioVariavel.setFotoProfessorFuncionario(anexo);

		resultado = new ProfessorFuncionarioVariavelService()
				.atualizarProfessorFuncionarioVariavel(objProfessorFuncionarioVariavel);

		return resultado;

	}

}
