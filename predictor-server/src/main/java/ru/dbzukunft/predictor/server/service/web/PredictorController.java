package ru.dbzukunft.predictor.server.service.web;

import com.predictor.beans.ExchangeRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.dbzukunft.predictor.server.service.service.PredictorService;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PredictorController {

    private final PredictorService stackoverflowService;

    @Autowired
    public PredictorController(PredictorService stackoverflowService) {
        this.stackoverflowService = stackoverflowService;
    }

    @RequestMapping("/predictor")
    public @NotNull List<ExchangeRate> getListOfProviders() {
        return stackoverflowService.getCrbDaily();
    }

}
