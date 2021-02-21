package com.RedisPractice.info.config;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "spring.redis.cluster")
public class RedisConfig {

	 List<String> nodes;

	 @Bean
	 public RedisConnectionFactory connectionFactory() {
		 return new JedisConnectionFactory(new RedisClusterConfiguration(nodes));
	 }

}

