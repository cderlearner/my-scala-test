package com.example.myscalatest;

import com.typesafe.config.ConfigFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyScalaTestApplication {

    public static void main(String[] args) {
        System.out.println("tomcat.port:" + ConfigFactory.load().getString("uc.tomcat.server.port"));
        System.out.println("tomcat.threads:" + ConfigFactory.load().getString("uc.tomcat.max.threads"));
        SpringApplication.run(MyScalaTestApplication.class, args);

//        Set<Long> sets = new HashSet<Long>();
//        sets.add(1L);
//        System.out.println(sets.contains(Optional.of(1)));
//        System.out.println(sets.contains(new Long(1)));
//        System.out.println(new Long(1).hashCode());
//        System.out.println(Optional.of(1).hashCode());
    }

    @Bean
    public String helloBean() {
        return "hello";
    }

    @Bean
    public String testBean(String helloBean) {
        Boolean isSnowBall = Boolean.FALSE;
        System.out.println(Boolean.TRUE.equals(isSnowBall));
        System.out.println("1---------" + helloBean);
        return helloBean;
    }

    @Bean
    public String test2Bean(String helloBean) {
        System.out.println("2---------" + helloBean);
        return helloBean;
    }

}
