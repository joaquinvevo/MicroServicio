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

import com.micro.negocio.Entity.EstImportanciaEntity;
import com.micro.negocio.Service.IEstImportanciaService;

@RestController
@RequestMapping("/importancia")
public class EstImportanciaController {
	
	@Autowired
	private IEstImportanciaService service;
	
	@GetMapping("/findall")
	public List<EstImportanciaEntity> findAll(){
		return service.findAll();
	}
	
	@PostMapping("/create")
	public void save(@RequestBody EstImportanciaEntity importancia) {
		service.save(importancia);
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<EstImportanciaEntity> findById(@PathVariable Long id){
		Optional<EstImportanciaEntity> importancia = service.findById(id);
		return importancia
				.map(value-> new ResponseEntity<>(value, HttpStatus.OK))
				.orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@PutMapping("/updateById/{id}")
	public ResponseEntity<EstImportanciaEntity> update(@PathVariable Long id, @RequestBody EstImportanciaEntity importancia){
		EstImportanciaEntity updateImportancia = service.updateImportancia(id, importancia);
		return ResponseEntity.ok(updateImportancia);
	}
	
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id){
		if(service.findById(id).isPresent()) {
			service.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
