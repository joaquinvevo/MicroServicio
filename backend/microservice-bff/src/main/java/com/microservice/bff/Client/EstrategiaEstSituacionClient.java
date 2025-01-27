package com.microservice.bff.Client;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.microservice.bff.DTO.ProyectoDTOEstrategia_est_situacion;

import jakarta.validation.Valid;

//@FeignClient(name= "")
public interface EstrategiaEstSituacionClient {
	
	//@GetMapping("")
	//public List<ProyectoDTOEstrategia_est_situacion> findAll();
	
	//@GetMapping("")
    //public Optional<ProyectoDTOEstrategia_est_situacion> findById(@PathVariable("id") Long id);
    
	//@PostMapping("")
	//public ProyectoDTOEstrategia_est_situacion save(@RequestBody @Valid ProyectoDTOEstrategia_est_situacion proyectoDTO);
    
	//@DeleteMapping("")
	//public void deleteById(@PathVariable Long id);
	
	//@PutMapping("")
	//ProyectoDTOEstrategia_est_situacion updateProyecto(@PathVariable("id") Long id, @RequestBody ProyectoDTOEstrategia_est_situacion proyectoDetails);
}