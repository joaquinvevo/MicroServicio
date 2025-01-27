package com.microservice.bff.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.bff.Client.MicronegocioClient;
import com.microservice.bff.DTO.BcsObjetivoDTO;
import com.microservice.bff.DTO.ProyectoDTOEstrategia_est_situacion;

@Service
public class Estrategia_est_situacionService implements IEstrategia_est_situacionService{
	
	@Autowired
	private MicronegocioClient proyectoClient;
	
	@Override
	public List<ProyectoDTOEstrategia_est_situacion> findAllSituacion() {
		return proyectoClient.findAllSituacion() ;
	}

	@Override
	public Optional<ProyectoDTOEstrategia_est_situacion> FindByIdSituacion(Long id) {
		return proyectoClient.findByIdSituacion(id);
	}

	@Override
	public void SaveSituacion(ProyectoDTOEstrategia_est_situacion proyectoDTO) {
		proyectoClient.saveSituacion(proyectoDTO);
	}

	@Override
	public void DeleteByIdSituacion(Long id) {
		proyectoClient.deleteByIdSituacion(id);
	}

	@Override
	public ProyectoDTOEstrategia_est_situacion updateProyectoSituacion(Long id, ProyectoDTOEstrategia_est_situacion situacion) {
		return proyectoClient.findByIdSituacion(id).map(existingProyecto->{
			BeanUtils.copyProperties(situacion, existingProyecto, "id", "fecha_registro");
			return proyectoClient.updateProyectoSituacion(id, existingProyecto);
		}).orElseGet(null);
	}
	
	
}
