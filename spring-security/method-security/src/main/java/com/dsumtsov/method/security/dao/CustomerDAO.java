package com.dsumtsov.method.security.dao;

import com.dsumtsov.method.security.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerDAO extends CrudRepository<Customer, Long> {
}
