package com.micro.negocio.Service;

import java.util.List;
import java.util.Optional;

import com.micro.negocio.Entity.BcsObjetivoEntity;

public interface IBcsObjetivoService {

	List<BcsObjetivoEntity> findAll();
	Optional<BcsObjetivoEntity> findById(Long id);
	void save(BcsObjetivoEntity objetivo);
	void deleteById(Long id);
	BcsObjetivoEntity updateObjetivo(Long id, BcsObjetivoEntity objetivo);
}
