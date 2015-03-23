package br.com.muranodesign.resources;

import org.apache.commons.codec.binary.Base64;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.junit.Test;

import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.test.framework.AppDescriptor;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.WebAppDescriptor;


public class RegistroDiario extends JerseyTest  {
	@Override
	protected AppDescriptor configure() {
		return new WebAppDescriptor.Builder().build();
	}
	
	
	@Test
	public void insert() {
		WebResource webResource = client().resource("http://localhost:8082/plataformaAmorim/RegistroDiario");
		 webResource.post("action=create&data=2014-12-04&"
		 		+ "registro=dentro+da+tutoria+e+em+seguida+descemos+a+biblioteca+para+ver+a+nova+plataforma+de+registro+estudantil+do+Amorim+Lima+que+comeÃ§arÃ¡+a+ser+usada+no+ano+que+vem&planoEstudo=213");
		 
				
	}
	
	@Test
	public void testFound() {

		String orig = "admin:admin";

		// encoding byte array into base 64
		byte[] encoded = Base64.encodeBase64(orig.getBytes());

		WebResource webResource = client().resource("http://localhost:8082/");

		webResource.header("Authorization", "Basic " + encoded);
		JSONObject json = webResource.path("plataformaAmorim/RegistroDiario/1").get(
				JSONObject.class);
	}
	
	@Test
	public void testList() {

		String orig = "admin:admin";

		// encoding byte array into base 64
		byte[] encoded = Base64.encodeBase64(orig.getBytes());

		WebResource webResource = client().resource("http://localhost:8082/");

		webResource.header("Authorization", "Basic " + encoded);
		JSONArray json = webResource.path("plataformaAmorim/RegistroDiario").get(JSONArray.class);
	}

    
}