package com.example.demo;

import com.example.demo.services.ColourPrint;
import com.example.demo.services.impl.ColourPrinter;
import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Log
public class DemoApplication implements CommandLineRunner {

	ColourPrint p;
	public DemoApplication(ColourPrint col) {
		p = col;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

@Override
	public void run(String... args) {
	  log.info(p.print());
	}
}
