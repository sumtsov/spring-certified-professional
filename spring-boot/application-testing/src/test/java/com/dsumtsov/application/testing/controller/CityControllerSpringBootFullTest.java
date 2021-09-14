package com.dsumtsov.application.testing.controller;

import com.dsumtsov.application.testing.model.City;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CityControllerSpringBootFullTest {

    @Autowired
    private CityController cityController;

    @Test
    public void saveCitiesTest() {
        cityController.saveCity(City.builder().name("Los Angeles").build());
        cityController.saveCity(City.builder().name("New York").build());
        cityController.saveCity(City.builder().name("San Francisco").build());

        assertThat(cityController.getCities())
                .containsOnly(
                        new City(1L, "Los Angeles"),
                        new City(2L, "New York"),
                        new City(3L, "San Francisco")
                );
    }
}
