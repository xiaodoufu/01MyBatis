package com.xdf.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 单例类
 * 目的就是通过接口返回给用户一个session
 */
public class SessionFactoryUtil {

    //创建需要单例的对象
    private  static SqlSessionFactory factory;
    //私有化构造
    private SessionFactoryUtil() {
    }
    //对外部访问的接口
    public static synchronized SqlSession  getSession(){
        try {
            /**
             *  给我们一个核心配置文件的位置  返回一个输入流
             *  也就是把配置信息读取到了 内存中 方便我们后续使用
             */
            InputStream stream = Resources.getResourceAsStream("mybatis.xml");
            //通过构造器创建工厂
            if (factory==null){
                factory = new SqlSessionFactoryBuilder().build(stream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  factory.openSession();//通过工厂获取session
    }
}
