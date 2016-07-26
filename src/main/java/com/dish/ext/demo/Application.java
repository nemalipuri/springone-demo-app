package com.dish.ext.demo;

import com.dish.ext.demo.config.ApplicationConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Slf4j
@SpringBootApplication
@Import({ApplicationConfig.class})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        log.info("springone-demo-app application has been initialized!");
    }
}
