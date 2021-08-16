package com.dsumtsov.proxy.objects.proxy.manual;

import com.dsumtsov.proxy.objects.dao.PersonDAO;
import com.dsumtsov.proxy.objects.dao.impl.PersonDAOImpl;
import com.dsumtsov.proxy.objects.model.Person;

public class Runner {

    public static void main(String[] args) {

        PersonDAO personDAO = new PersonDAOProxy(
                new PersonDAOImpl()
        );

        Person person = personDAO.findById(1);
        personDAO.save(person);
    }
}
