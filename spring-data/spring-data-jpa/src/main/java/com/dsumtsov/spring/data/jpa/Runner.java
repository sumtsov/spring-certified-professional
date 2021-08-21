package com.dsumtsov.spring.data.jpa;

import com.dsumtsov.spring.data.jpa.service.EmployeeService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@ComponentScan
@EnableAspectJAutoProxy
public class Runner {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Runner.class);
        context.registerShutdownHook();

        EmployeeService employeeService = context.getBean(EmployeeService.class);

        employeeService.saveAllEmployees();

        employeeService.listAllEmployees();
    }
}