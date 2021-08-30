package com.dsumtsov.spring.aop;

import com.dsumtsov.spring.aop.config.AppConfiguration;
import com.dsumtsov.spring.aop.service.ComplexReportAction;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {

    public static void main(String[] args) throws InterruptedException {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
        context.registerShutdownHook();

        ComplexReportAction complexReportAction = context.getBean(ComplexReportAction.class);

        complexReportAction.perform();
    }
}
