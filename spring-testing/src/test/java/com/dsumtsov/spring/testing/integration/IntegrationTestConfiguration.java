package com.dsumtsov.spring.testing.integration;

import com.dsumtsov.spring.testing.config.AppConfiguration;
import com.dsumtsov.spring.testing.integration.config.MockitoConfiguration;
import com.dsumtsov.spring.testing.integration.config.TestDataConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;

@Configuration
@ContextConfiguration(classes = {TestDataConfiguration.class, MockitoConfiguration.class})
public class IntegrationTestConfiguration extends AppConfiguration {
}
