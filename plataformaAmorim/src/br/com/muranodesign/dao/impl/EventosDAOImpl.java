/*
package br.com.muranodesign.dao.impl;
import java.util.List;

import org.hibernate.Criteria;

import org.hibernate.criterion.Restrictions;

import br.com.muranodesign.dao.EventosDAO;
import br.com.muranodesign.hibernate.AbstractHibernateDAO;
import br.com.muranodesign.hibernate.HibernatePersistenceContext;
import br.com.muranodesign.model.Eventos;


public class EventosDAOImpl extends AbstractHibernateDAO implements EventosDAO {

	public EventosDAOImpl(HibernatePersistenceContext persistenceContext) {
		super(persistenceContext);
		
	}

	public List<Eventos> listAll() {
		
		Criteria criteria = getSession().createCriteria(Eventos.class);
		List<Eventos> result = criteria.list();
		
		
		return result;
	} 
	

	public void criar(Eventos c) {
		synchronized (EventosDAOImpl.class) {
			getSession().persist(c);
			getSession().flush();

		}
	}

	public void deletar(Eventos c) {
		getSession().delete(c);
		getSession().flush();
	}

	public void atualizar(Eventos p) {
		getSession().merge(p);
		getSession().flush();
	}
	
	
	public List<Eventos> listarKey(int key){
		Criteria criteria = getSession().createCriteria(Eventos.class);
		criteria.add(Restrictions.eq("ideventos", key));
		List<Eventos> result = criteria.list();
		return result;
	}

	public List<Eventos> listarEvento(String evento) {
		
		Criteria criteria = getSession().createCriteria(Eventos.class);
		criteria.add(Restrictions.eq("evento", evento));
		List<Eventos> result = criteria.list();
		
		
		return result;
	}





	

}
*/