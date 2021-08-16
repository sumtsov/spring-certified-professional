package com.dsumtsov.health.indicator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CustomStatusHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        return Health.status("custom-status")
                .withDetail("current-status", "custom")
                .build();
    }
}
