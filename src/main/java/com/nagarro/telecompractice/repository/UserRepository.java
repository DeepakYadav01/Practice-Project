package com.nagarro.telecompractice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.telecompractice.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	public User getUserByEmail(String email);
}
