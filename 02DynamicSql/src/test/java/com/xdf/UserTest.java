package com.xdf;

import com.xdf.dao.UserMapper;
import com.xdf.pojo.Users;
import com.xdf.util.SessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserTest {

    SqlSession session=null;
    UserMapper mapper=null;
    @Before
    public  void  before(){
        //获取session
        session = SessionFactoryUtil.getSession();
        //获取mapper实例=》让接口和xml文件关联
        mapper= session.getMapper(UserMapper.class);
    }
    @After
    public void after(){
        session.commit(); //提交事务
        session.close();  //关闭session
    }


    /**
     * where+if  不知道用户给对象的那些属性赋值
     */
    @Test
    public void  testIf(){
        Users users=new Users();
        users.setUserName("admin");
        users.setPassword("123");
        List<Users>  list= mapper.findUsersByCondition(users);
        System.out.println(list);
    }

    /**
     * set 修改操作
     */
    @Test
    public void  testSet(){
        Users users=new Users();
        users.setId(2);
        users.setUserName("heihei");
        users.setPassword("heihei");
        mapper.updateBySet(users);
    }

    /**
     * choose只能匹配一项
     */
    @Test
    public void  testChoose(){
        Users users=new Users();
        users.setId(2);
        users.setUserName("haha");
        List<Users> users1 = mapper.selectByChoose(users);
        System.out.println(users1);
    }
    /**
     * 遍历数组
     */
    @Test
    public void  testArray(){
        int [] ids={1,3,13};
        List<Users> users = mapper.selectByArray(ids);
        System.out.println(users);
    }
    /**
     * 遍历list集合 单一类型
     */
    @Test
    public void  testList(){
        List<Integer> ids=new ArrayList<>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        List<Users> users = mapper.selectByList(ids);
        System.out.println(users);
    }
    /**
     * 遍历list集合 对象类型
     */
    @Test
    public void  testListUser(){
        List<Users> ids=new ArrayList<>();
        Users u1=new Users(1);
        Users u2=new Users(13);
        Users u3=new Users(2);
        ids.add(u1);
        ids.add(u2);
        ids.add(u3);
        List<Users> users = mapper.selectByListUser(ids);
        System.out.println(users);
    }


    /*新增多个用户
    * */
    @Test
    public void  testAddListUser(){
        List<Users> ids=new ArrayList<>();
        Users u1=new Users("齐亮大帅哥1","admin1");
        Users u2=new Users("齐亮大帅哥2","admin2");
        Users u3=new Users("齐亮大帅哥3","admin3");
        ids.add(u1);
        ids.add(u2);
        ids.add(u3);
        mapper.insertManyUsers(ids);
    }
    /**
     * map集合
    */
    @Test
    public void  testMap(){

        Map<String,Integer> map=new HashMap<>();
        map.put("1",1);
        map.put("2",2);
        map.put("3",13);
        List<Users> users = mapper.selectByMap(map);
        System.out.println(users);
    }
    /**
     * map集合  对象
    */
    @Test
    public void  testMapUser(){
        Map<String,Users> map=new HashMap<>();
        Users u1=new Users(1);
        Users u2=new Users(13);
        Users u3=new Users(2);
        map.put("key1",u1);
        map.put("key2",u2);
        map.put("key3",u3);
        List<Users> users = mapper.selectByMapUser(map);
        System.out.println(users);
    }

}
