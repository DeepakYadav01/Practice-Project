package com.nagarro.telecompractice.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.telecompractice.model.User;
import com.nagarro.telecompractice.repository.UserRepository;
import com.nagarro.telecompractice.service.UserRegistrationService;

@Service("userRegistrationService")
public class UserRegistrationServiceImpl implements UserRegistrationService {
	
	@Autowired
	private UserRepository userRepository; 

	@Override
	public User getUserByEmail(String email) {
		return userRepository.getUserByEmail(email);
	}

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

}
