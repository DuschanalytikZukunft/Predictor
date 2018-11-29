package ru.dbzukunft.predictor.server.service.web;

import com.predictor.beans.ExchangeRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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

    @RequestMapping(value = "/rates", method = RequestMethod.GET)
    public @NotNull List<ExchangeRate> getListOfProviders() {
        return predictorService.getRates();
    }

    @RequestMapping(value = "/rates?{date}", method = RequestMethod.GET)
    public @NotNull List<ExchangeRate> getListOfProviders(@PathVariable String date) {
        return predictorService.getRates(date);
    }

    @RequestMapping(value = "/{valute}", method = RequestMethod.GET)
    public @NotNull ExchangeRate getValute(@PathVariable String valute) {
        return predictorService.getValute(valute);
    }

    @RequestMapping(value = "/{valute}?{date}", method = RequestMethod.GET)
    public @NotNull ExchangeRate getValute(@PathVariable String valute, @PathVariable String date) {
        return predictorService.getValute(valute, date);
    }
}
