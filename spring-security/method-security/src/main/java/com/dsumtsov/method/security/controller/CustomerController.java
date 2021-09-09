package com.dsumtsov.method.security.controller;

import com.dsumtsov.method.security.dao.CustomerDAO;
import com.dsumtsov.method.security.model.Customer;
import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.List;

import static com.dsumtsov.method.security.security.constants.SecurityRoles.CUSTOMERS_ADMIN;
import static com.dsumtsov.method.security.security.constants.SecurityRoles.ROLE_PREFIX;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/api/v1/customers",
        produces = APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerDAO customerDAO;

    @GetMapping
    @RolesAllowed(ROLE_PREFIX + CUSTOMERS_ADMIN)
    public List<Customer> getAllCustomers() {
        return Lists.newArrayList(customerDAO.findAll());
    }
}
