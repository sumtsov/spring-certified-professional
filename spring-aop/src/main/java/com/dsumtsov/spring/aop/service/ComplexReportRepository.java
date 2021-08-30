package com.dsumtsov.spring.aop.service;

import com.dsumtsov.spring.aop.annotations.PerformanceLogger;
import com.dsumtsov.spring.aop.model.Report;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class ComplexReportRepository {

    @PerformanceLogger
    public void save(Report report) throws InterruptedException {
        System.out.println("[Saving the report...]");
        Thread.sleep(TimeUnit.SECONDS.toMillis(2));
        System.out.println("[Report saved]");
    }
}
