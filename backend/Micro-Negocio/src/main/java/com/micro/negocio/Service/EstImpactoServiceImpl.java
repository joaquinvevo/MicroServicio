package com.micro.negocio.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micro.negocio.Entity.EstImpactoEntity;
import com.micro.negocio.Repository.EstImpactoRepository;

@Service
public class EstImpactoServiceImpl implements IEstImpactoService {
	
	@Autowired
	private EstImpactoRepository repo;
	
	@Override
	public List<EstImpactoEntity> findAll(){
		return repo.findAll();
	}
	
	@Override
	public Optional<EstImpactoEntity> findById(Long id){
		return repo.findById(id);
	}
	
	@Override
	public void save(EstImpactoEntity impacto) {
		repo.save(impacto);
	}
	
	@Override
	public void deleteById(Long id) {
		repo.deleteById(id);
	}
	
	@Override
	public EstImpactoEntity updateImpacto(Long id, EstImpactoEntity impacto) {
		return repo.findById(id).map(existingProyecto->{
				BeanUtils.copyProperties(impacto, existingProyecto, "id", "fecha_registro");
				return repo.save(existingProyecto);
			}).orElse(null);
				
	}
}
