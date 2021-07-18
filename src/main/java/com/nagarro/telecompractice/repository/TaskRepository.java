package com.nagarro.telecompractice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.telecompractice.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer>{

}
