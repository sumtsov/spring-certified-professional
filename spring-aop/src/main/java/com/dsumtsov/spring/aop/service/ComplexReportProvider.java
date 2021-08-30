package com.dsumtsov.spring.aop.service;

import com.dsumtsov.spring.aop.annotations.Cacheable;
import com.dsumtsov.spring.aop.annotations.PerformanceLogger;
import com.dsumtsov.spring.aop.model.Report;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class ComplexReportProvider {

    @Cacheable
    @PerformanceLogger
    public Report getReport() throws InterruptedException {
        System.out.println("[Fetching the report...]");
        Thread.sleep(TimeUnit.SECONDS.toMillis(3));
        System.out.println("[Report created]");

        return new Report();
    }
}
