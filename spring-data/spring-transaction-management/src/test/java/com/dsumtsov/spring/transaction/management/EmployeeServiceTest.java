package com.dsumtsov.spring.transaction.management;

import com.dsumtsov.spring.transaction.management.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Runner.class})
public class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;

    @Test
    @Transactional
    public void shouldRollbackTransaction() {
        employeeService.methodWithTransaction();
    }

    @Test
    @Transactional
    @Rollback(false)
    public void shouldNotRollbackTransaction() {
        employeeService.methodWithTransaction();
    }
}
