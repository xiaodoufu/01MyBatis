package com.xdf.dao;

import com.xdf.pojo.Student;
import com.xdf.pojo.Teacher;

import java.io.Serializable;

public interface StudentMapper {
    /**
     * 根据学生编号 查询出学生和对应老师的信息
     */
    Student  findStudentBySid(Serializable id);
    /**
     * 根据老师编号 查询出老师和对应学生的信息
     */
    Teacher findTeacherByid(Serializable id);
}
