package ru.dbzukunft.predictor.server.util.mapper;

import ru.dbzukunft.predictor.server.entity.AlphaVantageMetaData;
import ru.dbzukunft.predictor.server.entity.AlphaVantageTimeSeries;
import ru.dbzukunft.predictor.server.util.dto.AlphaVantageApiDTO;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class AlphaVantageMapper {
    private static final String ZONED_DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ssVV";
    private static final String LOCAL_DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    private static final DateTimeFormatter ZONED_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(ZONED_DATE_TIME_PATTERN);
    private static final DateTimeFormatter LOCAL_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(LOCAL_DATE_TIME_PATTERN);

    public static AlphaVantageApiDTO map(AlphaVantageMetaData metaData, List<AlphaVantageTimeSeries> timeSeries) {
        return null;
    }

    public static AlphaVantageMetaData mapMetaData(AlphaVantageApiDTO dto) {

        ZonedDateTime zonedDateTime = ZonedDateTime.parse(
                dto.getMetaData().get("3. Last Refreshed")
                        + dto.getMetaData().get("6. Time Zone"),
                ZONED_DATE_TIME_FORMATTER);
        return AlphaVantageMetaData.builder()
                .information(dto.getMetaData().get("1. Information"))
                .symbol(dto.getMetaData().get("2. Symbol"))
                .lastRefreshed(zonedDateTime)
                .interval(dto.getMetaData().get("4. Interval"))
                .outputSize(dto.getMetaData().get("5. Output Size"))
                .build();
    }

    public static List<AlphaVantageTimeSeries> mapTimeSeries(AlphaVantageApiDTO dto) {
        return dto.getTimeSeries().entrySet().stream()
                .map(o -> AlphaVantageTimeSeries.builder()
                        .dateTime(LocalDateTime.parse(o.getKey(), LOCAL_DATE_TIME_FORMATTER))
                        .open(Double.parseDouble(o.getValue().get("1. open")))
                        .high(Double.parseDouble(o.getValue().get("2. high")))
                        .low(Double.parseDouble(o.getValue().get("3. low")))
                        .close(Double.parseDouble(o.getValue().get("4. close")))
                        .volume(Integer.parseInt(o.getValue().get("5. volume")))
                        .build())
                .collect(Collectors.toList());
    }
}
