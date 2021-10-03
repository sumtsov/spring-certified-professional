package com.dsumtsov.spring.testing.config;

import com.dsumtsov.spring.testing.dao.CityDAO;
import com.dsumtsov.spring.testing.model.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class DefaultDataConfiguration {

    public static final String MOSCOW = "Moscow";
    public static final String LONDON = "London";
    public static final String BERLIN = "Berlin";

    @Autowired
    private CityDAO cityDAO;

    @PostConstruct
    private void registerCities() {
        registerCity(new City(MOSCOW));
        registerCity(new City(LONDON));
        registerCity(new City(BERLIN));
    }

    private void registerCity(City city) {
        cityDAO.save(city);
    }
}
