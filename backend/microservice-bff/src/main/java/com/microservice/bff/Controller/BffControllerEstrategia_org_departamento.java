package com.microservice.bff.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.microservice.bff.Client.ProyectoClientEstrategia_org_departamento;
import com.microservice.bff.DTO.ProyectoDTOEstrategia_org_departamento;
import com.microservice.bff.service.IBffServiceEstrategia_org_departamento;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bff/estrategia_org_departamento")
public class BffControllerEstrategia_org_departamento {
	
	@Autowired
	private IBffServiceEstrategia_org_departamento bffServiceEstrategia_org_departamento;
	
	@Autowired
	private ProyectoClientEstrategia_org_departamento client; // Inyección del cliente Feign


	@GetMapping("/findall")
    public List<ProyectoDTOEstrategia_org_departamento> findAll() {
        return bffServiceEstrategia_org_departamento.FindAll();
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<ProyectoDTOEstrategia_org_departamento> FindById(@PathVariable("id") Long id) {
        if (id == null) {
            return ResponseEntity.badRequest().build();
        }
        Optional<ProyectoDTOEstrategia_org_departamento> ProyectoDTOEstrategia_org_departamento = bffServiceEstrategia_org_departamento.FindById(id);
        return ProyectoDTOEstrategia_org_departamento.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public ResponseEntity<Void> Save(@RequestBody @Valid ProyectoDTOEstrategia_org_departamento proyectoDTO) {
        if (proyectoDTO == null) {
            return ResponseEntity.badRequest().build();
        }
        bffServiceEstrategia_org_departamento.Save(proyectoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
   
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> PersonaDelete(@PathVariable("id") Long id) {
        if (id == null) {
            return ResponseEntity.badRequest().build();
        }
        bffServiceEstrategia_org_departamento.DeleteById(id);
        return ResponseEntity.noContent().build();
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<ProyectoDTOEstrategia_org_departamento> updateProyecto(@PathVariable Long id, @RequestBody ProyectoDTOEstrategia_org_departamento proyectoDetails) {
    	ProyectoDTOEstrategia_org_departamento updatedProyecto = bffServiceEstrategia_org_departamento.updateProyecto(id, proyectoDetails);
        return ResponseEntity.ok(updatedProyecto);
    }
    
    @GetMapping("subdepto/{id}")
    public ResponseEntity<List<ProyectoDTOEstrategia_org_departamento>> getSubDepartments(@PathVariable("id") Long org_departamento_id_padre) {
        List<ProyectoDTOEstrategia_org_departamento> subDepartamentos = client.findSubDepartments(org_departamento_id_padre);
        return new ResponseEntity<>(subDepartamentos, HttpStatus.OK);
    }
}
