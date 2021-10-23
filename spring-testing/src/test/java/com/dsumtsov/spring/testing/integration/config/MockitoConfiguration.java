package com.dsumtsov.spring.testing.integration.config;

import com.dsumtsov.spring.testing.service.CustomerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.mockito.Mockito.mock;

@Configuration
public class MockitoConfiguration {

    @Bean
    public CustomerService guestSharableDataService() {
        return mock(CustomerService.class);
    }
}
