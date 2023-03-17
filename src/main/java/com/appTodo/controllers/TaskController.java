package com.appTodo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appTodo.persistence.entity.Task;
import com.appTodo.services.TaskService;
import com.appTodo.services.dto.TaskInDto;


@RestController
@RequestMapping(path="task")
public class TaskController {

	@Autowired
	private TaskService service;
	
	@GetMapping
	public String demo() {
		return "Hola mundo";
	}
	
	@PostMapping(path ="/nuevo")
	public ResponseEntity<Task> create(@RequestBody TaskInDto taskDto)
	{
		Task task = this.service.createTask(taskDto);
		
		 return new ResponseEntity<>(task,HttpStatus.CREATED);
	}
	
	@GetMapping(path="/all")
	public ResponseEntity<List<Task>> allTask()
	{
		List<Task> lista = service.allTask();
		return new ResponseEntity<> (lista,HttpStatus.OK);
	}
	
	@PostMapping(path="update")
	public String actualiza()
	{
		return "hola";
	}
}
