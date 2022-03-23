import com.hanxiao.bean.Account;
import com.hanxiao.bean.Bccount;
import com.hanxiao.mapper.AccountMapper;
import com.hanxiao.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
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

    @AfterClass
    public static void close() {
        sqlSession.close();
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

    @Test
    public void testUpdateAccountSelectiveById() {
        Account account = new Account();
        account.setId(2);
        account.setMoney(0);
        Integer affectedRows = accountMapper.updateAccountSelectiveById(account);
        System.out.println("affectedRows = " + affectedRows);
    }

    @Test
    public void testSelectAccountByIdWithInclude() {
        Account account = accountMapper.selectAccountByIdWithInclude(2);
        System.out.println("account = " + account);
    }

    @Test
    public void testSelectAccountListByIdLst() {
        ArrayList<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        ids.add(7);
        List<Account> accounts = accountMapper.selectAccountListByIdLst(ids);
        System.out.println("accounts = " + accounts);
    }

    @Test
    public void testSelectAccountListByIdArray() {
        Integer[] ids={1,3,6};
        List<Account> accounts = accountMapper.selectAccountListByIdArray(ids);
        System.out.println("accounts = " + accounts);
    }
}
