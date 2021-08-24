package com.dsumtsov.spring.data.source.application.server.controller;

import com.dsumtsov.spring.data.source.application.server.dao.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @Autowired
    private EmployeeDAO employeeDAO;

    @RequestMapping
    @ResponseBody
    public String index() {
        return String.join(", ", employeeDAO.findEmployeeEmails());
    }
}
