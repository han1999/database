package utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/3/15
 **/

public class C3P0Utils {
    static DataSource dataSource;
    static {
       dataSource = new ComboPooledDataSource();
    }

    public static Connection getConnection() {
        Connection connection=null;
        try {
            connection = dataSource.getConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return connection;
    }
}
