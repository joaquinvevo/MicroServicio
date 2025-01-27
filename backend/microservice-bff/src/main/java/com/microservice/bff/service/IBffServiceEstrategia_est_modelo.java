package com.microservice.bff.service;

import java.util.List;
import java.util.Optional;

import com.microservice.bff.DTO.ModeloByIdTipo;
import com.microservice.bff.DTO.ProyectoDTOEstrategia_est_modelo;

public interface IBffServiceEstrategia_est_modelo {
	
	   List<ProyectoDTOEstrategia_est_modelo> FindAll();
	   Optional<ProyectoDTOEstrategia_est_modelo> FindById(Long id);
	   void Save(ProyectoDTOEstrategia_est_modelo proyectoDTO);
	   void DeleteById(Long id);
	   ProyectoDTOEstrategia_est_modelo updateProyecto(ProyectoDTOEstrategia_est_modelo proyectoDetails);
	   ModeloByIdTipo findAllModeloByIdTipo(Long estModeloId);
}
