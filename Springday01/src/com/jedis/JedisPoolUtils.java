package com.jedis;

import java.util.HashMap;
import java.util.Map;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
public class JedisPoolUtils {
	
	private static JedisPool jedisPool=null;
	
	static{
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(30);
		config.setMaxIdle(10);
		jedisPool=new JedisPool(config,"192.168.0.104",6379);
	}
	
	
	public static  Jedis getJedis(){
		Jedis jedis=jedisPool.getResource();
		return jedis;	
	}
	
	
}
