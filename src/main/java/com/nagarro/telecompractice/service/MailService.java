package com.nagarro.telecompractice.service;

import javax.mail.MessagingException;

public interface MailService {
	
	public String sendMailToRegisteredUser(String username, String password);
	public void sendMailWithLoginCredentials(String toMail,String msg) throws MessagingException;
}
