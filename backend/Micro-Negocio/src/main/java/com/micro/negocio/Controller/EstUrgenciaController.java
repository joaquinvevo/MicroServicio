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
import com.micro.negocio.Entity.EstUrgenciaEntity;
import com.micro.negocio.Service.IEstUrgenciaService;

@RestController
@RequestMapping("/urgencia")
public class EstUrgenciaController {
	
	@Autowired
	private IEstUrgenciaService service;
	
	@GetMapping("/findall")
	public List<EstUrgenciaEntity> findAll(){
		return service.findAll();
	}
	
	@PostMapping("/create")
	public void save(@RequestBody EstUrgenciaEntity urgencia) {
		service.save(urgencia);
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<EstUrgenciaEntity> findById(@PathVariable Long id){
		Optional<EstUrgenciaEntity> urgencia = service.findById(id);
		return urgencia
				.map(value-> new ResponseEntity<>(value, HttpStatus.OK))
				.orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@PutMapping("/updateById/{id}")
	public ResponseEntity<EstUrgenciaEntity> update(@PathVariable Long id, @RequestBody EstUrgenciaEntity urgencia){
		EstUrgenciaEntity updateUrgencia = service.updateUrgencia(id, urgencia);
		return ResponseEntity.ok(updateUrgencia);
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
