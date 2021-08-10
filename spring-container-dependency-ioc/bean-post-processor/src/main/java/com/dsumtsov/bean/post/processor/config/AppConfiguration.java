package com.dsumtsov.bean.post.processor.config;

import com.dsumtsov.bean.post.processor.CustomBeanPostProcessor;
import com.dsumtsov.bean.post.processor.bean.SpringBean1;
import com.dsumtsov.bean.post.processor.bean.SpringBean2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.dsumtsov.bean.post.processor")
public class AppConfiguration {

    @Bean
    public static CustomBeanPostProcessor customBeanPostProcessor() {
        return new CustomBeanPostProcessor();
    }

    @Bean(initMethod = "initMethod")
    public SpringBean1 springBean1() {
        return new SpringBean1();
    }

    @Bean(destroyMethod = "destroyMethod")
    public SpringBean2 springBean2() {
        return new SpringBean2();
    }
}
