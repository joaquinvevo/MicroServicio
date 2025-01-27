package com.microservice.bff.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.bff.Client.MicronegocioClient;
import com.microservice.bff.DTO.EstUrgenciaDTO;

@Service
public class EstUrgenciaServiceImpl implements IEstUrgenciaService{
	
	@Autowired
	private MicronegocioClient client;
	
	@Override
	public List<EstUrgenciaDTO> findallUrgencia(){
		return client.findAllUrgencia();
	}
	
	@Override
	public void saveUrgencia(EstUrgenciaDTO urgencia) {
		client.saveUrgencia(urgencia);
	}
	
	@Override
	public Optional<EstUrgenciaDTO> findByIdUrgencia(Long id){
		return client.findByIdUrgencia(id);
	}
	
	@Override 
	public EstUrgenciaDTO updateUrgencia(Long id, EstUrgenciaDTO urgencia) {
		return client.findByIdUrgencia(id).map(existingProyecto->{
				BeanUtils.copyProperties(urgencia, existingProyecto, "id","fecha_registro");
				return client.updateUrgencia(id, existingProyecto);
		}).orElseGet(null);
				
	}
	
	@Override
	public void deleteByIdUrgencia(Long id) {
		client.deleteByIdUrgencia(id);
	}
	
}
