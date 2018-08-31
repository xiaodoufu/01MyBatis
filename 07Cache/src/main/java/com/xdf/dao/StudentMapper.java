package com.xdf.dao;

import com.xdf.pojo.Student;

import java.io.Serializable;
import java.util.List;

public interface StudentMapper {
    /**
     * 根据学生编号 查询出学生的信息
     */
    Student  findStudentBySid(Serializable id);

    /**
     * 修改指定学生信息
     */
    void   updateStudent(Student stu);
    /**
     * 分页查询所有的学生信息
     */
    List<Student> findStudentsByPage();

    /**
     * 调用存储过程
     */
     void  selectNameByProcedure(Student stu);



}
