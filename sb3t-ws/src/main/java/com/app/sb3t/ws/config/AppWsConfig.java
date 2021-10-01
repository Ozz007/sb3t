package com.app.sb3t.ws.config;

import com.app.sb3t.business.config.AppBusinessConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@Configuration
@ComponentScan({"com.app.sb3t.ws.controller"})
@Import({AppBusinessConfig.class})
@Slf4j
public class AppWsConfig {

    @PostConstruct
    public void postInit() {
        log.info("AppWsConfig Initialized");
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
