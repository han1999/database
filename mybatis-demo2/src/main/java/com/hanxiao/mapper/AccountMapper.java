package com.hanxiao.mapper;

import com.hanxiao.bean.Account;

/**
 * @description:
 * @author: hanxiao
 * @date: 2022/3/19
 **/
public interface AccountMapper {
    Account selectAccountById(Integer id);

    Integer insertAccount(Account account);

    Integer deleteAccountById(Integer id);

    Integer updateAccountByName(String name);
}
