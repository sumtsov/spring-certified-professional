package com.dsumtsov.proxy.objects.proxy.jdk;

import com.dsumtsov.proxy.objects.dao.PersonDAO;
import com.dsumtsov.proxy.objects.dao.impl.PersonDAOImpl;
import com.dsumtsov.proxy.objects.model.Person;

import java.lang.reflect.Proxy;

public class Runner {

    public static void main(String[] args) {
        PersonDAO personDAO = (PersonDAO) Proxy.newProxyInstance(
                PersonDAO.class.getClassLoader(), PersonDAOImpl.class.getInterfaces(),
                new PersonDAOInvocationHandler(
                        new PersonDAOImpl()
                )
        );

        Person person = personDAO.findById(1);
        personDAO.save(person);
    }
}
