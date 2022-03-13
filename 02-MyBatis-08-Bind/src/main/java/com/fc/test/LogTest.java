package com.fc.test;

import com.fc.dao.StudentDao;
import com.fc.entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogTest {
    @Test
    public void textInsert2(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession session = factory.openSession();

            StudentDao studentDao = session.getMapper(StudentDao.class);

            Student student = new Student();

            student.setName("萍");
            student.setAge((byte)3);
            student.setGender("女");
            student.setBirthday(new Date(2001,1,3,4,5,6));
            student.setInfo("还是个三岁的孩子");

            int affectedRows = studentDao.insert2(student);

            session.commit();
            session.close();
            System.out.println("受影响的行数"+affectedRows);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void textInsert(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession session = factory.openSession();

            StudentDao studentDao = session.getMapper(StudentDao.class);

            int affectedRows = studentDao.insert("思雨", 18, "女", new Date(2021, 10, 29, 10, 10, 10), "嘿嘿");

            session.commit();
            session.close();
            System.out.println("受影响的行数"+affectedRows);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void textFindByIdAndGender(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession session = factory.openSession();

            StudentDao studentDao = session.getMapper(StudentDao.class);

            Map<String, Object> map = new HashMap<>();

            map.put("id",1);
            map.put("gender","男");

            List<Student> students = studentDao.findByIdAndGender(map);

            for (Student student : students) {
                System.out.println(student);
            }

            session.commit();

            session.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void textFindByAgeAndName(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession session = factory.openSession();

            StudentDao studentDao = session.getMapper(StudentDao.class);

            List<Student> students = studentDao.findByAgeAndName(22, "易烊千玺");

            for (Student student : students) {
                System.out.println(student);
            }

            session.commit();
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void textFindByIdAndAge(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession session = factory.openSession();

            StudentDao studentDao = session.getMapper(StudentDao.class);

            List<Student> students = studentDao.findByIdAndAge(1, 22);

            for (Student student : students) {
                System.out.println(student);
            }

            session.commit();
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void textFindByIdAndName(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession session = factory.openSession();

            StudentDao studentDao = session.getMapper(StudentDao.class);

            List<Student> students = studentDao.findByIdAndName(1,"易烊千玺");

            for (Student student : students) {
                System.out.println(student);
            }
            session.commit();
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void textFindById(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession session = factory.openSession();

            StudentDao mapper = session.getMapper(StudentDao.class);

            List<Student> students = mapper.findById(1);

            for (Student student : students) {
                System.out.println(student);
            }
            session.commit();
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
