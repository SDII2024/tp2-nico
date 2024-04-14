package com.example.tp2nicoseccion2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {"com.example.tp2nicoseccion2.Ej3"})
public class SpringWSApp {
	public static void main(String[] args) {
		System.setProperty("java.awt.headless", "false");
		SpringApplication.run(SpringWSApp.class, args);
	}
}
