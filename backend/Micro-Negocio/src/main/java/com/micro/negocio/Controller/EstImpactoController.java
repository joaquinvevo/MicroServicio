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

import com.micro.negocio.Entity.EstImpactoEntity;
import com.micro.negocio.Service.IEstImpactoService;

@RestController
@RequestMapping("/impacto")
public class EstImpactoController {
	
	@Autowired
	private IEstImpactoService service;
	
	@GetMapping("/findall")
	public List<EstImpactoEntity> findAll(){
		return service.findAll();
	}
	
	@PostMapping("/create")
	public void save(@RequestBody EstImpactoEntity impacto) {
		service.save(impacto);
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<EstImpactoEntity> findById(@PathVariable Long id){
		Optional<EstImpactoEntity> impacto = service.findById(id);
		return impacto
				.map(value-> new ResponseEntity<>(value, HttpStatus.OK))
				.orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@PutMapping("/updateById/{id}")
	public ResponseEntity<EstImpactoEntity> update(@PathVariable Long id, @RequestBody EstImpactoEntity impacto){
		EstImpactoEntity updateImpacto = service.updateImpacto(id, impacto);
		return ResponseEntity.ok(updateImpacto);
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
