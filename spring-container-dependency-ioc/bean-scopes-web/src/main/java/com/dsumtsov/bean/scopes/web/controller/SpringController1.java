package com.dsumtsov.bean.scopes.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SpringController1 {

    @RequestMapping
    @ResponseBody
    public String index() {
        return "Start page";
    }
}
