package com.dsumtsov.spring.jdbc.callbacks.service;

import com.dsumtsov.spring.jdbc.callbacks.dao.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeReportService {

    @Autowired
    private EmployeeDAO employeeDAO;

    public void printReport() {

        System.out.println("[Employee Report Start]");

        System.out.println("Employees List:");
        employeeDAO.findEmployees()
                .forEach(System.out::println);

        System.out.println("Employees Average Salary Calculated Row by Row:");
        System.out.println(employeeDAO.findAverageSalaryRowByRow());

        System.out.println("Employees Average Salary Calculated on Entire Result Set:");
        System.out.println(employeeDAO.findAverageSalaryCalculatedOnEntireResultSet());

        System.out.println("Employee found based on email:");
        System.out.println(employeeDAO.findEmployeeIdFromEmail("Jayvon.Grant@corp.com"));

        System.out.println("[Employee Report Stop]");
    }
}
