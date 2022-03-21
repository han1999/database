package com.hanxiao;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/3/15
 **/

public class DruidUtils {
    static DataSource dataSource;

    static {
        try {
            Properties properties = new Properties();
//            FileInputStream fileInputStream = new FileInputStream("druid.properties");
            ClassLoader classLoader = DruidUtils.class.getClassLoader();
            InputStream resourceAsStream = classLoader.getResourceAsStream("druid.properties");
            properties.load(resourceAsStream);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static DataSource getDataSource() {
        return dataSource;
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (Exception ex) {

            ex.printStackTrace();
        }
        return connection;

    }
}
