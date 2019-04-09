package com.kc.struts1;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class HelloAction extends ActionSupport {

    @Override
    public String execute() throws Exception {
        System.out.println("hello");
        return Action.SUCCESS;
    }
}
