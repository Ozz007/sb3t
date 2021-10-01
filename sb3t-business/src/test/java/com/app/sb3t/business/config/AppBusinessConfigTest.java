package com.app.sb3t.business.config;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = { AppBusinessConfigTest.Config.class })
public class AppBusinessConfigTest {

    @Configuration
    @ComponentScan(basePackages = {"com.app.sb3t.business"})
    @EnableAutoConfiguration
    @PropertySource("classpath:application-tu.properties")
    public static class Config {

    }
}
