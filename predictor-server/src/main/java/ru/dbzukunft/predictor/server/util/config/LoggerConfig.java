package ru.dbzukunft.predictor.server.util.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.dbzukunft.predictor.server.ServerApplication;

@Configuration
public class LoggerConfig {
    @Bean
    public Logger log() {
        return LoggerFactory.getLogger(ServerApplication.class);
    }
}
