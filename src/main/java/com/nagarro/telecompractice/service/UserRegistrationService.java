package com.nagarro.telecompractice.service;

import com.nagarro.telecompractice.model.User;

public interface UserRegistrationService {
	
	public User getUserByEmail(String email);
	public User saveUser(User user);
}
