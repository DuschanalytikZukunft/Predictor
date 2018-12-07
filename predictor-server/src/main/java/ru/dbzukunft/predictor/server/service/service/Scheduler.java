package ru.dbzukunft.predictor.server.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import ru.dbzukunft.predictor.server.service.DailyRatesService;

public class Scheduler {

    private final PredictorService predictorService;

    @Autowired
    public Scheduler(PredictorService predictorService) {
        this.predictorService = predictorService;
    }

    @Scheduled(cron = "0 0 0/24 * *  ?") //Start every 24h
    public void saveRates() {
        predictorService.getRates();
        DailyRatesService dailyRatesService = new DailyRatesService();
        dailyRatesService.saveDailyRates(predictorService.getDailyRates());
    }

}
