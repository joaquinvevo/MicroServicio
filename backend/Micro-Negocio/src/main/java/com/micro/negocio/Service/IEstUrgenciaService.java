package com.micro.negocio.Service;

import java.util.List;
import java.util.Optional;

import com.micro.negocio.Entity.EstUrgenciaEntity;

public interface IEstUrgenciaService {
	
	List<EstUrgenciaEntity> findAll();
	Optional<EstUrgenciaEntity> findById(Long id);
	void save(EstUrgenciaEntity urgencia);
	void deleteById(Long id);
	EstUrgenciaEntity updateUrgencia(Long id, EstUrgenciaEntity urgencia);
}
