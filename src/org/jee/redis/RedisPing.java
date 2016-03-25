package org.jee.redis;

import redis.clients.jedis.Jedis;

/**
 * Created by bysocket on 16/3/25.
 */
public class RedisPing {
    public static Jedis jedis;
    public static void main(String[] args) {
        pingRedis();
    }

    public static void pingRedis(){
        jedis = new Jedis("localhost");
        System.out.println("Server is running: " + jedis.ping());
    }
}
