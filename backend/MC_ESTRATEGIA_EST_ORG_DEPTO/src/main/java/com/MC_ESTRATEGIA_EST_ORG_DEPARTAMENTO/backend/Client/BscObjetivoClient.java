package com.MC_ESTRATEGIA_EST_ORG_DEPARTAMENTO.backend.Client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.MC_ESTRATEGIA_EST_ORG_DEPARTAMENTO.backend.DTO.BscObjetivoDTO;

//@FeignClient(name = "nombre-del-microservicio") // Cambia "nombre-del-microservicio" por el nombre real del microservicio
public interface BscObjetivoClient {
	
//	@GetMapping("/api/objetivo/findall")
//    List<BscObjetivoDTO> findAll();
//    
//    @GetMapping("/api/objetivo/findById/{id}")
//    BscObjetivoDTO findById(@PathVariable Long id);
//    
//    @GetMapping("/api/objetivo/findByTipo/{tipoId}")
//	static
//    List<BscObjetivoDTO> findByTipo(@PathVariable Long tipoId) {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
