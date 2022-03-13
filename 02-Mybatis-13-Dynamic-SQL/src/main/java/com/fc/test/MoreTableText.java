package com.fc.test;

import com.fc.dao.StudentDao;
import com.fc.entity.Student;
import com.fc.util.MyBatisUtil;
import org.junit.Test;

import javax.security.auth.Subject;
import java.util.Date;
import java.util.List;

public class MoreTableText {
    @Test
    public void textFindAll(){
        StudentDao mapper = MyBatisUtil.getMapper(StudentDao.class);

        List<Student> students = mapper.findAll();

        for (Student student : students) {
            System.out.println(student);
        }

        MyBatisUtil.commit();
    }
    @Test
    public void textFindByKeyword(){
        StudentDao mapper = MyBatisUtil.getMapper(StudentDao.class);

        List<Student> students = mapper.findByKeyword("%莎%",null);

        for (Student student : students) {
            System.out.println(student);
        }

        MyBatisUtil.commit();
    }
    @Test
    public void textFindByStudents(){
        StudentDao mapper = MyBatisUtil.getMapper(StudentDao.class);

        Student student = new Student();

        student.setId(1);
        student.setName("易烊千玺");

        List<Student> students = mapper.findByStudents(student);
        for (Student student1 : students) {
            System.out.println(student1);
        }

        MyBatisUtil.commit();
    }

    @Test
    public void textUpdate(){
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);

        Student student = new Student();
        student.setId(2);
        student.setName("Krystal");
        student.setBirthday(new Date());
        student.setAge((byte)10);
        student.setInfo("Operator");

        int update = studentDao.update(student);

        System.out.println(update);

        MyBatisUtil.commit();
    }
    @Test
    public void testFindByStudentOnTrim(){
        StudentDao mapper = MyBatisUtil.getMapper(StudentDao.class);

        Student student = new Student();

        student.setId(2);
        student.setName("Krystal");
        student.setBirthday(new Date());
        student.setAge((byte)40);
        student.setInfo("Operator");

        List<Student> trim = mapper.findByStudentOnTrim(student);

        for (Student student1 : trim) {
            System.out.println(student1);
        }

        MyBatisUtil.commit();
    }

    @Test
    public void testDeleteMore(){
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);

        int i = studentDao.deleteMore(1,7);

        System.out.println(i);
        MyBatisUtil.commit();
    }

}
