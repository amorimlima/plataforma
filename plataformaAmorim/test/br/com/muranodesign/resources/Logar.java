package br.com.muranodesign.resources;

import org.junit.Test;

import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.test.framework.AppDescriptor;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.WebAppDescriptor;


public class Logar extends JerseyTest  {
	@Override
	protected AppDescriptor configure() {
		return new WebAppDescriptor.Builder().build();
	}
	
	@Test
	public void EnviarUsuarioSenha() {
		WebResource webResource = client().resource("http://localhost:8082/plataformaAmorim/Logar");
		 webResource.post("usuario=TESTE&senha=teste");
		 
				
	}
	
	
	

    
}