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

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.com.muranodesign.dao.UsuarioDAO;
import br.com.muranodesign.hibernate.AbstractHibernateDAO;
import br.com.muranodesign.hibernate.HibernatePersistenceContext;
import br.com.muranodesign.model.Usuario;


/**
 * Abstração do dao e implementação do GRUD
 *
 * @author Rogerio Lima dos Santos
 * @version 1.00
 * @since Release 1 da aplicação
 */
public class UsuarioDAOImpl extends AbstractHibernateDAO implements UsuarioDAO {

	/**
	 * Instantiates a new tutoria dao impl.
	 *
	 * @param persistenceContext the persistence context
	 */
	public UsuarioDAOImpl(HibernatePersistenceContext persistenceContext) {
		super(persistenceContext);
		
	}

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.UsuarioDAO#listAll()
	 */
	public List<Usuario> listAll() {
		
		Criteria criteria = getSession().createCriteria(Usuario.class);
		List<Usuario> result = criteria.list();
		
		
		return result;
	} 
	

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.UsuarioDAO#criar(br.com.muranodesign.model.Usuario)
	 */
	public void criar(Usuario c) {
		synchronized (UsuarioDAOImpl.class) {
			getSession().persist(c);
			getSession().flush();

		}
	}

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.UsuarioDAO#deletar(br.com.muranodesign.model.Usuario)
	 */
	public void deletar(Usuario c) {
		getSession().delete(c);
		getSession().flush();
	}

	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.UsuarioDAO#atualizar(br.com.muranodesign.model.Usuario)
	 */
	public void atualizar(Usuario p) {
		getSession().merge(p);
		getSession().flush();
	}
	
	
	/* (non-Javadoc)
	 * @see br.com.muranodesign.dao.UsuarioDAO#listarKey(int)
	 */
	public List<Usuario> listarKey(int key){
		Criteria criteria = getSession().createCriteria(Usuario.class);
		criteria.add(Restrictions.eq("idusuario", key));
		List<Usuario> result = criteria.list();
		return result;
	}

	@Override
	public List<Usuario> listarUsuario(String usuario) {
		
		Criteria criteria = getSession().createCriteria(Usuario.class);
		criteria.add(Restrictions.eq("login", usuario));
		List<Usuario> result = criteria.list();
		return result;
	}


	public List<Usuario> listaAluno(int idAluno){
		Criteria criteria = getSession().createCriteria(Usuario.class);
		criteria.createAlias("aluno", "aluno");
		criteria.add(Restrictions.eq("aluno.idAluno", idAluno));
		List<Usuario> result = criteria.list();
		return result;
	}

	@Override
	public List<Usuario> listaUsuarioEmail(String email) {
		Criteria criteria = getSession().createCriteria(Usuario.class);
		//criteria.createAlias("aluno", "aluno");
		criteria.add(Restrictions.eq("email", email));
		List<Usuario> result = criteria.list();
		return result;
	}





	
	

}