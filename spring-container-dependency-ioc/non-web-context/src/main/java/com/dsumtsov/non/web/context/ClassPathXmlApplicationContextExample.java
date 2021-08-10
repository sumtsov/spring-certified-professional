package com.dsumtsov.non.web.context;

import com.dsumtsov.non.web.context.beans.SpringBean1;
import com.dsumtsov.non.web.context.beans.SpringBean2;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClassPathXmlApplicationContextExample {

    public static void main(String[] args) {

        // providing file located on the classpath
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/beans.xml");

        SpringBean1 bean1 = context.getBean(SpringBean1.class);
        SpringBean2 bean2 = context.getBean(SpringBean2.class);

        bean1.test();
        bean2.test();
    }
}
