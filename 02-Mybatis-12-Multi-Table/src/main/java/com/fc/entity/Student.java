package com.fc.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Student {
    private Integer id;
    private String name;
    private String gender;
    private Byte age;
    private Date birthday;
    private String info;
    private List<Subject> subjects;
}
