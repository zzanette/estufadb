package com.projeto.estufadb.config;

import com.projeto.estufadb.services.DataBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig {
    @Autowired
    DataBaseService dataBaseService;

    @Bean
    public void instantiateDataBase() {
        dataBaseService.initDatabase();
    }
}
