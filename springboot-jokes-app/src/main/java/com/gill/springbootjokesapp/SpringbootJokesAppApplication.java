package com.gill.springbootjokesapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:chuck-config.xml")
public class SpringbootJokesAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootJokesAppApplication.class, args);
    }

}
