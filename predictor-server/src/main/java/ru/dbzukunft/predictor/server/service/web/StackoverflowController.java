package ru.dbzukunft.predictor.server.service.web;

import com.predictor.beans.PredictorWebsite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.dbzukunft.predictor.server.service.service.StackoverflowService;

@RestController
@RequestMapping("/api")
public class StackoverflowController {

    @Autowired
    private StackoverflowService stackoverflowService; //dependency injection

    @RequestMapping("/predictor/")
    public PredictorWebsite getListOfProviders() {
        return stackoverflowService.getCrbDaily();
    }

}
