package com.md.weatherapp.service;

import com.md.weatherapp.client.OpenWeatherMapRestClient;
import com.md.weatherapp.model.openweathermap.OpenWeatherMapResponse;
import com.md.weatherapp.model.Response;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WeatherService {
    private final OpenWeatherMapRestClient openWeatherMapRestClient;

    public Response getWeather(@NonNull final String cityName,
                               @NonNull final String countryCode) {
        final OpenWeatherMapResponse weatherMapResponse = openWeatherMapRestClient.getWeatherData(cityName, countryCode);
        final TemperatureCalculator temperatureCalculator = new TemperatureCalculator(weatherMapResponse.getWeatherData());

        return Response.builder()
                .cityName(cityName)
                .countryCode(countryCode)
                .averageTemperature(temperatureCalculator.calculateAverageTemperature())
                .averagePressure(temperatureCalculator.calculateAveragePressure())
                .averageHumidity(temperatureCalculator.calculateAverageHumidity())
                .build();
    }
}
