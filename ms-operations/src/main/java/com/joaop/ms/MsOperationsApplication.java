package com.joaop.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsOperationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsOperationsApplication.class, args);
	}

}
