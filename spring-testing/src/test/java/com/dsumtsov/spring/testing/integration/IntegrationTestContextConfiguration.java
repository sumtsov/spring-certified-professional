package com.dsumtsov.spring.testing.integration;

import com.dsumtsov.spring.testing.config.AppConfiguration;
import com.dsumtsov.spring.testing.integration.config.MockitoConfiguration;
import com.dsumtsov.spring.testing.integration.config.TestDataConfiguration;
import org.springframework.test.context.ContextConfiguration;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@ContextConfiguration(classes = {AppConfiguration.class, TestDataConfiguration.class, MockitoConfiguration.class})
public @interface IntegrationTestContextConfiguration {
}

