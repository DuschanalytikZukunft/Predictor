package ru.dbzukunft.predictor.server.util.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Configuration
@AllArgsConstructor
public class DataCrawlerConfig {

    private AlphaVantageConfigurationProperties aVProperties;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public String alphaVantageUrl() {
        return UriComponentsBuilder.fromHttpUrl(aVProperties.getUrl())
                .queryParam("function" , aVProperties.getFunction())
                .queryParam("symbol", aVProperties.getSymbol())
                .queryParam("interval", aVProperties.getInterval())
                .queryParam("outputsize", aVProperties.getOutputsize())
                .queryParam("datatype", aVProperties.getDatatype())
                .queryParam("apikey", aVProperties.getApikey())
                .build()
                .toUriString();
    }

}
