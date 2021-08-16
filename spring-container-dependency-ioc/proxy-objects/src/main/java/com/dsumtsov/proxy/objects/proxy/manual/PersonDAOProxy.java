package com.dsumtsov.proxy.objects.proxy.manual;

import com.dsumtsov.proxy.objects.dao.PersonDAO;
import com.dsumtsov.proxy.objects.model.Person;

public class PersonDAOProxy implements PersonDAO {

    private final PersonDAO target;

    public PersonDAOProxy(PersonDAO target) {
        this.target = target;
    }

    @Override
    public Person findById(int id) {
        System.out.println("Before findById");
        Person person = target.findById(id);
        System.out.println("After findById");
        return person;
    }

    @Override
    public void save(Person person) {
        System.out.println("Before save");
        target.save(person);
        System.out.println("After save");
    }
}
