package com.dsumtsov.web.servlet3.annotation.context.beans;

import org.springframework.stereotype.Component;

@Component
public class SpringBean1 {

    public String test() {
        return "SpringBean1 test";
    }
}
