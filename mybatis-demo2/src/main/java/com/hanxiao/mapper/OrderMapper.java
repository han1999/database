package com.hanxiao.mapper;

import com.hanxiao.bean.Account;
import com.hanxiao.bean.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: hanxiao
 * @date: 2022/3/19
 **/
public interface OrderMapper {
    Order selectOrderByTableNameAndId(@Param("tableName") String tableName, @Param("id") Integer id);
}
