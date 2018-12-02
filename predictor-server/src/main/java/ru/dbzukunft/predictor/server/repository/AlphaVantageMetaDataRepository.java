package ru.dbzukunft.predictor.server.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.dbzukunft.predictor.server.entity.AlphaVantageMetaData;

import java.time.ZonedDateTime;

@Repository
public interface AlphaVantageMetaDataRepository extends CrudRepository<AlphaVantageMetaData, Long> {
    boolean existsByLastRefreshed(ZonedDateTime lastRefreshed);
}
