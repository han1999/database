import com.hanxiao.bean.Account;
import com.hanxiao.mapper.AccountMapper;
import com.hanxiao.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/3/19
 **/

public class AccountTest {
    static SqlSession sqlSession;
    static AccountMapper accountMapper;

    @BeforeClass
    public static void init() {
        sqlSession = MybatisUtils.getSqlSession();
        accountMapper = sqlSession.getMapper(AccountMapper.class);
    }

    @After
    public void after() {
        sqlSession.commit();
    }

    @Test
    public void testSelectAccountById() {
        Account account = accountMapper.selectAccountById(1);
        System.out.println("account = " + account);
    }

    @Test
    public void testInsert() {
        Account account = new Account();
        account.setName("caocao");
        account.setMoney(9000);
        Integer affectedRows = accountMapper.insertAccount(account);
        System.out.println("affectedRows = " + affectedRows);
    }

    @Test
    public void testDeleteAccountById() {
        Integer affectedRows = accountMapper.deleteAccountById(6);
        System.out.println("affectedRows = " + affectedRows);
    }

    @Test
    public void testUpdateAccountByName() {
        Integer affectedRows = accountMapper.updateAccountByName("zhangsan");
        System.out.println("affectedRows = " + affectedRows);
    }

    @Test
    public void testUpdateNameById() {
        Integer affectedRows = accountMapper.updateNameById("zhangsanfeng", 1);
        System.out.println("affectedRows = " + affectedRows);
    }

    @AfterClass
    public static void close() {
        sqlSession.close();
    }
}
