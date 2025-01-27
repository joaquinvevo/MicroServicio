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

import com.microservice.bff.DTO.ProyectoDTOEstrategia_org_cargo;

@FeignClient(name = "mc-estrategia-org-cargo", url = "localhost:8089/estrategia_org_cargo")
public interface ProyectoClientEstrategia_org_cargo {

    @GetMapping("/findall")
    public List<ProyectoDTOEstrategia_org_cargo> findAll();

    @GetMapping("/findById/{id}")
    public Optional<ProyectoDTOEstrategia_org_cargo> findById(@PathVariable("id") Long id);

    @PostMapping("/create")
    public ProyectoDTOEstrategia_org_cargo save(@RequestBody @Valid ProyectoDTOEstrategia_org_cargo proyectoDTO);

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id);

    @PutMapping("/update/{id}")
    ProyectoDTOEstrategia_org_cargo updateProyecto(@PathVariable("id") Long id, @RequestBody ProyectoDTOEstrategia_org_cargo proyectoDetails);


}
