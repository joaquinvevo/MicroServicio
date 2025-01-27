package com.MC_ESTRATEGIA_EST_MODELO.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication

public class McEstrategiaEstModeloApplication {

	public static void main(String[] args) {
		SpringApplication.run(McEstrategiaEstModeloApplication.class, args);
	}

}
