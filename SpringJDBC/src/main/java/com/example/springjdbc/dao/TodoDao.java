package com.example.springjdbc.dao;

import com.example.springjdbc.model.Todo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Component
public class TodoDao {
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    private final JdbcTemplate jdbcTemplate;

    public TodoDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;

        //create table if doesn't exist
        String createQuery = "CREATE TABLE IF NOT EXISTS todos(" +
                "id  SERIAL PRIMARY KEY,title VARCHAR(50) NOT NULL,content VARCHAR(500)," +
                "status VARCHAR(10) NOT NULL, addedDate DATE, todoDate DATE);";
        int rows = jdbcTemplate.update(createQuery);
        log.info(String.format("Table created.................... and %s rows have been affected ", rows));
    }


    //save todo
    public Todo saveTodo(Todo todo) {
        String insertQuery = "INSERT INTO todos(id,title,content,status,addedDate,todoDate) values(?,?,?,?,?,?)";
        int rows = jdbcTemplate.update(insertQuery, todo.getId(), todo.getTitle(), todo.getContent(), todo.getStatus(), todo.getAddedDate(), todo.getToDoDate());
        log.info(String.format("%s rows have been added", rows));
        return todo;
    }

    //get todo
    public Todo getTodo(int id) {
        String query = "SELECT * FROM todos WHERE id= ?";
        //Map<String, Object> todoMap = jdbcTemplate.queryForMap(query, id);
        return jdbcTemplate.queryForObject(query,new TodoRowMapper(),id);
    }

    //get list of todos
    public List<Todo> getListOfTodos() {
        String query = "Select * from todos";
        //List<Map<String, Object>> todoMapOfList = jdbcTemplate.queryForList(query);

        //        List<Todo> todoList = todoMapOfList.stream().map(todo -> {
//
//            Todo todos = new Todo();
//            todos.setId((Integer) todo.get("id"));
//            todos.setTitle((String) todo.get("title"));
//            todos.setContent((String) todo.get("content"));
//            todos.setStatus((String) todo.get("status"));
//            todos.setAddedDate((Date) todo.get("addeddate"));
//            todos.setToDoDate((Date) todo.get("tododate"));
//            return todos;
//        }).collect(Collectors.toList());

        return jdbcTemplate.query(query,(rs, rowNum)->{
            Todo todo = new Todo();
            todo.setId(rs.getInt("id"));
            todo.setTitle(rs.getString("title"));
            todo.setContent(rs.getString("content"));
            todo.setStatus(rs.getString("status"));
            todo.setAddedDate(rs.getDate("addeddate"));
            todo.setToDoDate(rs.getDate("tododate"));
            return todo;
        });
    }

    //update todo

    public Todo updateTodo(int id,Todo todo){
        String query="update todos set title=?,content=?,status=?,addeddate=?,tododate=? where id=?";
        jdbcTemplate.update(query,todo.getTitle(),todo.getContent(),todo.getStatus(),todo.getAddedDate(),id);
        return todo;
    }
}
