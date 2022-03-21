import utils.DruidUtils;
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/3/12
 **/

public class ConnectionPoolDemo {
    public static void main(String[] args) throws SQLException {
//        Connection connection = MyConnectionPool.getConnection();
//        Connection connection = DBCPUtils.getConnection();
//        Connection connection = C3P0Utils.getConnection();
        Connection connection = DruidUtils.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from account");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int money = resultSet.getInt("money");
            System.out.println("id:"+id+", name:"+name+", money:"+money);
        }
        JDBCUtils.closeResources(null, preparedStatement, resultSet);
        MyConnectionPool.returnConnection(connection);
    }
}
