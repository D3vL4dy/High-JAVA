package cumtrip.main.service;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import cumtrip.main.dao.MemberDaolmpl;

public class Mail {
	
	
//	public String random() {
//		String number;
//		int num1 = (int)(Math.random()*10+0+1)-0;
//		int num2 = (int)(Math.random()*10+0+1)-0;
//		int num3 = (int)(Math.random()*10+0+1)-0;
//		int num4 = (int)(Math.random()*10+0+1)-0;
//		number = String.valueOf(num1)+String.valueOf(num2)+String.valueOf(num3)+String.valueOf(num4);
//		
//		return number;
//	}
	
	
	public String start(String mail) throws EmailException {
		String number;
		int num1 = (int)(Math.random()*9+0+1)-0;
		int num2 = (int)(Math.random()*9+0+1)-0;
		int num3 = (int)(Math.random()*9+0+1)-0;
		int num4 = (int)(Math.random()*9+0+1)-0;
		number = String.valueOf(num1)+String.valueOf(num2)+String.valueOf(num3)+String.valueOf(num4);

		
		System.out.println("=====start send=====");
		Email email = new SimpleEmail();
		email.setHostName("smtp.naver.com");
		email.setSmtpPort(587);
		email.setAuthenticator(new DefaultAuthenticator("wjdrbq", "zo7627sc@@"));
		email.setSSLOnConnect(true);
		email.setFrom("wjdrbq@naver.com");
		email.setSubject("CUM TRIP 이메일 인증번호입니다.");
		email.setMsg("인증 번호는"+number+"입니다.");
		email.addTo(mail);
		email.send();
		System.out.println("=====end send=====");
		
		return number;
		
		
		
	}
	
//	public static void main(String[] args) throws EmailException {
//		String mail = "sun035160@gmail.com";
//		new Mail().start(mail);
//	}
	


}
