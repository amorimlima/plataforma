/**
 *   Este codigo é software livre você e pode resdistribuir e/ou modificar ele seguindo os termos da
 *   Creative Commons Attribution 4.0 International Pare visualizar uma copia desta 
 *   licensa em ingles visite http://creativecommons.org/licenses/by/4.0/.
 *   
 *   This code is free software; you can redistribute it and/or modify it
 *   under the terms of Creative Commons Attribution 4.0 International License. 
 *   To view a copy of this license, visit http://creativecommons.org/licenses/by/4.0/.
 */
package br.com.muranodesign.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
 

/**
 * Classe utilitaria auxiliar na criptografia MD5.
 *
 * @author Rogerio Lima dos Santos
 * @version 1.00
 * @since Release 1 da aplicação
 */
public class JavaMD5Hash {
 

     
    /**
     * Md5.
     *
     * @param  String a ser criptografada
     * @return String criptografada
     */
    public static String md5(String input) {
         
        String md5 = null;
         
        if(null == input) return null;
         
        try {
             

        MessageDigest digest = MessageDigest.getInstance("MD5");
         
  
        digest.update(input.getBytes(), 0, input.length());
 
    
        md5 = new BigInteger(1, digest.digest()).toString(16);
 
        } catch (NoSuchAlgorithmException e) {
 
            e.printStackTrace();
        }
        return md5;
    }
}