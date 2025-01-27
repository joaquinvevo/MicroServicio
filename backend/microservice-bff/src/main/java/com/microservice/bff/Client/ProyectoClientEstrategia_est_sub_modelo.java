package com.microservice.bff.Client;

import java.util.List;
import java.util.Optional;

import jakarta.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.microservice.bff.DTO.ProyectoDTOEstrategia_est_sub_modelo;
import com.microservice.bff.DTO.ProyectoDTOEstrategia_est_situacion;
import com.microservice.bff.DTO.situacionByIdEstSubmodeloId;

@FeignClient(name = "mnEstrategiaEstSubModelo", url = "localhost:8083/estrategia_est_sub_modelo")
public interface ProyectoClientEstrategia_est_sub_modelo {
	
	@GetMapping("/search-sub-modelo/{idEstSubModelo}")
	situacionByIdEstSubmodeloId findAllSituacionesByIdEstSubModelo(@PathVariable("EstSubmodeloId") Long EstSubmodeloId);
    
	@GetMapping("/findall")
    public List<ProyectoDTOEstrategia_est_sub_modelo> findAll();

    @GetMapping("/findById/{id}")
    public Optional<ProyectoDTOEstrategia_est_sub_modelo> findById(@PathVariable("id") Long id);

    @PostMapping("/create")
    public ProyectoDTOEstrategia_est_sub_modelo save(@RequestBody @Valid ProyectoDTOEstrategia_est_sub_modelo proyectoDTO);

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id);

    @PutMapping("/update")
    ProyectoDTOEstrategia_est_sub_modelo updateProyecto(@RequestBody ProyectoDTOEstrategia_est_sub_modelo proyectoDetails);



}
