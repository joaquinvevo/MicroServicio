package com.microservice.bff.service;

import java.util.List;
import java.util.Optional;

import com.microservice.bff.DTO.EstImportanciaDTO;

public interface IEstImportanciaService {
	
	public List<EstImportanciaDTO> findallImportancia();
	public void saveImportancia(EstImportanciaDTO importancia);
	public Optional<EstImportanciaDTO> findByIdImportancia(Long id);
	public EstImportanciaDTO updateImportancia(Long id, EstImportanciaDTO importancia);
	public void deleteByIdImportancia(Long id);
	
}
