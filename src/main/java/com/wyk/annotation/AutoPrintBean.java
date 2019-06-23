package com.wyk.annotation;

/**
 * Created by k on 2019/6/18.
 */
public class AutoPrintBean {
    public void out(){
        System.out.println(this.getClass().getName());
    }
}
