package com.dsumtsov.application.testing.dao;

import com.dsumtsov.application.testing.model.City;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CityDAOTest {

    private static final City CITY_1 = new City(1L, "Los Angeles");
    private static final City CITY_2 = new City(2L, "New York");

    @Autowired
    private CityDAO cityDAO;
    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void saveCitiesTest() {

        cityDAO.saveAll(Arrays.asList(
                CITY_1,
                CITY_2
        ));

        assertEquals(CITY_1, testEntityManager.find(City.class, 1L));
        assertEquals(CITY_2, testEntityManager.find(City.class, 2L));
    }

    @Test
    public void findCityByNameTest() {

        testEntityManager.merge(CITY_1);
        testEntityManager.merge(CITY_2);

        assertEquals(CITY_1, cityDAO.findByName(CITY_1.getName()));
        assertEquals(CITY_2, cityDAO.findByName(CITY_2.getName()));
    }
}
