package com.dsumtsov.bean.scopes;

import com.dsumtsov.bean.scopes.beans.SpringBean1;
import com.dsumtsov.bean.scopes.beans.SpringBean2;
import com.dsumtsov.bean.scopes.config.AppConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                AppConfiguration.class);

        context.registerShutdownHook();

        System.out.println(context.getBean(SpringBean1.class));
        System.out.println(context.getBean(SpringBean1.class));

        System.out.println(context.getBean(SpringBean2.class));
        System.out.println(context.getBean(SpringBean2.class));

        SpringBean2 springBean2 = context.getBean(SpringBean2.class);

        springBean2.test();
        springBean2.test();
    }
}
