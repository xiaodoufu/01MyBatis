package com.xdf;

import com.sun.javafx.collections.MappingChange;
import com.xdf.dao.UserMapper;
import com.xdf.pojo.Users;
import com.xdf.util.SessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
     * 新增
     */
    @Test
    public void testAddMapper(){
        Users users=new Users();
        users.setUserName("用户名");
        users.setPassword("密码");
        int num = mapper.addUser(users);//通过mapper调用接口的方法
        System.out.println(users.getId()); // 没有值
    }
    /**
     * 删除
     */
    @Test
    public void deleteUser(){
        int num = mapper.deleteUser(10);//通过mapper调用接口的方法
        if (num>0){
            System.out.println("删除成功");
        }else{
            System.out.println("删除失败");
        }
    }
    /**
     * 修改
     */
    @Test
    public void updateUser(){
        Users users=new Users();
        users.setId(9);
        users.setUserName("齐亮");
        users.setPassword("666");
        int num = mapper.updateUser(users);//通过mapper调用接口的方法
        if (num>0){
            System.out.println("修改成功");
        }else{
            System.out.println("修改失败");
        }
    }
    /**
     * 查询指定id的用户
     */
    @Test
    public void selectUserById(){
       Users users = mapper.findUsersById(9);//通过mapper调用接口的方法
        System.out.println(users);
    }
    /**
     * 查询所有用户
     */
    @Test
    public void findAllUsers(){
       List<Users> users = mapper.findAllUsers();//通过mapper调用接口的方法
        System.out.println(users);
    }

    /**
     * 多个参数的传递
     */
    @Test
    public void findOneByTwoCondition(){
        Users users = mapper.findOneByTwoCondition("小白","123");//通过mapper调用接口的方法
        System.out.println(users);
    }
    /**
     * Map参数的传递
     */
    @Test
    public void findOneByMap(){
        Map<String,Object> map=new HashMap<>();
       /* map.put("myName","小白");
        map.put("myPwd","123");*/
        Users users =new Users();
        users.setUserName("小白");
        users.setPassword("123");
        map.put("user",users);
        Users users2 = mapper.findOneByMap(map);//通过mapper调用接口的方法
        System.out.println(users2);
    }
}
