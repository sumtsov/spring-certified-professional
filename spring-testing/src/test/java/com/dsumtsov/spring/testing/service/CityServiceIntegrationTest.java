package com.dsumtsov.spring.testing.service;

import com.dsumtsov.spring.testing.config.AppConfiguration;
import com.dsumtsov.spring.testing.model.City;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class) // does not load ApplicationContext;
// it acts as a bridge between Spring Test features and JUnit;
// it enables spring boot features like @Autowire, @MockBean, etc... during junit testing
@ContextConfiguration(classes = AppConfiguration.class) // loads ApplicationContext for test
public class CityServiceIntegrationTest {

    private static final String MOSCOW = "Moscow";

    @Autowired
    private CityService cityService;

    @Test
    @DirtiesContext
    public void findCityTest() {

        City city = cityService.find(MOSCOW);

        assertEquals(MOSCOW, city.getName());
    }
}
