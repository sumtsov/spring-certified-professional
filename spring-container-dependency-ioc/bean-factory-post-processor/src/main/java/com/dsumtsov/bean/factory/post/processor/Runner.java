package com.dsumtsov.bean.factory.post.processor;

import com.dsumtsov.bean.factory.post.processor.beans.AppProperties;
import com.dsumtsov.bean.factory.post.processor.config.AppConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfiguration.class);

        context.registerShutdownHook();

        AppProperties appProperties = context.getBean(AppProperties.class);
        appProperties.printProperties();
    }
}
