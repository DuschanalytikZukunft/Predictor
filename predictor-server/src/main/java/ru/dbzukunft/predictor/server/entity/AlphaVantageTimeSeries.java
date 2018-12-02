package ru.dbzukunft.predictor.server.entity;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
@Getter
public class AlphaVantageTimeSeries {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(unique = true)
    LocalDateTime dateTime;
    Double open;
    Double high;
    Double low;
    Double close;
    Integer volume;
}
