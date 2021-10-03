package com.dsumtsov.spring.testing.model;

import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class CityUnitTest {

    private static final Long CITY_ID = new Random().nextLong();

    @Test
    public void setCityIdTest() {

        City city = new City();

        ReflectionTestUtils.setField(city, "id", CITY_ID, Long.class);

        assertEquals(CITY_ID, city.getId());
    }
}
