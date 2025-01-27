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

import com.microservice.bff.DTO.BcsObjetivoDTO;
import com.microservice.bff.DTO.EstImpactoDTO;
import com.microservice.bff.DTO.EstImportanciaDTO;
import com.microservice.bff.DTO.EstUrgenciaDTO;
import com.microservice.bff.DTO.ProyectoDTOEstrategia_est_situacion;
import com.microservice.bff.service.BcsObjetivoServiceImpl;
import com.microservice.bff.service.EstImpactoServiceImpl;
import com.microservice.bff.service.EstImportanciaServiceImpl;
import com.microservice.bff.service.EstUrgenciaServiceImpl;
import com.microservice.bff.service.Estrategia_est_situacionService;

@RestController
@RequestMapping("/api/bff/micronegocio")
public class MicronegocioController {
	
	@Autowired
	private BcsObjetivoServiceImpl objetivoService;
	
	@Autowired
	private EstImportanciaServiceImpl importanciaService;
	
	@Autowired
	private EstImpactoServiceImpl impactoService;
	
	@Autowired
	private EstUrgenciaServiceImpl urgenciaService;
	
	@Autowired
	private Estrategia_est_situacionService situacionService;
	
	
	//Controller Objetivo
	
	@GetMapping("/findallObjetivo")
	public List<BcsObjetivoDTO> findallObjetivo(){
		return objetivoService.findallObjetivo();
	}
	
	@PostMapping("/createObjetivo")
	public void saveObjetivo(@RequestBody BcsObjetivoDTO objetivo) {
		objetivoService.saveObjetivo(objetivo);
	}
	
	@GetMapping("/findByIdObjetivo/{id}")
	public ResponseEntity<BcsObjetivoDTO> findByIdObjetivo(@PathVariable Long id){
		Optional<BcsObjetivoDTO> objetivo = objetivoService.findByIdObjetivo(id);
		return objetivo
				.map(value-> new ResponseEntity<>(value, HttpStatus.OK))
				.orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@DeleteMapping("/deleteByIdObjetivo/{id}")
	public ResponseEntity<Void> deleteByIdObjetivo(@PathVariable Long id){
		if(objetivoService.findByIdObjetivo(id).isPresent()) {
			objetivoService.deleteByIdObjetivo(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/updateByIdObjetivo/{id}")
	public ResponseEntity<BcsObjetivoDTO> updateObjetivo(@PathVariable Long id, @RequestBody BcsObjetivoDTO objetivo){
		BcsObjetivoDTO updateObjetivo = objetivoService.updateObjetivo(id, objetivo);
		return ResponseEntity.ok(updateObjetivo);
	}
	
	
	
	//Controller Importancia
	
	
	@GetMapping("/findallImportancia")
	public List<EstImportanciaDTO> findallImportancia(){
		return importanciaService.findallImportancia();
	}
	
	@PostMapping("/createImportancia")
	public void saveImportancia(@RequestBody EstImportanciaDTO importancia) {
		importanciaService.saveImportancia(importancia);
	}
	
	@GetMapping("/findByIdImportancia/{id}")
	public ResponseEntity<EstImportanciaDTO> findByIdImportancia(@PathVariable Long id){
		Optional<EstImportanciaDTO> importancia = importanciaService.findByIdImportancia(id);
		return importancia
				.map(value-> new ResponseEntity<>(value, HttpStatus.OK))
				.orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@DeleteMapping("/deleteByIdImportancia/{id}")
	public ResponseEntity<Void> deleteByIdImportancia(@PathVariable Long id){
		if(importanciaService.findByIdImportancia(id).isPresent()) {
			importanciaService.deleteByIdImportancia(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/updateByIdImportancia/{id}")
	public ResponseEntity<EstImportanciaDTO> updateImportancia(@PathVariable Long id, @RequestBody EstImportanciaDTO importancia){
		EstImportanciaDTO updateImpor = importanciaService.updateImportancia(id, importancia);
		return ResponseEntity.ok(updateImpor);
	}
	
	
	
	//COntroller Impacto
	
	@GetMapping("/findallImpacto")
	public List<EstImpactoDTO> findallImpacto(){
		return impactoService.findallImpacto();
	}
	
	@PostMapping("/createImpacto")
	public void saveImpacto(@RequestBody EstImpactoDTO impacto) {
		impactoService.saveImpacto(impacto);
	}
	
	@GetMapping("/findByIdImpacto/{id}")
	public ResponseEntity<EstImpactoDTO> findByIdImpacto(@PathVariable Long id){
		Optional<EstImpactoDTO> impacto = impactoService.findByIdImpacto(id);
		return impacto
				.map(value-> new ResponseEntity<>(value, HttpStatus.OK))
				.orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@DeleteMapping("/deleteByIdImpacto/{id}")
	public ResponseEntity<Void> deleteByIdImpacto(@PathVariable Long id){
		if(impactoService.findByIdImpacto(id).isPresent()) {
			impactoService.deleteByIdImpacto(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/updateByIdImpacto/{id}")
	public ResponseEntity<EstImpactoDTO> updateImpacto(@PathVariable Long id, @RequestBody EstImpactoDTO impacto){
		EstImpactoDTO updateImpac = impactoService.updateImpacto(id, impacto);
		return ResponseEntity.ok(updateImpac);
	}


	//Controller Urgencia
	
	@GetMapping("/findallUrgencia")
	public List<EstUrgenciaDTO> findallUrgencia(){
		return urgenciaService.findallUrgencia();
	}
	
	@PostMapping("/createUrgencia")
	public void saveUrgencia(@RequestBody EstUrgenciaDTO urgencia) {
		urgenciaService.saveUrgencia(urgencia);
	}
	
	@GetMapping("/findByIdUrgencia/{id}")
	public ResponseEntity<EstUrgenciaDTO> findByIdUrgencia(@PathVariable Long id){
		Optional<EstUrgenciaDTO> urgencia = urgenciaService.findByIdUrgencia(id);
		return urgencia
				.map(value-> new ResponseEntity<>(value, HttpStatus.OK))
				.orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@DeleteMapping("/deleteByIdUrgencia/{id}")
	public ResponseEntity<Void> deleteByIdUrgencia(@PathVariable Long id){
		if(urgenciaService.findByIdUrgencia(id).isPresent()) {
			urgenciaService.deleteByIdUrgencia(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/updateByIdUrgencia/{id}")
	public ResponseEntity<EstUrgenciaDTO> updateUrgencia(@PathVariable Long id, @RequestBody EstUrgenciaDTO urgencia){
		EstUrgenciaDTO updateUrg = urgenciaService.updateUrgencia(id, urgencia);
		return ResponseEntity.ok(updateUrg);
	}
	
	//Controller Situacion
	
	@GetMapping("/findallSituacion")
	public List<ProyectoDTOEstrategia_est_situacion> findallSituacion(){
		return situacionService.findAllSituacion();
	}
		
	@PostMapping("/createSituacion")
	public void saveUrgencia(@RequestBody ProyectoDTOEstrategia_est_situacion situacion) {
		situacionService.SaveSituacion(situacion);
	}
		
	@GetMapping("/findByIdSituacion/{id}")
	public ResponseEntity<ProyectoDTOEstrategia_est_situacion> findByIdSituacion(@PathVariable Long id){
		Optional<ProyectoDTOEstrategia_est_situacion> situacion = situacionService.FindByIdSituacion(id);
		return situacion
				.map(value-> new ResponseEntity<>(value, HttpStatus.OK))
				.orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@DeleteMapping("/deleteByIdSituacion/{id}")
	public ResponseEntity<Void> deleteByIdSituacion(@PathVariable Long id){
		if(situacionService.FindByIdSituacion(id).isPresent()) {
			situacionService.DeleteByIdSituacion(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/updateByIdSituacion/{id}")
	public ResponseEntity<ProyectoDTOEstrategia_est_situacion> updateSituacion(@PathVariable Long id, @RequestBody ProyectoDTOEstrategia_est_situacion situacion){
		ProyectoDTOEstrategia_est_situacion updateSit = situacionService.updateProyectoSituacion(id, situacion);
		return ResponseEntity.ok(updateSit);
	}	
}