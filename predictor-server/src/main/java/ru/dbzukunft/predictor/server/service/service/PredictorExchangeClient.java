package ru.dbzukunft.predictor.server.service.service;

import com.google.gson.Gson;
import com.predictor.beans.DailyRates;
import com.predictor.beans.ExchangeRate;
import org.jsoup.Jsoup;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

/**
 * User: victoria.shepard
 * Date: 25/11/2018
 * Time: 14:53
 */
@Component
public class PredictorExchangeClient {

    List<ExchangeRate> getExchangeRate() {
        String url = "https://api.privatbank.ua/p24api/exchange_rates?json&date=27.11.2018";
        try {
            String json = Jsoup.connect(url).ignoreContentType(true).execute().body();
            DailyRates response = new Gson().fromJson(json, DailyRates.class);
            return Objects.requireNonNull(response).getExchangeRate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
