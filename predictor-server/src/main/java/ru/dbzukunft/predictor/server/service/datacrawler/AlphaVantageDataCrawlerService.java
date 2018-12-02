package ru.dbzukunft.predictor.server.service.datacrawler;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.dbzukunft.predictor.server.entity.AlphaVantageMetaData;
import ru.dbzukunft.predictor.server.entity.AlphaVantageTimeSeries;
import ru.dbzukunft.predictor.server.repository.AlphaVantageMetaDataRepository;
import ru.dbzukunft.predictor.server.repository.AlphaVantageTimeSeriesRepository;
import ru.dbzukunft.predictor.server.util.dto.AlphaVantageApiDTO;
import ru.dbzukunft.predictor.server.util.exception.ServerException;
import ru.dbzukunft.predictor.server.util.mapper.AlphaVantageMapper;

import java.util.List;

@Service
@EnableScheduling
@AllArgsConstructor
public class AlphaVantageDataCrawlerService implements DataCrawlerService {

    private RestTemplate restTemplate;
    private String alphaVantageUrl;
    private AlphaVantageMetaDataRepository metaDataRepository;
    private AlphaVantageTimeSeriesRepository timeSeriesRepository;

    @Override
    @Scheduled(fixedRate = 10000)
    public void getDataFromApi() {
        ResponseEntity<AlphaVantageApiDTO> responseEntity = restTemplate.getForEntity(alphaVantageUrl, AlphaVantageApiDTO.class);

        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            AlphaVantageMetaData metaData = AlphaVantageMapper.mapMetaData(responseEntity.getBody());

            if (!metaDataRepository.existsByLastRefreshed(metaData.getLastRefreshed())) {
                List<AlphaVantageTimeSeries> timeSeries = AlphaVantageMapper.mapTimeSeries(responseEntity.getBody());
                timeSeriesRepository.saveAll(timeSeries);
                metaDataRepository.save(metaData);
                System.out.println("ADDED");
            } else {
                System.out.println("CANCELED");
            }

        } else {
            throw new ServerException();
        }
    }

}
