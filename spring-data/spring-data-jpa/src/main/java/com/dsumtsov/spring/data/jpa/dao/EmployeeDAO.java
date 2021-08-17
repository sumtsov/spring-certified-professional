package com.dsumtsov.spring.data.jpa.dao;

import com.dsumtsov.spring.data.jpa.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeDAO extends CrudRepository<Employee, Integer> {
}
