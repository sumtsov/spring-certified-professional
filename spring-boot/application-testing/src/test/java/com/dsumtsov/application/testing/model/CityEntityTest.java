package com.dsumtsov.application.testing.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CityEntityTest {

    private static final City CITY_1 = new City(1L, "Los Angeles");
    private static final City CITY_2 = new City(2L, "New York");

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void saveAndFindByIdTest() {

        testEntityManager.merge(CITY_1);
        testEntityManager.merge(CITY_2);

        assertEquals(CITY_1, testEntityManager.find(City.class, 1L));
        assertEquals(CITY_2, testEntityManager.find(City.class, 2L));
    }
}
