package com.fc.test;


import com.fc.dao.StudentDao;
import com.fc.entity.Student;
import com.fc.util.MyBatisUtil;
import org.junit.Test;

import java.util.List;

public class PageHelperText {

   @Test
    public void testFindAll(){
       StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);

       studentDao.findAll();

       MyBatisUtil.commit();

   }

   @Test
    public void testFindById(){
       StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);

       studentDao.findById(2);

       MyBatisUtil.commit();
   }
   @Test
    public void testInsert(){
       StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);

       Student student = new Student();

       student.setName("小猪");
       student.setGender("男");
       student.setInfo("最可爱");

       studentDao.insert(student);

       MyBatisUtil.commit();
   }
   @Test
    public void testDelete(){
       StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);

       studentDao.delete(12);

       MyBatisUtil.commit();
   }
   @Test
    public void testUpdate(){
       StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);

       Student student = new Student();

       student.setId(4);
       student.setInfo("好看");

       studentDao.update(student);

       MyBatisUtil.commit();
   }

}
