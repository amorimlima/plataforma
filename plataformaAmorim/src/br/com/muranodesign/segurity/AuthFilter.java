/**
 *   Este codigo é software livre você e pode resdistribuir e/ou modificar ele seguindo os termos da
 *   Creative Commons Attribution 4.0 International Pare visualizar uma copia desta 
 *   licensa em ingles visite http://creativecommons.org/licenses/by/4.0/.
 *   
 *   This code is free software; you can redistribute it and/or modify it
 *   under the terms of Creative Commons Attribution 4.0 International License. 
 *   To view a copy of this license, visit http://creativecommons.org/licenses/by/4.0/.
 */
package br.com.muranodesign.segurity;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;

import br.com.muranodesign.business.UsuarioService;
import br.com.muranodesign.model.Acoes;
import br.com.muranodesign.model.Usuario;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;

public class AuthFilter implements ContainerRequestFilter {
	
	
	private Logger logger = Logger.getLogger(AuthFilter.class.getName());
    /**
     * Aplica filtro : Verifica a solicitação e valida do usuario , Acesso e autorização
     * @param containerRequest The request from Tomcat server
     */
    @Override
    public ContainerRequest filter(ContainerRequest containerRequest) throws WebApplicationException {
        //GET, POST, PUT, DELETE, ...
        String method = containerRequest.getMethod();
        // myresource/get/56bCA for example
        String path = containerRequest.getPath(true);
        
        logger.info("path: " + path);
       
 
        //We do allow wadl to be retrieve
        //if (method.equals("GET") && (path.equals("Logar") || path.equals("application.wadl/xsd0.xsd"))) {
        if (method.equals("GET") && (path.equals("Logar"))) {
        	logger.debug("Permitindo acesso a este path sem usuario e senha");
            return containerRequest;
        }
        
        logger.debug("Proximo nivel de validacao");
 
        //Get the authentification passed in HTTP headers parameters
        String auth = containerRequest.getHeaderValue("Authorization");
 
        //If the user does not have the right (does not provide any HTTP Basic Auth)
        if(auth == null){
        	logger.debug("Cabecario Vazio");
            throw new WebApplicationException(Status.UNAUTHORIZED);
        }
 
        //lap : loginAndPassword
        String[] lap = BasicAuth.decode(auth);
 
        logger.debug("lap : " + lap);
        //If login or password fail
        if(lap == null || lap.length != 2){
            throw new WebApplicationException(Status.UNAUTHORIZED);
        }
 
        //TODO: Consutar usuario e senha
        //User authentificationResult =  AuthentificationThirdParty.authentification(lap[0], lap[1]);
        
        logger.debug("lap[0] : " + lap[0]); 
        logger.debug("lap[1] : " + lap[1]); 
        
        String authentificationResult = "nok";
        List<Usuario> resultado;
		resultado = new UsuarioService().listarLogin(lap[0]);
		
		
		MessageDigest m;
		try {
			m = MessageDigest.getInstance("MD5");
			m.update(lap[1].getBytes(),0,lap[1].length());
			//System.out.println("MD5: "+new BigInteger(1,m.digest()).toString(16));
			String senhaMD5 = new BigInteger(1,m.digest()).toString(16);
			
			for (Usuario user : resultado) {
				
				
				
				if (user.getSenha().equals(senhaMD5)){
					//ret = user;
					 authentificationResult = "tmp";
					
					for (Acoes acoes :  user.getPerfil().getAcoesCollection() ) {
						logger.debug("Acoes permitidas " + acoes.getServico());
						
						// Verifica se tem um path Cadastro 
						if (acoes.getServico().equals(path)){
							
							// Compara com get 
							if (method.equals("GET") && acoes.getListar() == 1 ) {
								 authentificationResult = "ok";
								 logger.debug("GET - Usuario " + lap[0] + " liberado para acessa a aplicação");
								 
								// Compara com post  
							} else if ( method.equals("POST") && acoes.getCriar() == 1 ){
								 logger.debug("POST - Usuario " + lap[0] + " liberado para acessa a aplicação");
								 authentificationResult = "ok";
								 
								// Compara com delete  
							} else if (method.equals("DELETE")  && acoes.getDeletar() == 1) {
								 logger.debug("DELETE - Usuario " + lap[0] + " liberado para acessa a aplicação");
								 authentificationResult = "ok";
								 
							 }
							 
						}	
					}
					
					
					
					//logger.info("Perfil " + perfil);
					
				
				}

			}

		} catch (NoSuchAlgorithmException e) {
			logger.info("Erro ao realizar login");
			throw new WebApplicationException(Status.UNAUTHORIZED);
		}
        if(authentificationResult.equals("nok")){
        	logger.info("Usuario ou senha invalido ");
            throw new WebApplicationException(Status.UNAUTHORIZED);
        }else if (authentificationResult.equals("tmp")){
        	logger.info("Erro de permissao ");
            throw new WebApplicationException(Status.UNAUTHORIZED);
        	
        }
        

 
        return containerRequest;
    }
}
