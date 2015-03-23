package br.com.muranodesign.resources;

import org.apache.commons.codec.binary.Base64;
import org.codehaus.jettison.json.JSONObject;
import org.junit.Test;

import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.test.framework.AppDescriptor;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.WebAppDescriptor;


public class ProfessorFuncionario extends JerseyTest  {
	@Override
	protected AppDescriptor configure() {
		return new WebAppDescriptor.Builder().build();
	}
	
	
	@Test
	public void insert() {
		WebResource webResource = client().resource("http://localhost:8082/plataformaAmorim/ProfessorFuncionario");
		 webResource.post("action=create&nome=AntoniodaSilva&rua=rua+Aguinal+do+Vasconcelos&numero=778&complemento=&cep=09129090&"
		 		+ "bairro=JardimdasFlores"
		 		+ "&cidade=Sao+Paulo&estado=Sao+Paulo&naturalidadeEstado=Pernambuco&naturalidadePais=Brasileiro&qpe=20"
		 		+ "&dataEntradaPrefeitura=2014-10-06&ativo=S&dataEntradaEscola=2014-11-18&observacao=Teste");
		 
				
	}
	
	@Test
	public void testFound() {

		String orig = "admin:admin";

		// encoding byte array into base 64
		byte[] encoded = Base64.encodeBase64(orig.getBytes());

		WebResource webResource = client().resource("http://localhost:8082/");

		webResource.header("Authorization", "Basic " + encoded);
		JSONObject json = webResource.path("plataformaAmorim/ProfessorFuncionario/5").get(
				JSONObject.class);
	}

    
}