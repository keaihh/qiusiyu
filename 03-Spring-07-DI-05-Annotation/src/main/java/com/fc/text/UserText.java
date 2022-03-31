package com.fc.text;

import com.fc.controller.UserController;
import com.fc.dao.UserDao;
import com.fc.dao.impl.UserDaoImpl;
import com.fc.entity.User;
import com.fc.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class UserText {

    @Test
    public void testUser(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        applicationContext.close();
    }
    @Test
    public void testAnnotation(){
        //通过注解获取Spring容器
        //必须配置包扫描路径扫描指定包下的所有注解
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.fc");

        User user = applicationContext.getBean(User.class);

        System.out.println(user);

    }

    @Test
    public void testXML(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        User user = applicationContext.getBean(User.class);
        UserController userController = applicationContext.getBean(UserController.class);


        System.out.println(user);


        List<User> aLl = userController.findALl();

        System.out.println(aLl);
    }

}
