import Utils.DruidUtils;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/3/15
 **/

public class Demo {
    public static void main(String[] args) throws SQLException {
        DataSource dataSource = DruidUtils.getDataSource();
        QueryRunner queryRunner = new QueryRunner(dataSource);
//        Account query = queryRunner.query("select * from account where id = ?", new BeanHandler<>(Account.class), 1);
        List<Account> accountList = queryRunner.query("select * from account", new BeanListHandler<Account>(Account.class));
        System.out.println(accountList);
//        System.out.println(query);
    }
}
