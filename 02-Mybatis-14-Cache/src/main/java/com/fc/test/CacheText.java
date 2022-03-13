package com.fc.test;

import com.fc.dao.StudentDao;
import com.fc.entity.Student;
import com.fc.util.MyBatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.Date;
import java.util.List;

public class CacheText {
    @Test
    public void textFindById(){
        try {
            Reader resource = Resources.getResourceAsReader("mybatis-config.xml");

            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resource);

            SqlSession session = factory.openSession();
            StudentDao studentDao = session.getMapper(StudentDao.class);

            SqlSession session1 = factory.openSession();

            StudentDao studentDao1 = session1.getMapper(StudentDao.class);

            Student student = studentDao.findById(1);
            //清除缓存 三种方式
//            session.clearCache();
//            session.commit();
//            session.rollback();

            Student student1 = studentDao1.findById(1);

            System.out.println(student==student1);



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test2(){
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");

            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);

            SqlSession session = factory.openSession();

            StudentDao studentDao = session.getMapper(StudentDao.class);

            System.out.println("第一次查询");
            studentDao.findById(2);

            session.commit();


            System.out.println("第二次查询");

            studentDao.findById(2);

            Student student = new Student();
            student.setId(6);
            student.setInfo("明天第一节体育课");
            studentDao.update(student);

            session.commit();

            System.out.println("第三次查询");
            studentDao.findById(2);

//            session.close();

            SqlSession session2 = factory.openSession();

            StudentDao studentDao2 = session2.getMapper(StudentDao.class);

            System.out.println("第四次查询");

            studentDao2.findById(2);



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
