package org.jee.redis;

/**
 * Created by bysocket on 16/3/25.
 */
public class RedisString {
    public static void main(String[] args) {
        setGetString();
    }

    public static void setGetString() {
        RedisPing.pingRedis();

        // set redis string
        RedisPing.jedis.set("name","bysocket");

        // get redis string
        System.out.println(RedisPing.jedis.get("name"));

    }
}
