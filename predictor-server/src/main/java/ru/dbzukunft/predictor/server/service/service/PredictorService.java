package ru.dbzukunft.predictor.server.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dbzukunft.predictor.server.entity.DailyRate;
import ru.dbzukunft.predictor.server.entity.ExchangeRate;

import javax.validation.constraints.NotNull;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class PredictorService {

    private final PredictorExchangeClient stackExchangeClient;

    @Autowired
    public PredictorService(PredictorExchangeClient stackExchangeClient) {
        this.stackExchangeClient = stackExchangeClient;
    }

    public @NotNull List<ExchangeRate> getRates() {
        return getRates(getLastDate());
    }

    public @NotNull DailyRate getDailyRates() {
        return stackExchangeClient.getDailyRates(getLastDate());
    }

    public @NotNull List<ExchangeRate> getRates(@NotNull String date) {
        return toPredictorWebsite(stackExchangeClient.getDailyRates(date));
    }

    public DailyRate getDailyRates(@NotNull String date) {
        return stackExchangeClient.getDailyRates(date);
    }

    public @NotNull ExchangeRate getValute(String valute) {
        return toPredictorWebsiteValute(stackExchangeClient.getDailyRates(getLastDate()), valute);
    }

    public @NotNull ExchangeRate getValute(String valute, String date) {
        return toPredictorWebsiteValute(stackExchangeClient.getDailyRates(date), valute);
    }

    private @NotNull List<ExchangeRate> toPredictorWebsite(@NotNull DailyRate dailyRate) {
        return dailyRate.getExchangeRate();
    }

    private ExchangeRate toPredictorWebsiteValute(@NotNull DailyRate dailyRate, @NotNull String valute) {
        return dailyRate.getExchangeRate().stream().filter(exchangeRate -> exchangeRate.getCurrency() != null &&
                exchangeRate.getCurrency().equals(valute)).findFirst().orElseThrow(() ->
               new IllegalArgumentException("Don't find USD rate"));
    }

    private String getLastDate(){
        OffsetDateTime yesterday = OffsetDateTime.now().minusDays(1);
        return yesterday.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }
}
