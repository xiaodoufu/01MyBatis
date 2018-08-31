package com.xdf.dao;

import com.xdf.pojo.Users;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 用户的接口
 */
public interface UserMapper {
    /**
     * 根据用户传递的对象属性  来执行sql查询
     */
    List<Users> findUsersByCondition(Users users);

    /**
     * 根据用户传递的对象属性  来执行sql修改
     */
    void updateBySet(Users users);

    /**
     * 根据用户传递的对象属性  来执行sql修改
     */
    List<Users> selectByChoose(Users users);

    /**
     * 查询id in(1,2,3)的用户信息
     */
    List<Users> selectByArray(int[]ids);
    /**
     * 查询id in(1,2,3)的用户信息
     * list 单一类型
     */
    List<Users> selectByList(List<Integer> list);

    /**
     * 查询id in(1,2,3)的用户信息
     * list 对象类型
     */
    List<Users> selectByListUser(List<Users> list);
    /**
     * 新增多个用户信息
     * list 对象类型
     */
   void insertManyUsers(List<Users> list);
    /**
     * 查询id in(1,2,3)的用户信息
     * map 单一类型
     */
    List<Users> selectByMap(@Param("myMap") Map<String,Integer> map);
    /**
     * 查询id in(1,2,3)的用户信息
     * map 对象类型
     */
    List<Users> selectByMapUser(@Param("myMap") Map<String,Users> map);


}
