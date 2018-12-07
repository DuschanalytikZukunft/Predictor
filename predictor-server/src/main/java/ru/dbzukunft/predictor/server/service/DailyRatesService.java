package ru.dbzukunft.predictor.server.service;

import ru.dbzukunft.predictor.server.Dao.DailyRatesDao;
import ru.dbzukunft.predictor.server.entity.DailyRate;

public class DailyRatesService {

    private DailyRatesDao dailyRatesDao = new DailyRatesDao();

    public DailyRatesService() {
    }

    public void saveDailyRates(DailyRate dailyRate) {
        dailyRatesDao.save(dailyRate);
    }

    public void deleteDailyRates(DailyRate dailyRate) {
        dailyRatesDao.delete(dailyRate);
    }

    public void updateDailyRates(DailyRate dailyRate) {
        dailyRatesDao.update(dailyRate);
    }

}
