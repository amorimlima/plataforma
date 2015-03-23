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

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.log4j.Logger;

import br.com.muranodesign.business.PlanoEstudoService;
import br.com.muranodesign.business.RegistroDiarioService;
import br.com.muranodesign.model.PlanoEstudo;
import br.com.muranodesign.model.RegistroDiario;




/**
 * Classe tem como objetivo disponibilizar os serviços relacionandos ao registro diario
 *
 * @author Rogerio Lima dos Santos
 * @version 1.00
 * @since Release 1 da aplicação
 */
@Path("RegistroDiario")
public class RegistroDiarioResource {

	/** The logger. */
	private Logger logger = Logger.getLogger(RegistroDiarioResource.class.getName());
	
	/**
	 * Gets the registro diario.
	 *
	 * @return the registro diario
	 */
	@GET
	//@Produces("text/xml")
	@Produces("application/json")
	public List<RegistroDiario> getRegistroDiario() {
		logger.debug("Listar RegistroDiario ...");
		List<RegistroDiario> resultado;
		 resultado = new RegistroDiarioService().listarTodos();
		 logger.debug("QTD RegistroDiario : " +  resultado.size());
		return resultado;
	}

	/**
	 * Gets the registro diario.
	 *
	 * @param id the id
	 * @return the registro diario
	 */
	@Path("{id}")
	@GET
	//@Produces("text/xml")
	@Produces("application/json")
	public RegistroDiario getRegistroDiario(@PathParam("id") int id) {
		
		logger.debug("Lista Evento  por id " + id );
		 List<RegistroDiario> resultado;
		 resultado = new RegistroDiarioService().listarkey(id);
		 RegistroDiario RegistroDiario = resultado.get(0);
		 
		return RegistroDiario;
		
	}

  
	/**
	 * Removes the registro diario.
	 *
	 * @param id the id
	 * @return the string
	 */
	@Path("{id}")
	@DELETE
	@Produces("text/plain")
	public String removeRegistroDiario(@PathParam("id") int id) {
		
		logger.debug("Remover RegistroDiario " + id );
		
		List<RegistroDiario> resultado;
		 resultado = new RegistroDiarioService().listarkey(id);
		 RegistroDiario RegistroDiario = resultado.get(0);

		new RegistroDiarioService().deletarRegistroDiario(RegistroDiario);

		return "Deletado";

	}
	
	
	/**
	 * Registro diario action.
	 *
	 * @param action the action
	 * @param strid the strid
	 * @param data the data
	 * @param registro the registro
	 * @param planoEstudo the plano estudo
	 * @return the string
	 */
	@POST
	@Produces("text/plain")
	public String RegistroDiarioAction(
			
			@FormParam("action") String action,
			@FormParam("id") String strid,
			@FormParam("data") String data,
			@FormParam("registro") String registro,
			@FormParam("planoEstudo") String planoEstudo 
		
			
			) {
		RegistroDiario objRegistroDiario;
		RegistroDiario resultado;
		Date dataConvertido = null;
		
		//TODO: Ajustar o tratamento de erro
		DateFormat formatter = new SimpleDateFormat("yy-MM-dd");
		try {
			dataConvertido = (Date) formatter.parse(data);
			
		} catch (ParseException e) {
			e.printStackTrace();
			
		}
		
		objRegistroDiario = new RegistroDiario();
		
			
		
		// get tipo evento
		List<PlanoEstudo> rsPlanoEstudo;
		rsPlanoEstudo= new PlanoEstudoService().listarkey(Integer.parseInt(planoEstudo));
		PlanoEstudo objPlanoEstudo = rsPlanoEstudo.get(0);
		//TODO: Validar valores.
		
		
		
	
		if (action.equals("create")) {
			logger.info("Criando no  evento");
			objRegistroDiario.setData(dataConvertido);
			objRegistroDiario.setRegistro(registro);
			objRegistroDiario.setPlanoEstudo(objPlanoEstudo);
		
			
			
			resultado = new RegistroDiarioService().criarRegistroDiario(objRegistroDiario);
		}else if (action.equals("update")) {
			int id=Integer.parseInt(strid);
			
			
			
			
			List<RegistroDiario> rsRegistroDiario;
			rsRegistroDiario= new RegistroDiarioService().listarkey(id);
			objRegistroDiario = rsRegistroDiario.get(0);
			objRegistroDiario.setData(dataConvertido);
			objRegistroDiario.setRegistro(registro);
			objRegistroDiario.setPlanoEstudo(objPlanoEstudo);
		
			
			//objEventoEdit = objEvento;
			
			resultado = new RegistroDiarioService().atualizarRegistroDiario(objRegistroDiario);
			
		} else {
			
			logger.info("Erro na URI  " + action);
			return "0";
			
		}
		
		return Integer.toString(resultado.getIdregistroDiario());

	}
	
	
}
