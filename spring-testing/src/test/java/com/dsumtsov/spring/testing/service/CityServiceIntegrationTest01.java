package com.dsumtsov.spring.testing.service;

import com.dsumtsov.spring.testing.config.AppConfiguration;
import com.dsumtsov.spring.testing.model.City;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class) // does not load ApplicationContext;
// it acts as a bridge between Spring Test features and JUnit;
// it enables spring boot features like @Autowire, @MockBean, etc... during junit testing
@ContextConfiguration(classes = AppConfiguration.class) // loads ApplicationContext for test
public class CityServiceIntegrationTest01 {

    private static final String MOSCOW = "Moscow";
    private static final String CUSTOMER_NAME = "MOCKED_NAME";

    @Autowired
    private CityService cityService;

    @Autowired
    private CustomerService customerService;

    @Test
    @Transactional
    @DirtiesContext // it indicates the associated test or class modifies the ApplicationContext;
                    // it tells the testing framework to close and recreate the context for later tests
    public void findCityTest() {

        City city = cityService.find(MOSCOW);

        assertEquals(MOSCOW, city.getName());
    }

    @Test
    public void getCustomerNameTest() {
        when(customerService.getName()).thenReturn(CUSTOMER_NAME);

        String name = customerService.getName();

        assertEquals(CUSTOMER_NAME, name);
    }

    @BeforeTransaction
    private void beforeTransaction() {
        System.out.println("BEFORE TRANSACTION");
    }

    @AfterTransaction
    private void afterTransaction() {
        System.out.println("AFTER TRANSACTION");
    }

    // one of the ways to put mock into context without Spring Boot
    @Configuration
    public static class MockConfiguration {

        @Bean
        @Primary
        public CustomerService customerService() {
            return Mockito.mock(CustomerService.class);
        }
    }
}