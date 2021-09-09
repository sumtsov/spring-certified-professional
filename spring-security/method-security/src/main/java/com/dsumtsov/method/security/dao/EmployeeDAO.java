package com.dsumtsov.method.security.dao;

import com.dsumtsov.method.security.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeDAO extends CrudRepository<Employee, Long> {
}
