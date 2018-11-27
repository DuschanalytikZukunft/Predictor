package ru.dbzukunft.predictor.server.service.service;

import com.predictor.beans.CbrDaily;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.jsoup.Jsoup;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
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
        String json = null;
        try {
            json = Jsoup.connect(url).ignoreContentType(true).execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //TODO Json parsing
        CbrDaily response = restTemplate.getForObject(Objects.requireNonNull(json), CbrDaily.class);
        return Objects.requireNonNull(response);
    }

}
