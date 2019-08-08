package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.bean.Task;
import com.demo.repo.TaskOwnRepository;
import com.demo.repo.TaskRepository;

@Service
@Transactional
public class TaskService {
	
	@Autowired
	TaskOwnRepository taskOwnRepository;
	
	@Autowired
	TaskRepository taskRepository;
	
	public void initializeDemoTasks() {
		Task task01 = new Task("Preparer seminaire", "Coder programme et rediger la documentation");
		Task task02 = new Task("Faire le rapport final", "Annexer les rapports hebdomadaires");
		saveAllTasks(task01, task02);
	}
	
	public List<Task> findAll(){
		return taskRepository.findAll();
	}
	
	public List<Task> findByName(String name){
		return taskOwnRepository.findByName(name);
	}
	
	public List<Task> findByDescription(String description){
		return taskOwnRepository.findByDescription(description);
	}
	
	public void saveTask(Task task) {
		taskRepository.save(task);
	}
	
	public void saveAllTasks(Task ...tasks) {
		for(Task task : tasks) {
			if(null != task) {
				taskRepository.save(task);
			}
		}
	}
	
	public void deleteTask(Task task) {
		taskRepository.delete(task);
	}
	
}
