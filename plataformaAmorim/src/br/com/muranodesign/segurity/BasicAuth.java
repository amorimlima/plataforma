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

import javax.xml.bind.DatatypeConverter;



/**
 * Classe permite decodificar a autenticacao
 *
 * @author Rogerio Lima dos Santos
 * @version 1.00
 * @since Release 1 da aplicação
 */
public class BasicAuth {
    /**
     * Decode the basic auth converte array login/password
     * @param auth String codificada
     * @return senha
     */
    public static String[] decode(String auth) {
     
        auth = auth.replaceFirst("[B|b]asic ", "");
 
       
        byte[] decodedBytes = DatatypeConverter.parseBase64Binary(auth);
 
  
        if(decodedBytes == null || decodedBytes.length == 0){
            return null;
        }
 
        return new String(decodedBytes).split(":", 2);
    }
}
