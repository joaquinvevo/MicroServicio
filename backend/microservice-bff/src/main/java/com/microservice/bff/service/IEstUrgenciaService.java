package com.microservice.bff.service;

import java.util.List;
import java.util.Optional;

import com.microservice.bff.DTO.EstUrgenciaDTO;


public interface IEstUrgenciaService {
	
	public List<EstUrgenciaDTO> findallUrgencia();
	public Optional<EstUrgenciaDTO> findByIdUrgencia(Long id);
	public void saveUrgencia(EstUrgenciaDTO urgencia);
	public void deleteByIdUrgencia(Long id);
	public EstUrgenciaDTO updateUrgencia(Long id, EstUrgenciaDTO urgencia);
}
