import com.hanxiao.bean.Account;
import com.hanxiao.bean.Bccount;
import com.hanxiao.mapper.AccountMapper;
import com.hanxiao.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

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

    @Test
    public void testSelectAccountListByMap() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("id", 1);
        hashMap.put("money", 100);
        List<Account> accounts = accountMapper.selectAccountListByMap(hashMap);
        System.out.println("accounts = " + accounts);
    }

    @Test
    public void testSelectAccountListByMapWithParam() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("id", 1);
        hashMap.put("money", 1000);
        List<Account> accounts = accountMapper.selectAccountListByMapWithParam(hashMap);
        System.out.println("accounts = " + accounts);
    }

    @Test
    public void testSelectAccountListByIdOrMoney() {
        List<Account> accounts = accountMapper.selectAccountListByIdOrMoney(1, "zhangsan", 2000);
        System.out.println("accounts = " + accounts);
    }

    @Test
    public void testSelectAccountListOrderByColumn() {
        List<Account> accounts = accountMapper.selectAccountListOrderByColumn("id");
        System.out.println("accounts = " + accounts);
    }

    @Test
    public void selectBccountById() {
        Bccount bccount = accountMapper.selectBccountById(1);
        System.out.println("bccount = " + bccount);
    }

    @Test
    public void testSelectAccountListSelectively() {
        Account account = new Account();
//        account.setMoney(200);
        account.setId(2);
        List<Account> accounts = accountMapper.selectAccountListSelectively(account);
        System.out.println("accounts = " + accounts);
    }

    @Test
    public void testSelectAccountListByMoney() {
        List<Account> accounts = accountMapper.selectAccountListByMoney(800);
        System.out.println("accounts = " + accounts);
    }
    @AfterClass
    public static void close() {
        sqlSession.close();
    }
}
