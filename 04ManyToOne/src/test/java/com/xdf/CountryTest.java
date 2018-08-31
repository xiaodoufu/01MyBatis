package com.xdf;

import com.xdf.dao.CountryMapper;
import com.xdf.pojo.Country;
import com.xdf.pojo.Provincial;
import com.xdf.util.SessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CountryTest {
    SqlSession session=null;
    CountryMapper mapper=null;
    @Before
    public  void  before(){
        //获取session
        session = SessionFactoryUtil.getSession();
        //获取mapper实例=》让接口和xml文件关联
        mapper= session.getMapper(CountryMapper.class);
    }
    @After
    public void after(){
        session.commit(); //提交事务
        session.close();  //关闭session
    }


    /**
     * 延迟加载的方式
     */
    @Test
    public  void   testFindProvincialLazy(){
        Provincial provincial = mapper.selectProvincialByPid(3);
        System.out.println(provincial.getCountry().getcName());


    }


}
