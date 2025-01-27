package com.microservice.bff.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import com.microservice.bff.DTO.BscTipoProyectoDTO;

import java.util.List;

//@FeignClient(name = "porDefinir")
public interface BscTipoProyectoClient {

//    @GetMapping("/findall")
//    List<BscTipoProyectoDTO> findAll();
//
//    @GetMapping("/findById/{id}")
//    BscTipoProyectoDTO findById(@PathVariable("id") Long id);
//
//    @PostMapping("/create")
//    BscTipoProyectoDTO save(@RequestBody BscTipoProyectoDTO tipoProyectoDTO);
//
//    @PutMapping("/update/{id}")
//    BscTipoProyectoDTO update(@PathVariable("id") Long id, @RequestBody BscTipoProyectoDTO tipoProyectoDTO);
//
//    @DeleteMapping("/delete/{id}")
//    void deleteById(@PathVariable("id") Long id);
}
