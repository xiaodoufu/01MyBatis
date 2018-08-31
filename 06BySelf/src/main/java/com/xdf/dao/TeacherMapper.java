package com.xdf.dao;

import com.xdf.pojo.Teacher;

import java.io.Serializable;
import java.util.List;

public interface TeacherMapper {
    /**
     * 根据导师的编号 查询出所有的老师
     */
    List<Teacher> findTeachersByTid(Serializable id);

}
