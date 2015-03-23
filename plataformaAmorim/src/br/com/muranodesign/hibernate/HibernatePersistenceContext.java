/**
 *   Este codigo é software livre você e pode resdistribuir e/ou modificar ele seguindo os termos da
 *   Creative Commons Attribution 4.0 International Pare visualizar uma copia desta 
 *   licensa em ingles visite http://creativecommons.org/licenses/by/4.0/.
 *   
 *   This code is free software; you can redistribute it and/or modify it
 *   under the terms of Creative Commons Attribution 4.0 International License. 
 *   To view a copy of this license, visit http://creativecommons.org/licenses/by/4.0/.
 */
package br.com.muranodesign.hibernate;

import org.apache.log4j.Logger;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import br.com.muranodesign.hibernate.impl.PersistenceContext;




/**
 *  Implementacao de PersistenceContext que encapsula uma Session do hibernate.
 *
 * @author Rogerio Lima dos Santos
 * @version 1.00
 * @since Release 1 da aplicação
 */

public class HibernatePersistenceContext implements PersistenceContext {

	//private static final Logger logger = LoggerFactory.getLogger(HibernatePersistenceContext.class);
	
	/**
	 * Timeout para as transacoes do Hibernate.
	 */
	
	// TODO Subir este item para configuracao global
	private static final int TRANSACTION_TIMEOUT = 15;
	
	private static SessionFactory factory;
	
	private Logger logger = Logger.getLogger(HibernatePersistenceContext.class.getName());
	
	private Session session;
	private Transaction trans;
	
	static {
		factory = new AnnotationConfiguration().configure().buildSessionFactory();
	}
	
	public HibernatePersistenceContext() {
		session = factory.openSession();
		session.setFlushMode(FlushMode.COMMIT);
		trans = session.beginTransaction();
		trans.setTimeout(TRANSACTION_TIMEOUT);
	}
	
	@Override
	public Object getContext() {
		return session;
	}

	@Override
	public void commitAndClose() {
		trans.commit();
		session.close();
	}

	@Override
	public void rollbackAndClose() {
		try {
			trans.rollback();
		} catch (Exception e) {
			// Usualmente o rollback sao chamado em caso de erro. Nao vamos mascara-lo
			// com uma nova excecao, por isso logamos e ignoramos.
			logger.error("ERRO AO EFETUAR ROLLBACK DE TRANSACAO", e);
		}
		session.close();
	}

	@Override
	public void detach(Object o) {
		session.evict(o);
	}

	
}
