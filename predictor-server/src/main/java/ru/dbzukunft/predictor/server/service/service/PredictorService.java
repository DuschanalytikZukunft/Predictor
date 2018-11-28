package ru.dbzukunft.predictor.server.service.service;

import com.predictor.beans.ExchangeRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public class PredictorService {

    private final PredictorExchangeClient stackExchangeClient;

    @Autowired
    public PredictorService(PredictorExchangeClient stackExchangeClient) {
        this.stackExchangeClient = stackExchangeClient;
    }

    public ExchangeRate getCrbDaily() {
        return toPredictorWebsite(stackExchangeClient.getExchangeRate());
    }

    private ExchangeRate toPredictorWebsite(@NotNull List<ExchangeRate> exchangeRates) {
        return exchangeRates.stream().filter(exchangeRate -> exchangeRate.getCurrency() != null && exchangeRate.getCurrency().equals("USD")).findFirst().orElseThrow(() ->
                new IllegalArgumentException("Don't find USD rate"));
    }

}
