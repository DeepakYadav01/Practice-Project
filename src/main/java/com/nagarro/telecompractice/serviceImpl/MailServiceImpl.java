package com.nagarro.telecompractice.serviceImpl;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.nagarro.telecompractice.service.MailService;
import com.nagarro.telecompractice.utils.Constants;


@Service("mailService")
public class MailServiceImpl implements MailService {

	@Autowired
	JavaMailSender mailSender;

	@Override
	public String sendMailToRegisteredUser(String username, String password) {

		String toMail = username;
		String msg = "Welcome !!\n\n"
				+"Subject: Your Login Credentials :\n\n"
				+ "Username : " + username + " \nPassword: " + password
				+ "\n\nPlease contact us at js794017@gmail.com if you have any questions.\n\n" + "Thank you.\n";
				
		try {
			sendMailWithLoginCredentials(toMail, msg);
			return Constants.mailSuccess;
		} catch (Exception e) {
			return Constants.mailError + e;
		}

	}

	
	
	@Override
	public void sendMailWithLoginCredentials(String toMail, String msg) throws MessagingException {

		try {
			MimeMessage message = mailSender.createMimeMessage();

			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setTo(toMail);
			helper.setSubject(Constants.Subject);
			helper.setText(msg);

			mailSender.send(message);

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
}
