package com.contact.app.service;

import java.util.Properties;

import org.springframework.stereotype.Service;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {
	
	public boolean sendEmail(String to,String text,String subject)
	{
		boolean sent=false;
		
		String username="sainathkadam1025@gmail.com";
		String password="uxheencvlmjsaxdf";
		String host="smtp.gmail.com";
		String from="sainathkadam1025@gmail.com";
		
		Properties properties=new Properties();
		
		properties.put("mail.smtp.host",host);
		properties.put("mail.smtp.ssl.trust",host);
		properties.put("mail.smtp.port",587);
		
		properties.put("mail.smtp.starttls.enable",true);
		properties.put("mail.smtp.auth",true);
		
		
		Session session=Session.getInstance(properties,new Authenticator() {
			
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		Message message=new MimeMessage(session);
		
		try {
			message.setFrom(new InternetAddress(from));
			message.setRecipient(Message.RecipientType.TO,new InternetAddress(to));
			message.setSubject(subject);
			message.setContent(text,"text/html");
			
			
			System.out.println("sending message:"+text);
			Transport.send(message);
			
			sent=true;
			
			System.out.println("sent email successfully");
			
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sent;
	}

}
