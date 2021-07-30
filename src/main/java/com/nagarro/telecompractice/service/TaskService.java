package com.nagarro.telecompractice.service;

import com.nagarro.telecompractice.model.Task;

public interface TaskService {

	public void createAndUpdateTask(Task task, String email);

	public String deleteTask(int id);
	
	

}
