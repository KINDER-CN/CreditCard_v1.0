package com.zl.main;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@ComponentScan("com.zl")
@MapperScan("com.zl.dao")
@EnableFeignClients("com.zl.api")
@EnableEurekaClient
@EnableCircuitBreaker
@EnableRedisHttpSession(maxInactiveIntervalInSeconds=300)
@EnableHystrix
public class CctradingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CctradingServiceApplication.class, args);
	}

}
