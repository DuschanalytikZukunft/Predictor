package ru.dbzukunft.predictor.server.service.service;

import com.predictor.beans.DailyRates;
import com.predictor.beans.ExchangeRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class PredictorService {

    private final PredictorExchangeClient stackExchangeClient;

    @Autowired
    public PredictorService(PredictorExchangeClient stackExchangeClient) {
        this.stackExchangeClient = stackExchangeClient;
    }

    public @NotNull List<ExchangeRate> getTodayRates() {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date date = new Date();
        return toPredictorWebsite(stackExchangeClient.getDailyRates(dateFormat.format(date)));
    }

    public @NotNull List<ExchangeRate> getRates(String date) {
        return toPredictorWebsite(stackExchangeClient.getDailyRates(date));
    }

    private @NotNull List<ExchangeRate> toPredictorWebsite(@NotNull DailyRates exchangeRates) {
       // return exchangeRates.stream().filter(exchangeRate -> exchangeRate.getCurrency() != null && exchangeRate.getCurrency().equals("USD")).findFirst().orElseThrow(() ->
        //        new IllegalArgumentException("Don't find USD rate"));
        return exchangeRates.getExchangeRate();
    }

}
