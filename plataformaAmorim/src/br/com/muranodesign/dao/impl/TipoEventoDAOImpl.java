/**
 *   Este codigo é software livre você e pode resdistribuir e/ou modificar ele seguindo os termos da
 *   Creative Commons Attribution 4.0 International Pare visualizar uma copia desta 
 *   licensa em ingles visite http://creativecommons.org/licenses/by/4.0/.
 *   
 *   This code is free software; you can redistribute it and/or modify it
 *   under the terms of Creative Commons Attribution 4.0 International License. 
 *   To view a copy of this license, visit http://creativecommons.org/licenses/by/4.0/.
 */

package br.com.muranodesign.dao.impl;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.com.muranodesign.dao.TipoEventoDAO;
import br.com.muranodesign.hibernate.AbstractHibernateDAO;
import br.com.muranodesign.hibernate.HibernatePersistenceContext;
import br.com.muranodesign.model.TipoEvento;




/**
 * Abstração do dao e implementação do GRUD
 *
 * @author Rogerio Lima dos Santos
 * @version 1.00
 * @since Release 1 da aplicação
 */
public class TipoEventoDAOImpl extends AbstractHibernateDAO implements TipoEventoDAO {
	
	/** The logger. */
	private Logger logger = Logger.getLogger(TipoEventoDAOImpl.class.getName());

	/**
	 * Instantiates a new tipo evento dao impl.
	 *
	 * @param persistenceContext the persistence context
	 */
	public TipoEventoDAOImpl(HibernatePersistenceContext persistenceContext) {
		super(persistenceContext);
		
	}

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.TipoEventoDAO#listAll()
	 */
	public List<TipoEvento> listAll() {
		
		Criteria criteria = getSession().createCriteria(TipoEvento.class);
		List<TipoEvento> result = criteria.list();
		
		
		return result;
	} 
	

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.TipoEventoDAO#criar(br.com.muranodesign.model.TipoEvento)
	 */
	public void criar(TipoEvento c) {
		
		logger.info("criando evento ... ");
		synchronized (TipoEventoDAOImpl.class) {
			getSession().persist(c);
			getSession().flush();

		}
	}

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.TipoEventoDAO#deletar(br.com.muranodesign.model.TipoEvento)
	 */
	public void deletar(TipoEvento c) {
		getSession().delete(c);
		getSession().flush();
	}

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.TipoEventoDAO#atualizar(br.com.muranodesign.model.TipoEvento)
	 */
	public void atualizar(TipoEvento p) {
		logger.info("Atualizando evento ... ");
		
		getSession().merge(p);
		getSession().flush();
	}
	
	
	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.TipoEventoDAO#listarKey(int)
	 */
	public List<TipoEvento> listarKey(int key){
		Criteria criteria = getSession().createCriteria(TipoEvento.class);
		criteria.add(Restrictions.eq("idtipoEvento", key));
		List<TipoEvento> result = criteria.list();
		return result;
	}

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.TipoEventoDAO#listarTipoEvento(java.lang.String)
	 */
	public List<TipoEvento> listarTipoEvento(String tipoEvento) {
		
		Criteria criteria = getSession().createCriteria(TipoEvento.class);
		criteria.add(Restrictions.eq("TipoEvento", tipoEvento));
		List<TipoEvento> result = criteria.list();
		
		
		return result;
	}





	

}