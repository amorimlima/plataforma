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
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import br.com.muranodesign.business.AlunoService;
import br.com.muranodesign.model.Aluno;
import br.com.muranodesign.util.StringUtil;
import br.com.muranodesign.util.Upload;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

/**
 * Classe tem como objetivo disponibilizar os serviços relacionandos a Aluno.
 * 
 * @author Rogerio Lima dos Santos
 * @version 1.00
 * @since Release 1 da aplicação
 */
@Path("Alunos")
public class AlunoResource {

	/** logger. */
	private Logger logger = Logger.getLogger(AlunoResource.class.getName());

	/**
	 * Serviço reponsavel por Lista todos os alunos.
	 * 
	 * @return Alunos
	 */
	@GET
	@Produces("application/json")
	public List<Aluno> getAlunos() {
		logger.debug("Listar Alunos ...");
		List<Aluno> resultado;
		resultado = new AlunoService().listarTodos();
		logger.debug("QTD Alunos : " + resultado.size());
		return resultado;
	}

	/**
	 * Lista aluno especifico.
	 * 
	 * @param id
	 *            do aluno
	 * @return Aluno
	 */
	@Path("{id}")
	@GET
	@Produces("application/json")
	public Aluno getAluno(@PathParam("id") int id) {

		List<Aluno> resultado;
		resultado = new AlunoService().listarkey(id);
		Aluno aluno = null;

		if (!resultado.isEmpty()) {
			aluno = resultado.get(0);
		}
		return aluno;

	}

	/**
	 * Carrega foto do aluno.
	 * 
	 * @param strId
	 *            id do aluno a ser adicionado a foto 
	 * @param uploadedInputStream
	 *           stream foto
	 * @param fileDetail
	 *            detalhes do arquivo
	 * @return id do Aluno
	 */

	@POST
	@Path("upload/aluno/{id}")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Aluno eventoAction(

	@PathParam("id") String strId,
			@FormDataParam("fotoAluno") InputStream uploadedInputStream,
			@FormDataParam("fotoAluno") FormDataContentDisposition fileDetail

	) {

		Aluno objAluno = new Aluno();
		int id = Integer.parseInt(strId);
		List<Aluno> rsAluno;
		rsAluno = new AlunoService().listarkey(id);
		objAluno = rsAluno.get(0);

		// TODO: Criar uma configiracao para o caminho
		StringUtil stringUtil = new StringUtil();
		String arquivo = stringUtil.geraNomeAleatorio(fileDetail.getFileName(),
				50);
		String uploadedFileLocation = "/home/tomcat/webapps/files/" + arquivo;

		Upload upload = new Upload();
		// save it
		upload.writeToFile(uploadedInputStream, uploadedFileLocation);

		String anexo = "http://177.55.99.90/files/" + arquivo;

		logger.info("anexo" + anexo);

		objAluno.setFotoAluno(anexo);
		Aluno resultado = new AlunoService().atualizarAluno(objAluno);

		return resultado;

	}

	/**
	 * Serviço reponsavel por cadastra e atualizar dados do aluno
	 * 
	 * @param action
	 *            Metodo a ser executado create ou update
	 * @param strid
	 *            id do aluno para update
	 * @param bairro
	 *            parte do endereço bairro
	 * @param cep
	 *            the parte do endereço cep
	 * @param cepMae
	 *            parte do endereço cep mae
	 * @param cepPai
	 *            parte do endereço cep pai
	 * @param cepResponsavel
	 *            parte do endereço cep responsavel
	 * @param cidade
	 *            parte do endereço cidade
	 * @param cidadeMae
	 *            parte do endereço cidade mae
	 * @param cidadePai
	 *            parte do endereço cidade pai
	 * @param cidadeResponsavel
	 *            parte do endereço cidade responsavel
	 * @param complemento
	 *            parte do endereço complemento
	 * @param complementoMae
	 *            parte do endereço complemento mae
	 * @param complementoPai
	 *            parte do endereço complemento pai
	 * @param complementoResponsavel
	 *            parte do endereço complemento responsavel
	 * @param dataMatricula
	 *            data matricula
	 * @param dataNascimento
	 *            data nascimento do aluno
	 * @param email1Mae
	 *            primeiro email da mae
	 * @param email1Pai
	 *            primeiro email do pai
	 * @param email1Responsavel
	 *            the email1 responsavel
	 * @param email2Mae
	 *            segundo email da mae
	 * @param email2Pai
	 *            segundo email do pai
	 * @param email2Responsavel
	 *            segundo email responsavel
	 * @param endereco
	 *            parte do endereco rua-av
	 * @param enderecoMae
	 *            parte do endereco rua-av
	 * @param enderecoPai
	 *            parte do endereco rua-av
	 * @param enderecoResponsavel
	 *            parte do endereco rua-av
	 * @param etnia
	 *            definição de algum grupo social, cultura, origens, raça etc..
	 * @param naturalCidade
	 *            cidade de nascimento do aluno
	 * @param naturalEstado
	 *            estado de nascimento do aluno
	 * @param naturalPais
	 *            pais de nascimento do aluno
	 * @param nome
	 *            nome do aluno
	 * @param nomeMae
	 *            nome da mae
	 * @param nomePai
	 *            nome do pai
	 * @param nomeResponsavel
	 *            nome do responsavel
	 * @param numero
	 *            parte do endereço numero
	 * @param numeroMae
	 *            parte do endereço numero da mae
	 * @param numeroPai
	 *            parte do endereço numero do pai
	 * @param numeroResponsavel
	 *            parte do endereço numero do responsavel
	 * @param pais
	 *            parte do endereço pais
	 * @param responsaveisResponsavel
	 *            nome responsaveis responsavel
	 * @param rg
	 *            rg do aluno
	 * @param telefoneCelularMae
	 *            telefone celular mae
	 * @param telefoneCelularPai
	 *            telefone celular pai
	 * @param telefoneCelularResponsavel
	 *            telefone celular responsavel
	 * @param telefoneComercialMae
	 *            telefone comercial mae
	 * @param telefoneComercialPai
	 *            telefone comercial pai
	 * @param telefoneComercialResponsavel
	 *            telefone comercial responsavel
	 * @param telefoneResidencialMae
	 *            telefone residencial mae
	 * @param telefoneResidencialPai
	 *            telefone residencial pai
	 * @param telefoneResidencialResponsavel
	 *            telefone residencial responsavel
	 * @param necessidadeEspecial
	 *            necessidade especial
	 * @param uf
	 *            parte do endereço uf
	 * @param ufMae
	 *            parte do endereço uf mae
	 * @param ufPai
	 *            parte do endereço uf pai
	 * @param ufResponsavel
	 *            parte do endereço uf responsavel
	 * @param sexo
	 *            sexo do aluno
	 * @param ativo
	 *            Estatus do cadastro - 0 ou 1
	 * @param numeroEol
	 *            numero eol
	 * @param numeroRA
	 *            numero ra
	 * @param email
	 *            email
	 * @param celular
	 *            celular
	 * @param cpf
	 *            cpf
	 * @param observacao
	 *            observacao
	 * @param parentescoResponsavel
	 *            parentesco responsavel
	 * @param e
	 *            necessidadeEspecial é portador de necessidade especial
	 * @param e
	 *            responsavelLegalMae A mae é responsavel legal
	 * @param e
	 *            responsavelLegalPai O pai é eresponsavel legal
	 * @param e
	 *            responsavelLegalResponsavel existe outro responsavel legal
	 * @return string identificador de controle interno da aplicação
	 */
	@POST
	// @Path("upload")
	@Produces("application/json")
	public String eventoAction(

			@FormParam("action") String action,
			@FormParam("id") String strid,
			@FormParam("bairro") String bairro,
			@FormParam("cep") String cep,
			@FormParam("cepMae") String cepMae,
			@FormParam("cepPai") String cepPai,
			@FormParam("cepResponsavel") String cepResponsavel,
			@FormParam("cidade") String cidade,
			@FormParam("cidadeMae") String cidadeMae,
			@FormParam("cidadePai") String cidadePai,
			@FormParam("cidadeResponsavel") String cidadeResponsavel,
			@FormParam("complemento") String complemento,
			@FormParam("complementoMae") String complementoMae,
			@FormParam("complementoPai") String complementoPai,
			@FormParam("complementoResponsavel") String complementoResponsavel,
			@FormParam("dataMatricula") String dataMatricula,
			@FormParam("dataNascimento") String dataNascimento,
			@FormParam("email1Mae") String email1Mae,
			@FormParam("email1Pai") String email1Pai,
			@FormParam("email1Responsavel") String email1Responsavel,
			@FormParam("email2Mae") String email2Mae,
			@FormParam("email2Pai") String email2Pai,
			@FormParam("email2Responsavel") String email2Responsavel,
			@FormParam("endereco") String endereco,
			@FormParam("enderecoMae") String enderecoMae,
			@FormParam("enderecoPai") String enderecoPai,
			@FormParam("enderecoResponsavel") String enderecoResponsavel,
			@FormParam("etnia") String etnia,
			@FormParam("naturalCidade") String naturalCidade,
			@FormParam("naturalEstado") String naturalEstado,
			@FormParam("naturalPais") String naturalPais,
			@FormParam("nome") String nome,
			@FormParam("nomeMae") String nomeMae,
			@FormParam("nomePai") String nomePai,
			@FormParam("nomeResponsavel") String nomeResponsavel,
			@FormParam("numero") String numero,
			@FormParam("numeroMae") String numeroMae,
			@FormParam("numeroPai") String numeroPai,
			@FormParam("numeroResponsavel") String numeroResponsavel,
			@FormParam("pais") String pais,
			@FormParam("responsaveisResponsavel") String responsaveisResponsavel,
			@FormParam("rg") String rg,
			@FormParam("telefoneCelularMae") String telefoneCelularMae,
			@FormParam("telefoneCelularPai") String telefoneCelularPai,
			@FormParam("telefoneCelularResponsavel") String telefoneCelularResponsavel,
			@FormParam("telefoneComercialMae") String telefoneComercialMae,
			@FormParam("telefoneComercialPai") String telefoneComercialPai,
			@FormParam("telefoneComercialResponsavel") String telefoneComercialResponsavel,
			@FormParam("telefoneResidencialMae") String telefoneResidencialMae,
			@FormParam("telefoneResidencialPai") String telefoneResidencialPai,
			@FormParam("telefoneResidencialResponsavel") String telefoneResidencialResponsavel,
			@FormParam("necessidadeEspecial") String necessidadeEspecial,
			@FormParam("uf") String uf,
			@FormParam("ufMae") String ufMae,
			@FormParam("ufPai") String ufPai,
			@FormParam("ufResponsavel") String ufResponsavel,
			// @FormParam("fotoAluno") String fotoAluno,
			// @FormParam("fotoAluno") InputStream uploadedInputStream,
			// @FormParam("fotoAluno") FormDataContentDisposition fileDetail,
			@FormParam("sexo") String sexo,
			@FormParam("ativo") String ativo,
			@FormParam("numeroEol") String numeroEol,
			@FormParam("numeroRA") String numeroRA,
			@FormParam("email") String email,
			@FormParam("celular") String celular,
			@FormParam("cpf") String cpf,
			@FormParam("observacao") String observacao,
			@FormParam("parentescoResponsavel") String parentescoResponsavel,
			@FormParam("enecessidadeEspecial") String enecessidadeEspecial,
			@FormParam("eresponsavelLegalMae") String eresponsavelLegalMae,
			@FormParam("eresponsavelLegalPai") String eresponsavelLegalPai,
			@FormParam("eresponsavelLegalResponsavel") String eresponsavelLegalResponsavel) {

		StringUtil stringUtil = new StringUtil();
		Aluno objAluno = new Aluno();
		logger.info("Novo Aluno ...");
		Aluno resultado;

		if (action.equals("create")) {

			if (!bairro.isEmpty()) {
				objAluno.setBairro(bairro);
			}

			if (!cep.isEmpty()) {
				objAluno.setCep(cep);
			}
			if (!cepMae.isEmpty()) {
				objAluno.setCepMae(cepMae);
			}
			if (!cepPai.isEmpty()) {
				objAluno.setCepPai(cepPai);
			}
			if (!cepResponsavel.isEmpty()) {
				objAluno.setCepResponsavel(cepResponsavel);
			}
			if (!cidade.isEmpty()) {
				objAluno.setCidade(cidade);
			}
			if (!cidadeMae.isEmpty()) {
				objAluno.setCidadeMae(cidadeMae);
			}
			if (!cidadePai.isEmpty()) {
				objAluno.setCidadePai(cidadePai);
			}
			if (!cidadeResponsavel.isEmpty()) {
				objAluno.setCidadeResponsavel(cidadeResponsavel);
			}
			if (!complemento.isEmpty()) {
				objAluno.setComplemento(complemento);
			}
			if (!complementoMae.isEmpty()) {
				objAluno.setComplementoMae(complementoMae);
			}
			if (!complementoPai.isEmpty()) {
				objAluno.setComplementoPai(complementoPai);
			}
			if (!complementoResponsavel.isEmpty()) {
				objAluno.setComplementoResponsavel(complementoResponsavel);
			}
			if (!dataMatricula.isEmpty()) {
				objAluno.setDataMatricula(stringUtil
						.converteStringData(dataMatricula));
			}
			if (!dataNascimento.isEmpty()) {
				objAluno.setDataNascimento(stringUtil
						.converteStringData(dataNascimento));
			}
			if (!email1Mae.isEmpty()) {
				objAluno.setEmail1Mae(email1Mae);
			}
			if (!email1Pai.isEmpty()) {
				objAluno.setEmail1Pai(email1Pai);
			}
			if (!email1Responsavel.isEmpty()) {
				objAluno.setEmail1Responsavel(email1Responsavel);
			}
			if (!email2Mae.isEmpty()) {
				objAluno.setEmail2Mae(email2Mae);
			}
			if (!email2Pai.isEmpty()) {
				objAluno.setEmail2Pai(email2Pai);
			}
			if (!email2Responsavel.isEmpty()) {
				objAluno.setEmail2Responsavel(email2Responsavel);
			}
			if (!endereco.isEmpty()) {
				objAluno.setEndereco(endereco);
			}
			if (!enderecoMae.isEmpty()) {
				objAluno.setEnderecoMae(enderecoMae);
			}
			if (!enderecoPai.isEmpty()) {
				objAluno.setEnderecoPai(enderecoPai);
			}
			if (!enderecoResponsavel.isEmpty()) {
				objAluno.setEnderecoResponsavel(enderecoResponsavel);
			}
			if (!etnia.isEmpty()) {
				objAluno.setEtnia(etnia);
			}
			if (!naturalCidade.isEmpty()) {
				objAluno.setNaturalCidade(naturalCidade);
			}
			if (!naturalEstado.isEmpty()) {
				objAluno.setNaturalEstado(naturalEstado);
			}
			if (!naturalPais.isEmpty()) {
				objAluno.setNaturalPais(naturalPais);
			}
			if (!nome.isEmpty()) {
				objAluno.setNome(nome);
			}
			if (!nomeMae.isEmpty()) {
				objAluno.setNomeMae(nomeMae);
			}
			if (!nomePai.isEmpty()) {
				objAluno.setNomePai(nomePai);
			}
			if (!nomeResponsavel.isEmpty()) {
				objAluno.setNomeResponsavel(nomeResponsavel);
			}
			if (!numero.isEmpty()) {
				objAluno.setNumero(numero);
			}
			if (!numeroMae.isEmpty()) {
				objAluno.setNumeroMae(numeroMae);
			}
			if (!numeroPai.isEmpty()) {
				objAluno.setNumeroPai(numeroPai);
			}
			if (!numeroResponsavel.isEmpty()) {
				objAluno.setNumeroResponsavel(numeroResponsavel);
			}
			if (!pais.isEmpty()) {
				objAluno.setPais(pais);
			}
			if (!responsaveisResponsavel.isEmpty()) {
				objAluno.setResponsaveisResponsavel(responsaveisResponsavel);
			}
			if (!rg.isEmpty()) {
				objAluno.setRg(rg);
			}
			if (!telefoneCelularMae.isEmpty()) {
				objAluno.setTelefoneCelularMae(telefoneCelularMae);
			}
			if (!telefoneCelularPai.isEmpty()) {
				objAluno.setTelefoneCelularPai(telefoneCelularPai);
			}
			if (!telefoneCelularResponsavel.isEmpty()) {
				objAluno.setTelefoneCelularResponsavel(telefoneCelularResponsavel);
			}
			if (!telefoneComercialMae.isEmpty()) {
				objAluno.setTelefoneComercialMae(telefoneComercialMae);
			}
			if (!telefoneComercialPai.isEmpty()) {
				objAluno.setTelefoneComercialPai(telefoneComercialPai);
			}
			if (!telefoneComercialResponsavel.isEmpty()) {
				objAluno.setTelefoneComercialResponsavel(telefoneComercialResponsavel);
			}
			if (!telefoneResidencialMae.isEmpty()) {
				objAluno.setTelefoneResidencialMae(telefoneResidencialMae);
			}
			if (!telefoneResidencialPai.isEmpty()) {
				objAluno.setTelefoneResidencialPai(telefoneResidencialPai);
			}
			if (!telefoneResidencialResponsavel.isEmpty()) {
				objAluno.setTelefoneResidencialResponsavel(telefoneResidencialResponsavel);
			}
			if (!necessidadeEspecial.isEmpty()) {
				objAluno.setNecessidadeEspecial(necessidadeEspecial);
			}
			if (!uf.isEmpty()) {
				objAluno.setUf(uf);
			}
			if (!ufMae.isEmpty()) {
				objAluno.setUfMae(ufMae);
			}
			if (!ufPai.isEmpty()) {
				objAluno.setUfPai(ufPai);
			}
			if (!ufResponsavel.isEmpty()) {
				objAluno.setUfResponsavel(ufResponsavel);
			}
			// objAluno.setFotoAluno(fotoAluno);
			if (!sexo.isEmpty()) {
				objAluno.setSexo(sexo);
			}
			if (!ativo.isEmpty()) {
				objAluno.setAtivo(ativo);
			}
			if (!numeroEol.isEmpty()) {
				objAluno.setNumeroEol(numeroEol);
			}
			if (!numeroRA.isEmpty()) {
				objAluno.setNumeroRA(numeroRA);
			}
			if (!email.isEmpty()) {
				objAluno.setEmail(email);
			}
			if (!celular.isEmpty()) {
				objAluno.setCelular(celular);
			}
			if (!cpf.isEmpty()) {
				objAluno.setCpf(cpf);
			}
			if (!observacao.isEmpty()) {
				objAluno.setObservacao(observacao);
			}
			if (!parentescoResponsavel.isEmpty()) {
				objAluno.setParentescoResponsavel(parentescoResponsavel);
			}
			if (!enecessidadeEspecial.isEmpty()) {
				objAluno.setENecessidadeEspecial(enecessidadeEspecial);
			}
			if (!eresponsavelLegalMae.isEmpty()) {
				objAluno.setEResponsavelLegalMae(eresponsavelLegalMae);
			}
			if (!eresponsavelLegalPai.isEmpty()) {
				objAluno.setEResponsavelLegalPai(eresponsavelLegalPai);
			}
			if (!eresponsavelLegalResponsavel.isEmpty()) {
				objAluno.setEResponsavelLegalResponsavel(eresponsavelLegalResponsavel);
			}

			resultado = new AlunoService().criarAluno(objAluno);

		} else if (action.equals("update")) {

			int id = Integer.parseInt(strid);
			List<Aluno> rsAluno;
			rsAluno = new AlunoService().listarkey(id);
			objAluno = rsAluno.get(0);

			if (!bairro.isEmpty()) {
				objAluno.setBairro(bairro);
			}

			if (!cep.isEmpty()) {
				objAluno.setCep(cep);
			}
			if (!cepMae.isEmpty()) {
				objAluno.setCepMae(cepMae);
			}
			if (!cepPai.isEmpty()) {
				objAluno.setCepPai(cepPai);
			}
			if (!cepResponsavel.isEmpty()) {
				objAluno.setCepResponsavel(cepResponsavel);
			}
			if (!cidade.isEmpty()) {
				objAluno.setCidade(cidade);
			}
			if (!cidadeMae.isEmpty()) {
				objAluno.setCidadeMae(cidadeMae);
			}
			if (!cidadePai.isEmpty()) {
				objAluno.setCidadePai(cidadePai);
			}
			if (!cidadeResponsavel.isEmpty()) {
				objAluno.setCidadeResponsavel(cidadeResponsavel);
			}
			if (!complemento.isEmpty()) {
				objAluno.setComplemento(complemento);
			}
			if (!complementoMae.isEmpty()) {
				objAluno.setComplementoMae(complementoMae);
			}
			if (!complementoPai.isEmpty()) {
				objAluno.setComplementoPai(complementoPai);
			}
			if (!complementoResponsavel.isEmpty()) {
				objAluno.setComplementoResponsavel(complementoResponsavel);
			}
			if (!dataMatricula.isEmpty()) {
				objAluno.setDataMatricula(stringUtil
						.converteStringData(dataMatricula));
			}
			if (!dataNascimento.isEmpty()) {
				objAluno.setDataNascimento(stringUtil
						.converteStringData(dataNascimento));
			}
			if (!email1Mae.isEmpty()) {
				objAluno.setEmail1Mae(email1Mae);
			}
			if (!email1Pai.isEmpty()) {
				objAluno.setEmail1Pai(email1Pai);
			}
			if (!email1Responsavel.isEmpty()) {
				objAluno.setEmail1Responsavel(email1Responsavel);
			}
			if (!email2Mae.isEmpty()) {
				objAluno.setEmail2Mae(email2Mae);
			}
			if (!email2Pai.isEmpty()) {
				objAluno.setEmail2Pai(email2Pai);
			}
			if (!email2Responsavel.isEmpty()) {
				objAluno.setEmail2Responsavel(email2Responsavel);
			}
			if (!endereco.isEmpty()) {
				objAluno.setEndereco(endereco);
			}
			if (!enderecoMae.isEmpty()) {
				objAluno.setEnderecoMae(enderecoMae);
			}
			if (!enderecoPai.isEmpty()) {
				objAluno.setEnderecoPai(enderecoPai);
			}
			if (!enderecoResponsavel.isEmpty()) {
				objAluno.setEnderecoResponsavel(enderecoResponsavel);
			}
			if (!etnia.isEmpty()) {
				objAluno.setEtnia(etnia);
			}
			if (!naturalCidade.isEmpty()) {
				objAluno.setNaturalCidade(naturalCidade);
			}
			if (!naturalEstado.isEmpty()) {
				objAluno.setNaturalEstado(naturalEstado);
			}
			if (!naturalPais.isEmpty()) {
				objAluno.setNaturalPais(naturalPais);
			}
			if (!nome.isEmpty()) {
				objAluno.setNome(nome);
			}
			if (!nomeMae.isEmpty()) {
				objAluno.setNomeMae(nomeMae);
			}
			if (!nomePai.isEmpty()) {
				objAluno.setNomePai(nomePai);
			}
			if (!nomeResponsavel.isEmpty()) {
				objAluno.setNomeResponsavel(nomeResponsavel);
			}
			if (!numero.isEmpty()) {
				objAluno.setNumero(numero);
			}
			if (!numeroMae.isEmpty()) {
				objAluno.setNumeroMae(numeroMae);
			}
			if (!numeroPai.isEmpty()) {
				objAluno.setNumeroPai(numeroPai);
			}
			if (!numeroResponsavel.isEmpty()) {
				objAluno.setNumeroResponsavel(numeroResponsavel);
			}
			if (!pais.isEmpty()) {
				objAluno.setPais(pais);
			}
			if (!responsaveisResponsavel.isEmpty()) {
				objAluno.setResponsaveisResponsavel(responsaveisResponsavel);
			}
			if (!rg.isEmpty()) {
				objAluno.setRg(rg);
			}
			if (!telefoneCelularMae.isEmpty()) {
				objAluno.setTelefoneCelularMae(telefoneCelularMae);
			}
			if (!telefoneCelularPai.isEmpty()) {
				objAluno.setTelefoneCelularPai(telefoneCelularPai);
			}
			if (!telefoneCelularResponsavel.isEmpty()) {
				objAluno.setTelefoneCelularResponsavel(telefoneCelularResponsavel);
			}
			if (!telefoneComercialMae.isEmpty()) {
				objAluno.setTelefoneComercialMae(telefoneComercialMae);
			}
			if (!telefoneComercialPai.isEmpty()) {
				objAluno.setTelefoneComercialPai(telefoneComercialPai);
			}
			if (!telefoneComercialResponsavel.isEmpty()) {
				objAluno.setTelefoneComercialResponsavel(telefoneComercialResponsavel);
			}
			if (!telefoneResidencialMae.isEmpty()) {
				objAluno.setTelefoneResidencialMae(telefoneResidencialMae);
			}
			if (!telefoneResidencialPai.isEmpty()) {
				objAluno.setTelefoneResidencialPai(telefoneResidencialPai);
			}
			if (!telefoneResidencialResponsavel.isEmpty()) {
				objAluno.setTelefoneResidencialResponsavel(telefoneResidencialResponsavel);
			}
			if (!necessidadeEspecial.isEmpty()) {
				objAluno.setNecessidadeEspecial(necessidadeEspecial);
			}
			if (!uf.isEmpty()) {
				objAluno.setUf(uf);
			}
			if (!ufMae.isEmpty()) {
				objAluno.setUfMae(ufMae);
			}
			if (!ufPai.isEmpty()) {
				objAluno.setUfPai(ufPai);
			}
			if (!ufResponsavel.isEmpty()) {
				objAluno.setUfResponsavel(ufResponsavel);
			}
			// objAluno.setFotoAluno(fotoAluno);
			if (!sexo.isEmpty()) {
				objAluno.setSexo(sexo);
			}
			if (!ativo.isEmpty()) {
				objAluno.setAtivo(ativo);
			}
			if (!numeroEol.isEmpty()) {
				objAluno.setNumeroEol(numeroEol);
			}
			if (!numeroRA.isEmpty()) {
				objAluno.setNumeroRA(numeroRA);
			}
			if (!email.isEmpty()) {
				objAluno.setEmail(email);
			}
			if (!celular.isEmpty()) {
				objAluno.setCelular(celular);
			}
			if (!cpf.isEmpty()) {
				objAluno.setCpf(cpf);
			}
			if (!observacao.isEmpty()) {
				objAluno.setObservacao(observacao);
			}
			if (!parentescoResponsavel.isEmpty()) {
				objAluno.setParentescoResponsavel(parentescoResponsavel);
			}
			if (!enecessidadeEspecial.isEmpty()) {
				objAluno.setENecessidadeEspecial(enecessidadeEspecial);
			}
			if (!eresponsavelLegalMae.isEmpty()) {
				objAluno.setEResponsavelLegalMae(eresponsavelLegalMae);
			}
			if (!eresponsavelLegalPai.isEmpty()) {
				objAluno.setEResponsavelLegalPai(eresponsavelLegalPai);
			}
			if (!eresponsavelLegalResponsavel.isEmpty()) {
				objAluno.setEResponsavelLegalResponsavel(eresponsavelLegalResponsavel);
			}

			resultado = new AlunoService().atualizarAluno(objAluno);

		} else {
			return "0";
		}
		return Integer.toString(resultado.getIdAluno());

	}

	/**
	 * Serviço reponsavel por Remover Aluno.
	 * 
	 * @param id
	 *            identificador de controle interno da aplicação
	 * @return string retorna Deletado.
	 */
	@Path("{id}")
	@DELETE
	@Produces("text/plain")
	public String removeAluno(@PathParam("id") int id) {

		logger.debug("Remover Aluno " + id);

		List<Aluno> resultado;
		resultado = new AlunoService().listarkey(id);
		Aluno aluno = resultado.get(0);

		new AlunoService().deletarAluno(aluno);

		return "Deletado";

	}

}
