package com.dsumtsov.proxy.objects.dao;

import com.dsumtsov.proxy.objects.model.Person;

public interface PersonDAO {

    Person findById(int id);
    void save(Person person);
}
