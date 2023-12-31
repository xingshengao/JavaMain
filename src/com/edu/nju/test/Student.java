package com.edu.nju.test;

import java.util.Objects;

public class Student {
    private String name;
    private int a;

    public Student() {
    }

    public Student(String name, int a) {
        this.name = name;
        this.a = a;
    }

    @Override
    public String toString() {
        return "com.edu.nju.test.Student{" +
                "name='" + name + '\'' +
                ", a=" + a +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return a == student.a && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, a);
    }
}
