package com.dsumtsov.basic.authentication.authorization.dao;

import com.dsumtsov.basic.authentication.authorization.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerDAO extends CrudRepository<Customer, Integer> {
}
