package com.hanxiao;

import com.hanxiao.bean.Account;
import com.hanxiao.mapper.AccountMapper;
import com.hanxiao.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/3/19
 **/

public class Main {
    public static void main(String[] args) throws IOException {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
        Account account = mapper.selectAccountById(1);
        System.out.println(account);
    }
}
