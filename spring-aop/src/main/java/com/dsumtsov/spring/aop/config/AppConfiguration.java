package com.dsumtsov.spring.aop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.dsumtsov.spring.aop")
@EnableAspectJAutoProxy
public class AppConfiguration {
}
