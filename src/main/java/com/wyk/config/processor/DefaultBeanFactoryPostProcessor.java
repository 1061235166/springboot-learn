package com.wyk.config.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * 容器被创建前的一些操作
 * Created by wyk on 2019/6/23.
 */
public class DefaultBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        Class<? extends ConfigurableListableBeanFactory> aClass = beanFactory.getClass();
        System.out.println("aClass:"+aClass);
    }
}
