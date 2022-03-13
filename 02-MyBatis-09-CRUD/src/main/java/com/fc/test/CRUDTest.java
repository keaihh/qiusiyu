package com.fc.test;

import com.fc.dao.StudentDao;
import com.fc.entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CRUDTest {
    @Test
    public void testGetAutoIncrement(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession session = factory.openSession();

            StudentDao studentDao = session.getMapper(StudentDao.class);

            Student student = new Student();

            student.setName("萍萍");
            student.setGender("女");
            student.setAge((byte) 18);
            student.setBirthday(new Date(2001,2,1,2,3,2));
            student.setInfo("拥你入怀的是钟馗");

            //受影响的行数
            int affectRows = studentDao.getAutoIncrement(student);
            session.commit();
            session.close();

            System.out.println("受影响的行数"+affectRows);

            System.out.println("自增长的id"+student.getId());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFindByKeyword(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession session = factory.openSession();

            StudentDao mapper = session.getMapper(StudentDao.class);

            List<Student> students = mapper.findByKeyword("%雨%");

            for (Student student : students) {
                System.out.println(student);
            }
            session.commit();
            session.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFindAll(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession session = factory.openSession();

            StudentDao mapper = session.getMapper(StudentDao.class);

            List<Student> students = mapper.findAll();

            for (Student student : students) {
                System.out.println(student);
            }
            session.commit();
            session.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFindById(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession session = factory.openSession();

            StudentDao studentDao = session.getMapper(StudentDao.class);

            List<Student> students = studentDao.findById(2);

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
    public void testInsert(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession session = factory.openSession();

            StudentDao studentDao = session.getMapper(StudentDao.class);

            Student student = new Student();

            student.setName("莎莎");
            student.setGender("女");
            student.setAge((byte) 18);
            student.setBirthday(new Date(2001,2,1,2,3,2));
            student.setInfo("为啥呀");

            int insert = studentDao.insert(student);
            session.commit();
            session.close();

            System.out.println(insert);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDelete(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession session = factory.openSession();

            StudentDao studentDao = session.getMapper(StudentDao.class);



            int insert = studentDao.delete(4);
            session.commit();
            session.close();

            System.out.println(insert);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdate(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession session = factory.openSession();

            StudentDao studentDao = session.getMapper(StudentDao.class);

            Student student = new Student();

            student.setId(9);
            student.setInfo("莫名其妙这首歌");

            int insert = studentDao.update(student);
            session.commit();
            session.close();

            System.out.println(insert);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
