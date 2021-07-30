package com.nagarro.telecompractice.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	private MailService mailService;
	
	@Autowired(required = true)
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public User getUserByEmail(String email) {
		return userRepository.getUserByEmail(email);
	}

	@Override
	public User saveUser(User user) {
		String password = RandomPasswordGenerator.generatePassword();
		user.setPassword(bCryptPasswordEncoder.encode(password));
		User succesfullyRegisteredUser = userRepository.save(user);
		mailService.sendMailToRegisteredUser(succesfullyRegisteredUser.getEmail(),password);
		return succesfullyRegisteredUser;
	}

}
