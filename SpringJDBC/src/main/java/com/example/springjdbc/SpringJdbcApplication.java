package com.example.springjdbc;

import com.example.springjdbc.dao.TodoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class SpringJdbcApplication implements CommandLineRunner {

	@Autowired
	public TodoDao todoDao;

	public static void main(String[] args) {SpringApplication.run(SpringJdbcApplication.class, args);}

	@Override
	public void run(String... args) throws Exception {
		JdbcTemplate jdbcTemplate=todoDao.getJdbcTemplate();
		System.out.println(jdbcTemplate.getDataSource());
	}
}
