package com.nagarro.telecompractice.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.telecompractice.model.Task;
import com.nagarro.telecompractice.model.User;
import com.nagarro.telecompractice.repository.TaskRepository;
import com.nagarro.telecompractice.repository.UserRepository;
import com.nagarro.telecompractice.service.TaskService;

@Service("taskService")
public class TaskServiceImpl implements TaskService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Override
	public void createTask(Task task, String email) {

		User user = userRepository.getUserByEmail(email);
		task.setUser(user);
		taskRepository.save(task);

	}
	
	@Override
	public void updateTask(Task task,String email) {
		
		User user = userRepository.getUserByEmail(email);
		task.setUser(user);
		taskRepository.save(task);

	}
	
	
	@Override
	public String deleteTask(int id) {
		
		taskRepository.deleteById(id);
		return "Task deleted successfully!!";

	}
	
}
