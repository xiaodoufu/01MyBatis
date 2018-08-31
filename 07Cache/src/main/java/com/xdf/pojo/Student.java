package com.xdf.pojo;

import java.io.Serializable;
import java.util.Set;

public class Student implements Serializable {

    private int  sId;
    private int  age;
    private String  sName;

    public Student() {
    }

    public Student(int sId, int age, String sName) {

        this.sId = sId;
        this.age = age;
        this.sName = sName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sId=" + sId +
                ", age=" + age +
                ", sName='" + sName + '\'' +
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

}
