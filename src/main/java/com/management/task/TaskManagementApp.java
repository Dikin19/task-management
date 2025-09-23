package com.management.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskManagementApp {

	public static void main(String[] args) {
		SpringApplication.run(TaskManagementApp.class, args);
        System.out.println("server can be run on https://localhost:8080");
	}

}
