package com.dsumtsov.spring.transaction.management.service;

import com.dsumtsov.spring.transaction.management.dao.EmployeeDAO;
import com.dsumtsov.spring.transaction.management.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    public void printEmployees() {
        System.out.println("[Printing list of employees...]");
        employeeDAO.findAllEmployees().forEach(System.out::println);
    }

    public void deleteAllEmployees() {
        System.out.println("[Deleting all employees...]");
        employeeDAO.deleteAllEmployees();
    }

    public void saveEmployeesWithoutTransaction() {
        System.out.println("[Saving employees without transaction...]");
        saveEmployees();
    }

    @Transactional
    public void saveEmployeesInTransaction() {
        System.out.println("[Saving employees with transaction...]");
        saveEmployees();
    }

    private void saveEmployees() {
        employeeDAO.saveEmployee(new Employee(1, "John", "Doe", "John.Doe@corp.com", "555-55-55", Date.valueOf("2019-06-05"), 70000));
        employeeDAO.saveEmployee(new Employee(2, "Willow", "Zhang", "Willow.Zhang@corp.com", "555-55-56", Date.valueOf("2019-07-12"), 80000));
        employeeDAO.saveEmployee(new Employee(3, "Jayvon", "Grant", "Jayvon.Grant@corp.com", "555-55-57", Date.valueOf("2019-07-17"), 90000));
        employeeDAO.saveEmployee(new Employee(-1, "Shaylee", "Mcclure", "Shaylee.Mcclure@corp.com", "555-55-58", Date.valueOf("2019-07-19"), 120000));
        employeeDAO.saveEmployee(new Employee(5, "Miley", "Krueger", "Miley.Krueger@corp.com", "555-55-59", Date.valueOf("2019-07-20"), 110000));
    }
}
