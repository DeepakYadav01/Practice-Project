package com.nagarro.telecompractice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.telecompractice.Exceptions.UserAlreadyExistException;
import com.nagarro.telecompractice.model.User;
import com.nagarro.telecompractice.service.UserRegistrationService;


@RestController
@CrossOrigin
@RequestMapping("/api")
public class UserRegistrationController {
	
	@Autowired
	private UserRegistrationService userRegistrationService;
	
	@RequestMapping(path = "/register", method = RequestMethod.POST)
	public ResponseEntity<User> registerUser(@RequestBody User user) throws UserAlreadyExistException {

		String userEmail = user.getEmail();
		User existingUser = userRegistrationService.getUserByEmail(userEmail);
		if (existingUser != null) {
			throw new UserAlreadyExistException("User with " + userEmail + "already exist, please choose a different email");
		}
		User registeredUser = userRegistrationService.saveUser(user);
		return new ResponseEntity<User>(registeredUser,HttpStatus.CREATED);
	}
	
}
