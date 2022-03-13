package com.fc.test;

import com.fc.dao.UserDao;
import com.fc.dao.impl.UserDaoImpl;
import com.fc.dao.impl.UserOracleImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StartText {
    @Test
    public void test(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserDao userDao = applicationContext.getBean("userDao", UserDao.class);

        userDao.findAll();
    }
}
