package com.wyk.annotation;

/**
 * Created by wyk on 2019/6/18.
 */
public class AutoPrintBean {
    public void out(){
        System.out.println(this.getClass().getName());
    }
}
