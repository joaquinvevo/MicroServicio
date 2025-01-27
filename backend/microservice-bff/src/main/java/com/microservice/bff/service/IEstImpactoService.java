package com.microservice.bff.service;

import java.util.List;
import java.util.Optional;

import com.microservice.bff.DTO.EstImpactoDTO;


public interface IEstImpactoService {
	
	public List<EstImpactoDTO> findallImpacto();
	public void saveImpacto(EstImpactoDTO impacto);
	public Optional<EstImpactoDTO> findByIdImpacto(Long id);
	public EstImpactoDTO updateImpacto(Long id, EstImpactoDTO impacto);
	public void deleteByIdImpacto(Long id);
}
