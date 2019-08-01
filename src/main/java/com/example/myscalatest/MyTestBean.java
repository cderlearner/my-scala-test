package com.example.myscalatest;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class MyTestBean {
    @Autowired
    private MyTestBean2 myTestBean2;

    @PostConstruct
    protected void init() {
        System.out.println("Hello MyTestBean init.");
        myTestBean2.helloTestBean2();
    }

    public void testBean2() {
        myTestBean2.helloTestBean2();
    }
}
