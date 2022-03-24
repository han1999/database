import com.hanxiao.bean.Order;
import com.hanxiao.mapper.OrderMapper;
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

public class OrderTest {
    static SqlSession sqlSession;
    static OrderMapper orderMapper;

    @BeforeClass
    public static void init() {
        sqlSession = MybatisUtils.getSqlSession();
        orderMapper = sqlSession.getMapper(OrderMapper.class);
    }

    @After
    public void after() {
        sqlSession.commit();
    }

    @Test
    public void testSelectOrderByTableNameAndId() {
        Order order_1 = orderMapper.selectOrderByTableNameAndId("order_1", 1);
        System.out.println("order_1 = " + order_1);
    }

    @AfterClass
    public static void close() {
        sqlSession.close();
    }
}
