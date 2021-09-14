package com.dsumtsov.application.testing.controller;

import com.dsumtsov.application.testing.model.City;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CityControllerRestTemplateTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void saveCitiesTest() {
        String url = String.format("http://localhost:%d/api/v1/cities", port);

        restTemplate.postForEntity(url, City.builder().name("Los Angeles").build(), City[].class);
        restTemplate.postForEntity(url, City.builder().name("New York").build(), City[].class);

        City[] cities = restTemplate.getForEntity("/api/v1/cities", City[].class).getBody();

        assertThat(cities)
                .containsOnly(
                        new City(1L, "Los Angeles"),
                        new City(2L, "New York")
                );
    }
}
