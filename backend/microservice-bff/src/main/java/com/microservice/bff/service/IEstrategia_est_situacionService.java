package com.microservice.bff.service;

import java.util.List;
import java.util.Optional;

import com.microservice.bff.DTO.ProyectoDTOEstrategia_est_situacion;

public interface IEstrategia_est_situacionService {
	
	   List<ProyectoDTOEstrategia_est_situacion> findAllSituacion();
	   Optional<ProyectoDTOEstrategia_est_situacion> FindByIdSituacion(Long id);
	   void SaveSituacion(ProyectoDTOEstrategia_est_situacion proyectoDTO);
	   void DeleteByIdSituacion(Long id);
	   ProyectoDTOEstrategia_est_situacion updateProyectoSituacion(Long id, ProyectoDTOEstrategia_est_situacion proyectoDetails);
}

