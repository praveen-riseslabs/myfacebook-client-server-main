package com.riseslabs.registration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {

	@Autowired
	private JavaMailSender javaMailSender;

	public void sendEmail(	String toemail,
							String subject,
							String body) {

		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("naidurishi879@gmail.com"); 
	    message.setTo(toemail);
		message.setText(body);
		message.setSubject(subject);
		
		javaMailSender.send(message);
		
	}

}
