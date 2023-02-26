package com.md.weatherapp.client;

import com.md.weatherapp.config.OpenWeatherMapConfiguration;
import com.md.weatherapp.model.openweathermap.OpenWeatherMapResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class OpenWeatherMapRestClient {
    private final RestTemplate restTemplate;
    private final OpenWeatherMapConfiguration openWeatherMapConfiguration;

    public OpenWeatherMapResponse getWeatherData(@NonNull final String cityName,
                                                 @NonNull final String countryCode) {
        final String uri = adjustEndpoint(cityName, countryCode);
        return restTemplate.getForObject(uri, OpenWeatherMapResponse.class);
    }

    private String adjustEndpoint(final String cityName,
                                  final String countryCode) {
        return String.format(openWeatherMapConfiguration.getEndpoint(), cityName, countryCode);
    }
}
