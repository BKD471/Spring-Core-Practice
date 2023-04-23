package com.example.todo.todomanager.controller;

import com.example.todo.todomanager.model.Todo;
import com.example.todo.todomanager.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private  final TodoService todoService;
    TodoController(TodoService todoService){
        this.todoService=todoService;
    }

    @PostMapping("/create")
    public ResponseEntity<Todo> createTodos(@RequestBody Todo todo){
        todo.setId(UUID.randomUUID());
        Todo getTodo=todoService.createService(todo);
        return new ResponseEntity<>(getTodo, HttpStatus.CREATED);
    }

    @GetMapping
    public  ResponseEntity<List<Todo>> getAllTodos(){
        return new ResponseEntity<>(todoService.getAllTodos(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Todo> getTodoById(@PathVariable("id") UUID todoId){
        return new ResponseEntity<>(todoService.getTodoById(todoId),HttpStatus.OK);
    }

}
