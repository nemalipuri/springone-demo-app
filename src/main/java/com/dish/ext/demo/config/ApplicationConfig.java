package com.dish.ext.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Slf4j
@Configuration
@ImportResource({"classpath:spring-context.xml"})
public class ApplicationConfig {

    @Autowired
    private Environment env;

    @PostConstruct
    public void init() {
        if (env != null) {
            log.info("Environment active profile(s) for springone-demo-app: "
                    + Arrays.toString(env.getActiveProfiles()));
        } else {
            log.debug("*** Missing active profile(s) ***");
        }
    }

}
