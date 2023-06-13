package com.shi.shicash;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.shi.shicash.models")
public class ShiCashApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShiCashApplication.class, args);
	}

}
