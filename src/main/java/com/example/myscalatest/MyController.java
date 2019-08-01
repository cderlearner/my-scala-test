package com.example.myscalatest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Autowired
    private CachedUserDao cachedUserDao;
    @Autowired
    private MyTestBean myTestBean;
    @Autowired
    private ScalaJdbcPrivacyForwardingDao forwardingDao;

    @RequestMapping("/hello")
    public void hello() {
        System.out.println(cachedUserDao.selectFrom(1, 1));
        myTestBean.testBean2();

        System.err.println("000000000000000000000000000000");
        //System.out.println(scalaJdbcPrivacyDao.getDatasource().name());
        System.out.println(forwardingDao.getScalaJdbcPrivacyDao().jdbcTemplate().getScalaJdbcDatasource().name());
    }
}
