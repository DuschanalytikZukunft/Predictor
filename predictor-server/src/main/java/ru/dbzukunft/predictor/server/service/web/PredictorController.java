package ru.dbzukunft.predictor.server.service.web;

import com.predictor.beans.ExchangeRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.dbzukunft.predictor.server.service.service.PredictorService;

@RestController
@RequestMapping("/api")
public class PredictorController {

    private final PredictorService stackoverflowService;

    @Autowired
    public PredictorController(PredictorService stackoverflowService) {
        this.stackoverflowService = stackoverflowService;
    }

    @RequestMapping("/predictor")
    public ExchangeRate getListOfProviders() {
        return stackoverflowService.getCrbDaily();
    }

}
