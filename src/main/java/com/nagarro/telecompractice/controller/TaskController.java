package com.nagarro.telecompractice.controller;

import java.security.Principal;

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
import com.nagarro.telecompractice.service.TaskService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class TaskController {
	
	@Autowired
	private TaskService taskService;

	@RequestMapping(value = "/create-task", method = RequestMethod.POST)
	public void createTask(@RequestBody Task task, Principal principal) {
		taskService.createTask(task, principal.getName());

	}
	
	
	@RequestMapping(value = "/update-task", method = RequestMethod.PUT)
	public void updateTask( @RequestBody Task task,Principal principal) {
		taskService.updateTask(task, principal.getName());

	}
	
	
	
	@RequestMapping(value = "/delete-task/{id}", method = RequestMethod.DELETE)
	public String deleteTask(@PathVariable(value = "id") int id) {
		return taskService.deleteTask(id);

	}
	
	
}
