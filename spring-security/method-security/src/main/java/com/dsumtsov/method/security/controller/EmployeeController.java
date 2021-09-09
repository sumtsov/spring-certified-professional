package com.dsumtsov.method.security.controller;

import com.dsumtsov.method.security.dao.EmployeeDAO;
import com.dsumtsov.method.security.model.Employee;
import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/api/v1/employees",
        produces = APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeDAO employeeDAO;

    @GetMapping
    @PreAuthorize("hasRole('ROLE_EMPLOYEES_ADMIN')")
    public List<Employee> getAllEmployees() {
        return Lists.newArrayList(employeeDAO.findAll());
    }
}
