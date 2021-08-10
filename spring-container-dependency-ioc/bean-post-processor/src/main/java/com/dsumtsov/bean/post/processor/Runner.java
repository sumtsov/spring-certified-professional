package com.dsumtsov.bean.post.processor;

import com.dsumtsov.bean.post.processor.config.AppConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
        context.registerShutdownHook();
    }
}
