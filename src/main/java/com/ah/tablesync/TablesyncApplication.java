package com.ah.tablesync;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "com.ah.tablesync", "com.ah.tablesynclib" })
public class TablesyncApplication {

	public static void main(String[] args) {
		SpringApplication.run(TablesyncApplication.class, args);
	}

}
