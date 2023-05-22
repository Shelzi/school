package com.altonix.repository.configuration;

import com.zaxxer.hikari.HikariDataSource;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

import static com.altonix.repository.constant.ProfileName.PRODUCTION;
import static com.altonix.repository.constant.ProfileName.DEVELOPMENT;

@Configuration
@PropertySource("classpath:properties/database.properties")
@RequiredArgsConstructor
public class DataSourceConfiguration {
    private static final String DATABASE_DRIVER_CLASS_NAME = "spring.datasource.driver-class-name";
    private static final String DATABASE_URL = "spring.datasource.url";
    private static final String DATABASE_USERNAME = "spring.datasource.username";
    private static final String DATABASE_PASSWORD = "spring.datasource.password";
    private static final String DATABASE_MAX_POOL_SIZE = "spring.datasource.hikari.maximum-pool-size";
    private static final int DEFAULT_DATABASE_MAX_POOL_SIZE = 8;
    private static final String CREATE_DATABASE_SCRIPT = "classpath:database_scripts/schema.sql";
    private static final String FILL_DATABASE_WITH_DATA_SCRIPT = "classpath:database_scripts/data.sql";

    private final Environment environment;

    @Profile(PRODUCTION)
    @Bean
    public DataSource dataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName(environment.getProperty(DATABASE_DRIVER_CLASS_NAME));
        dataSource.setJdbcUrl(environment.getProperty(DATABASE_URL));
        dataSource.setUsername(environment.getProperty(DATABASE_USERNAME));
        dataSource.setPassword(environment.getProperty(DATABASE_PASSWORD));
        dataSource.setMaximumPoolSize(parseMaxPoolSize(environment.getProperty(DATABASE_MAX_POOL_SIZE)));
        return dataSource;
    }

    @Profile(DEVELOPMENT)
    @Bean
    public DataSource embeddedDataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript(CREATE_DATABASE_SCRIPT)
                .addScript(FILL_DATABASE_WITH_DATA_SCRIPT)
                .build();
    }

    private static int parseMaxPoolSize(final String property) {
        int maxPoolSize;
        try {
            maxPoolSize = Integer.parseInt(property);
        } catch (NumberFormatException e) {
            maxPoolSize = DEFAULT_DATABASE_MAX_POOL_SIZE;
        }
        return maxPoolSize;
    }
}
