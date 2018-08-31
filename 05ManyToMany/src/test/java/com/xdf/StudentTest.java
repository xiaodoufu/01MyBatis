package com.xdf;

import com.xdf.dao.StudentMapper;
import com.xdf.pojo.Student;
import com.xdf.pojo.Teacher;
import com.xdf.util.SessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StudentTest {
    SqlSession session=null;
    StudentMapper mapper=null;
    @Before
    public  void  before(){
        //获取session
        session = SessionFactoryUtil.getSession();
        //获取mapper实例=》让接口和xml文件关联
        mapper= session.getMapper(StudentMapper.class);
    }
    @After
    public void after(){
        session.commit(); //提交事务
        session.close();  //关闭session
    }



    @Test
    public  void  testFindStduent(){
        Student student = mapper.findStudentBySid(4);
        System.out.println(student);
    }
    @Test
    public  void  testFindTeacher(){
        Teacher teacher = mapper.findTeacherByid(1);
        System.out.println(teacher);
    }

}
