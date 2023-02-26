package com.md.weatherapp.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RootUriTemplateHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfiguration {
    private final OpenWeatherMapConfiguration openWeatherMapConfiguration;

    @Bean
    public RestTemplate restTemplate() {
        final RestTemplate restTemplate = new RestTemplate();
        restTemplate.setUriTemplateHandler(new RootUriTemplateHandler(openWeatherMapConfiguration.getBaseUrl()));
        return restTemplate;
    }
}
