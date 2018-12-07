package ru.dbzukunft.predictor.server.service.web;

import com.google.common.collect.ImmutableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.dbzukunft.predictor.server.entity.DailyRate;
import ru.dbzukunft.predictor.server.entity.ExchangeRate;
import ru.dbzukunft.predictor.server.service.DailyRatesService;
import ru.dbzukunft.predictor.server.service.service.PredictorService;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PredictorController {

    private final PredictorService predictorService;

    @Autowired
    public PredictorController(PredictorService predictorService) {
        this.predictorService = predictorService;
    }

    @RequestMapping(value = "/rates", params = {"date", "valute"}, method = RequestMethod.GET)
    public @NotNull List<ExchangeRate> getListOfProviders(@RequestParam(required = false) String date,
                                                          @RequestParam(required = false)  String valute) {
        if (date.isEmpty() && valute.isEmpty()) {
            return predictorService.getRates();
        } else if (date.isEmpty()) {
            return ImmutableList.of(predictorService.getValute(valute));
        } else if (valute.isEmpty()) {
            return predictorService.getRates(date);
        } else return ImmutableList.of(predictorService.getValute(valute, date));
    }

    @RequestMapping(value = "/save", params = {"date"},  method = RequestMethod.GET)
    public DailyRate saveValute(@RequestParam String date) {
        DailyRate rates = predictorService.getDailyRates(date);
        DailyRatesService dailyRatesService = new DailyRatesService();
        dailyRatesService.saveDailyRates(rates);
        return rates;
    }
}
