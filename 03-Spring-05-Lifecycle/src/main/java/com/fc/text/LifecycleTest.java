package com.fc.text;

import com.fc.entity.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifecycleTest {
    @Test
    public void test(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");


        applicationContext.close();
//        Student student1 = applicationContext.getBean("student", Student.class);
//        Student student2 = applicationContext.getBean("student", Student.class);
//
//        System.out.println(student1);
//        System.out.println(student2);
    }
}
