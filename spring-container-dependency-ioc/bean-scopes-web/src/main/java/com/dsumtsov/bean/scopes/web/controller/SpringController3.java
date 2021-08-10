package com.dsumtsov.bean.scopes.web.controller;

import com.dsumtsov.bean.scopes.web.beans.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Scope("prototype")
@RequestMapping("controller/prototype")
public class SpringController3 {

    private final SpringBean1 springBean1;
    private final SpringBean2 springBean2;
    private final SpringBean3 springBean3;
    private final SpringBean4 springBean4;
    private final SpringBean5 springBean5;

    public SpringController3(SpringBean1 springBean1,
                             SpringBean2 springBean2,
                             SpringBean3 springBean3,
                             SpringBean4 springBean4,
                             SpringBean5 springBean5) {

        this.springBean1 = springBean1;
        this.springBean2 = springBean2;
        this.springBean3 = springBean3;
        this.springBean4 = springBean4;
        this.springBean5 = springBean5;
    }

    @RequestMapping
    @ResponseBody
    public String index() {
        return "<pre>" +
                springBean1 + " - Singleton\n" +
                springBean2 + " - Prototype\n" +
                springBean3 + " - Request Scope\n" +
                springBean4 + " - Session Scope\n" +
                springBean5 + " - Application Scope\n" +
                "</pre>";
    }
}
