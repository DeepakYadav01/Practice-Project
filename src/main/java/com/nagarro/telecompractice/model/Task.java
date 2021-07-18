package com.nagarro.telecompractice.model;

import java.util.Date;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
public class Task {
	
	private String name;
	private Date dueDate;
	private int priority;
}
