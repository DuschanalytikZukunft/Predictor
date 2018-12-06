package ru.dbzukunft.predictor.server.entity;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Builder
@Getter
public class AlphaVantageMetaData {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String information;
    String symbol;
    @Column(unique = true)
    ZonedDateTime lastRefreshed;
    String interval;
    String outputSize;
}
