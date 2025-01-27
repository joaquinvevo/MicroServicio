package com.MC_ESTRATEGIA_EST_ORG_DEPARTAMENTO.backend.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.MC_ESTRATEGIA_EST_ORG_DEPARTAMENTO.backend.DTO.Estrategia_org_departamentoDTO;
import com.MC_ESTRATEGIA_EST_ORG_DEPARTAMENTO.backend.Entity.Estrategia_org_departamentoEntity;
import com.MC_ESTRATEGIA_EST_ORG_DEPARTAMENTO.backend.Service.IEstrategia_org_departamentoService;

import jakarta.validation.Valid;
import lombok.NonNull;

@Controller
@RequestMapping("estrategia/org_departamento")
public class Estrategia_org_departamentoController {

    @Autowired
    private IEstrategia_org_departamentoService estrategiaOrgDepartamentoService;

    @ResponseBody
    @PostMapping("create")
    public Estrategia_org_departamentoDTO crearEstrategiaOrgDepartamento(@Valid @NonNull @RequestBody Estrategia_org_departamentoDTO dto) {
        return estrategiaOrgDepartamentoService.save(dto);
    }

    @ResponseBody
    @GetMapping("findall")
    public List<Estrategia_org_departamentoDTO> findAll() {
        return estrategiaOrgDepartamentoService.findAll();
    }

    @ResponseBody
    @GetMapping("findById/{id}")
    public Estrategia_org_departamentoDTO findById(@PathVariable("id") Long id) {
        Optional<Estrategia_org_departamentoDTO> dtoOpt = estrategiaOrgDepartamentoService.findById(id);
        return dtoOpt.orElse(null);  // Devuelve null si el DTO no está presente
    }

    @ResponseBody
    @PutMapping("update/{id}")
    public Estrategia_org_departamentoDTO updateEstrategiaOrgDepartamento(@Valid @NonNull @RequestBody Estrategia_org_departamentoDTO dto) {
        Optional<Estrategia_org_departamentoDTO> oDto = estrategiaOrgDepartamentoService.findById(dto.getId());
        if (oDto.isPresent()) {
            return estrategiaOrgDepartamentoService.save(dto);
        } else {
            return null;  // Retorna null si el ID no existe
        }
    }

    @ResponseBody
    @DeleteMapping("delete/{id}")
    public boolean deleteEstrategiaOrgDepartamentoById(@PathVariable("id") Long id) {
        Optional<Estrategia_org_departamentoDTO> oDto = estrategiaOrgDepartamentoService.findById(id);
        if (oDto.isPresent()) {
            estrategiaOrgDepartamentoService.delete(oDto.get());
            return true;
        } else {
            return false;
        }
    }
    
    @GetMapping("subdepto/{id}")
    public ResponseEntity<List<Estrategia_org_departamentoEntity>> getSubDepartments(@PathVariable("id") Long org_departamento_id_padre) {
        // Usa la instancia de estrategiaOrgDepartamentoService
        List<Estrategia_org_departamentoEntity> subDepartamentos = estrategiaOrgDepartamentoService.findSubDepartments(org_departamento_id_padre);
        return new ResponseEntity<>(subDepartamentos, HttpStatus.OK);
    }


   
}
