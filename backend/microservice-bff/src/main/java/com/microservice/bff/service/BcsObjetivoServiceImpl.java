package com.microservice.bff.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.bff.Client.MicronegocioClient;
import com.microservice.bff.DTO.BcsObjetivoDTO;

@Service
public class BcsObjetivoServiceImpl implements IBcsObjetivoService{

	@Autowired
	private MicronegocioClient client;
	
	@Override
	public List<BcsObjetivoDTO> findallObjetivo(){
		return client.findAllObjetivo();
	}
	
	@Override
	public Optional<BcsObjetivoDTO> findByIdObjetivo(Long id){
		return client.findByIdObjetivo(id);
	}
	
	@Override
	public void saveObjetivo(BcsObjetivoDTO objetivo) {
		client.saveObjetivo(objetivo);
	}
	
	@Override
	public void deleteByIdObjetivo(Long id) {
		client.deleteByIdObjetivo(id);
	}
	
	@Override
	public BcsObjetivoDTO updateObjetivo(Long id, BcsObjetivoDTO objetivo) {
		return client.findByIdObjetivo(id).map(existingProyecto->{
			BeanUtils.copyProperties(objetivo, existingProyecto, "id", "fecha_registro");
			return client.updateObjetivo(id, existingProyecto);
		}).orElseGet(null);
	}
}
