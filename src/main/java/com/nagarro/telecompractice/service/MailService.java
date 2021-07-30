package com.nagarro.telecompractice.service;

import javax.mail.MessagingException;

import com.nagarro.telecompractice.model.Task;

public interface MailService {
	
	public void sendMailToRegisteredUser(String username, String password);
	public void sendNotificationToUser(String username, Task task);
	public void sendMailWithLoginCredentials(String toMail,String msg) throws MessagingException;
	public void sendMailWithTaskAlert(String toMail, String msg, String subject) throws MessagingException;
	
}
