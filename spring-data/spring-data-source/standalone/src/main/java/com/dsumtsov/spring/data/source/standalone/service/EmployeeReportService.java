package com.dsumtsov.spring.data.source.standalone.service;

import com.dsumtsov.spring.data.source.standalone.dao.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeReportService {

    @Autowired
    private EmployeeDAO employeeDAO;

    public void printReport() {
        System.out.println("[Employee Report Start]");

        employeeDAO.findEmployeeEmails()
                .forEach(System.out::println);

        System.out.println("[Employee Report Stop]");
    }
}
