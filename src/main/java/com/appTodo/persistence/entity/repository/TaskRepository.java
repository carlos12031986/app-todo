package com.appTodo.persistence.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appTodo.persistence.entity.Task;

public interface TaskRepository extends JpaRepository<Task,Long>{

}
