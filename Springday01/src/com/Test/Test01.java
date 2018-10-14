package com.Test;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itcast.Person;
import com.itcast.User;
import com.jedis.JedisApi;

import redis.clients.jedis.Jedis;

public class Test01 {
	@Test
	public void test02(){
		ClassPathXmlApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		User user=(User) ac.getBean("hahaahah");
		Person p=user.getPerson();
		System.out.println(p.getName());
	}
	
	@Test
	public void testredis() throws InterruptedException{
		Jedis jedis=new Jedis("192.168.0.104",6379);
//		jedis.set("me", "love xiaoya");
		/*System.out.println(jedis.get("me"));
		jedis.close();
		System.out.println("--------------------");
		JedisApi api=JedisApi.getRedisApi();
		System.out.println(api.getRedis("192.168.0.104",6379).get("username"));
		jedis.del("username");
		System.out.println(jedis.keys("*"));
		System.out.println("设置键 2的过期时间为5s:" + jedis.expireAt("me", 5));
		TimeUnit.SECONDS.sleep(2);
        System.out.println("查看键 2的剩余生存时间：" + jedis.ttl("me"));*/
		jedis.mset("key1","value1","key2","value2","key3","value3");
		System.out.println(jedis.mget("key1","key2","key3"));
	}

}
