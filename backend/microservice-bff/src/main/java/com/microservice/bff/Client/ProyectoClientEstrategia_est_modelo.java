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

import com.microservice.bff.DTO.ModeloByIdTipo;
import com.microservice.bff.DTO.ProyectoDTOEstrategia_est_modelo;

@FeignClient(name = "mc-estrategia-est-modelo")
public interface ProyectoClientEstrategia_est_modelo {

    @GetMapping("/mc_estrategia_est_modelo/findall")
    public List<ProyectoDTOEstrategia_est_modelo> findAll();

    @GetMapping("/mc_estrategia_est_modelo/findById/{id}")
    public Optional<ProyectoDTOEstrategia_est_modelo> findById(@PathVariable("id") Long id);

    @PostMapping("/mc_estrategia_est_modelo/create")
    public ProyectoDTOEstrategia_est_modelo save(@RequestBody @Valid ProyectoDTOEstrategia_est_modelo proyectoDTO);

    @DeleteMapping("/mc_estrategia_est_modelo/delete/{id}")
    public void deleteById(@PathVariable Long id);

    @PutMapping("/mc_estrategia_est_modelo/update")
    ProyectoDTOEstrategia_est_modelo updateProyecto(@RequestBody ProyectoDTOEstrategia_est_modelo proyectoDetails);

	@GetMapping("/mc_estrategia_est_modelo/findByEstModeloId/{estModeloId}")
	ModeloByIdTipo findAllModeloByIdTipo(@PathVariable("estModeloId") Long estModeloId);
	

}
