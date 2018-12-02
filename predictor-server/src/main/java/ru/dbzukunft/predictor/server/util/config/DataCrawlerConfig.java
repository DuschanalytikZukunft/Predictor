package ru.dbzukunft.predictor.server.util.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Configuration
@PropertySource(value = "classpath:datacrawler.properties")
@ConfigurationProperties(prefix = "alphavantage")
public class DataCrawlerConfig {

    @Value("${alphavantage.url}")
    private String url;

    @Value("${alphavantage.function}")
    private String function;

    @Value("${alphavantage.symbol}")
    private String symbol;

    @Value("${alphavantage.interval}")
    private String interval;

    @Value("${alphavantage.outputsize}")
    private String outputsize;

    @Value("${alphavantage.datatype}")
    private String datatype;

    @Value("${alphavantage.apikey}")
    private String apikey;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public String alphaVantageUrl() {
        return UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("function" , function)
                .queryParam("symbol", symbol)
                .queryParam("interval", interval)
                .queryParam("outputsize", outputsize)
                .queryParam("datatype", datatype)
                .queryParam("apikey", apikey)
                .build()
                .toUriString();
    }

}
