package com.wyk.annotation;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * 自动配置类，使用该配置，会自动引入AutoPrintBean实例
 * Created by k on 2019/6/18.
 */
@Import(AutoPrintBean.class)
@Configuration
//@EnableAutoConfiguration
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoPrint {
}
