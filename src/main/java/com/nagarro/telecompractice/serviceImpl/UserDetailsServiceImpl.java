package com.nagarro.telecompractice.serviceImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nagarro.telecompractice.model.User;
import com.nagarro.telecompractice.repository.UserRepository;


@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
			User user =  userRepository.getUserByEmail(username);			
			if(user == null ) {
				throw new UsernameNotFoundException("Username Not Found :"+ username);
			}
			else {
				return new  org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),new ArrayList<>());
			}
			
	}

}
