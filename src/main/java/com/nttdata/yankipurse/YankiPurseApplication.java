package com.nttdata.yankipurse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class YankiPurseApplication {

	public static void main(String[] args) {
		SpringApplication.run(YankiPurseApplication.class, args);
	}

}
