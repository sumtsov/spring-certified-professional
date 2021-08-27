package com.dsumtsov.spring.framework.jpa.service;

import com.dsumtsov.spring.framework.jpa.dao.EmployeeDAO;
import com.dsumtsov.spring.framework.jpa.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Transactional
    public void saveAllEmployees() {

        System.out.println("[Saving all employees...]");

        employeeDAO.save(new Employee(1, "John", "Doe", "John.Doe@corp.com", "555-55-55", Date.valueOf("2019-06-05"), 70000));
        employeeDAO.save(new Employee(2, "Willow", "Zhang", "Willow.Zhang@corp.com", "555-55-56", Date.valueOf("2019-07-12"), 80000));
        employeeDAO.save(new Employee(3, "Jayvon", "Grant", "Jayvon.Grant@corp.com", "555-55-57", Date.valueOf("2019-07-17"), 90000));
        employeeDAO.save(new Employee(4, "Shaylee", "Mcclure", "Shaylee.Mcclure@corp.com", "555-55-58", Date.valueOf("2019-07-19"), 120000));
        employeeDAO.save(new Employee(5, "Miley", "Krueger", "Miley.Krueger@corp.com", "555-55-59", Date.valueOf("2019-07-20"), 110000));

        System.out.println("[Saved all employees]");
    }

    @Transactional
    public void listAllEmployees() {

        System.out.println("[Listing all employees...]");

        employeeDAO.findAll().forEach(System.out::println);
    }
}

