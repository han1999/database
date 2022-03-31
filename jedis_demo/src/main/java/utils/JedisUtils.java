package utils;

import redis.clients.jedis.Jedis;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/3/31
 **/

public class JedisUtils {
    private static Jedis jedis;

    static {
        jedis=new Jedis();
        jedis.auth("123456");
    }

    public static Jedis getJedis() {
        return jedis;
    }
}
