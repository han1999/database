package com.hanxiao;

import com.hanxiao.bean.Account;
import com.hanxiao.utils.MybatisUtils;
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

public class Main {
    public static void main(String[] args) throws IOException {
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        Object o = sqlSession.selectOne("com.hanxiao.selectAccountById", 1);
        System.out.println(o);

        sqlSession.close();
    }
}
