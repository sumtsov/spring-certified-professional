package com.dsumtsov.bean.factory.post.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import java.util.Arrays;
import java.util.Objects;

public class CustomBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        Arrays.stream(beanFactory.getBeanDefinitionNames())
                .map(beanFactory::getBeanDefinition)
                .filter(beanDefinition -> Objects.nonNull(beanDefinition.getBeanClassName())
                        && beanDefinition.getBeanClassName().contains(
                                "com.dsumtsov.bean.factory.post.processor.beans"))
                .map(BeanDefinition::getBeanClassName)
                .forEach(beanClassName -> System.out.println(
                        "[CustomBeanFactoryPostProcessor] "
                                + beanClassName
                                + " bean definition processed"));
    }
}
