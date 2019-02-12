package com.projeto.estufadb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

@Configuration
@Profile({"dev", "prod"})
public class FlywayConfig {

    @Autowired
    private DataSource dataSource;

    @Value("${spring.flyway.table}")
    private String flywayTable;

    @Value("${spring.flyway.baseline-version}")
    private String baseLine;

    @Bean
    public FlywayMigrationStrategy flywayMigrationStrategy() {
        return flyway -> {
            if (!isFlywayInitilized()) {
                flyway.configure().baselineVersion(baseLine);
                flyway.baseline();
            }

            flyway.migrate();
        };
    }

    private boolean isFlywayInitilized() {
        try {
            DatabaseMetaData metaData = dataSource.getConnection().getMetaData();
            ResultSet resultSet = metaData.getTables(null, null, flywayTable, null);
            return resultSet.next();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inicializar configurações com Flyway", e);
        }
    }
}
