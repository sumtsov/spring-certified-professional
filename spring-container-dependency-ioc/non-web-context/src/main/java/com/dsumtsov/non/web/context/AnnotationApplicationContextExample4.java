package com.dsumtsov.non.web.context;

import com.dsumtsov.non.web.context.beans.SpringBean1;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationApplicationContextExample4 {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.scan("com.dsumtsov.non.web.context");
        context.refresh();

        SpringBean1 bean1 = context.getBean(SpringBean1.class);
        bean1.test();
    }
}
