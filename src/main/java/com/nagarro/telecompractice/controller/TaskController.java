package com.nagarro.telecompractice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.telecompractice.model.Task;
import com.nagarro.telecompractice.model.User;
import com.nagarro.telecompractice.repository.TaskRepository;
import com.nagarro.telecompractice.repository.UserRepository;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class TaskController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TaskRepository taskRepository;

	@RequestMapping(value = "/{username}/create-task", method = RequestMethod.POST)
	public void createTask(@PathVariable(value = "username") String username, @RequestBody Task task) {
		
		User user = userRepository.getUserByEmail(username);
		task.setUser(user);
		taskRepository.save(task);

	}
	
	
}
