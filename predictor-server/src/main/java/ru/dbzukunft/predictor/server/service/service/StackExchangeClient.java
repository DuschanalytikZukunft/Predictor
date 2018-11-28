package ru.dbzukunft.predictor.server.service.service;

import com.google.gson.Gson;
import com.predictor.beans.DailyRates;
import com.predictor.beans.ExchangeRate;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;
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

    List<ExchangeRate> getExchangeRate() {
        String url = "https://api.privatbank.ua/p24api/exchange_rates?json&date=27.11.2018";
        try {
            //DailyRates response = restTemplate.getForObject(new URI(url), DailyRates.class);
            String json = Jsoup.connect(url).ignoreContentType(true).execute().body();
            //JSONObject obj = new JSONObject(json);
            /*JSONObject valute = obj.getJSONObject("Valute");
            String keys[] = new String[valute.length()];
            for (int i = 0, len = valute.length(); i < len; i++) {
                keys[i] = valute.names().getString(i);
            }
            for (int i = 0, len = 34; i < len; i++) {
                if (!keys[i].equals("EUR") && !keys[i].equals("USD")) {
                    valute.remove(keys[i]);
                }
            }*/
           // DailyRates response = new Gson().fromJson(obj.toString(), DailyRates.class);
            DailyRates response = new Gson().fromJson(json, DailyRates.class);
            return Objects.requireNonNull(response).getExchangeRate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
