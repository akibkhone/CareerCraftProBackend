package com.personal.careercraftpro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class CareercraftproApplication {

	public static void main(String[] args) {
		SpringApplication.run(CareercraftproApplication.class, args);
	}

}
