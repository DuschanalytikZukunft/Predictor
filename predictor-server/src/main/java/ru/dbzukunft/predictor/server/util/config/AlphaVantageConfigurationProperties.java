package ru.dbzukunft.predictor.server.util.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@PropertySource(value = "classpath:datacrawler.properties")
@ConfigurationProperties(prefix = "alphavantage")
public class AlphaVantageConfigurationProperties {

    private String url;
    private String function;
    private String symbol;
    private String interval;
    private String outputsize;
    private String datatype;
    private String apikey;
    private Integer shedulerate;
}
