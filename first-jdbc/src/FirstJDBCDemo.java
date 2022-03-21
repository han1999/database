import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/3/10
 **/

public class FirstJDBCDemo {
    public static void main(String[] args) throws SQLException {
//        DriverManager.registerDriver(new Driver());
//        String url = "jdbc:mysql://localhost:3306/homework?useSSL=false";
//        String user = "root";
//        String password = "123456";
//        Connection connection = DriverManager.getConnection(url, user, password);
        Connection connection = JDBCUtils.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from book");
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String author = resultSet.getString("author");
            double price = resultSet.getDouble("price");
            int inventory = resultSet.getInt("inventory");
            System.out.println("  id:" + id + "  name:" + name + "  author:" + author + "  price:" + price +
                    "  inventory:" + inventory);
        }
//        try {
//            resultSet.close();
//        }finally {
//            try {
//                statement.close();
//            }finally {
//                connection.close();
//            }
//        }
        JDBCUtils.closeResources(connection, statement, resultSet);
    }
}
