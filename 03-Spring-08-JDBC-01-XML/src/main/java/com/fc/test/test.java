package com.fc.test;

import com.fc.dao.UserDao;
import com.fc.entity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class test {
    @Test
    public void test(){

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserDao userDao = applicationContext.getBean(UserDao.class);

        List<User> list = userDao.findAll();

        System.out.println(list);
    }
}
