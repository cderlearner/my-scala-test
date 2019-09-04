package com.example.myscalatest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MySubConfig extends MyConfig {

    @Bean
    public Test toTest() {
        Test test = new Test();
        test.setId(2);
        System.out.println("22222LJX--------- Test Id:" + test.getId());
        return test;
    }

}
