package com.edu.nju.test2;

public class Student {
    int age;

    public Student() {
    }

    public void setAge(int age) {
        if (age > 100) {
            throw new RuntimeException();
        } else
            this.age = age;
    }

    public int getAge() {
        return age;
    }

    public Student(int age) {
        this.age = age;
    }
}
