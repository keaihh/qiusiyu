package com.fc.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Student implements Serializable {
    private Integer id;
    private String name;
    private String gender;
    private Byte age;
    private Date birthday;
    private String info;
}
