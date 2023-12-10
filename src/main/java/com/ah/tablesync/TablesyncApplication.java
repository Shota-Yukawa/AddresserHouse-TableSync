package com.ah.tablesync;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({ "com.ah.tablesync", "com.ah.tablesynclib", "com.ah.querydatasource" })
@EntityScan("com.ah.querydatasource.entity")
@EnableJpaRepositories("com.ah.querydatasource.repository")
public class TablesyncApplication {

	public static void main(String[] args) {
		SpringApplication.run(TablesyncApplication.class, args);
	}

}
