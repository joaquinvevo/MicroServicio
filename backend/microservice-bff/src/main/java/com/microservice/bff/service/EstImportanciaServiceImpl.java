package com.microservice.bff.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.bff.Client.MicronegocioClient;
import com.microservice.bff.DTO.EstImportanciaDTO;

@Service
public class EstImportanciaServiceImpl implements IEstImportanciaService {
	
	@Autowired
	private MicronegocioClient client;
	
	@Override
	public List<EstImportanciaDTO> findallImportancia(){
		return client.findAllImportancia();
	}
	
	@Override
	public void saveImportancia(EstImportanciaDTO importancia) {
		client.saveImportancia(importancia);
	}
	
	@Override
	public Optional<EstImportanciaDTO> findByIdImportancia(Long id){
		return client.findByIdImportancia(id);
	}
	
	@Override 
	public EstImportanciaDTO updateImportancia(Long id, EstImportanciaDTO importancia) {
		return client.findByIdImportancia(id).map(existingProyecto->{
				BeanUtils.copyProperties(importancia, existingProyecto, "id","fecha_registro");
				return client.updateImportancia(id, existingProyecto);
		}).orElseGet(null);
				
	}
	
	@Override
	public void deleteByIdImportancia(Long id) {
		client.deleteByIdImportancia(id);
	}
	
}
