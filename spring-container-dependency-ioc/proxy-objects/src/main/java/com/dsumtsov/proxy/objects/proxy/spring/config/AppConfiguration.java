package com.dsumtsov.proxy.objects.proxy.spring.config;

import com.dsumtsov.proxy.objects.proxy.spring.beans.SpringBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean
    SpringBean springBean() {
        System.out.println("Creating SpringBean in " + getClass().getSimpleName());
        return new SpringBean();
    }
}
