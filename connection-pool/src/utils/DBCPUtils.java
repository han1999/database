package utils;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/3/15
 **/

public class DBCPUtils {
    static DataSource dataSource;
    static {
        try {
            Properties properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream("dbcp.properties");
            properties.load(fileInputStream);
            dataSource = BasicDataSourceFactory.createDataSource(properties);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
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
