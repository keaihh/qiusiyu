package com.fc.test;

import com.fc.config.ApplicationContextConfig;
import com.fc.dao.UserDao;
import com.fc.entity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class test {
    @Test
    public void test(){

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationContextConfig.class);

        UserDao userDao = applicationContext.getBean(UserDao.class);

        List<User> all = userDao.findAll();

        System.out.println(all);
    }
    @Test
    public void testById(){

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationContextConfig.class);

        UserDao userDao = applicationContext.getBean(UserDao.class);

        User byId = userDao.findById(1);

        System.out.println(byId);
    }
    @Test
    public void testFIndCount(){

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationContextConfig.class);

        UserDao userDao = applicationContext.getBean(UserDao.class);

        int count = userDao.findCount();

        System.out.println(count);
    }
    @Test
    public void testInsert(){

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationContextConfig.class);

        UserDao userDao = applicationContext.getBean(UserDao.class);

        int affectRows = userDao.insert(new User(null,"可爱","666666"));

        System.out.println(affectRows);
    }
    @Test
    public void testUpdate(){

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationContextConfig.class);

        UserDao userDao = applicationContext.getBean(UserDao.class);

        int affectRows = userDao.update(new User(5,"可爱","8888"));

        System.out.println(affectRows);
    }
    @Test
    public void testDelete(){

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationContextConfig.class);

        UserDao userDao = applicationContext.getBean(UserDao.class);

        int affectRows = userDao.delete(5);

        System.out.println(affectRows);
    }

}
