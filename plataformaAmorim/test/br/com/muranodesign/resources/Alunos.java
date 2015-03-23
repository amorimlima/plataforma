package br.com.muranodesign.resources;

import org.apache.commons.codec.binary.Base64;
import org.codehaus.jettison.json.JSONObject;
import org.junit.Test;

import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.test.framework.AppDescriptor;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.WebAppDescriptor;

public class Alunos extends JerseyTest {
	@Override
	protected AppDescriptor configure() {
		return new WebAppDescriptor.Builder().build();
	}

	@Test
	public void testFound() {

		String orig = "admin:admin";

		// encoding byte array into base 64
		byte[] encoded = Base64.encodeBase64(orig.getBytes());

		WebResource webResource = client().resource("http://localhost:8082/");

		webResource.header("Authorization", "Basic " + encoded);
		JSONObject json = webResource.path("plataformaAmorim/Alunos/1").get(
				JSONObject.class);
	}

	@Test(expected = UniformInterfaceException.class)
	public void testAlunoNotFound() {
		WebResource webResource = client().resource("http://localhost:8082/");
		webResource.path("plataformaAmorim/Alunos/9999").get(JSONObject.class);
	}

	@Test
	public void insert() {
		WebResource webResource = client().resource("http://localhost:8082/plataformaAmorim/Alunos");
		
		 webResource.post("action=create&bairro=Jardim Tupi&cep=09932187&cepMae=09932187&cepPai=09932187&cepResponsavel=null&"
		 		+ "cidade=Sao Paulo&cidadeMae=null&cidadePai=null&cidadeResponsavel=null&complemento=null&complementoMae=null"
		 		+ "&complementoPai=null&complementoResponsavel=null&dataMatricula=2014-11-19&dataNascimento=1990-11-19&email1Mae=null"
		 		+ "&email1Pai=null&email1Responsavel=null&email2Mae=null&email2Pai=null&email2Responsavel=null"
		 		+ "&endereco=Rua Manoel da Nobrega&enderecoMae=null&enderecoPai=null&enderecoResponsavel=null"
		 		+ "&etnia=Brasileira&naturalCidade=null&naturalEstado=null&naturalPais=null&nome=Aluno Teste"
		 		+ "&nomeMae=Maria das Dores Rosa&nomePai=Fernando de Vasconcelos Leme&nomeResponsavel=null"
		 		+ "&numero=null&numeroMae=null&numeroPai=null&numeroResponsavel=null&pais=null&responsaveisResponsavel=null"
		 		+ "&rg=null&telefoneCelularMae=null&telefoneCelularPai=null&telefoneCelularResponsavel=null"
		 		+ "&telefoneComercialMae=null&telefoneComercialPai=null&telefoneComercialResponsavel=999999999&telefoneResidencialMae=99999999"
		 		+ "&telefoneResidencialPai=99999999&telefoneResidencialResponsavel=9999999&necessidadeEspecial=N&uf=SP&ufMae=SP"
		 		+ "&ufPai=SP&ufResponsavel=SP&sexo=m&ativo=S&numeroEol=null&numeroRA=null&email=null&celular=null&cpf=null"
		 		+ "&observacao=null&parentescoResponsavel=null&enecessidadeEspecial=N&eresponsavelLegalMae=S"
		 		+ "&eresponsavelLegalPai=S&eresponsavelLegalResponsavel=N");
	}
	
	
	@Test
	public void update() {
		WebResource webResource = client().resource("http://localhost:8082/plataformaAmorim/Alunos");
		
		 webResource.post("id=1&action=update&bairro=Jardim Tupi&cep=09932187&cepMae=09932187&cepPai=09932187&cepResponsavel=null&"
		 		+ "cidade=Sao Paulo&cidadeMae=null&cidadePai=null&cidadeResponsavel=null&complemento=null&complementoMae=null"
		 		+ "&complementoPai=null&complementoResponsavel=null&dataMatricula=2015-02-01&dataNascimento=1992-11-18&email1Mae=null"
		 		+ "&email1Pai=null&email1Responsavel=null&email2Mae=null&email2Pai=null&email2Responsavel=null"
		 		+ "&endereco=Rua Manoel da Nobrega&enderecoMae=null&enderecoPai=null&enderecoResponsavel=null"
		 		+ "&etnia=Brasileira&naturalCidade=null&naturalEstado=null&naturalPais=null&nome=Aluno Teste"
		 		+ "&nomeMae=Maria das Dores Rosa&nomePai=Fernando de Vasconcelos Leme&nomeResponsavel=null"
		 		+ "&numero=null&numeroMae=null&numeroPai=null&numeroResponsavel=null&pais=null&responsaveisResponsavel=null"
		 		+ "&rg=null&telefoneCelularMae=null&telefoneCelularPai=null&telefoneCelularResponsavel=null"
		 		+ "&telefoneComercialMae=null&telefoneComercialPai=null&telefoneComercialResponsavel=999999999&telefoneResidencialMae=99999999"
		 		+ "&telefoneResidencialPai=99999999&telefoneResidencialResponsavel=9999999&necessidadeEspecial=N&uf=SP&ufMae=SP"
		 		+ "&ufPai=SP&ufResponsavel=SP&sexo=m&ativo=S&numeroEol=null&numeroRA=null&email=null&celular=null&cpf=null"
		 		+ "&observacao=null&parentescoResponsavel=null&enecessidadeEspecial=N&eresponsavelLegalMae=S"
		 		+ "&eresponsavelLegalPai=S&eresponsavelLegalResponsavel=N");
	}

	
}
