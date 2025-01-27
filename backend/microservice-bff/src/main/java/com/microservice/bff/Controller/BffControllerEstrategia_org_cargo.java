package com.microservice.bff.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.bff.DTO.ProyectoDTOEstrategia_org_cargo;
import com.microservice.bff.service.IBffServiceEstrategia_org_cargo;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/bff/estrategia_org_cargo")
public class BffControllerEstrategia_org_cargo {
	
	
	@Autowired
	private IBffServiceEstrategia_org_cargo bffService;
	
    @GetMapping("/findall")
    public List<ProyectoDTOEstrategia_org_cargo> findAll() {
        return bffService.FindAll();
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<ProyectoDTOEstrategia_org_cargo> FindById(@PathVariable("id") Long id) {
        if (id == null) {
            return ResponseEntity.badRequest().build();
        }
        Optional<ProyectoDTOEstrategia_org_cargo> proyectoDTO = bffService.FindById(id);
        return proyectoDTO.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public ResponseEntity<Void> Save(@RequestBody @Valid ProyectoDTOEstrategia_org_cargo proyectoDTO) {
        if (proyectoDTO == null) {
            return ResponseEntity.badRequest().build();
        }
        bffService.Save(proyectoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
   
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> PersonaDelete(@PathVariable("id") Long id) {
        if (id == null) {
            return ResponseEntity.badRequest().build();
        }
        bffService.DeleteById(id);
        return ResponseEntity.noContent().build();
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<ProyectoDTOEstrategia_org_cargo> updateProyecto(@PathVariable Long id, @RequestBody ProyectoDTOEstrategia_org_cargo proyectoDetails) {
    	ProyectoDTOEstrategia_org_cargo updatedProyecto = bffService.updateProyecto(id, proyectoDetails);
        return ResponseEntity.ok(updatedProyecto);
    }
    
    
}
