package com.fc.text;

import com.fc.service.UserService;
import com.fc.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XMLTest {
@Test
    public void test(){
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

    UserService userService = applicationContext.getBean(UserService.class);

    userService.add();
    System.out.println("----------分割线-----------");
    userService.update();
}
}
