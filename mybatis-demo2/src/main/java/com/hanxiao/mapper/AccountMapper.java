package com.hanxiao.mapper;

import com.hanxiao.bean.Account;
import com.hanxiao.bean.Bccount;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

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

    List<Account> selectAccountListByMap(Map map);

    List<Account> selectAccountListByMapWithParam(@Param("map") Map map);

    List<Account> selectAccountListByIdOrMoney(Integer id, String name, Integer money);

    List<Account> selectAccountListOrderByColumn(@Param("columnName") String columnName);

    Integer selectAccountTotalCounts();

    List<String> selectNameList();

    String[] selectNameArr();

    List<Account> selectAccountList();

    Bccount selectBccountById(@Param("id") Integer id);

    List<Account> selectAccountListSelectively(@Param("account") Account account);

    List<Account> selectAccountListByMoney(@Param("money") Integer money);
}
