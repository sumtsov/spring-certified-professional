package com.dsumtsov.spring.boot.jpa.dao;

import com.dsumtsov.spring.boot.jpa.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeDAO extends CrudRepository<Employee, Integer> {
}
