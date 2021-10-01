package com.app.sb3t.business.config;

import com.app.sb3t.persistence.config.AppPersistenceConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.annotation.PostConstruct;

@Configuration
@ComponentScan({"com.app.sb3t.business.service",
        "com.app.sb3t.business.mapper"
})
@Import({AppPersistenceConfig.class})
@Slf4j
public class AppBusinessConfig {
    @PostConstruct
    public void postInit() {
        log.info("AppBusinessConfig Initialized");
    }
}
