package br.com.muranodesign.resources;

import org.apache.commons.codec.binary.Base64;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.junit.Test;

import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.json.impl.provider.entity.JSONListElementProvider;
import com.sun.jersey.test.framework.AppDescriptor;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.WebAppDescriptor;


public class Materia extends JerseyTest  {
	@Override
	protected AppDescriptor configure() {
		return new WebAppDescriptor.Builder().build();
	}
	
	
	
	@Test
	public void testList() {

		String orig = "admin:admin";

		// encoding byte array into base 64
		byte[] encoded = Base64.encodeBase64(orig.getBytes());

		WebResource webResource = client().resource("http://localhost:8082/");

		webResource.header("Authorization", "Basic " + encoded);
		JSONArray json = webResource.path("plataformaAmorim/Materia").get(JSONArray.class);
	}

    
}