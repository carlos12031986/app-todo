package com.appTodo.services;

import java.util.List;

import com.appTodo.persistence.entity.Task;
import com.appTodo.services.dto.TaskInDto;

public interface TaskServiceImp {

	public Task createTask(TaskInDto task);
	public List<Task> allTask();
}
