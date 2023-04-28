package com.example.springjdbc;

import com.example.springjdbc.dao.TodoDao;
import com.example.springjdbc.model.Todo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;
import java.util.List;

@Slf4j
@SpringBootApplication
public class SpringJdbcApplication implements CommandLineRunner {

	@Autowired
	public TodoDao todoDao;


	public static void main(String[] args) {SpringApplication.run(SpringJdbcApplication.class, args);}

	@Override
	public void run(String... args) throws Exception {
		Todo todo=new Todo();
		todo.setId(123);
		todo.setTitle("Master Spring");
		todo.setContent("learning spring for backend");
		todo.setStatus("WORKING");
		todo.setAddedDate(new Date());
		todo.setToDoDate(new Date());

		//save todo
		//todoDao.saveTodo(todo);

		//get a todo
		Todo todo1=todoDao.getTodo(123);
		log.info(""+todo1);

		//get all todos
		List<Todo> listofTodo=todoDao.getListOfTodos();
		log.info(listofTodo.toString());
	}
}
