package com.MC_ESTRATEGIA_EST_ORG_DEPARTAMENTO.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaServer 
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class MnEstrategiaEstOrgDeptoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MnEstrategiaEstOrgDeptoApplication.class, args);
	}

}
