package com.fc.entity;

public class Person {
    private String name;
    private String gender;
    private Integer age;
    private Car car;

    public Person(String name, String gender, Integer age, Car car) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.car = car;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", car=" + car +
                '}';
    }
}
