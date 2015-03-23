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

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.muranodesign.business.NativeQueryService;
import br.com.muranodesign.model.report.ReportStatusPlanoEstudos;

/**
 * Classe tem como objetivo disponibilizar os serviços que utilizam query nativa em sua repostar
 * 
 * @author Rogerio Lima dos Santos
 * @version 1.00
 * @since Release 1 da aplicação
 */
@Path("relatorio")
public class ReportEspeciais {
	
	
	@Path("statusPlanoestudos/{id}")
	@GET
	@Produces("application/json")
	public List<ReportStatusPlanoEstudos> getReportStatusPlanoEstudos(@PathParam("id") int id){
		
		List<ReportStatusPlanoEstudos> listReportStatusPlanoEstudos = new ArrayList<ReportStatusPlanoEstudos>();
		String QUERY = " select idplanejamento_roteiro, objetivo, status, plano_estudo,alungrupTut.id_aluno, grupo, "
				+ "tutoria from planejamento_roteiro join ((Select id_aluno, grupo, tutoria from grupo join "
				+ "((SELECT id_aluno, grupo FROM `aluno_variavel` join `aluno` on (aluno = id_aluno)) as alunGrup) on"
				+ " (grupo = idgrupo) where tutoria = " + id +" ) as alungrupTut) on (alungrupTut.id_aluno = planejamento_roteiro.id_aluno)";
		List<Object[]> entities_percent ;
		
		//System.out.println("query:" +  QUERY);
		entities_percent = new NativeQueryService().listar(QUERY);
		//System.out.println(entities_percent.isEmpty());
		   for (Object[] entity : entities_percent) {
			  
			   ReportStatusPlanoEstudos reportStatusPlanoEstudos = new ReportStatusPlanoEstudos();
			   
			   reportStatusPlanoEstudos.setIdPlanejamentoRoteiro(Integer.parseInt(entity[0].toString()));
			   reportStatusPlanoEstudos.setObjetivo(entity[1].toString());
			   reportStatusPlanoEstudos.setStatus(entity[2].toString());
			   reportStatusPlanoEstudos.setPlanoEstudo(entity[3].toString());
			   reportStatusPlanoEstudos.setIdAluno(entity[4].toString());
			   reportStatusPlanoEstudos.setGrupo(entity[5].toString());
			   reportStatusPlanoEstudos.setTutoria(entity[6].toString());
			   
			  
			   listReportStatusPlanoEstudos.add(reportStatusPlanoEstudos);
		   }
		return listReportStatusPlanoEstudos;
		
	}
	
	@Path("existAlunoVariavelGrupo/{id}")
	@GET
	@Produces("text/plain")
	public String getExistAlunoVariavelGrupo(@PathParam("id") int id){
		
		List<ReportStatusPlanoEstudos> listReportStatusPlanoEstudos = new ArrayList<ReportStatusPlanoEstudos>();
		String QUERY = " select * from aluno_variavel where ativo = 1 and  "
				+ " grupo in (select idgrupo from grupo where grupo.tutoria in "
				+ " ( SELECT idtutoria FROM `tutoria` WHERE tutoria.tutor = "+ id + " ))";
		List<Object[]> entities ;
		
		System.out.println("query:" +  QUERY);
		entities = new NativeQueryService().listar(QUERY);
		
		String retorno = "0";
		if (entities.isEmpty()) {
			retorno = "0";
		}else {
			retorno = "1";
		}
		
		
		return
				retorno;
		
	}

}
