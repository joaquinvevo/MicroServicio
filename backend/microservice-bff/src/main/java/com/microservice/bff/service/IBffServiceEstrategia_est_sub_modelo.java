package com.microservice.bff.service;

import java.util.List;
import java.util.Optional;

import com.microservice.bff.DTO.ProyectoDTOEstrategia_est_sub_modelo;
import com.microservice.bff.DTO.situacionByIdEstSubmodeloId;

public interface IBffServiceEstrategia_est_sub_modelo {
	
	   List<ProyectoDTOEstrategia_est_sub_modelo> FindAll();
	   Optional<ProyectoDTOEstrategia_est_sub_modelo> FindById(Long id);
	   void Save(ProyectoDTOEstrategia_est_sub_modelo proyectoDTO);
	   void DeleteById(Long id);
	   ProyectoDTOEstrategia_est_sub_modelo updateProyecto(Long id, ProyectoDTOEstrategia_est_sub_modelo proyectoDetails);
	   //situacionByIdEstSubmodeloId findAllSituacionesByIdEstSubModelo(Long EstSubmodeloId);
}
