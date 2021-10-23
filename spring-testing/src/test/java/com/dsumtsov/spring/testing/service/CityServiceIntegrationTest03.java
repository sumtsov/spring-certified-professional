package com.dsumtsov.spring.testing.service;

import com.dsumtsov.spring.testing.integration.IntegrationTestContextConfiguration;
import com.dsumtsov.spring.testing.model.City;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;

import static com.dsumtsov.spring.testing.integration.config.TestDataConfiguration.*;
import static org.fest.assertions.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@IntegrationTestContextConfiguration
public class CityServiceIntegrationTest03 {

    private static final String CUSTOMER_NAME = "MOCKED_NAME";

    @Autowired
    private CityService cityService;

    @Autowired
    private CustomerService customerService;

    @Test
    public void findCitiesFromTestConfigurationTest() {
        List<City> cities = cityService.findAll();

        assertThat(cities.stream()
                .map(City::getName)
                .collect(Collectors.toList()))
                .contains(NEW_YORK, ROME, PARIS);
    }

    @Test
    public void getCustomerNameTest() {
        when(customerService.getName()).thenReturn(CUSTOMER_NAME);

        String name = customerService.getName();

        assertEquals(CUSTOMER_NAME, name);
    }
}
