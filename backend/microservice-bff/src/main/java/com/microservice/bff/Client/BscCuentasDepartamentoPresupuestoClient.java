package com.microservice.bff.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import com.microservice.bff.DTO.BscCuentasDepartamentoPresupuestoDTO;

import java.util.List;

//@FeignClient(name = "porDefinir")
public interface BscCuentasDepartamentoPresupuestoClient {

//    @GetMapping("/findall")
//    List<BscCuentasDepartamentoPresupuestoDTO> findAll();
//
//    @GetMapping("/findById/{id}")
//    BscCuentasDepartamentoPresupuestoDTO findById(@PathVariable("id") Long id);
//
//    @PostMapping("/create")
//    BscCuentasDepartamentoPresupuestoDTO save(@RequestBody BscCuentasDepartamentoPresupuestoDTO cuentasDTO);
//
//    @PutMapping("/update/{id}")
//    BscCuentasDepartamentoPresupuestoDTO update(@PathVariable("id") Long id, @RequestBody BscCuentasDepartamentoPresupuestoDTO cuentasDTO);
//
//    @DeleteMapping("/delete/{id}")
//    void deleteById(@PathVariable("id") Long id);
}
