package com.checkpeng.springboottest.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Date;
import java.util.Set;

public class RedisNormal {

    public static void main(String[] args) {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(30);
        jedisPoolConfig.setMaxTotal();


        Jedis jedis = new Jedis("121.196.157.45", 6379);
        System.out.println(System.currentTimeMillis());
        for (int i = 0; i < 1000000; i++) {
            String s = String.valueOf(i);
            jedis.lpush("strtest:1", s);
        }
        System.out.println(System.currentTimeMillis());
    }

    public void keyOperation(Jedis jedis, String key) {
        Long del = jedis.del(key);// 删除key,成功返回1，失败返回0
        byte[] dump = jedis.dump(key);// 序列化给定 key
        Boolean exists = jedis.exists(key); // 检查当前key是否存在
        jedis.expire(key, 10); // 为给定 key 设置过期时间，以秒计。成功返回1，失败返回0
        jedis.keys("*"); // 查找所有符合给定模式( pattern)的 key 。

    }
}
