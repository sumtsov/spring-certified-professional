package com.dsumtsov.application.testing.controller;

import com.dsumtsov.application.testing.model.City;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@JsonTest
public class CityJsonConverterTest {

    @Autowired
    private JacksonTester<City> json;

    @Test
    public void serializationTest() throws IOException {
        City city = new City(1L, "New York");

        String json = this.json.write(city).getJson();

        assertEquals(json, "{\"id\":1,\"name\":\"New York\"}");
    }

    @Test
    public void deserializationTest() throws IOException {
        City city = json.parse("{\"id\":1,\"name\":\"New York\"}").getObject();

        assertEquals(Long.valueOf(1), city.getId());
        assertEquals("New York", city.getName());
    }
}
