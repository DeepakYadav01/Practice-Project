package com.nagarro.telecompractice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.hibernate.PropertyValueException;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.nagarro.telecompractice.model.Task;
import com.nagarro.telecompractice.model.User;
import com.nagarro.telecompractice.repository.TaskRepository;
import com.nagarro.telecompractice.repository.UserRepository;
import com.nagarro.telecompractice.service.TaskService;
import com.nagarro.telecompractice.service.UserRegistrationService;

@RunWith(SpringRunner.class)
@SpringBootTest
class TelecomPracticeApplicationTests {

	@Autowired
	private UserRegistrationService userRegistrationService;
	
	@Autowired
	private TaskService taskService;
	
	@MockBean
	private UserRepository userRepository;
	
	@MockBean
	private TaskRepository taskRepository;
	
	@Test
	public void getUserByEmailTest() {
		String email = "js79401672@gmail.com";
		String nonExistingEmail = "js@gmail.com";
		User user = new User();
		user.setId(1);
		user.setFirstName("jhon");
		user.setLastName("Smith");
		user.setEmail("js79401672@gmail.com");
		
		when(userRepository.getUserByEmail(email)).thenReturn(user);
		assertEquals(user, userRegistrationService.getUserByEmail(email));
		
		when(userRepository.getUserByEmail(nonExistingEmail)).thenReturn(null);
		assertEquals(null, userRegistrationService.getUserByEmail(nonExistingEmail));
	}
	
	@Test
	public void saveUserTest() {
		String email = "js79401672@gmail.com";
		User user = new User();
		user.setId(1);
		user.setFirstName("jhon");
		user.setLastName("Smith");
		user.setEmail("js79401672@gmail.com");
		
		when(userRepository.save(user)).thenReturn(user);
		assertEquals(user, userRegistrationService.saveUser(user));

	}
	
	@Test
	public void createTaskTest() throws PropertyValueException {
		String email = "js79401672@gmail.com";
		Task task = new Task();
		task.setId(1);
		task.setName("meet");
		task.setDueDate("");
		task.setPriority(1);
		
		when(userRepository.getUserByEmail(email)).thenReturn(null);
		when(taskRepository.save(task)).thenThrow(PropertyValueException.class);
		assertThrows(PropertyValueException.class, ()->taskService.createAndUpdateTask(task,null));
	}

}
