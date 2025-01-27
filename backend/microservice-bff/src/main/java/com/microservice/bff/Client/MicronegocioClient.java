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

import com.microservice.bff.DTO.BcsObjetivoDTO;
import com.microservice.bff.DTO.EstImpactoDTO;
import com.microservice.bff.DTO.EstImportanciaDTO;
import com.microservice.bff.DTO.EstUrgenciaDTO;
import com.microservice.bff.DTO.ProyectoDTOEstrategia_est_situacion;

import jakarta.validation.Valid;

@FeignClient(name="Micro-Negocio")
public interface MicronegocioClient {

	// BcsObjetivo
	@GetMapping("/objetivo/findallObjetivo")
	public List<BcsObjetivoDTO> findAllObjetivo();
	
	@PostMapping("/objetivo/createObjetivo")
	public void saveObjetivo(@RequestBody BcsObjetivoDTO objetivo);
	
	@GetMapping("/objetivo/findByIdObjetivo/{id}")
	public Optional<BcsObjetivoDTO> findByIdObjetivo(@PathVariable Long id);
	
	@DeleteMapping("/objetivo/deleteByIdObjetivo/{id}")
	public void deleteByIdObjetivo(@PathVariable Long id);
	
	@PutMapping("/objetivo/updateByIdObjetivo/{id}")
	public BcsObjetivoDTO updateObjetivo(@PathVariable Long id, @RequestBody BcsObjetivoDTO objetivo);
	
	// EstImpacto
	@GetMapping("/impacto/findall")
	public List<EstImpactoDTO> findAllImpacto();
	
	@PostMapping("/impacto/create")
	public void saveImpacto(@RequestBody EstImpactoDTO impacto);
	
	@GetMapping("/impacto/findById/{id}")
	public Optional<EstImpactoDTO> findByIdImpacto(@PathVariable Long id);
	
	@DeleteMapping("/impacto/deleteById/{id}")
	public void deleteByIdImpacto(@PathVariable Long id);
	
	@PutMapping("/impacto/updateById/{id}")
	public EstImpactoDTO updateImpacto(@PathVariable Long id, @RequestBody EstImpactoDTO impacto);
	
	// EstImportancia
	@GetMapping("/importancia/findall")
	public List<EstImportanciaDTO> findAllImportancia();
	
	@PostMapping("/importancia/create")
	public void saveImportancia(@RequestBody EstImportanciaDTO importancia);
	
	@GetMapping("/importancia/findById/{id}")
	public Optional<EstImportanciaDTO> findByIdImportancia(@PathVariable Long id);
	
	@DeleteMapping("/importancia/deleteById/{id}")
	public void deleteByIdImportancia(@PathVariable Long id);
	
	@PutMapping("/importancia/updateById/{id}")
	public EstImportanciaDTO updateImportancia(@PathVariable Long id, @RequestBody EstImportanciaDTO importancia);
	
	// EstUrgencia
	@GetMapping("/urgencia/findall")
	public List<EstUrgenciaDTO> findAllUrgencia();
	
	@PostMapping("/urgencia/create")
	public void saveUrgencia(@RequestBody EstUrgenciaDTO urgencia);
	
	@GetMapping("/urgencia/findById/{id}")
	public Optional<EstUrgenciaDTO> findByIdUrgencia(@PathVariable Long id);
	
	@DeleteMapping("/urgencia/deleteById/{id}")
	public void deleteByIdUrgencia(@PathVariable Long id);
	
	@PutMapping("/urgencia/updateById/{id}")
	public EstUrgenciaDTO updateUrgencia(@PathVariable Long id, @RequestBody EstUrgenciaDTO urgencia);

	// EstSituacion
	
	@GetMapping("/situacion/findall")
	public List<ProyectoDTOEstrategia_est_situacion> findAllSituacion();
		
	@GetMapping("/situacion/findById/{id}")
	public Optional<ProyectoDTOEstrategia_est_situacion> findByIdSituacion(@PathVariable("id") Long id);
	    
	@PostMapping("/situacion/create")
	public ProyectoDTOEstrategia_est_situacion saveSituacion(@RequestBody @Valid ProyectoDTOEstrategia_est_situacion proyectoDTO);
	    
	@DeleteMapping("/situacion/deleteById/{id}")
	public void deleteByIdSituacion(@PathVariable Long id);
		
	@PutMapping("/situacion/updateById/{id}")
	ProyectoDTOEstrategia_est_situacion updateProyectoSituacion(@PathVariable("id") Long id, @RequestBody ProyectoDTOEstrategia_est_situacion proyectoDetails);

}

