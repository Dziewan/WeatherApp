package com.md.weatherapp.controller;

import com.md.weatherapp.model.Response;
import com.md.weatherapp.service.WeatherService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/weather")
public class WeatherController {
    private final WeatherService weatherService;

    @GetMapping
    public ResponseEntity<Response> getWeather(@RequestParam @NonNull final String cityName,
                                               @RequestParam @NonNull final String countryCode) {
        return ResponseEntity.ok(weatherService.getWeather(cityName, countryCode));
    }
}
