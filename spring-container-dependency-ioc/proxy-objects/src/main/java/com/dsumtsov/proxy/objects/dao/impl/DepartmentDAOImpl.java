package com.dsumtsov.proxy.objects.dao.impl;

import com.dsumtsov.proxy.objects.model.Department;

public class DepartmentDAOImpl {

    public Department findById(int id) {
        System.out.println("Searching for department...");
        return new Department();
    }

    public void save(Department department) {
        System.out.println("Saving department...");
    }
}
