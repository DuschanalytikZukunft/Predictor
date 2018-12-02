package ru.dbzukunft.predictor.server.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.dbzukunft.predictor.server.entity.AlphaVantageTimeSeries;

@Repository
public interface AlphaVantageTimeSeriesRepository extends CrudRepository<AlphaVantageTimeSeries, Long> {
}
