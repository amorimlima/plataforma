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

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.apache.log4j.Logger;

import br.com.muranodesign.business.UsuarioService;
import br.com.muranodesign.model.Usuario;



/**
 * Classe tem como objetivo de validar usuario e senha na tela de login
 *
 * @author Rogerio Lima dos Santos
 * @version 1.00
 * @since Release 1 da aplicação
 */

@Path("Logar")
public class LoginResource {
	
	/** The logger. */
	private Logger logger = Logger.getLogger(LoginResource.class.getName());
	
	/**
	 * Metodo que realiza a atenticação na aplicação.
	 *
	 * @param usuario - Usuario
	 * @param senha - senha
	 * @return String - Usuario
	 */
	@POST
	@Produces("application/json")
	public Usuario doLogar(@FormParam("usuario") String usuario,
			@FormParam("senha") String senha) {
		Usuario ret = null;
		logger.info("Logar Usuario ..." + usuario);
		
		List<Usuario> resultado;
		resultado = new UsuarioService().listarLogin(usuario);
		MessageDigest m;
		try {
			m = MessageDigest.getInstance("MD5");
			m.update(senha.getBytes(),0,senha.length());
			//System.out.println("MD5: "+new BigInteger(1,m.digest()).toString(16));
			String senhaMD5 = new BigInteger(1,m.digest()).toString(16);
			
			for (Usuario user : resultado) {
				//System.out.println("user.getSenha(): " + user.getSenha());
				//System.out.println("senhaMD5: " + senhaMD5);
				if (user.getSenha().equals(senhaMD5)){
					ret = user;
					logger.info("Usuario " + usuario + " liberado para acessa a aplicação");
					//logger.info("Perfil " + perfil);
				
				}

			}

		} catch (NoSuchAlgorithmException e) {
			logger.info("Erro ao realizar login");
		}
		
		
		return ret ;
	}

}
