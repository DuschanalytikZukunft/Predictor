package ru.dbzukunft.predictor.server.service.service;

import com.predictor.beans.CbrDaily;
import com.predictor.beans.PredictorWebsite;
import com.predictor.beans.Valute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

@Service
public class StackoverflowService {

    @Autowired
    private StackExchangeClient stackExchangeClient;

    public PredictorWebsite getCrbDaily() {
        return toPredictorWebsite(stackExchangeClient.getCbrDaily());
    }

    private PredictorWebsite toPredictorWebsite(@NotNull CbrDaily cbrDaily) {
        Valute valuteEUR = cbrDaily.getValute().getEUR();
        Valute valuteUSD = cbrDaily.getValute().getUSD();
        System.out.println("!!!!!"+ valuteEUR);

        PredictorWebsite predictorWebsite = new PredictorWebsite()
                .withDate(cbrDaily.getDate())
                .withTimestamp(cbrDaily.getTimestamp())
                .withPreviousDate(cbrDaily.getPreviousDate())
                .withPreviousUrl(cbrDaily.getPreviousUrl())
                .withValueEUR(valuteEUR.getValue())
                .withPreviousEUR(valuteEUR.getPrevious())
                .withCharCodeEUR(valuteEUR.getCharCode())
                .withValueUSD(valuteUSD.getValue())
                .withPreviousUSD(valuteUSD.getPrevious())
                .withCharCodeUSD(valuteUSD.getCharCode());
        return predictorWebsite;
    }

}
