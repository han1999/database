package com.hanxiao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/3/18
 **/

public class Main {
    public static void main(String[] args) throws SQLException {
        System.out.println("hello, world!");
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        List<Account> query = queryRunner.query("select * from account", new BeanListHandler<Account>(Account.class));
        System.out.println(query);
    }
}
