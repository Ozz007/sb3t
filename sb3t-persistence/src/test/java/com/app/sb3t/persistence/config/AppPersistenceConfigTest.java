package com.app.sb3t.persistence.config;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = { AppPersistenceConfigTest.Config.class })
public class AppPersistenceConfigTest {

    @Configuration
    @ComponentScan(basePackages = {"com.app.sb3t.persistence"})
    @EnableAutoConfiguration
    @PropertySource("classpath:application-ut.yml")
    public static class Config {

    }
}
