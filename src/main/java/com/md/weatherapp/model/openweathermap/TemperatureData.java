package com.md.weatherapp.model.openweathermap;

import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TemperatureData {

    @JsonProperty(value = "temp")
    private BigDecimal currentTemperature;

    @JsonProperty(value = "pressure")
    private BigDecimal pressure;

    @JsonProperty(value = "humidity")
    private BigDecimal humidity;
}
