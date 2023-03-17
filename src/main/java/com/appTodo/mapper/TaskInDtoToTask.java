package com.appTodo.mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.appTodo.persistence.entity.Task;
import com.appTodo.persistence.entity.TaskStatus;
import com.appTodo.services.dto.TaskInDto;

@Component
public class TaskInDtoToTask implements IMapper<TaskInDto,Task>{

	@Override
	public Task map(TaskInDto in) {
		
		Task task = new Task();
		task.setTitle(in.getTitle());
		task.setDescription(in.getDescription());
		task.setEta(in.getEta());
		task.setCreatedDate(LocalDateTime.now());
		task.setFinished(false);
		task.setTaskStatus(TaskStatus.ON_TIME);
		return task;
	}

	

}
