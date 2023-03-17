package com.appTodo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appTodo.mapper.TaskInDtoToTask;
import com.appTodo.persistence.entity.Task;
import com.appTodo.persistence.entity.repository.TaskRepository;
import com.appTodo.services.dto.TaskInDto;

@Service
public class TaskService implements TaskServiceImp {

	@Autowired
	private TaskRepository repository;
	
	@Autowired
	private TaskInDtoToTask mapper;
	
	@Override
	public Task createTask(TaskInDto taskDto) {
		Task task=mapper.map(taskDto);
		return this.repository.save(task);
	}

	@Override
	public List<Task> allTask() {
		return this.repository.findAll();
		
	}

}
