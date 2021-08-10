package com.dsumtsov.non.web.context;

import com.dsumtsov.non.web.context.beans.SpringBean1;
import com.dsumtsov.non.web.context.config.AppConfiguration2;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationApplicationContextExample2 {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                AppConfiguration2.class
        );

        SpringBean1 bean1 = context.getBean(SpringBean1.class);
        bean1.test();
    }
}
