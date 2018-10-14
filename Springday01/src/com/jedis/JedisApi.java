package com.jedis;

import java.util.HashMap;
import java.util.Map;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisApi {
	private static Map<String,JedisPool> poolMap =new HashMap<String,JedisPool>();
	private volatile static JedisApi jedisApi;
	
	private JedisApi() {
		
    }

	private  static JedisPool getPool(String ip, int port){
		JedisPool pool = null; 
		String key = ip + ":" + port;
		if(!poolMap.containsKey(key)){
			JedisPoolConfig config = new JedisPoolConfig(); 
			config.setMaxIdle(10); 
			config.setMaxTotal(30); 
			config.setTestOnBorrow(true);
			config.setTestOnReturn(true);
            pool = new JedisPool(config, ip, port, 30);
            poolMap.put(key, pool);
		}else{
			pool=poolMap.get(key);
		}
		
		return pool;
	}
	//线程安全单列模式
	public static JedisApi getRedisApi() { 
		if (jedisApi == null) { 
			synchronized (JedisApi.class) {
				if (jedisApi == null) { 
					jedisApi = new JedisApi(); 
					} 
				} 
		}
		return jedisApi; 
	}

	public  Jedis getRedis(String ip, int port) {
		Jedis jedis = null;
		int count = 0;
	    while (jedis == null && count <= 10) {	 
	    	try {	    		
	    		jedis = getPool(ip, port).getResource(); 
	    	} catch (Exception e) { 
	    		 
	    	} 
	    }
	    return jedis;
	 }


}

