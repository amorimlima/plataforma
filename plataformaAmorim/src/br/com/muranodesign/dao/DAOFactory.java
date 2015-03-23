/**
 *   Este codigo é software livre você e pode resdistribuir e/ou modificar ele seguindo os termos da
 *   Creative Commons Attribution 4.0 International Pare visualizar uma copia desta 
 *   licensa em ingles visite http://creativecommons.org/licenses/by/4.0/.
 *   
 *   This code is free software; you can redistribute it and/or modify it
 *   under the terms of Creative Commons Attribution 4.0 International License. 
 *   To view a copy of this license, visit http://creativecommons.org/licenses/by/4.0/.
 */
package br.com.muranodesign.dao;

import br.com.muranodesign.dao.impl.AlunoDAOImpl;
import br.com.muranodesign.dao.impl.AlunoVariavelDAOImpl;
import br.com.muranodesign.dao.impl.AnoEstudoDAOImpl;
import br.com.muranodesign.dao.impl.AnoLetivoDAOImpl;
import br.com.muranodesign.dao.impl.AtividadeDAOImpl;
import br.com.muranodesign.dao.impl.AvaliacaoProducaoAlunoDAOImpl;
import br.com.muranodesign.dao.impl.CalendarioDAOImpl;
import br.com.muranodesign.dao.impl.CalendarioEventosDAOImpl;
import br.com.muranodesign.dao.impl.CategoriaProducaoAlunoDAOImpl;
import br.com.muranodesign.dao.impl.ChamadaDAOImpl;
import br.com.muranodesign.dao.impl.ForumQuestaoDAOImpl;
import br.com.muranodesign.dao.impl.ForumRespostaDAOImpl;
import br.com.muranodesign.dao.impl.GrupoDAOImpl;
import br.com.muranodesign.dao.impl.MateriaDAOImpl;
import br.com.muranodesign.dao.impl.MensagensDAOImpl;
import br.com.muranodesign.dao.impl.NativeQueryDAOImpl;
import br.com.muranodesign.dao.impl.ObjetivoDAOImpl;
import br.com.muranodesign.dao.impl.PerfilDAOImpl;
import br.com.muranodesign.dao.impl.PeriodoDAOImpl;
import br.com.muranodesign.dao.impl.PlanejamentoRoteiroDAOImpl;
import br.com.muranodesign.dao.impl.PlanoEstudoDAOImpl;
import br.com.muranodesign.dao.impl.PresencaProfessorDAOImpl;
import br.com.muranodesign.dao.impl.ProducaoAlunoDAOImpl;
import br.com.muranodesign.dao.impl.ProfessorFuncionarioDAOImpl;
import br.com.muranodesign.dao.impl.ProfessorFuncionarioVariavelDAOImpl;
import br.com.muranodesign.dao.impl.RecursoAprendizagemDAOImpl;
import br.com.muranodesign.dao.impl.RegistroDiarioDAOImpl;
import br.com.muranodesign.dao.impl.RelatorioTutoriaDAOImpl;
import br.com.muranodesign.dao.impl.RoteiroDAOImpl;
import br.com.muranodesign.dao.impl.TipoEventoDAOImpl;
import br.com.muranodesign.dao.impl.TipoProducaoAlunoDAOImpl;
import br.com.muranodesign.dao.impl.TipoRecursoAprendizagemDAOImpl;
import br.com.muranodesign.dao.impl.TutoriaDAOImpl;
import br.com.muranodesign.dao.impl.UsuarioDAOImpl;
import br.com.muranodesign.hibernate.HibernatePersistenceContext;
import br.com.muranodesign.hibernate.impl.PersistenceContext;




/**
/**
 * Ponto central para criacaoo de DAOs e contextos de persistencia. <br />
 * Idealmente, esta e a unica classe no sistema que devera conhecer como obter
 * implementacoes concretas destes objetos.
 * 
 *
 * @author Rogerio Lima dos Santos
 * @version 1.00
 * @since Release 1 da aplicação
 */

public class DAOFactory {

	/**
	 * Retorna uma nova instancia do contexto de persistencia.
	 *
	 * @return the persistence context
	 */
	public static PersistenceContext createPersistenceContext() {
		return new HibernatePersistenceContext();
	}

	/**
	 * Gets the aluno dao.
	 *
	 * @param persistenceContext the persistence context
	 * @return the aluno dao
	 */
	public static AlunoDAO getAlunoDAO(PersistenceContext persistenceContext) {
		return new AlunoDAOImpl(
				(HibernatePersistenceContext) persistenceContext);
	}

	/**
	 * Gets the aluno variavel dao.
	 *
	 * @param persistenceContext the persistence context
	 * @return the aluno variavel dao
	 */
	public static AlunoVariavelDAO getAlunoVariavelDAO(
			PersistenceContext persistenceContext) {
		return new AlunoVariavelDAOImpl(
				(HibernatePersistenceContext) persistenceContext);
	}

	/**
	 * Gets the ano estudo dao.
	 *
	 * @param persistenceContext the persistence context
	 * @return the ano estudo dao
	 */
	public static AnoEstudoDAO getAnoEstudoDAO(
			PersistenceContext persistenceContext) {
		return new AnoEstudoDAOImpl(
				(HibernatePersistenceContext) persistenceContext);
	}

	/**
	 * Gets the ano letivo dao.
	 *
	 * @param persistenceContext the persistence context
	 * @return the ano letivo dao
	 */
	public static AnoLetivoDAO getAnoLetivoDAO(
			PersistenceContext persistenceContext) {
		return new AnoLetivoDAOImpl(
				(HibernatePersistenceContext) persistenceContext);
	}

	/**
	 * Gets the atividade dao.
	 *
	 * @param persistenceContext the persistence context
	 * @return the atividade dao
	 */
	public static AtividadeDAO getAtividadeDAO(
			PersistenceContext persistenceContext) {
		return new AtividadeDAOImpl(
				(HibernatePersistenceContext) persistenceContext);
	}

	/**
	 * Gets the avaliacao producao aluno dao.
	 *
	 * @param persistenceContext the persistence context
	 * @return the avaliacao producao aluno dao
	 */
	public static AvaliacaoProducaoAlunoDAO getAvaliacaoProducaoAlunoDAO(
			PersistenceContext persistenceContext) {
		return new AvaliacaoProducaoAlunoDAOImpl(
				(HibernatePersistenceContext) persistenceContext);
	}

	/**
	 * Gets the categoria producao aluno dao.
	 *
	 * @param persistenceContext the persistence context
	 * @return the categoria producao aluno dao
	 */
	public static CategoriaProducaoAlunoDAO getCategoriaProducaoAlunoDAO(
			PersistenceContext persistenceContext) {
		return new CategoriaProducaoAlunoDAOImpl(
				(HibernatePersistenceContext) persistenceContext);
	}

	/**
	 * Gets the chamada dao.
	 *
	 * @param persistenceContext the persistence context
	 * @return the chamada dao
	 */
	public static ChamadaDAO getChamadaDAO(PersistenceContext persistenceContext) {
		return new ChamadaDAOImpl(
				(HibernatePersistenceContext) persistenceContext);
	}


/*
	public static EventosDAO getEventosDAO(PersistenceContext persistenceContext) {
		return new EventosDAOImpl(
				(HibernatePersistenceContext) persistenceContext);
	}
*/
	/**
 * Gets the mensagens dao.
 *
 * @param persistenceContext the persistence context
 * @return the mensagens dao
 */
public static MensagensDAO getMensagensDAO(
			PersistenceContext persistenceContext) {
		return new MensagensDAOImpl(
				(HibernatePersistenceContext) persistenceContext);
	}

	/**
	 * Gets the planejamento roteiro dao.
	 *
	 * @param persistenceContext the persistence context
	 * @return the planejamento roteiro dao
	 */
	public static PlanejamentoRoteiroDAO getPlanejamentoRoteiroDAO(
			PersistenceContext persistenceContext) {
		return new PlanejamentoRoteiroDAOImpl(
				(HibernatePersistenceContext) persistenceContext);
	}

	/**
	 * Gets the plano estudo dao.
	 *
	 * @param persistenceContext the persistence context
	 * @return the plano estudo dao
	 */
	public static PlanoEstudoDAO getPlanoEstudoDAO(
			PersistenceContext persistenceContext) {
		return new PlanoEstudoDAOImpl(
				(HibernatePersistenceContext) persistenceContext);
	}

	/**
	 * Gets the producao aluno dao.
	 *
	 * @param persistenceContext the persistence context
	 * @return the producao aluno dao
	 */
	public static ProducaoAlunoDAO getProducaoAlunoDAO(
			PersistenceContext persistenceContext) {
		return new ProducaoAlunoDAOImpl(
				(HibernatePersistenceContext) persistenceContext);
	}

	/**
	 * Gets the professor funcionario dao.
	 *
	 * @param persistenceContext the persistence context
	 * @return the professor funcionario dao
	 */
	public static ProfessorFuncionarioDAO getProfessorFuncionarioDAO(
			PersistenceContext persistenceContext) {
		return new ProfessorFuncionarioDAOImpl(
				(HibernatePersistenceContext) persistenceContext);
	}

	/**
	 * Gets the professor funcionario variavel dao.
	 *
	 * @param persistenceContext the persistence context
	 * @return the professor funcionario variavel dao
	 */
	public static ProfessorFuncionarioVariavelDAO getProfessorFuncionarioVariavelDAO(
			PersistenceContext persistenceContext) {
		return new ProfessorFuncionarioVariavelDAOImpl(
				(HibernatePersistenceContext) persistenceContext);
	}



	/**
	 * Gets the relatorio tutoria dao.
	 *
	 * @param persistenceContext the persistence context
	 * @return the relatorio tutoria dao
	 */
	public static RelatorioTutoriaDAO getRelatorioTutoriaDAO(
			PersistenceContext persistenceContext) {
		return new RelatorioTutoriaDAOImpl(
				(HibernatePersistenceContext) persistenceContext);
	}

	/**
	 * Gets the roteiro dao.
	 *
	 * @param persistenceContext the persistence context
	 * @return the roteiro dao
	 */
	public static RoteiroDAO getRoteiroDAO(PersistenceContext persistenceContext) {
		return new RoteiroDAOImpl(
				(HibernatePersistenceContext) persistenceContext);
	}

	/**
	 * Gets the objetivo dao.
	 *
	 * @param persistenceContext the persistence context
	 * @return the objetivo dao
	 */
	public static ObjetivoDAO getObjetivoDAO(PersistenceContext persistenceContext) {
		return new ObjetivoDAOImpl(
				(HibernatePersistenceContext) persistenceContext);
	}

	
	/**
	 * Gets the registro diario dao.
	 *
	 * @param persistenceContext the persistence context
	 * @return the registro diario dao
	 */
	public static RegistroDiarioDAO getRegistroDiarioDAO(PersistenceContext persistenceContext) {
		return new RegistroDiarioDAOImpl(
				(HibernatePersistenceContext) persistenceContext);
	}

	/**
	 * Gets the tipo evento dao.
	 *
	 * @param persistenceContext the persistence context
	 * @return the tipo evento dao
	 */
	public static TipoEventoDAO getTipoEventoDAO(
			PersistenceContext persistenceContext) {
		return new TipoEventoDAOImpl(
				(HibernatePersistenceContext) persistenceContext);
	}

	/**
	 * Gets the tipo producao aluno dao.
	 *
	 * @param persistenceContext the persistence context
	 * @return the tipo producao aluno dao
	 */
	public static TipoProducaoAlunoDAO getTipoProducaoAlunoDAO(
			PersistenceContext persistenceContext) {
		return new TipoProducaoAlunoDAOImpl(
				(HibernatePersistenceContext) persistenceContext);
	}

	/**
	 * Gets the tutoria dao.
	 *
	 * @param persistenceContext the persistence context
	 * @return the tutoria dao
	 */
	public static TutoriaDAO getTutoriaDAO(PersistenceContext persistenceContext) {
		return new TutoriaDAOImpl(
				(HibernatePersistenceContext) persistenceContext);
	}

	/**
	 * Gets the usuario dao.
	 *
	 * @param persistenceContext the persistence context
	 * @return the usuario dao
	 */
	public static UsuarioDAO getUsuarioDAO(PersistenceContext persistenceContext) {
		return new UsuarioDAOImpl(
				(HibernatePersistenceContext) persistenceContext);
	}


	/**
	 * Gets the grupo dao.
	 *
	 * @param persistenceContext the persistence context
	 * @return the grupo dao
	 */
	public static GrupoDAO getGrupoDAO(PersistenceContext persistenceContext) {
		return new GrupoDAOImpl(
				(HibernatePersistenceContext) persistenceContext);
	}
	
	
	/**
	 * Gets the materia dao.
	 *
	 * @param persistenceContext the persistence context
	 * @return the materia dao
	 */
	public static MateriaDAO getMateriaDAO(PersistenceContext persistenceContext) {
		return new MateriaDAOImpl(
				(HibernatePersistenceContext) persistenceContext);
	}
	
	
	/**
	 * Gets the perfil dao.
	 *
	 * @param persistenceContext the persistence context
	 * @return the perfil dao
	 */
	public static PerfilDAO getPerfilDAO(PersistenceContext persistenceContext) {
		return new PerfilDAOImpl(
				(HibernatePersistenceContext) persistenceContext);
	}
	
	
	/**
	 * Gets the presenca professor dao.
	 *
	 * @param persistenceContext the persistence context
	 * @return the presenca professor dao
	 */
	public static PresencaProfessorDAO getPresencaProfessorDAO(PersistenceContext persistenceContext) {
		return new PresencaProfessorDAOImpl(
				(HibernatePersistenceContext) persistenceContext);
	}
	
	
	/**
	 * Gets the recurso aprendizagem dao.
	 *
	 * @param persistenceContext the persistence context
	 * @return the recurso aprendizagem dao
	 */
	public static RecursoAprendizagemDAO getRecursoAprendizagemDAO(PersistenceContext persistenceContext) {
		return new RecursoAprendizagemDAOImpl(
				(HibernatePersistenceContext) persistenceContext);
	}
	
	/**
	 * Gets the tipo recurso aprendizagem dao.
	 *
	 * @param persistenceContext the persistence context
	 * @return the tipo recurso aprendizagem dao
	 */
	public static TipoRecursoAprendizagemDAO getTipoRecursoAprendizagemDAO(PersistenceContext persistenceContext) {
		return new TipoRecursoAprendizagemDAOImpl(
				(HibernatePersistenceContext) persistenceContext);
	}
	
	/**
	 * Gets the periodo dao.
	 *
	 * @param persistenceContext the persistence context
	 * @return the periodo dao
	 */
	public static PeriodoDAO getPeriodoDAO(PersistenceContext persistenceContext) {
		return new PeriodoDAOImpl(
				(HibernatePersistenceContext) persistenceContext);
	}
	
	/**
	 * Gets the calendario dao.
	 *
	 * @param persistenceContext the persistence context
	 * @return the calendario dao
	 */
	public static CalendarioDAO getCalendarioDAO(PersistenceContext persistenceContext) {
		return new CalendarioDAOImpl(
				(HibernatePersistenceContext) persistenceContext);
	}
	
	/**
	 * Gets the forum resposta dao.
	 *
	 * @param persistenceContext the persistence context
	 * @return the forum resposta dao
	 */
	public static ForumRespostaDAO getForumRespostaDAO(PersistenceContext persistenceContext) {
		return new ForumRespostaDAOImpl(
				(HibernatePersistenceContext) persistenceContext);
	}
	
	/**
	 * Gets the forum questao dao.
	 *
	 * @param persistenceContext the persistence context
	 * @return the forum questao dao
	 */
	public static ForumQuestaoDAO getForumQuestaoDAO(PersistenceContext persistenceContext) {
		return new ForumQuestaoDAOImpl(
				(HibernatePersistenceContext) persistenceContext);
	}
	
	/**
	 * Gets the calendario eventos dao.
	 *
	 * @param persistenceContext the persistence context
	 * @return the calendario eventos dao
	 */
	public static CalendarioEventosDAO getCalendarioEventosDAO(PersistenceContext persistenceContext) {
		return new CalendarioEventosDAOImpl(
				(HibernatePersistenceContext) persistenceContext);
	}
	

	// / NATIVE QUERY
	/**
	 * Gets the native query dao.
	 *
	 * @param persistenceContext the persistence context
	 * @return the native query dao
	 */
	public static NativeQueryDAO getNativeQueryDAO(
			PersistenceContext persistenceContext) {
		return new NativeQueryDAOImpl(
				(HibernatePersistenceContext) persistenceContext);
	}

}
