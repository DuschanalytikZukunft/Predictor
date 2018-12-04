package ru.dbzukunft.predictor.server.service.service;

import com.google.gson.Gson;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.dbzukunft.predictor.server.entity.DailyRates;
import ru.dbzukunft.predictor.server.entity.ExchangeRate;

import java.util.Objects;

/**
 * User: victoria.shepard
 * Date: 25/11/2018
 * Time: 14:53
 */
@Component
public class PredictorExchangeClient {

    @Value("${privatbank_url:default}")
    public String privatbankUrl;

    DailyRates getDailyRates(String date) {
        String url = privatbankUrl + date;
        try {
            String json = Jsoup.connect(url).ignoreContentType(true).execute().body();
            ExchangeRate response = new Gson().fromJson(json, ExchangeRate.class);
            return Objects.requireNonNull(null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
