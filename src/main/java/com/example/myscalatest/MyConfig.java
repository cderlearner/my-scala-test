package com.example.myscalatest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    /**
     * scala main程序启动后 执行此段代码
     *
     * @return
     */
    @Bean
    public Test toTest() {
        Test test = new Test();
        test.setId(1);
        System.out.println("Test Id:" + test.getId());
        return test;
    }

    @Bean
    public MyTestBean toMyTestBean() {
        return new MyTestBean();
    }

    public static class Test {
        private long id;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }
    }
}
