package com.dsumtsov.bean.post.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class CustomBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("[CustomBeanPostProcessor] postProcessBeforeInitialization on "
                + bean.getClass().getSimpleName());

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("[CustomBeanPostProcessor] postProcessAfterInitialization on "
                + bean.getClass().getSimpleName());

        return bean;
    }
}
