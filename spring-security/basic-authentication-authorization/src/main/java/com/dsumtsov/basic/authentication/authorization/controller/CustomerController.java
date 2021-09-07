package com.dsumtsov.basic.authentication.authorization.controller;

import com.dsumtsov.basic.authentication.authorization.dao.CustomerDAO;
import com.dsumtsov.basic.authentication.authorization.model.Customer;
import com.dsumtsov.basic.authentication.authorization.security.annotations.IsCustomerRead;
import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/api/v1/customers",
        produces = APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerDAO customerDAO;

    @IsCustomerRead
    @GetMapping
    public List<Customer> getAllCustomers() {
        return Lists.newArrayList(customerDAO.findAll());
    }
}
