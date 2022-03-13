package com.fc.dao;

import com.fc.entity.Student;
import org.apache.ibatis.annotations.Param;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface StudentDao {
    List<Student> findById(Integer id);

    List<Student> findByIdAndName(Integer id,String name);

    List<Student> findByIdAndAge(Integer id,Integer age);

    List<Student> findByAgeAndName(@Param("age") Integer age, @Param("name") String name);

    List<Student> findByIdAndGender(Map<String,Object> map);

    int insert(@Param("name") String name, @Param("age") Integer age, @Param("gender") String gender, @Param("birthday") Date birthday, @Param("info") String info);

    int insert2(Student student);
}
