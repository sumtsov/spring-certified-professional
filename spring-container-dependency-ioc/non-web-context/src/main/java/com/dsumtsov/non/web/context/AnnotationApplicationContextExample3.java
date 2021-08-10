package com.dsumtsov.non.web.context;

import com.dsumtsov.non.web.context.beans.SpringBean1;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationApplicationContextExample3 {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                "com.dsumtsov.non.web.context"
        );

        SpringBean1 bean1 = context.getBean(SpringBean1.class);
        bean1.test();
    }
}
