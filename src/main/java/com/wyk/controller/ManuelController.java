package com.wyk.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractUrlViewController;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.mvc.SimpleControllerHandlerAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by k on 2018/12/7.
 */
public class ManuelController extends SimpleControllerHandlerAdapter {


    protected String getViewNameForRequest(HttpServletRequest request) {
        return null;
    }
}
