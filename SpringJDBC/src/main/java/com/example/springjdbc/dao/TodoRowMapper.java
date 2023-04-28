package com.example.springjdbc.dao;

import com.example.springjdbc.model.Todo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class TodoRowMapper implements RowMapper<Todo> {
    /**
     * @param rs
     * @param rowNum
     * @return
     * @throws SQLException
     */
    @Override
    public Todo mapRow(ResultSet rs, int rowNum) throws SQLException {
        Todo todo = new Todo();
        todo.setId(rs.getInt("id"));
        todo.setTitle(rs.getString("title"));
        todo.setContent(rs.getString("content"));
        todo.setStatus(rs.getString("status"));
        todo.setAddedDate(rs.getDate("addeddate"));
        todo.setToDoDate(rs.getDate("tododate"));
        return todo;
    }
}
