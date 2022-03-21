package com.hanxiao.mapper.impl;

import com.hanxiao.bean.Account;
import com.hanxiao.mapper.AccountMapper;
import com.hanxiao.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/3/19
 **/

public class AccountMapperImpl implements AccountMapper {
    @Override
    public Account selectAccountById(Integer id) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        Account account = sqlSession.selectOne("com.hanxiao.selectAccountById", id);
        return account;
    }
}
