package com.RedisPractice.info.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {

	@Autowired
	private StringRedisTemplate redisTemplate;

	@RequestMapping(value="/redis/{key}/{value}" ,method = RequestMethod.GET)
	public String registerRedisServer( @PathVariable("key")String redisKey , @PathVariable("value") String redisValue) {

		//文字列操作をする場合はrg.springframework.data.redis.core　のValueOperationsを使用する
		ValueOperations<String, String> stringOoperation  = redisTemplate.opsForValue();
		stringOoperation.set(redisKey, redisValue);


		return null;
	}

}
