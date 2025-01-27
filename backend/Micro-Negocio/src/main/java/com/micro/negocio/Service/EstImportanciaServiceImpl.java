package com.micro.negocio.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micro.negocio.Entity.EstImportanciaEntity;
import com.micro.negocio.Repository.EstImportanciaRepository;

@Service
public class EstImportanciaServiceImpl implements IEstImportanciaService{

	@Autowired
	private EstImportanciaRepository repo;
	
	@Override
	public List<EstImportanciaEntity> findAll(){
		return repo.findAll();
	}
	
	@Override
	public Optional<EstImportanciaEntity> findById(Long id){
		return repo.findById(id);
	}
	
	@Override
	public void save(EstImportanciaEntity importancia) {
		repo.save(importancia);
	}
	
	@Override
	public void deleteById(Long id) {
		repo.deleteById(id);
	}
	
	@Override
	public EstImportanciaEntity updateImportancia(Long id, EstImportanciaEntity importancia) {
		return repo.findById(id).map(existingProyecto->{
			BeanUtils.copyProperties(importancia, existingProyecto, "id", "fecha_registro");
			return repo.save(existingProyecto);
		}).orElse(null);

	}
}
