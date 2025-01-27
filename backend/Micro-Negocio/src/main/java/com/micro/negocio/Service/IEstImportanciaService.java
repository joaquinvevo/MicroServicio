package com.micro.negocio.Service;

import java.util.List;
import java.util.Optional;

import com.micro.negocio.Entity.EstImportanciaEntity;

public interface IEstImportanciaService {
	List<EstImportanciaEntity> findAll();
	Optional<EstImportanciaEntity> findById(Long id);
	void save(EstImportanciaEntity importancia);
	void deleteById(Long id);
	EstImportanciaEntity updateImportancia(Long id, EstImportanciaEntity importancia);
}
