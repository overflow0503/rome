package com.weelfly.cache.client.impl;


import com.weelfly.cache.client.JedisClient;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.exceptions.JedisDataException;

import javax.annotation.Resource;

/**
 * 单机情况使用 try-with-resources 自动关闭
 * 集群情况下就不能使用这种方式
 */
@Component
public class JedisClientPool implements JedisClient {

    @Resource
    private JedisPool jedisPool;


    @Override
    public String get(String key) {
        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.get(key);
        }
    }

    @Override
    public String set(String key, String value) {
        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.set(key, value);
        }
    }

    @Override
    public Long incr(String key) throws JedisDataException {
        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.incr(key);
        }
    }


    @Override
    public Long del(final String... keys) {
        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.del(keys);
        }
    }


    @Override
    public Long expire(String key, int second) {
        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.expire(key, second);
        }
    }

    @Override
    public String setEx(String key, String value, int second) {
        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.setex(key, second, value);
        }
    }
}
