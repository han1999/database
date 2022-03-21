package com.hanxiao.mapper;

import com.hanxiao.bean.Account;
import org.apache.ibatis.annotations.Param;

/**
 * @description:
 * @author: hanxiao
 * @date: 2022/3/19
 **/
public interface AccountMapper {
    Account selectAccountById(Integer id);

    Integer insertAccount(@Param("acc") Account account);

    Integer deleteAccountById(Integer id);

    Integer updateAccountByName(String name);

    Integer updateNameById(@Param("username") String name, @Param("uid") Integer id);
}
