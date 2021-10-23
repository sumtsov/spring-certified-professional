package com.dsumtsov.spring.testing.integration;

import com.dsumtsov.spring.testing.config.AppConfiguration;
import com.dsumtsov.spring.testing.integration.config.MockitoConfiguration;
import com.dsumtsov.spring.testing.integration.config.TestDataConfiguration;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class) // if IntegrationTestBase was an interface,
// @RunWith would need to be moved to the implementing class
@ContextConfiguration(classes = {AppConfiguration.class, TestDataConfiguration.class, MockitoConfiguration.class})
public abstract class IntegrationTestBase {
}
