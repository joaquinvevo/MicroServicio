package com.micro.negocio.Service;

import java.util.List;
import java.util.Optional;


import com.micro.negocio.Entity.EstSituacionEntity;

public interface IEstSituacionService {
	
	List<EstSituacionEntity> findAll();
	Optional<EstSituacionEntity> findById(Long id);
	void save(EstSituacionEntity importancia);
	void deleteById(Long id);
	EstSituacionEntity updateSituacion(Long id, EstSituacionEntity situacion);
}
