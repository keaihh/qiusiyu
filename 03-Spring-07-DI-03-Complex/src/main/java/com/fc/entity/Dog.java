package com.fc.entity;

public class Dog {
    private String breed;
    private String color;

    public Dog(String breed, String color) {
        this.breed = breed;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "breed='" + breed + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    public Dog() {

    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
