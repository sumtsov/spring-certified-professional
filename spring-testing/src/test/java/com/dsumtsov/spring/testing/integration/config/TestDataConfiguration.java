package com.dsumtsov.spring.testing.integration.config;

import com.dsumtsov.spring.testing.model.City;
import com.dsumtsov.spring.testing.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class TestDataConfiguration {

    public static final String NEW_YORK = "New York";
    public static final String ROME = "Rome";
    public static final String PARIS = "Paris";

    @Autowired
    private CityService cityService;

    @PostConstruct
    private void registerCities() {
        cityService.save(new City(NEW_YORK));
        cityService.save(new City(ROME));
        cityService.save(new City(PARIS));
    }
}
