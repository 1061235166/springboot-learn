package com.wyk.config;

import org.springframework.context.annotation.Conditional;

/**
 * Created by k on 2019/6/23.
 */

public class ExistsBean {

    public ExistsBean() {
        System.out.println(this.getClass()+"被实例化");
    }

}
