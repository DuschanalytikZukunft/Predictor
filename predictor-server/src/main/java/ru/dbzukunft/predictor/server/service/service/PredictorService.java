package ru.dbzukunft.predictor.server.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dbzukunft.predictor.server.entity.DailyRates;
import ru.dbzukunft.predictor.server.entity.ExchangeRate;

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

    public @NotNull List<ExchangeRate> getRates() {
        return getRates(getCurrentDate());
    }

    public @NotNull DailyRates getDailyRates() {
        return stackExchangeClient.getDailyRates(getCurrentDate());
    }

    public @NotNull List<ExchangeRate> getRates(@NotNull String date) {
        return toPredictorWebsite(stackExchangeClient.getDailyRates(date));
    }

    public @NotNull ExchangeRate getValute(String valute) {
        return toPredictorWebsiteValute(stackExchangeClient.getDailyRates(getCurrentDate()), valute);
    }

    public @NotNull ExchangeRate getValute(String valute, String date) {
        return toPredictorWebsiteValute(stackExchangeClient.getDailyRates(date), valute);
    }

    private @NotNull List<ExchangeRate> toPredictorWebsite(@NotNull DailyRates dailyRates) {
        return dailyRates.getExchangeRate();
    }

    private ExchangeRate toPredictorWebsiteValute(@NotNull DailyRates dailyRates, @NotNull String valute) {
        return dailyRates.getExchangeRate().stream().filter(exchangeRate -> exchangeRate.getCurrency() != null &&
                exchangeRate.getCurrency().equals(valute)).findFirst().orElseThrow(() ->
               new IllegalArgumentException("Don't find USD rate"));
    }

    private String getCurrentDate(){
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
