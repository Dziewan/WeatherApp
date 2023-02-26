package com.md.weatherapp.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import com.md.weatherapp.model.openweathermap.TemperatureData;
import com.md.weatherapp.model.openweathermap.WeatherData;
import lombok.NonNull;

public class TemperatureCalculator {
    private final List<TemperatureData> temperatureDataList;
    private final BigDecimal temperatureDataListSize;

    public TemperatureCalculator(@NonNull final List<WeatherData> temperatureDataList) {
        this.temperatureDataList = temperatureDataList
                .stream()
                .map(WeatherData::getTemperatureData)
                .collect(Collectors.toList());
        this.temperatureDataListSize = new BigDecimal(temperatureDataList.size());
    }

    public BigDecimal calculateAverageTemperature() {
        return calculateAverage(TemperatureData::getCurrentTemperature);
    }

    public BigDecimal calculateAveragePressure() {
        return calculateAverage(TemperatureData::getPressure);
    }

    public BigDecimal calculateAverageHumidity() {
        return calculateAverage(TemperatureData::getHumidity);
    }

    private BigDecimal calculateAverage(Function<TemperatureData, BigDecimal> parameterExtractor) {
        return temperatureDataList
                .stream()
                .map(parameterExtractor)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .divide(temperatureDataListSize, RoundingMode.CEILING);
    }
}
