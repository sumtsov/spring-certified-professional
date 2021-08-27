package com.dsumtsov.spring.transaction.management;

import com.dsumtsov.spring.transaction.management.service.EmployeeService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class Runner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Runner.class);
        context.registerShutdownHook();

        EmployeeService employeeService = context.getBean(EmployeeService.class);

        saveWithoutTransaction(employeeService);
        saveInTransaction(employeeService);
    }

    private static void saveWithoutTransaction(EmployeeService employeeService) {

        try {
            employeeService.saveEmployeesWithoutTransaction();
        } catch (Exception e) {
            System.out.println("Exception during saving employees: " + e.getMessage());
        }
        employeeService.printEmployees();
        employeeService.deleteAllEmployees();
    }

    private static void saveInTransaction(EmployeeService employeeService) {

        try {
            employeeService.saveEmployeesInTransaction();
        } catch (Exception e) {
            System.out.println("Exception during saving employees: " + e.getMessage());
        }
        employeeService.printEmployees();
        employeeService.deleteAllEmployees();
    }
}
