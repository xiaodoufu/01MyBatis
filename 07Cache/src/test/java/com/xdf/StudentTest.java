package com.xdf;

import com.github.pagehelper.PageHelper;
import com.xdf.dao.StudentMapper;
import com.xdf.pojo.Student;
import com.xdf.util.SessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

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


    /**
     * 验证1级缓存  sqlSession 每个私有！
     */
    @Test
    public  void  testFindStduent(){
        Student student = mapper.findStudentBySid(4); //产生一条sql语句
        System.out.println(student);
        session.clearCache(); //清空缓存
        System.out.println("====================================");
        student=mapper.findStudentBySid(4); //会产生一条sql语句？
        System.out.println(student);
    }
    /**
     * 验证修改指定学生信息
     * 增删改是否会清空缓存
     */
    @Test
    public  void  testUpdate(){
        Student student = mapper.findStudentBySid(4); //产生一条sql语句
        System.out.println(student);
        System.out.println("====================================");
        student.setsName("哈哈哈哈");
        mapper.updateStudent(student);
        student=mapper.findStudentBySid(4); //再次查询
        System.out.println(student);
    }



    /**
     * 验证2级缓存  sqlSessionFactory
     * 所有的sqlSession共享
     */
    @Test
    public  void  testSecondCache(){
        Student student = mapper.findStudentBySid(4); //产生一条sql语句
        session.close();
        session = SessionFactoryUtil.getSession(); //重新获取session
        mapper= session.getMapper(StudentMapper.class);
        student=mapper.findStudentBySid(4); //会产生一条sql语句？
        session.close();
        session = SessionFactoryUtil.getSession(); //重新获取session
        mapper= session.getMapper(StudentMapper.class);
        student=mapper.findStudentBySid(4); //会产生一条sql语句？
        session.close();
        session = SessionFactoryUtil.getSession(); //重新获取session
        mapper= session.getMapper(StudentMapper.class);
        student=mapper.findStudentBySid(4); //会产生一条sql语句？
    }


    /**
     * 分页查询 每页2条数据 查询第1页
     */
     @Test
    public  void  testPage(){
         PageHelper.startPage(2,2);
         List<Student> students = mapper.findStudentsByPage();
         System.out.println(students);
     }

     @Test
    public  void  testProcedure(){
        Student student=new Student();
        student.setsId(2);
        System.out.println("执行存储过程之前===》"+student.getsName());
         mapper.selectNameByProcedure(student);
         System.out.println("执行存储过程之后===》"+student.getsName());
     }




}
