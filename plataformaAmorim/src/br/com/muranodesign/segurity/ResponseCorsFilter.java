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

import org.apache.log4j.Logger;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseFilter;
 
// TODO: Auto-generated Javadoc
/**
 * A Classe ResponseCorsFilter é utilizada para definir niveis de acesso diretos a aplicação.
 */
public class ResponseCorsFilter implements ContainerResponseFilter {
	
	
	/** The logger. */
	private Logger logger = Logger.getLogger(ResponseCorsFilter.class.getName());
	
 
    
    /* (non-Javadoc)
     * @see com.sun.jersey.spi.container.ContainerResponseFilter#filter(com.sun.jersey.spi.container.ContainerRequest, com.sun.jersey.spi.container.ContainerResponse)
     */
    @Override
    public ContainerResponse filter(ContainerRequest creq, ContainerResponse cres) {
    	
    	
    	logger.info("Validando permisão e acesso ..");
    	
    	//cres.getHttpHeaders().remove("Access-Control-Allow-Origin");
       
    	
    	cres.getHttpHeaders().add("Access-Control-Allow-Origin", "*");
        cres.getHttpHeaders().add("Access-Control-Allow-Headers", "origin, content-type, accept, authorization");
        cres.getHttpHeaders().add("Access-Control-Allow-Credentials", "true");
        cres.getHttpHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
        cres.getHttpHeaders().add("Access-Control-Max-Age", "1209600");
    	
  
        
        return cres;
    }

 
}