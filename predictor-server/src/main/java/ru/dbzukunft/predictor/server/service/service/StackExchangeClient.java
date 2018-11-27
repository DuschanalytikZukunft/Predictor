package ru.dbzukunft.predictor.server.service.service;

import com.predictor.beans.CbrDaily;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;

/**
 * User: victoria.shepard
 * Date: 25/11/2018
 * Time: 14:53
 */
@Component
public class StackExchangeClient {

    private CloseableHttpClient httpClient = HttpClientBuilder.create().build();
    private ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
    private RestTemplate restTemplate = new RestTemplate(requestFactory);

    CbrDaily getCbrDaily() {
        String url = "https://www.cbr-xml-daily.ru/daily_json.js";
        try {
            CbrDaily response = restTemplate.getForObject(new URI(url), CbrDaily.class);
            return Objects.requireNonNull(response);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

    }

}
