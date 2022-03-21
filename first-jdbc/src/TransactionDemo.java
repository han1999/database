import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/3/11
 **/

public class TransactionDemo {
    public static void main(String[] args) {
        transfer("zhangsan", "lisi", 1000);
    }

    public static void transfer(String fromName, String toName, int money) {
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = null;
        PreparedStatement preparedStatement1 = null;
        try {
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement("update account set money=money-? where name=? and money>=?");
            preparedStatement.setInt(1, money);
            preparedStatement.setString(2, fromName);
            preparedStatement.setInt(3, money);
            int affRow = preparedStatement.executeUpdate();
            if (affRow > 0) {
                System.out.println("扣钱成功");
            } else {
                throw new Exception("ex");
            }

//            int a = 1 / 0;
            preparedStatement1 = connection.prepareStatement("update account set money=money+? where name=?");
            preparedStatement1.setInt(1, money);
            preparedStatement1.setString(2, toName);
            int affRow2 = preparedStatement1.executeUpdate();
            if (affRow2 > 0) {
                System.out.println("加钱成功");
            } else {
                throw new Exception("ex2");
            }
            int b=1/0;
            connection.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        try {
            if (preparedStatement1 != null) {
                preparedStatement1.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JDBCUtils.closeResources(connection, preparedStatement, null);
    }
}
