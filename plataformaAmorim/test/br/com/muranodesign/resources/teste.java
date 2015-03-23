package br.com.muranodesign.resources;

import javax.ws.rs.core.MediaType;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.test.framework.AppDescriptor;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.WebAppDescriptor;


public class teste extends JerseyTest  {
	@Override
	protected AppDescriptor configure() {
		return new WebAppDescriptor.Builder().build();
	}
	
	
	
	@Test
	public void testFound() {

		String orig = "admin:admin";

		// encoding byte array into base 64
		byte[] encoded = Base64.encodeBase64(orig.getBytes());


		WebResource webResource = client().resource("http://plataformaamorim.org/WebServicePlataformaAmorimTeste/Logar/alterarSenha/");
		webResource.post("login=MurDevC&senhaAnt=MurDev&senha=MurDev&senhaNova=MurDev&id=1");
		System.out.println("0");
		//webResource = resource().path("product/kamal");
		String prod = webResource.accept(MediaType.TEXT_PLAIN).get(String.class);
		
		//assertEquals("ok", prod);
		
		
		System.out.println("1" + prod);


		
		
	}

    
}