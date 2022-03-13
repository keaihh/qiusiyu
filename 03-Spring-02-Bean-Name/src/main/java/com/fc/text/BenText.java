package com.fc.text;

import com.fc.entity.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BenText {
    @Test
    public void text(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        Student bean = (Student) applicationContext.getBean("student");

        System.out.println(bean);
    }
}
