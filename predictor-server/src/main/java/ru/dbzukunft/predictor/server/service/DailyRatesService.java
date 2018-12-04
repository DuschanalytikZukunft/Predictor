package ru.dbzukunft.predictor.server.service;

import ru.dbzukunft.predictor.server.Dao.DailyRatesDao;
import ru.dbzukunft.predictor.server.entity.DailyRates;

import java.util.List;

public class DailyRatesService {

    private DailyRatesDao dailyRatesDao = new DailyRatesDao();

    public DailyRatesService() {
    }

    public void saveDailyRates(DailyRates dailyRates) {
        dailyRatesDao.save(dailyRates);
    }

    public void deleteDailyRates(DailyRates dailyRates) {
        dailyRatesDao.delete(dailyRates);
    }

    public void updateDailyRates(DailyRates dailyRates) {
        dailyRatesDao.update(dailyRates);
    }

}
