package com.microservice.bff.service;

import java.util.List;
import java.util.Optional;

import com.microservice.bff.DTO.BcsObjetivoDTO;

public interface IBcsObjetivoService {
	
	public List<BcsObjetivoDTO> findallObjetivo();
	public Optional<BcsObjetivoDTO> findByIdObjetivo(Long id);
	public void saveObjetivo(BcsObjetivoDTO objetivo);
	public void deleteByIdObjetivo(Long id);
	public BcsObjetivoDTO updateObjetivo(Long id, BcsObjetivoDTO objetivo);
}
