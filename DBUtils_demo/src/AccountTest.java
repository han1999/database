import Utils.DruidUtils;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.*;

import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/3/15
 **/

public class AccountTest {
    static QueryRunner queryRunnerWithoutDatasource;
    static QueryRunner queryRunnerWithDatasource;
    static Connection connection;

    @BeforeClass
    public static void init() {
        queryRunnerWithoutDatasource = new QueryRunner();
        queryRunnerWithDatasource = new QueryRunner(DruidUtils.getDataSource());
        connection = DruidUtils.getConnection();
        System.out.println("beforeClass");
    }

    @Before
    public void before() throws SQLException {
        connection.setAutoCommit(false);
        System.out.println("before");
    }
    @Test
    public void testSelectAll() throws SQLException {
        List<Account> query = queryRunnerWithDatasource.query("select * from account", new BeanListHandler<Account>(Account.class));
        System.out.println(query);
    }

    @Test
    public void testSelectById() throws SQLException {

        Account query = queryRunnerWithoutDatasource.query(connection, "select * from account where id=?", new BeanHandler<Account>(Account.class), 1);
        System.out.println(query);
    }

    @After
    public void after() throws SQLException {
        connection.commit();
        System.out.println("after");
    }
    @AfterClass
    public static void destroy() {
        try {
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("afterClass");
    }

}
