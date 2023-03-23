package com.appTodo.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
		String variable = "cadena";
		return variable;
	}
	
	@GetMapping(path="/lista")
	public ResponseEntity lista()
	{
		Map respuesta = new HashMap();

		List<Integer> lista = new ArrayList<Integer>();
		lista = service.obtLista();
		
		List<Integer> listPares = new ArrayList<Integer>(); 
		List<Integer> listImpares = new ArrayList<Integer>(); 
		Iterator iterador = lista.iterator();
		
	    while(iterador.hasNext())
		{
	    	int num = (int) iterador.next();
			if(num%2 ==0)
			{
				listPares.add(num);
			}
			else
			{
				listImpares.add(num);
			}
			
		}
	    
	
	    respuesta.put("Pares",listPares);
	    respuesta.put("Impares",listImpares);
	    respuesta.put("Elements total", lista.size());
	    
	    Map<String,HashMap> nuevo = new HashMap<String,HashMap>();
	    nuevo.put("Respuesta", (HashMap) respuesta);

		return new ResponseEntity(nuevo,HttpStatus.OK);
	}
}
