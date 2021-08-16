package com.dsumtsov.proxy.objects.proxy.cjlib;

import com.dsumtsov.proxy.objects.dao.impl.DepartmentDAOImpl;
import com.dsumtsov.proxy.objects.model.Department;
import org.springframework.cglib.proxy.Enhancer;

public class Runner {

    public static void main(String[] args) {

        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(new DepartmentDAOMethodInterceptor());
        enhancer.setSuperclass(DepartmentDAOImpl.class);
        DepartmentDAOImpl departmentDAO = (DepartmentDAOImpl) enhancer.create();

        Department department = departmentDAO.findById(1);
        departmentDAO.save(department);
    }
}
