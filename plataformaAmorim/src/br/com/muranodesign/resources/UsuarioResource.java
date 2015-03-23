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

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.UUID;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.commons.mail.EmailException;
import org.apache.log4j.Logger;

import br.com.muranodesign.business.AlunoService;
import br.com.muranodesign.business.PerfilService;
import br.com.muranodesign.business.ProfessorFuncionarioService;
import br.com.muranodesign.business.UsuarioService;
import br.com.muranodesign.model.Aluno;
import br.com.muranodesign.model.Perfil;
import br.com.muranodesign.model.ProfessorFuncionario;
import br.com.muranodesign.model.Usuario;
import br.com.muranodesign.util.CommonsMail;


/**
 * Classe tem como objetivo disponibilizar os serviços relacionandos usuario
 *
 * @author Rogerio Lima dos Santos
 * @version 1.00
 * @since Release 1 da aplicação
 */
@Path("Usuario")
public class UsuarioResource {

	/** The logger. */
	private Logger logger = Logger.getLogger(UsuarioResource.class.getName());

	/**
	 * Gets the usuario.
	 *
	 * @return the usuario
	 */
	@GET
	@Produces("application/json")
	public List<Usuario> getUsuario() {
		logger.info("Listar Usuario ...");
		List<Usuario> resultado;
		resultado = new UsuarioService().listarTodos();
		logger.info("QTD Usuario : " + resultado.size());
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
	public Usuario getEvento(@PathParam("id") int id) {
		logger.info("Lista Usuario  por id " + id);
		List<Usuario> resultado;
		resultado = new UsuarioService().listarkey(id);
		Usuario evento = resultado.get(0);

		return evento;

	}
	
	@Path("aluno/{id}")
	@GET
	@Produces("application/json")
	public Usuario getAluno(@PathParam("id") int id) {
		logger.info("Lista Usuario  por id " + id);
		List<Usuario> resultado;
		resultado = new UsuarioService().listaAluno(id);
		Usuario evento = resultado.get(0);

		return evento;

	}
	
	@Path("recuperarSenha/{email}")
	@GET
	@Produces("application/json")
	public Usuario getNovoSenha(@PathParam("email") String email) {
		logger.info("Lista Usuario  por id " + email);
		List<Usuario> resultado;
		
		
		resultado = new UsuarioService().listaAlunoEmail(email);
		Usuario resultado2 = null;
		
		UUID uuid = UUID.randomUUID();    
		String myRandom = uuid.toString();    
		String novaSenha = (myRandom.substring(0,6));
		Usuario usuario = resultado.get(0);
		
		String senhaMD5 = null;
		MessageDigest m;
		try {
		m = MessageDigest.getInstance("MD5");
	
		m.update(novaSenha.getBytes(),0,novaSenha.length());
		//System.out.println("MD5: "+new BigInteger(1,m.digest()).toString(16));
		senhaMD5 = new BigInteger(1,m.digest()).toString(16);
		CommonsMail commonsMail = new CommonsMail();
		commonsMail.enviaEmailSimples(usuario.getEmail(), novaSenha);
		usuario.setSenha(senhaMD5);
		resultado2 = new UsuarioService().atualizarUsuario(usuario);
		
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return resultado2;

	}
	
	
	
	/**
	 * Removes the usuario.
	 *
	 * @param action the action
	 * @param id the id
	 * @return the string
	 */
	@Path("{action}/{id}")
	@Produces("text/plain")
	public String removeUsuario(@PathParam("action") String action,
			@PathParam("id") int id) {

		logger.info("Usuario  " + action);
		if ( action.equals("delete")) {
			List<Usuario> resultado;
			resultado = new UsuarioService().listarkey(id);
			Usuario res = resultado.get(0);
			new UsuarioService().deletarUsuario(res);
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
	 * @param login the login
	 * @param senha the senha
	 * @param email the email
	 * @param perfil the perfil
	 * @param aluno the aluno
	 * @param professor the professor
	 * @param moderador the moderador
	 * @return the string
	 */
	@POST
	@Produces("text/plain")
	public String eventoAction(
			
			@FormParam("action") String action,
			@FormParam("id") String strid,
			
			@FormParam("login") String login,
			@FormParam("senha") String senha,
			@FormParam("email") String email,
			@FormParam("perfil") String perfil,
			@FormParam("perfil3") String perfil3,
			@FormParam("perfil2") String perfil2,
			@FormParam("aluno") String aluno,
			@FormParam("professor") String professor,
			@FormParam("moderador") String moderador
			) {
		Usuario objUsuario = new Usuario();
		logger.info("eventoAction ...");
		Usuario  resultado;
		
		// get tipo aluno
		
		Aluno objAluno = null;	
		if (!aluno.isEmpty()){
				List<Aluno> rsAluno;
				rsAluno = new AlunoService().listarkey(Integer.parseInt(aluno));
				objAluno = rsAluno.get(0);
			}
				//TODO: Validar valores.
				
			ProfessorFuncionario objProfessorFuncionario = null	;
			if (!professor.isEmpty()){
				// get tipo Professor
				List<ProfessorFuncionario> rsProfessorFuncionario;
				rsProfessorFuncionario = new ProfessorFuncionarioService().listarkey(Integer.parseInt(professor));
				 objProfessorFuncionario= rsProfessorFuncionario.get(0);
				//TODO: Validar valores.
				}
				
				// get tipo Professor
				List<Perfil> rsPerfil;
				rsPerfil = new PerfilService().listarkey(Integer.parseInt(perfil));
				Perfil objPerfil= rsPerfil.get(0);
				
				
				Perfil objPerfil3 = null;
				if (!perfil3.isEmpty()) {
				// get tipo Professor
				List<Perfil> rsPerfil3;
				rsPerfil3 = new PerfilService().listarkey(Integer.parseInt(perfil3));
				objPerfil3= rsPerfil3.get(0);
				}
				
				Perfil objPerfil2 = null;
				if (!perfil2.isEmpty()) {
				// get tipo Professor
				List<Perfil> rsPerfil2;
				rsPerfil2 = new PerfilService().listarkey(Integer.parseInt(perfil2));
				 objPerfil2= rsPerfil2.get(0);
				}
				
				
				
				String senhaMD5 = null;
				if (!senha.isEmpty()) {
				MessageDigest m;
					try {
						m = MessageDigest.getInstance("MD5");
						m.update(senha.getBytes(),0,senha.length());
						//System.out.println("MD5: "+new BigInteger(1,m.digest()).toString(16));
						 senhaMD5 = new BigInteger(1,m.digest()).toString(16);
						
					} catch (NoSuchAlgorithmException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				
				if (action.equals("create")) {
					logger.info("Criando no  Plano de Estudos");
					
					objUsuario.setLogin(login);
					objUsuario.setSenha(senhaMD5);
					objUsuario.setEmail(email);
					objUsuario.setPerfil(objPerfil);
					objUsuario.setPerfil3(objPerfil3);
					objUsuario.setPerfil2(objPerfil2);
					objUsuario.setAluno(objAluno);
					objUsuario.setProfessor(objProfessorFuncionario);
					objUsuario.setModerador(moderador);
					
					resultado = new UsuarioService().criarUsuario(objUsuario);
					
					
				} else if (action.equals("update")) {
					int id=Integer.parseInt(strid);
					List<Usuario> rsUsuario;
					rsUsuario = new UsuarioService().listarkey(id);
					objUsuario = rsUsuario.get(0);
					objUsuario.setIdusuario(id);
					objUsuario.setLogin(login);
					if (!senha.isEmpty()) {
						objUsuario.setSenha(senhaMD5);
					}
					objUsuario.setEmail(email);
					objUsuario.setPerfil(objPerfil);
					objUsuario.setPerfil3(objPerfil3);
					objUsuario.setPerfil2(objPerfil2);
					objUsuario.setAluno(objAluno);
					objUsuario.setProfessor(objProfessorFuncionario);
					objUsuario.setModerador(moderador);
					
					resultado = new UsuarioService().atualizarUsuario(objUsuario);
					
					
					
					
				}else {
					logger.info("Erro na URI  " + action);
					return "0";
				}
				
		
		
				return Integer.toString(resultado.getIdusuario());
		
		
	}
	
	
	

}
