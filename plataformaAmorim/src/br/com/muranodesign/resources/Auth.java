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

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
 

/**
 * Classe tem como objetivo simular autenticação com usuario e senha
 *
 * @author Rogerio Lima dos Santos
 * @version 1.00
 * @since Release 1 da aplicação
 */
@Path("/auth")
public class Auth {
 
    /**
     * Devolve uma resposta em texto com o resultado da autenticação.
     * @param user String com o usuario
     * @param pass String com a senha
     * @return String com a resposta texto
     */
    @POST
    @Produces("text/plain")
  
    public String authText(@FormParam("userName") String user, @FormParam("password") String pass){
        System.out.println("authText");
        System.out.println("userName : " + user);
        System.out.println("password : " + pass);
    	return String.format("%d", session(user, pass));
    }
 
    /**
     * Devolve uma resposta em XML com o resultado da autenticação.
     *
     * @param user String com o usuario
     * @param pass String com a senha
     * @return String com a resposta em XML
     */
    @POST
    @Produces("text/xml")
    public String authXML(@FormParam("user") String user, @FormParam("pass") String pass){
    	System.out.println("authXML");
        return String.format("<?xml version=\"1.0\" encoding=\"UTF-8\"?><auth username=\"%s\">%d</auth>", user, session(user, pass));
    }
 
    /**
     * Caso o user seja igual à pass a autenticação é feita
     * com sucesso.
     *
     * @param user String com o usuario
     * @param pass String com a senha
     * @return -1 se a auth falha com long caso contrario
     */
    private long session(String user, String pass){
    	System.out.println("session");
        System.out.println(user);
        System.out.println(pass);
        if(user.equals(pass)){
            return System.nanoTime();
        }
        return -1;
    }
}