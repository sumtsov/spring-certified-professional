package com.dsumtsov.web.servlet3.annotation.context.controller;

import com.dsumtsov.web.servlet3.annotation.context.beans.SpringBean1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SpringController {

    @Autowired
    private SpringBean1 springBean1;

    @RequestMapping
    @ResponseBody
    public String index() {
        return springBean1.test();
    }
}
