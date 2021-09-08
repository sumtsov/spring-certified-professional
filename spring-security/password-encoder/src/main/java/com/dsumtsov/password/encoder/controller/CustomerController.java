package com.dsumtsov.password.encoder.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/api/v1/customers",
        produces = APPLICATION_JSON_VALUE)
public class CustomerController {

    @GetMapping
    public List<String> getAllCustomers() {
        return Arrays.asList(
                "customer-1",
                "customer-2",
                "customer-3"
        );
    }
}
