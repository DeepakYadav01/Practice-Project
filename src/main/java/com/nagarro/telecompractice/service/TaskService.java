package com.nagarro.telecompractice.service;

import java.security.Principal;

import com.nagarro.telecompractice.model.Task;

public interface TaskService {

	public void createTask(Task task, String email);

	public void updateTask(Task task, String email);

	public String deleteTask(int id);
	
	

}
