package com.dsumtsov.proxy.objects.dao.impl;

import com.dsumtsov.proxy.objects.dao.PersonDAO;
import com.dsumtsov.proxy.objects.model.Person;

public class PersonDAOImpl implements PersonDAO {

    @Override
    public Person findById(int id) {
        System.out.println("Searching for person...");
        return new Person();
    }

    @Override
    public void save(Person person) {
        System.out.println("Saving person...");
    }
}
