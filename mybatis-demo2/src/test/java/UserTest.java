import com.hanxiao.bean.User;
import com.hanxiao.mapper.UserMapper;
import com.hanxiao.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/3/28
 **/

public class UserTest {
    static SqlSession sqlSession;
    static UserMapper userMapper;

    @BeforeClass
    public static void init() {
        sqlSession = MybatisUtils.getSqlSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
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
    public void testSelectUserWithUserDetailByUsernameUseCounts() {
        User user = userMapper.selectUserWithUserDetailByUsernameUseCounts("change");
//        System.out.println("user = " + user);
    }

    @Test
    public void testSelectUserWithUserDetailByUsernameUseCrossQuery() {
        User user = userMapper.selectUserWithUserDetailByUsernameUseCrossQuery("change");
        System.out.println("user = " + user);
    }
}
