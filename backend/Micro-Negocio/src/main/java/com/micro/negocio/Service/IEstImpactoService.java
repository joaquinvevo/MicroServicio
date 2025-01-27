package com.micro.negocio.Service;

import java.util.List;
import java.util.Optional;

import com.micro.negocio.Entity.EstImpactoEntity;

public interface IEstImpactoService {
	
	List<EstImpactoEntity> findAll();
	Optional<EstImpactoEntity> findById(Long id);
	void save(EstImpactoEntity impacto);
	void deleteById(Long id);
	EstImpactoEntity updateImpacto(Long id, EstImpactoEntity impacto);
}
