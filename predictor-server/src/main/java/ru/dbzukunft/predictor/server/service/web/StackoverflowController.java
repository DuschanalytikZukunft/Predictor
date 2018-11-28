package ru.dbzukunft.predictor.server.service.web;

import com.predictor.beans.ExchangeRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.dbzukunft.predictor.server.service.service.StackoverflowService;

@RestController
@RequestMapping("/api")
public class StackoverflowController {

    private final StackoverflowService stackoverflowService;

    @Autowired
    public StackoverflowController(StackoverflowService stackoverflowService) {
        this.stackoverflowService = stackoverflowService;
    }

    @RequestMapping("/predictor")
    public ExchangeRate getListOfProviders() {
        return stackoverflowService.getCrbDaily();
    }

}
