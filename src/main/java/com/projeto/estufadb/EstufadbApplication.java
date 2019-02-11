package com.projeto.estufadb;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EstufadbApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(EstufadbApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {}
}


