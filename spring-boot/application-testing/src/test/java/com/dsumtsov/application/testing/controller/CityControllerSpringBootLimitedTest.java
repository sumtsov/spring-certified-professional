package com.dsumtsov.application.testing.controller;

import com.dsumtsov.application.testing.model.City;
import com.dsumtsov.application.testing.service.CityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CityController.class)
public class CityControllerSpringBootLimitedTest {

    @Autowired
    private CityController cityController;
    @MockBean
    private CityService cityService;

    @Test
    public void saveCitiesTest() {
        cityController.saveCity(City.builder().name("Los Angeles").build());
        cityController.saveCity(City.builder().name("New York").build());
        cityController.saveCity(City.builder().name("San Francisco").build());

        verify(cityService).save(new City(null, "Los Angeles"));
        verify(cityService).save(new City(null, "New York"));
        verify(cityService).save(new City(null, "San Francisco"));
    }

    @Test
    public void getCitiesTest() {
        when(cityService.findAll())
                .thenReturn(Arrays.asList(
                        new City(1L, "Los Angeles"),
                        new City(2L, "New York")
                ));

        List<City> fetchedCities = cityController.getCities();

        assertThat(fetchedCities)
                .containsOnly(
                        new City(1L, "Los Angeles"),
                        new City(2L, "New York")
                );
    }
}
