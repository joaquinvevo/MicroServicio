package com.MC_ESTRATEGIA_EST_ORG_DEPARTAMENTO.backend.Client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.MC_ESTRATEGIA_EST_ORG_DEPARTAMENTO.backend.DTO.BscTipoProyectoDTO;

//@FeignClient(name = "nombre-del-microservicio") // Cambia "nombre-del-microservicio" por el nombre real
public interface BscTipoProyectoClient {
    
//    @GetMapping("/api/tipo-proyecto/findall")
//	static
//    List<BscTipoProyectoDTO> findAll() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//    
//    @GetMapping("/api/tipo-proyecto/findById/{id}")
//    BscTipoProyectoDTO findById(@PathVariable Long id);
//    
//    @GetMapping("/api/tipo-proyecto/findByCampo/{campoId}")
//    List<BscTipoProyectoDTO> findByCampo(@PathVariable Long campoId);
}
