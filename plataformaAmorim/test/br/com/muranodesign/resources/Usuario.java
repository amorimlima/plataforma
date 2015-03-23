package br.com.muranodesign.resources;

import org.junit.Test;

import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.test.framework.AppDescriptor;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.WebAppDescriptor;


public class Usuario extends JerseyTest  {
	@Override
	protected AppDescriptor configure() {
		return new WebAppDescriptor.Builder().build();
	}
	
	
	
	// Teste com professor nulo
	@Test
	public void insert() {
		WebResource webResource = client().resource("http://localhost:8082/plataformaAmorim/Usuario");
		
		 webResource.post("login=TESTE1&senha=TEXTOABERTOwwww&email=roegrio1%40hotmail.com&moderador=&action=create&aluno=3&perfil=7&professor=");
		 
				
	}
	
	
	// teste com todos os campos
	@Test
	public void insert2() {
		WebResource webResource = client().resource("http://localhost:8082/plataformaAmorim/Usuario");
		 webResource.post("login=TESTE1&senha=TEXTOABERTO&email=aluno%40hotmail.com&moderador=&action=create&aluno=&perfil=7&professor=5");
		 
				
	}
    
}