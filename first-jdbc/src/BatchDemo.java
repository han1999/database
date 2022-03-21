import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/3/11
 **/

public class BatchDemo {
    public static void main(String[] args) throws SQLException {
        long t1 = System.currentTimeMillis();
        normalBatch();
        long t2 = System.currentTimeMillis();
        System.out.println("normal: " + (t2 - t1) + "ms");

        statementBatch();
        long t3 = System.currentTimeMillis();
        System.out.println("statement: " + (t3 - t2 + "ms"));

        prepareStatementBatch();
        long t4 = System.currentTimeMillis();
        System.out.println("prepareStatement: " + (t4 - t3) + "ms");


    }

    public static void normalBatch() throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        Statement statement = connection.createStatement();
        for (int i = 0; i < 1000; i++) {
            int affRow = statement.executeUpdate("insert into user values('lisi', '123456')");
        }
        JDBCUtils.closeResources(connection, statement, null);
    }

    public static void statementBatch() throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        Statement statement = connection.createStatement();
        for (int i = 0; i < 1000; i++) {
            statement.addBatch("insert into user values('wangwu', '123456')");
        }
        int[] ints = statement.executeBatch();
        JDBCUtils.closeResources(connection, statement, null);
    }

    public static void prepareStatementBatch() throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into user values(?, ?)");
        for (int i = 0; i < 1000; i++) {
            preparedStatement.setString(1, "lisi");
            preparedStatement.setString(2, "123456");
            preparedStatement.addBatch();
        }
        int[] ints = preparedStatement.executeBatch();
        JDBCUtils.closeResources(connection, preparedStatement, null);
    }
}
