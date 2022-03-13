package com.fc.test;


import com.fc.dao.StudentMapper;
import com.fc.entity.Student;
import com.fc.entity.StudentExample;
import com.fc.util.MyBatisUtil;
import org.junit.Test;

import java.util.List;

public class GeneratorTest {
    @Test
    public void testInsert(){
        StudentMapper studentMapper = MyBatisUtil.getMapper(StudentMapper.class);

        Student student = new Student();

        student.setName("唔系迪西");
        student.setAge((byte)2);


        int i = studentMapper.insertSelective(student);

        System.out.println(i);

        MyBatisUtil.commit();


        MyBatisUtil.commit();
    }
    //条件查询
    @Test
    public void testFindByAgeEqual(){
        StudentMapper studentMapper = MyBatisUtil.getMapper(StudentMapper.class);

        StudentExample example = new StudentExample();

        //获取标准规范
        StudentExample.Criteria criteria = example.createCriteria();

        //查询18岁人的个数
        criteria.andAgeEqualTo((byte) 18);
        //模糊查询含有”莎“字的个数
        criteria.andNameLike("%莎%");

        long l = studentMapper.countByExample(example);

        System.out.println(l);


        MyBatisUtil.commit();
    }

    @Test
    public void testCount(){
        StudentMapper studentMapper = MyBatisUtil.getMapper(StudentMapper.class);
        //查询数量
        long l = studentMapper.countByExample(null);


        System.out.println(l);


        MyBatisUtil.commit();
    }
    //查询所有内容，并携带大文本
    @Test
    public void testWithText(){
        StudentMapper studentMapper = MyBatisUtil.getMapper(StudentMapper.class);

        List<Student> students = studentMapper.selectByExampleWithBLOBs(null);

        for (Student student : students) {
            System.out.println(student);
        }
        MyBatisUtil.commit();
    }
    //查询全部 但info为空，因为里面是大字段
    @Test
    public void testFindAll(){
        StudentMapper studentMapper = MyBatisUtil.getMapper(StudentMapper.class);

        List<Student> students = studentMapper.selectByExample(null);

        for (Student student : students) {
            System.out.println(student);
        }
        MyBatisUtil.commit();
    }
}
