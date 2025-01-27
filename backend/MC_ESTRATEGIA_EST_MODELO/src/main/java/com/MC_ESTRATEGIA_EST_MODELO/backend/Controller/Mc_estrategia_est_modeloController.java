package com.MC_ESTRATEGIA_EST_MODELO.backend.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RestController;

import com.MC_ESTRATEGIA_EST_MODELO.backend.DTO.Mc_estrategia_est_modeloDTO;
import com.MC_ESTRATEGIA_EST_MODELO.backend.Entity.Mc_estrategia_est_modelo;
import com.MC_ESTRATEGIA_EST_MODELO.backend.Service.IMc_estrategia_est_modeloService;

import jakarta.validation.Valid;
import lombok.NonNull;

@RestController
@RequestMapping("/mc_estrategia_est_modelo")
public class Mc_estrategia_est_modeloController {

	@Autowired
	private IMc_estrategia_est_modeloService service;
	
	@GetMapping("/findByEstModeloId/{estModeloId}")
    public ResponseEntity<?>findAllModeloByIdTipo(@PathVariable Long estModeloId){
       return ResponseEntity.ok(service.findAllModeloByIdTipo(estModeloId));
	}
	
	@ResponseBody
	@PostMapping("create")
	public Mc_estrategia_est_modeloDTO crearPersona(@Valid @NonNull @RequestBody Mc_estrategia_est_modeloDTO dto) {
		return service.save(dto);
	}
	
	@ResponseBody
    @GetMapping("findall")
    public List<Mc_estrategia_est_modeloDTO> findAll() {
        return service.findAll();
    }
	
	@ResponseBody
    @GetMapping("findById/{id}")
    public Mc_estrategia_est_modeloDTO findById(@PathVariable("id") Long id) {
        Optional<Mc_estrategia_est_modeloDTO> uDto = service.findById(id);
        if (uDto.isPresent()) {
            Mc_estrategia_est_modeloDTO dto = uDto.get();
            return dto;
        } else {
            return null;
        }
    }
	
	@ResponseBody
    @PutMapping("update")
    public Mc_estrategia_est_modeloDTO updateUser(@Valid @NonNull @RequestBody Mc_estrategia_est_modelo dto) {
        Optional<Mc_estrategia_est_modeloDTO> oDto = service.findById(dto.getId());
        if (oDto.isPresent() == true) {
            return service.save(dto.toDTO());
        }else{
            return null;
        }
    }
	
	@ResponseBody
    @DeleteMapping("delete/{id}")
    public boolean deleteUserById(@PathVariable("id") Long id) {
        Optional<Mc_estrategia_est_modeloDTO> oDto = service.findById(id);
        if (oDto.isPresent() == true) {
            service.delete(oDto.get());
            return true;
        } else {
            return false;
        }
    }
	
}

