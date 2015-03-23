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

import br.com.muranodesign.business.ProfessorFuncionarioService;
import br.com.muranodesign.model.ProfessorFuncionario;
import br.com.muranodesign.util.StringUtil;
import br.com.muranodesign.util.Upload;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

/**
 * Classe tem como objetivo disponibilizar os serviços relacionandos professor
 * funcionario
 * 
 * @author Rogerio Lima dos Santos
 * @version 1.00
 * @since Release 1 da aplicação
 */

@Path("ProfessorFuncionario")
public class ProfessorFuncionarioResource {

	/** The logger. */
	private Logger logger = Logger.getLogger(ProfessorFuncionarioResource.class
			.getName());

	/**
	 * Gets the professor funcionario.
	 * 
	 * @return the professor funcionario
	 */
	@GET
	@Produces("application/json")
	public List<ProfessorFuncionario> getProfessorFuncionario() {
		logger.info("Listar ProfessorFuncionario ...");
		List<ProfessorFuncionario> resultado;
		resultado = new ProfessorFuncionarioService().listarTodos();
		logger.info("QTD ProfessorFuncionario : " + resultado.size());
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
	public ProfessorFuncionario getEvento(@PathParam("id") int id) {
		logger.info("Lista ProfessorFuncionario  por id " + id);
		List<ProfessorFuncionario> resultado;
		resultado = new ProfessorFuncionarioService().listarkey(id);
		ProfessorFuncionario evento = resultado.get(0);

		return evento;

	}

	/**
	 * Removes the professor funcionario.
	 * 
	 * @param action
	 *            the action
	 * @param id
	 *            the id
	 * @return the string
	 */
	@Path("{action}/{id}")
	@Produces("text/plain")
	public String removeProfessorFuncionario(
			@PathParam("action") String action, @PathParam("id") int id) {

		logger.info("ProfessorFuncionario  " + action);
		if (action.equals("delete")) {
			List<ProfessorFuncionario> resultado;
			resultado = new ProfessorFuncionarioService().listarkey(id);
			ProfessorFuncionario evento = resultado.get(0);
			new ProfessorFuncionarioService()
					.deletarProfessorFuncionario(evento);
			return "true";
		} else {
			return "false";
		}

	}

	@POST
	@Produces("text/plain")
	public String eventoAction(

	@FormParam("action") String action, @FormParam("id") String strid,

	@FormParam("nome") String nome, @FormParam("rua") String rua,
			@FormParam("numero") String numero,
			@FormParam("complemento") String complemento,

			@FormParam("cep") String cep, @FormParam("bairro") String bairro,
			@FormParam("cidade") String cidade,

			@FormParam("estado") String estado,
			@FormParam("naturalidadeEstado") String naturalidadeEstado,
			@FormParam("naturalidadePais") String naturalidadePais,

			
			@FormParam("dataEntradaPrefeitura") String dataEntradaPrefeitura,
			@FormParam("ativo") String ativo,

			@FormParam("dataEntradaEscola") String dataEntradaEscola,
			@FormParam("observacao") String observacao
			//@FormParam("perfil") String perfil

	) {
		ProfessorFuncionario objProfessorFuncionario = new ProfessorFuncionario();
		logger.info("eventoAction ...");
		ProfessorFuncionario resultado;
		StringUtil stringUtil = new StringUtil();

		// List<Perfil> rsPerfil;
		// rsPerfil = new PerfilService().listarkey(Integer.parseInt(perfil));
		// Perfil objPerfil= rsPerfil.get(0);

		if (action.equals("create")) {

			// objProfessorFuncionario.setDataInicio(stringUtil.converteStringParaData(dataInicio));

			if (!nome.isEmpty()) {
				objProfessorFuncionario.setNome(nome);
			}
			if (!rua.isEmpty()) {
				objProfessorFuncionario.setRua(rua);
			}
			if (!numero.isEmpty()) {
				objProfessorFuncionario.setNumero(numero);
			}
			if (!complemento.isEmpty()) {
				objProfessorFuncionario.setComplemento(complemento);
			}

			if (!cep.isEmpty()) {
				objProfessorFuncionario.setCep(cep);
			}
			if (!bairro.isEmpty()) {
				objProfessorFuncionario.setBairro(bairro);
			}
			if (!cidade.isEmpty()) {
				objProfessorFuncionario.setCidade(cidade);
			}

			if (!estado.isEmpty()) {
				objProfessorFuncionario.setEstado(estado);
			}
			if (!naturalidadeEstado.isEmpty()) {
				objProfessorFuncionario
						.setNaturalidadeEstado(naturalidadeEstado);
			}
			if (!naturalidadePais.isEmpty()) {
				objProfessorFuncionario.setNaturalidadePais(naturalidadePais);
			}

			
			if (!dataEntradaPrefeitura.isEmpty()) {
				objProfessorFuncionario.setDataEntradaPrefeitura(stringUtil
						.converteStringData(dataEntradaPrefeitura));
			}
			if (!ativo.isEmpty()) {
				objProfessorFuncionario.setAtivo(ativo);
			}

			if (!dataEntradaEscola.isEmpty()) {
				objProfessorFuncionario.setDataEntradaEscola(stringUtil
						.converteStringData(dataEntradaEscola));
			}
			if (!observacao.isEmpty()) {
				objProfessorFuncionario.setObservacao(observacao);
			}
			// if ( ! nome.isEmpty()) {
			// objProfessorFuncionario.setPerfil(objPerfil);

			resultado = new ProfessorFuncionarioService()
					.criarProfessorFuncionario(objProfessorFuncionario);

		} else if (action.equals("update")) {

			int id = Integer.parseInt(strid);
			List<ProfessorFuncionario> rsProfessorFuncionario;
			rsProfessorFuncionario = new ProfessorFuncionarioService()
					.listarkey(id);
			objProfessorFuncionario = rsProfessorFuncionario.get(0);

			if (!nome.isEmpty()) {
				objProfessorFuncionario.setNome(nome);
			}
			if (!rua.isEmpty()) {
				objProfessorFuncionario.setRua(rua);
			}
			if (!numero.isEmpty()) {
				objProfessorFuncionario.setNumero(numero);
			}
			if (!complemento.isEmpty()) {
				objProfessorFuncionario.setComplemento(complemento);
			}

			if (!cep.isEmpty()) {
				objProfessorFuncionario.setCep(cep);
			}
			if (!bairro.isEmpty()) {
				objProfessorFuncionario.setBairro(bairro);
			}
			if (!cidade.isEmpty()) {
				objProfessorFuncionario.setCidade(cidade);
			}

			if (!estado.isEmpty()) {
				objProfessorFuncionario.setEstado(estado);
			}
			if (!naturalidadeEstado.isEmpty()) {
				objProfessorFuncionario
						.setNaturalidadeEstado(naturalidadeEstado);
			}
			if (!naturalidadePais.isEmpty()) {
				objProfessorFuncionario.setNaturalidadePais(naturalidadePais);
			}

			
			if (!dataEntradaPrefeitura.isEmpty()) {
				objProfessorFuncionario.setDataEntradaPrefeitura(stringUtil
						.converteStringData(dataEntradaPrefeitura));
			}
			if (!ativo.isEmpty()) {
				objProfessorFuncionario.setAtivo(ativo);
			}

			if (!dataEntradaEscola.isEmpty()) {
				objProfessorFuncionario.setDataEntradaEscola(stringUtil
						.converteStringData(dataEntradaEscola));
			}
			if (!observacao.isEmpty()) {
				objProfessorFuncionario.setObservacao(observacao);
			}

			resultado = new ProfessorFuncionarioService()
					.atualizarProfessorFuncionario(objProfessorFuncionario);

		} else {
			return "0";
		}
		return Integer.toString(resultado.getIdprofessorFuncionario());

	}

	@POST
	@Path("upload/ProfessorFuncionario/imagem/{id}")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public ProfessorFuncionario eventoAction2(

	@PathParam("id") String strId,
			@FormDataParam("imagem") InputStream uploadedInputStream,
			@FormDataParam("imagem") FormDataContentDisposition fileDetail

	) {

		ProfessorFuncionario objProfessorFuncionario = new ProfessorFuncionario();
		ProfessorFuncionario resultado = new ProfessorFuncionario();

		int id = Integer.parseInt(strId);
		List<ProfessorFuncionario> rsProfessorFuncionario;
		rsProfessorFuncionario = new ProfessorFuncionarioService()
				.listarkey(id);
		objProfessorFuncionario = rsProfessorFuncionario.get(0);

		StringUtil stringUtil = new StringUtil();
		String imagem = stringUtil.geraNomeAleatorio(fileDetail.getFileName(),
				50);
		String uploadedFileLocation = "/home/tomcat/webapps/files/" + imagem;
		String anexo = "http://177.55.99.90/files/" + imagem;

		Upload upload = new Upload();
		upload.writeToFile(uploadedInputStream, uploadedFileLocation);

		logger.info("anexo" + anexo);

		objProfessorFuncionario.setFotoProfessorFuncionario(anexo);

		resultado = new ProfessorFuncionarioService()
				.atualizarProfessorFuncionario(objProfessorFuncionario);

		return resultado;

	}

}
