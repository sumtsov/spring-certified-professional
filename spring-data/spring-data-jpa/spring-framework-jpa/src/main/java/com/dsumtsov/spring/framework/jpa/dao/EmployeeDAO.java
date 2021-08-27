package com.dsumtsov.spring.framework.jpa.dao;

import com.dsumtsov.spring.framework.jpa.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeDAO extends CrudRepository<Employee, Integer> {
}
