package com.microservice.bff.service;

import java.util.List;
import java.util.Optional;

import com.microservice.bff.DTO.ProyectoDTOEstrategia_org_departamento;

public interface IBffServiceEstrategia_org_departamento {
		List<ProyectoDTOEstrategia_org_departamento> FindAll();
	   Optional<ProyectoDTOEstrategia_org_departamento> FindById(Long id);
	   void Save(ProyectoDTOEstrategia_org_departamento proyectoDTO);
	   void DeleteById(Long id);
	   ProyectoDTOEstrategia_org_departamento updateProyecto(Long id, ProyectoDTOEstrategia_org_departamento proyectoDetails);
}

