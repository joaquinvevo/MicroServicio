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

import com.microservice.bff.DTO.ProyectoDTOEstrategia_org_departamento;

import jakarta.validation.Valid;

@FeignClient(name = "mnEstrategiaEstSituacion", url = "localhost:8084/estrategia/org_departamento")

public interface ProyectoClientEstrategia_org_departamento {
	@GetMapping("/findall")
    List<ProyectoDTOEstrategia_org_departamento> findAll();

    @GetMapping("/findById/{id}")
    Optional<ProyectoDTOEstrategia_org_departamento> findById(@PathVariable("id") Long id);

    @PostMapping("/create")
    ProyectoDTOEstrategia_org_departamento save(@RequestBody @Valid ProyectoDTOEstrategia_org_departamento departamentoDTO);

    @DeleteMapping("/delete/{id}")
    void deleteById(@PathVariable("id") Long id);


	@PutMapping("/update/{id}")
    ProyectoDTOEstrategia_org_departamento updateProyecto(@PathVariable("id") Long id, @RequestBody ProyectoDTOEstrategia_org_departamento proyectoDetails);
	
	@GetMapping("/subdepto/{id}")
	List<ProyectoDTOEstrategia_org_departamento> findSubDepartments(@PathVariable("id") Long org_departamento_id_padre);

}

