package com.md.weatherapp.model.openweathermap;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherData {

    @JsonProperty(value = "main")
    private TemperatureData temperatureData;
}
