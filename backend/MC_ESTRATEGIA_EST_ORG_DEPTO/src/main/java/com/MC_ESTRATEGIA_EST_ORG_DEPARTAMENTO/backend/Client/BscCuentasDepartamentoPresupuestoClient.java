package com.MC_ESTRATEGIA_EST_ORG_DEPARTAMENTO.backend.Client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.MC_ESTRATEGIA_EST_ORG_DEPARTAMENTO.backend.DTO.BscCuentasDepartamentoPresupuestoDTO;

//@FeignClient(name = "nombre-del-microservicio") // Cambia "nombre-del-microservicio" por el nombre real del microservicio
public interface BscCuentasDepartamentoPresupuestoClient {
	
//    @GetMapping("/api/cuentas-departamento-presupuesto/findall")
//	static
//    List<BscCuentasDepartamentoPresupuestoDTO> findAll() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//    @GetMapping("/api/cuentas-departamento-presupuesto/findById/{id}")
//    BscCuentasDepartamentoPresupuestoDTO findById(@PathVariable Long id);
}
