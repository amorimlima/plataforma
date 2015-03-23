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

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.apache.log4j.Logger;


/**
 * Classe tem como objetivo realizar opeções com string.
 *
 * @author Rogerio Lima dos Santos
 * @version 1.00
 * @since Release 1 da aplicação
 */


public class StringUtil {
	
	
	private Logger logger = Logger.getLogger(StringUtil.class.getName());
	
	
	/**
	 * Gerar nome aleatorio. 
	 *
	 * @param nome Atual nome do arquivo atual.
	 * @param tamanho Tamanho do nome a ser gerado
	 * @return Novo nome.
	 */
	public String geraNomeAleatorio(String nomeAtual, int tamanho){
		
		logger.info("Gerando nome Aleatorio");
		
		
		
		String letras = "ABCDEFGHIJKLMNOPQRSTUVYWXZ"; 
		
		String arrNomeAtual [] = nomeAtual.split("\\.");

		
		
		String extencao = arrNomeAtual[arrNomeAtual.length-1];
		  
		Random random = new Random();  
		  
		String stringFinal = "";  
		int index = -1;  
		for( int i = 0; i < tamanho; i++ ) {  
		   index = random.nextInt( letras.length() );  
		   stringFinal += letras.substring( index, index + 1 );  
		} 
		
		logger.info("stringFinal.extencao;" + stringFinal + "." +extencao);
		
		return stringFinal + "." +extencao;
		
	}
	
	/**
	 * Converter String no formato yyyy-mm-dd para data 
	 *
	 * @param data em string
	 * @return data
	 */
	
	public Date converteStringData(String stringData){
		
		Date dataConvertida = null;
		DateFormat formatter = new SimpleDateFormat("yy-MM-dd");
		
		try {
			dataConvertida = (Date) formatter.parse(stringData);
			
		} catch (ParseException e) {
			logger.error("Erro ao converter data");
			e.printStackTrace();
			
		}
		return dataConvertida;
	}

	
	
}
