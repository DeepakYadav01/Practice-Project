package com.nagarro.telecompractice.serviceImpl;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.nagarro.telecompractice.model.Task;
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
				+ "Username: " + username + " \nPassword: " + password
				+ "\n\nPlease contact us at js794017@gmail.com if you have any queries.\n\n" + "Thank you.\n";
				
		try {
			sendMailWithLoginCredentials(toMail, msg);
			return Constants.mailSuccess;
		} catch (Exception e) {
			return Constants.mailError + e;
		}

	}
	
	@Override
	public String sendNotificationToUser(String username, Task task) {

		String toMail = username;
		String subject = "Pending task alert!";
		String msg = "Your Task Details :\n\n"
				+"Name : "+task.getName()+"\n" 
				+"DueDate : "+task.getDueDate()+"\n" 
				+"Priority : "+task.getPriority()+"\n" 
				+ "\n\nPlease contact us at js794017@gmail.com if you have any queries.\n\n" + "Thank you.\n";
				
		try {
			sendMailWithTaskAlert(toMail, msg, subject);
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
	
	
	@Override
	public void sendMailWithTaskAlert(String toMail, String msg, String subject) throws MessagingException {

		try {
			MimeMessage message = mailSender.createMimeMessage();

			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setTo(toMail);
			helper.setSubject(subject);
			helper.setText(msg);

			mailSender.send(message);

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
}
