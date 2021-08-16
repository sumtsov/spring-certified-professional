package com.dsumtsov.proxy.objects.proxy.jdk;

import com.dsumtsov.proxy.objects.dao.PersonDAO;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PersonDAOInvocationHandler implements InvocationHandler {

    private final PersonDAO target;

    public PersonDAOInvocationHandler(PersonDAO target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] args) throws Throwable {

        System.out.println("Before " + method.getName());
        Object result = method.invoke(target, args);
        System.out.println("After " + method.getName());
        return result;
    }
}
