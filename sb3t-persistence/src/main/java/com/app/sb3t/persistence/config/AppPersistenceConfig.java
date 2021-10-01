package com.app.sb3t.persistence.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.PostConstruct;

@Configuration
@ComponentScan({"com.app.sb3t.persistence"})
@EnableJpaRepositories("com.app.sb3t.persistence.repository")
@EntityScan("com.app.sb3t.persistence.domain")
@Slf4j
public class AppPersistenceConfig {

    @PostConstruct
    public void postInit() {
        log.info("AppPersistenceConfig Initialized");
    }
}
