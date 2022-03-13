package com.fc.entity;

import lombok.Data;

@Data
public class Employee {
    private Integer Id;
    private String Name;
    private Department department;

}
