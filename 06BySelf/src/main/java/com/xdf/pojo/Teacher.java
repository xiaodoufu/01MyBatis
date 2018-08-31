package com.xdf.pojo;

import java.io.Serializable;
import java.util.Set;

/**
 * 老师 和 导师的实体类
 */
public class Teacher implements Serializable{

    private  int id;
    private  String  name;
    //一个导师对应多个老师
    private Set<Teacher> teachers;
    //多个老师对应一个导师   private  Teacher  teacher;


    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", teachers=" + teachers +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }

    public Teacher() {

    }

    public Teacher(int id, String name, Set<Teacher> teachers) {

        this.id = id;
        this.name = name;
        this.teachers = teachers;
    }
}
