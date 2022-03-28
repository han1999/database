package com.hanxiao.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/3/19
 **/

public class MybatisUtils {
    static SqlSession sqlSession;
    static{
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        InputStream resourceAsStream = null;
        try {
            resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
//            resourceAsStream = Resources.getResourceAsStream("C:\\Users\\hx\\IdeaProjects\\database\\mybatis-demo2\\src\\main\\resources\\mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = builder.build(resourceAsStream);
        sqlSession=sqlSessionFactory.openSession();
    }

    public static SqlSession getSqlSession() {
        return sqlSession;
    }
}
