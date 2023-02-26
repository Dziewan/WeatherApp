package com.md.weatherapp.model.openweathermap;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenWeatherMapResponse {

    @JsonProperty(value = "list")
    private List<WeatherData> weatherData;
}
