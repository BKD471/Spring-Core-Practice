package com.example.todo.todomanager.service;

import com.example.todo.todomanager.model.Todo;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

@Service
public class TodoService {
     Logger log=  Logger.getLogger(String.valueOf(TodoService.class));
    List<Todo> todoList = new ArrayList<>();

    public Todo createService(Todo todo) {
      todoList.add(todo);
      log.info(" todo: "+todoList);
      return todo;
    }

    public  List<Todo> getAllTodos(){
        return todoList;
    }

    public  Todo getTodoById(UUID id){
      return todoList.stream().filter(todo -> todo.getId().equals(id)).findFirst().get();
    }
}
