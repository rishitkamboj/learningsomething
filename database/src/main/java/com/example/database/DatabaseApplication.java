package com.example.database;

import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@SpringBootApplication
@Log
public class DatabaseApplication implements CommandLineRunner {
	private final DataSource dataSource;
	//use for interacting with the DB
public DatabaseApplication(DataSource dataSource) {
	this.dataSource = dataSource;
}

	public static void main(String[] args) {
		SpringApplication.run(DatabaseApplication.class, args);
	}

	public void run(String... args){
	log.info("Data source "+dataSource.toString());
	final JdbcTemplate rest=new JdbcTemplate(dataSource);
	rest.execute("select 1");

	}
}
