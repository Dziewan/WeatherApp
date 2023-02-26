package com.md.weatherapp.model;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Response {
    private String cityName;
    private String countryCode;
    private BigDecimal averageTemperature;
    private BigDecimal averagePressure;
    private BigDecimal averageHumidity;
}
