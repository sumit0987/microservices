package com.demo.feignuserservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.demo.feignuserservice.config.RibbonConfiguration;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
@RibbonClient(name="orderclient",configuration=RibbonConfiguration.class)
public class FeignUserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeignUserServiceApplication.class, args);
	}

}
