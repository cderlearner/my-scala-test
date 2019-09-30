package com.example.myscalatest.apply_test;

import scala.Function1;

public class DelegateJava {

    <T> T withDelegate(Function1<Delegate, T> func) {
        Delegate delegate = new Delegate();
        T result = func.apply(delegate);
        System.out.println("WithDelegate Result:" + result);
        return result;
    }
}
