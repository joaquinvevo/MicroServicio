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

import com.micro.negocio.Entity.EstSituacionEntity;
import com.micro.negocio.Service.IEstSituacionService;

@RestController
@RequestMapping("/situacion")
public class EstSituacionCntroller {

	@Autowired
	private IEstSituacionService service;
	
	@GetMapping("/findall")
	public List<EstSituacionEntity> findAll(){
		return service.findAll();
	}
	
	@PostMapping("/create")
	public void save(@RequestBody EstSituacionEntity situacion) {
		service.save(situacion);
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<EstSituacionEntity> findById(@PathVariable Long id){
		Optional<EstSituacionEntity> situacion = service.findById(id);
		return situacion
				.map(value-> new ResponseEntity<>(value, HttpStatus.OK))
				.orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@PutMapping("/updateById/{id}")
	public ResponseEntity<EstSituacionEntity> update(@PathVariable Long id, @RequestBody EstSituacionEntity situacion){
		EstSituacionEntity updateSituacion = service.updateSituacion(id, situacion);
		return ResponseEntity.ok(updateSituacion);
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
