package com.xdf.pojo;

import java.io.Serializable;
import java.util.Set;

public class Student implements Serializable {

    private int  sId;
    private int  age;
    private String  sName;
    //一个学生可以有多个老师
    private Set<Teacher> teachers;

    public Student() {
    }

    public Student(int sId, int age, String sName, Set<Teacher> teachers) {

        this.sId = sId;
        this.age = age;
        this.sName = sName;
        this.teachers = teachers;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sId=" + sId +
                ", age=" + age +
                ", sName='" + sName + '\'' +
                ", teachers=" + teachers +
                '}';
    }

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }
}
