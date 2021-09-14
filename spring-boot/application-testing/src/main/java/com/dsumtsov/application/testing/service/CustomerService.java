package com.dsumtsov.application.testing.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class CustomerService {

    private String[] names = {"John", "Dave", "Tom"};
    private Random random = new Random();

    public String getName() {
        return names[random.nextInt(names.length)];
    }
}
