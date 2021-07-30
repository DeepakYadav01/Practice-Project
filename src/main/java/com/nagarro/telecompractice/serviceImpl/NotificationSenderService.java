package com.nagarro.telecompractice.serviceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.nagarro.telecompractice.model.Task;
import com.nagarro.telecompractice.repository.TaskRepository;
import com.nagarro.telecompractice.service.MailService;

@Service
public class NotificationSenderService {
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private MailService mailService;
	
	@Scheduled(fixedRate = 86400000)
	public void sendNotification() {
		
		String[] currentDate = new Date().toString().split(" ");
		List<Task> tasks = taskRepository.findAll();
		tasks.forEach(task->{
			
			String[] dueDate =	task.getDueDate().toString().split(" ");
			int dateDifference = Integer.parseInt(dueDate[2])-Integer.parseInt(currentDate[2]);
			
			if(dateDifference == 0) {
				mailService.sendNotificationToUser(task.getUser().getEmail(),task);
			}
	
		});
		
	}

}
