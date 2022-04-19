package com.fc.controller;

import com.fc.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@Component
@RequestMapping("student")
public class StudentController {
    @Value("${student.name}")
    private String name;
    @Value("${student.age}")
    private Integer age;
    @Value("${student.gender}")
    private String gender;
    @Value("${student.married}")
    private boolean married;
    @Value("${student.birthday}")
    private Date birthday;
    @Value("${student.info:几个字}")
    private String info;

    @Autowired
    private Student student;

    @RequestMapping("getStudent")
    public Student student(){
        return student;
    }

    @RequestMapping("test")
    public Map<String, Object> testYml() {
        Map<String, Object> map = new HashMap<>();
        map.put("name",name);
        map.put("age",age);
        map.put("gender",gender);
        map.put("married",married);
        map.put("birthday",birthday);
        map.put("info",info);
        return map;
    }
}
