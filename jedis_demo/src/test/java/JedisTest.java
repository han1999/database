import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import utils.JedisUtils;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/3/31
 **/

public class JedisTest {
    static Jedis jedis;

    @BeforeClass
    public static void init() {
        jedis = JedisUtils.getJedis();
    }

    @AfterClass
    public static void afterClass() {
        jedis.close();
    }

    @Test
    public void testString() {
        jedis.set("name", "hanxiao");
        String name = jedis.get("name");
        System.out.println("name = " + name);
    }
}
