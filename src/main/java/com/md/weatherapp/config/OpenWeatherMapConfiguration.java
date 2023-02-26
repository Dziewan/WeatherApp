package com.md.weatherapp.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "config.openweathermap")
public class OpenWeatherMapConfiguration {
    private String baseUrl;
    private String endpoint;
}
