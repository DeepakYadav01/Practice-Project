package com.nagarro.telecompractice.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.telecompractice.model.User;
import com.nagarro.telecompractice.repository.UserRepository;
import com.nagarro.telecompractice.service.MailService;
import com.nagarro.telecompractice.service.UserRegistrationService;
import com.nagarro.telecompractice.utils.RandomPasswordGenerator;

@Service("userRegistrationService")
public class UserRegistrationServiceImpl implements UserRegistrationService {
	
	@Autowired
	private UserRepository userRepository; 
	
	@Autowired
	MailService mailService;

	@Override
	public User getUserByEmail(String email) {
		return userRepository.getUserByEmail(email);
	}

	@Override
	public User saveUser(User user) {
		String password = RandomPasswordGenerator.generatePassword();
		user.setPassword(password);
		User SuccesfullyRegisteredUser = userRepository.save(user);
		String mailResponse = mailService.sendMailToRegisteredUser(SuccesfullyRegisteredUser.getEmail(),password);
		System.out.println(mailResponse);
		return SuccesfullyRegisteredUser;
	}

}
