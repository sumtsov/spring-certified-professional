package com.dsumtsov.spring.aop.service;

import com.dsumtsov.spring.aop.annotations.PerformanceLogger;
import com.dsumtsov.spring.aop.model.FormattedReport;
import com.dsumtsov.spring.aop.model.Report;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class ComplexReportFormatter {

    @PerformanceLogger
    public FormattedReport formatReport(Report report) throws InterruptedException {
        System.out.println("[Formatting the report...]");
        Thread.sleep(TimeUnit.SECONDS.toMillis(1));
        System.out.println("[Report Formatted]");

        return new FormattedReport(report);
    }
}
