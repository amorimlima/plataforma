package br.com.muranodesign.business;

import java.util.Date;
import java.util.List;

import br.com.muranodesign.dao.DAOFactory;
import br.com.muranodesign.dao.NativeQueryDAO;
import br.com.muranodesign.hibernate.impl.PersistenceContext;




public class NativeQueryService {
	
	
	
	public List<Object[]> listar(String query) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		
		
		NativeQueryDAO dao = DAOFactory.getNativeQueryDAO(pc);
		//List<ProdUser> result = dao.listarUser(user);
		//pc.commitAndClose();
		
		List <Object[]> list = dao.listAll(query);
		return list;
	}
	
	
	
	
	public List listArgs(String query,String ... args){
		
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		NativeQueryDAO dao = DAOFactory.getNativeQueryDAO(pc);
		List <Object[]> list = dao.listArgs(query,args);
		return list;
	}
	
	
	

}