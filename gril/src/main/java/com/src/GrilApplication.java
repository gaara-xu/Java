package com.src;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class GrilApplication {

/*	@Override
	protected SpringApplicationBuilder springApplicationBuilder(SpringApplicationBuilder applicationBuilder){
		return applicationBuilder.sources(GrilApplication.class);
	}*/

	public static void main(String[] args) {
		SpringApplication.run(GrilApplication.class, args);
	}
}
