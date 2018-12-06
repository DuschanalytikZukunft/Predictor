package ru.dbzukunft.predictor.server.util.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;
import java.util.Map;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlphaVantageApiDTO implements Serializable {
    @JsonProperty(value = "Meta Data")
    Map<String, String> metaData;
    @JsonProperty(value = "Time Series (5min)")
    Map<String, Map<String, String>> timeSeries;
}
