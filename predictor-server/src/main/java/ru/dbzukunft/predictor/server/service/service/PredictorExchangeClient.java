package ru.dbzukunft.predictor.server.service.service;

import com.google.gson.Gson;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.dbzukunft.predictor.server.entity.DailyRate;

/**
 * User: victoria.shepard
 * Date: 25/11/2018
 * Time: 14:53
 */
@Component
public class PredictorExchangeClient {

    @Value("${privatbank_url:default}")
    public String privatbankUrl;

    DailyRate getDailyRates(String date) {
        String url = privatbankUrl + date;
        try {
            String json = Jsoup.connect(url).ignoreContentType(true).execute().body();
            return new Gson().fromJson(json, DailyRate.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
