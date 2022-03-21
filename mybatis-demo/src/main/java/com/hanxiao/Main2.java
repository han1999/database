package com.hanxiao;

import com.hanxiao.bean.Account;
import com.hanxiao.mapper.AccountMapper;
import com.hanxiao.mapper.impl.AccountMapperImpl;
import com.hanxiao.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/3/19
 **/

public class Main2 {
    public static void main(String[] args) throws IOException {
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        AccountMapper accountMapper=new AccountMapperImpl();
        Account account = accountMapper.selectAccountById(1);
        System.out.println(account);
//        Object o = sqlSession.selectOne("com.hanxiao.selectAccountById", 1);
//        System.out.println(o);

        sqlSession.close();
    }
}
