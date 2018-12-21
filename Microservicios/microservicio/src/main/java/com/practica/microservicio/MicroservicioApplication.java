package com.practica.microservicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class MicroservicioApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(MicroservicioApplication.class, args);
	}

}

