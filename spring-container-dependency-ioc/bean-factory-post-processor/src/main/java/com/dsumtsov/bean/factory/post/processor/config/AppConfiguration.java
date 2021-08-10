package com.dsumtsov.bean.factory.post.processor.config;

import com.dsumtsov.bean.factory.post.processor.CustomBeanFactoryPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.dsumtsov.bean.factory.post.processor")
@PropertySource("classpath:/application.properties")
public class AppConfiguration {

    @Bean
    public static CustomBeanFactoryPostProcessor customerBeanFactoryPostProcessor() {
        return new CustomBeanFactoryPostProcessor();
    }
}
