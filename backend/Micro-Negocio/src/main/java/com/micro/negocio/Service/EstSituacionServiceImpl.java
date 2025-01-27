package com.micro.negocio.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micro.negocio.Entity.EstSituacionEntity;
import com.micro.negocio.Repository.EstSituacionRepository;

@Service
public class EstSituacionServiceImpl implements IEstSituacionService {
	
	@Autowired
	EstSituacionRepository repo;
	
	@Override
	public List<EstSituacionEntity> findAll(){
		return repo.findAll();
	}
	
	@Override
	public Optional<EstSituacionEntity> findById(Long id){
		return repo.findById(id);
	}
	
	@Override
	public void save(EstSituacionEntity situacion) {
		repo.save(situacion);
	}
	
	@Override
	public void deleteById(Long id) {
		repo.deleteById(id);
	}
	
	@Override
	public EstSituacionEntity updateSituacion(Long id, EstSituacionEntity situacion) {
		return repo.findById(id).map(existingProyecto->{
			BeanUtils.copyProperties(situacion, existingProyecto, "id", "fecha_registro");
			return repo.save(existingProyecto);
		}).orElse(null);
							
	}
	
}
