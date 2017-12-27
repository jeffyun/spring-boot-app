package com.jeffyun;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication

@MapperScan(basePackages = "com.jeff")
public class SpringBootWebApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebApplication.class, args);
	}
}
