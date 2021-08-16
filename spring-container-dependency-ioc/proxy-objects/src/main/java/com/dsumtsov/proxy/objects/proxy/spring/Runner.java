package com.dsumtsov.proxy.objects.proxy.spring;

import com.dsumtsov.proxy.objects.proxy.spring.config.AppConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                AppConfiguration.class);

        context.registerShutdownHook();
    }
}
