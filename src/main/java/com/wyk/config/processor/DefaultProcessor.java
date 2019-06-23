package com.wyk.config.processor;

import com.wyk.annotation.AutoPrintBean;
import com.wyk.config.ExistsBean;
import com.wyk.config.SubExsistBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * bean再被初始化前后的一些操作
 * Created by k on 2019/6/23.
 */
public class DefaultProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof ExistsBean){
            System.out.println(beanName);
            System.out.println(bean.getClass());
            return new SubExsistBean();
        }
        return bean;

    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        return bean;
    }
}
