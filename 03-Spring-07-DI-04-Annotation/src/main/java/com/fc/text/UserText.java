package com.fc.text;

import com.fc.controller.UserController;
import com.fc.dao.UserDao;
import com.fc.entity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class UserText {

    @Test
    public void testContext(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserController controller = applicationContext.getBean(UserController.class);

        List<User> all = controller.findALl();

        System.out.println(all);
    }
    @Test
    public void test(){
        UserController userController = new UserController();

        List<User> aLl = userController.findALl();

        System.out.println(aLl);
    }
}
