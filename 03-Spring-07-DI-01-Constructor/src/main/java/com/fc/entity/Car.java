package com.fc.entity;

import lombok.Data;

@Data
public class Car{
    private Float speed;
    private String color;

    public Car(Float speed, String color) {
        this.speed = speed;
        this.color = color;
    }
}
