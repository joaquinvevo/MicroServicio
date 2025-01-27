package com.micro.negocio.Controller;

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

import com.micro.negocio.Entity.BcsObjetivoEntity;
import com.micro.negocio.Service.IBcsObjetivoService;

@RestController
@RequestMapping("/objetivo")
public class BcsObjetivoController {
	
	@Autowired
	private IBcsObjetivoService service;
	
	@GetMapping("/findallObjetivo")
	public List<BcsObjetivoEntity> findAll(){
		return service.findAll();
	}
	
	@PostMapping("/createObjetivo")
	public void save(@RequestBody BcsObjetivoEntity objetivo) {
		service.save(objetivo);
	}
	
	@GetMapping("/findByIdObjetivo/{id}")
	public ResponseEntity<BcsObjetivoEntity> findById(@PathVariable Long id){
		Optional<BcsObjetivoEntity> objetivo = service.findById(id);
		return objetivo
				.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
				.orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@PutMapping("/updateByIdObjetivo/{id}")
	public ResponseEntity<BcsObjetivoEntity> update(@PathVariable Long id, @RequestBody BcsObjetivoEntity objetivo){
		BcsObjetivoEntity updateObjetivo = service.updateObjetivo(id, objetivo);
		return ResponseEntity.ok(updateObjetivo);
	}
	
	@DeleteMapping("/deleteByIdObjetivo/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		if(service.findById(id).isPresent()) {
			service.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
