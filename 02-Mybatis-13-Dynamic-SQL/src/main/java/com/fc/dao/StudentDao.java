package com.fc.dao;

import com.fc.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao {
    List<Student> findAll();

    List<Student> findByKeyword(@Param("name")String name,@Param("info") String info);

    List<Student> findByStudents(Student student);

    int update(Student student);

    List<Student> findByStudentOnTrim(Student student);
    //不定长参数/可变长参数  可以有一个两个或多个
    //只能放在最后，只能有一个
    int deleteMore(Integer... ids);

}
