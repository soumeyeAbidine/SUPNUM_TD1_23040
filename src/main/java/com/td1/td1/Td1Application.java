package com.td1.td1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.td1.td1.repository")
public class Td1Application {

    public static void main(String[] args) {
        SpringApplication.run(Td1Application.class, args);
    }

}
