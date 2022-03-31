package com.fc.text;

import com.fc.entity.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LazyTest {
    @Test
    public void test(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        Student student = applicationContext.getBean("student", Student.class);

        student.setAge((byte) 2);
        student.setName("可爱");
        student.setId(1);

        System.out.println(student);

//        applicationContext.close();
//        Student student1 = applicationContext.getBean("student", Student.class);
//        Student student2 = applicationContext.getBean("student", Student.class);
//
//        System.out.println(student1);
//        System.out.println(student2);
    }
}
