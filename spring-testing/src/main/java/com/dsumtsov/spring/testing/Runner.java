package com.dsumtsov.spring.testing;

import com.dsumtsov.spring.testing.config.AppConfiguration;
import com.dsumtsov.spring.testing.model.City;
import com.dsumtsov.spring.testing.service.CityService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
        context.registerShutdownHook();

        CityService cityService = context.getBean(CityService.class);

        City city1 = cityService.find("Moscow");
        System.out.println(city1);
    }
}
