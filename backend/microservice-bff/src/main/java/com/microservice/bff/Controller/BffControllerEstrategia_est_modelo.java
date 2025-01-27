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

import com.microservice.bff.DTO.ProyectoDTOEstrategia_est_modelo;
import com.microservice.bff.service.IBffServiceEstrategia_est_modelo;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/bff/estrategia_est_modelo")
public class BffControllerEstrategia_est_modelo {
	
	
	@Autowired
	private IBffServiceEstrategia_est_modelo bffService;
	
    @GetMapping("/findall")
    public List<ProyectoDTOEstrategia_est_modelo> findAll() {
        return bffService.FindAll();
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<ProyectoDTOEstrategia_est_modelo> FindById(@PathVariable("id") Long id) {
        if (id == null) {
            return ResponseEntity.badRequest().build();
        }
        Optional<ProyectoDTOEstrategia_est_modelo> proyectoDTO = bffService.FindById(id);
        return proyectoDTO.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public ResponseEntity<Void> Save(@RequestBody @Valid ProyectoDTOEstrategia_est_modelo proyectoDTO) {
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
    
    @PutMapping("/update")
    public ResponseEntity<ProyectoDTOEstrategia_est_modelo> updateProyecto(@RequestBody ProyectoDTOEstrategia_est_modelo proyectoDetails) {
    	ProyectoDTOEstrategia_est_modelo updatedProyecto = bffService.updateProyecto(proyectoDetails);
        return ResponseEntity.ok(updatedProyecto);
    }
    
	@GetMapping("/findByEstModeloId/{estModeloId}")
    public ResponseEntity<?>findAllModeloByIdTipo(@PathVariable Long estModeloId){
       return ResponseEntity.ok(bffService.findAllModeloByIdTipo(estModeloId));
	}
    
    
}


