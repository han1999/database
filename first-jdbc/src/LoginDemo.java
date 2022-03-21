import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/3/11
 **/

public class LoginDemo {
    public static void main(String[] args) {
        boolean loginRes = login("zhangsan", "123456");
        if (loginRes) {
            System.out.println("login success!");
        }else {
            System.out.println("login fail!");
        }
    }

    //    public static boolean login(String username, String password) {
//        Connection connection = JDBCUtils.getConnection();
//        Statement statement = null;
//        ResultSet resultSet=null;
//        try {
//            statement = connection.createStatement();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        String sql="select * from user where username='"+username+"' and password='"+password+"'";
//        System.out.println(sql);
//        try {
//            resultSet = statement.executeQuery(sql);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        try {
//            if (resultSet.next()) {
//                return true;
//            }else {
//                return false;
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
    public static boolean login(String username, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try {
           connection = JDBCUtils.getConnection();
             preparedStatement = connection.prepareStatement("select * from user where username=? and password=?");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            JDBCUtils.closeResources(connection, preparedStatement, resultSet);
        }
    }
}
