package com.microservice.bff.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.bff.Client.MicronegocioClient;
import com.microservice.bff.DTO.EstImpactoDTO;

@Service
public class EstImpactoServiceImpl implements IEstImpactoService{
	
	@Autowired
	private MicronegocioClient client;
	
	@Override
	public List<EstImpactoDTO> findallImpacto(){
		return client.findAllImpacto();
	}
	
	@Override
	public Optional<EstImpactoDTO> findByIdImpacto(Long id){
		return client.findByIdImpacto(id);
	}
	
	@Override
	public void saveImpacto(EstImpactoDTO impacto) {
		client.saveImpacto(impacto);
	}
	
	@Override
	public void deleteByIdImpacto(Long id) {
		client.deleteByIdImpacto(id);
	}
	
	@Override
	public EstImpactoDTO updateImpacto(Long id, EstImpactoDTO impacto) {
		return client.findByIdImpacto(id).map(existingProyecto->{
			BeanUtils.copyProperties(impacto, existingProyecto, "id", "fecha_registro");
			return client.updateImpacto(id, existingProyecto);
		}).orElseGet(null);
	}
}
