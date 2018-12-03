package ru.dbzukunft.predictor.server.service.datacrawler;

public interface DataCrawlerService<T> {
    void getDataFromApi();
    void saveCrawlerData(T t);
}
