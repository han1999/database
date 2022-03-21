import utils.JDBCUtils;

import java.sql.Connection;
import java.util.LinkedList;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/3/11
 **/

public class MyConnectionPool {
    static int INIT_SIZE = 10;
    static int ADD_SIZE = 10;
    static int MIN_SZIE = 10;
    static LinkedList<Connection> connectionList;

    static {
        connectionList = new LinkedList<>();
        addCapacity();
    }

    private static void addCapacity() {
        for (int i = 0; i < INIT_SIZE; i++) {
            Connection connection = JDBCUtils.getConnection();
            connectionList.addFirst(connection);
        }
    }

    public  static Connection getConnection() {
        if (connectionList.size() < MIN_SZIE) {
            addCapacity();
        }
        Connection connection = connectionList.removeLast();
        return connection;
    }

    public static void returnConnection(Connection connection) {
        connectionList.addFirst(connection);
    }
}
