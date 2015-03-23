package br.com.muranodesign.util;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class CommonsMail {
	
	
	
	/**
	 * envia email simples(somente texto)
	 * @throws EmailException
	 */
	public void enviaEmailSimples(String destinatario, String senha) throws EmailException {
		
		SimpleEmail email = new SimpleEmail();
		email.setHostName("smtp.plataformaamorim.org"); // o servidor SMTP para envio do e-mail
		email.addTo(destinatario); //destinatário
		email.setFrom("noreplay@plataformaamorim.org"); // remetente
		email.setSubject("Recuperacao Senha"); // assunto do e-mail
		email.setMsg("Sua nova senha é : " + senha); //conteudo do e-mail
		email.setAuthentication("noreplay@plataformaamorim.org", "pal@Jan2015");
		email.setSmtpPort(465);
		//email.setSSL(true);
		//email.setTLS(true);
		email.send();	
	}
	
	
	//public static void main(String[] args) throws EmailException, MalformedURLException {
		//CommonsMail commonsMail  = new CommonsMail();
		
		//commonsMail.enviaEmailSimples() ;
	//}

}
