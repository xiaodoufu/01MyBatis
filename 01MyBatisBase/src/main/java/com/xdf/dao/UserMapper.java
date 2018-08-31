package com.xdf.dao;

import com.xdf.pojo.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 用户的接口
 */
public interface UserMapper {

    /**
     * 新增用户
     */
    int addUser(Users users);

    /**
     * 删除
     */
    int deleteUser(Serializable condition);
    /**
     * 修改
     */
    int updateUser(Users user);
    /**
     * 查询
     */
    Users findUsersById(Serializable condition);
    /**
     * 查询所有
     */
    List<Users> findAllUsers();
    /**
     * 根据name和password查询指定数据
     */
    //Users findOneByTwoCondition(String name,String password);
    Users findOneByTwoCondition(@Param("myName") String name,@Param("myPwd") String password);


    /**
     * 参数类型是一个集合 Map
     */
    Users findOneByMap(Map<String,Object> map);
}
