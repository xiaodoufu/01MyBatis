package com.xdf;

import com.xdf.dao.TeacherMapper;
import com.xdf.pojo.Teacher;
import com.xdf.util.SessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TeacherTest {
    SqlSession session=null;
    TeacherMapper mapper=null;
    @Before
    public  void  before(){
        //获取session
        session = SessionFactoryUtil.getSession();
        //获取mapper实例=》让接口和xml文件关联
        mapper= session.getMapper(TeacherMapper.class);
    }
    @After
    public void after(){
        session.commit(); //提交事务
        session.close();  //关闭session
    }



    @Test
    public  void  testFindTeacher(){
        List<Teacher> teachers = mapper.findTeachersByTid(1);
        System.out.println(teachers);
    }

}
