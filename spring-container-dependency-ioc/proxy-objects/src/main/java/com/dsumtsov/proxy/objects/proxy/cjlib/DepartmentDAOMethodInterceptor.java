package com.dsumtsov.proxy.objects.proxy.cjlib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class DepartmentDAOMethodInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {

        System.out.println("Before " + method.getName());
        Object result = methodProxy.invokeSuper(object, args);
        System.out.println("After " + method.getName());
        return result;
    }
}
